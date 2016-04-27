(ns dysentery.core
  "This is the main class for running Dysentery as a self-contained
  JAR application."
  (:require [dysentery.finder :as finder]
            [dysentery.util :as util]
            [dysentery.vcdj :as vcdj]
            [dysentery.view :as view])
  (:gen-class))

(defn -main
  "The entry point when inovked as a jar from the command line. Will
  eventually parse command line options, but for now bring up the
  device packet analysis interface."
  [& args]
  (view/watch-devices)
  (if (seq (finder/current-dj-link-devices))
    (println "Type ^C to exit.")
    (System/exit 0)))