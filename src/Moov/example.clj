(ns Moov.example
  (:use [Moov.core :as TMDB]))

(defn -main [& args]
  (try
    (println (TMDB/movieSearch "movie"))
    (catch Exception e (println e)))
);-main


