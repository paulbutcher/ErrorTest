(ns errortest.core
  (:require [compojure.core :refer :all]
            [compojure.handler :refer [api]]
            [compojure.route :refer [resources not-found]]
            [ring.util.response :refer [redirect]]))

(defroutes app-routes
  (GET "/" [] (redirect "/index.html"))
  (POST "/log-error" {:keys [error line script trace]} (println error line script trace))
  (resources "/")
  (not-found "Page not found"))

(defn wrap-request-logging [handler]
  (fn [req]
    (println req)
    (handler req)))

(def handler (-> (api app-routes)
                 (wrap-request-logging)))
