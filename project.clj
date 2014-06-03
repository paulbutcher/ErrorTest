(defproject errortest "0.1"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2227"]
                 [compojure "1.1.8"]]
  :plugins [[lein-ancient "0.5.5"]
            [lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.10"]]
  :profiles {:production {:resource-paths ["target/production"]}
             :dev {:resource-paths ["target/dev"]}}
  :cljsbuild {:builds {:dev {:source-paths ["src-cljs"]
                             :compiler {:output-dir "target/dev/public/js"
                                        :output-to "target/dev/public/js/main.js"
                                        :optimizations :whitespace
                                        :pretty-print true
                                        :source-map "target/dev/public/js/main.map"}}
                       :production {:source-paths ["src-cljs"]
                                    :compiler {:output-to "target/production/public/js/main.js"
                                               :optimizations :advanced
                                               :pretty-print false}}}}
  :ring {:handler errortest.core/handler})
