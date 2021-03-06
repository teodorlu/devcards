(defproject devcards "0.2.4-SNAPSHOT"
  :description "Devcards is a ClojureScript library that provides a lab space in which you can develop your UI components independently and interactively."
  :url "http://github.com/bhauman/devcards"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [org.clojure/core.async  "0.3.443"]
                 [cljsjs/react "15.3.1-0"]
                 [cljsjs/react-dom "15.3.1-0"]
                 [sablono "0.7.4"]
                 [cljsjs/showdown "1.4.2-0"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["example-resources/public/devcards/js/compiled"
                                    :target-path]

  :scm { :name "git"
         :url "https://github.com/bhauman/devcards" }

  :cljsbuild {
              :builds [{:id "devcards-demos"
                        :source-paths ["example_src" "src"]
                        :figwheel { :devcards true }
                        :compiler {
                                   :main "devdemos.start-ui"
                                   :asset-path "js/compiled/out"
                                   :output-to "example-resources/public/devcards/js/compiled/devdemos.js"
                                   :output-dir "example-resources/public/devcards/js/compiled/out"
                                   :recompile-dependents false                             
                                   :optimizations :none
                                   :source-map-timestamp true}}
                       {:id "website"
                        :source-paths ["example_src" "src"]
                        ;; :figwheel { :devcards true }
                        :compiler {
                                   :main "devdemos.start-ui"
                                   :asset-path "site/out"
                                   :output-to "site/devdemos.js"
                                   :output-dir "site/out"
                                   :devcards true
                                   ;; :pseudo-names true                             
                                   :recompile-dependents true                             
                                   ;; :optimizations :simple
                                   :optimizations :advanced
                                   }}
                       ]}
  
         :figwheel { :css-dirs ["resources/public/devcards/css"]
                     :open-file-command "emacsclient"
                    ;;:nrepl-port 7888
                    }
  
  :profiles {
   :repl { ;:plugins [[cider/cider-nrepl "0.11.1"]]
           :repl-options {:init (set! *print-length* 50)}}
   :dev {
      :dependencies [;[org.omcljs/om "0.9.0"]
                     [org.omcljs/om "1.0.0-alpha46"]
                     [reagent "0.6.0"]
                     [figwheel-sidecar "0.5.8"]
                     [com.cemerick/piggieback "0.2.1"]
                     [org.clojure/tools.nrepl "0.2.12"]]                   
      :plugins [[lein-cljsbuild "1.1.4" :exclusions [org.clojure/clojure]]
                [lein-figwheel "0.5.8"]]
      :resource-paths ["resources" "example-resources"]   

         }})

