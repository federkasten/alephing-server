(ns alephing.server.core
  (:require [clojure.tools.logging :as logging]
            [lamina.core :refer :all]
            [aleph.http :refer :all]
            [environ.core :refer [env]]))

(def broadcast-channel (channel))

(defn handler [ch handshake]
  (try
    (receive-all ch (fn [msg] (enqueue broadcast-channel msg)))
    (receive-all broadcast-channel (fn [msg] (enqueue ch msg)))
    (catch Exception e nil)))

(defonce server (atom nil))

(defn start [port]
  (let [port (Integer. (or port (env :port) 5000))]
    (swap! server
           (fn [_] (start-http-server handler
                                      {:port port
                                       :websocket true})))
    (logging/info (str "Started with port " port))))

(defn stop []
  (when @server
    (@server)
    (swap! server (fn [_] nil))))

(defn -main [& [port]]
  (start port))
