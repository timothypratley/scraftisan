(ns scraftisan.scratch
  (:require [scraftisan.main :as main]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]))

(defn handler [request]
  (case (:uri request)
    "/" (-> (response/response (main/html))
            (response/content-type "image/svg+xml"))
    "/traction.js" (response/resource-response "traction.js")
    (response/not-found "Not Found")))

(defn start-server [port]
  (jetty/run-jetty #'handler {:port port :join? false}))

(comment

  (def s (start-server 8045))

  :-)
