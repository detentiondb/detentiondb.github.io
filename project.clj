(defproject f4f "0.1.0-SNAPSHOT"
  :source-paths ["."]

  :eval-in :leiningen

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-2371" :scope "provided"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]
                 [pani "0.0.2"]
                 [sablono "0.2.22"]
                 [cljs-uuid "0.0.4"]
                 [leiningen "2.5.0"]
                 [org.clojure/data.json "0.2.6"]]

  :plugins [[lein-s3-static-deploy "0.1.0"]
            [lein-cljsbuild "1.0.3"]]

  :aws {:access-key ~(System/getenv "AWS_ACCESS_KEY") 
        :secret-key ~(System/getenv "AWS_SECRET_KEY") 
        :s3-static-deploy {:bucket "hestadivest.net" 
                           :local-root "."}}

  :min-lein-version "2.5.0"

  :cljsbuild {:builds {:dev {:source-paths ["."]
                             :compiler {:output-to     "./js/f4f.js"
                                        :output-dir    "./js/out"
                                        :source-map    "./js/out.js.map"
                                        :preamble      ["react/react.min.js"]
                                        :externs       ["react/externs/react.js"]
                                        :optimizations :none
                                        :pretty-print  true}}}})

