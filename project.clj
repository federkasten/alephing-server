(defproject alephing-server "0.1.0-SNAPSHOT"
  :description "A demo program for webscoket ping/pong using aleph (server)"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [environ "0.4.0"]
                 [aleph "0.3.0"]]
  :min-lein-version "2.0.0"
  :profiles {:production {:env {:production true}}}
  :uberjar-name "alephing-server-standalone.jar")
