## Moov [moo-vee], (TMDB)The Movie Database API Wrapper ##

** Quick Example **
`
; Clojure 1.3 /  no-deps, stdlib-only

(ns Moov.example
  (:use [Moov.core :as TMDB]))

(defn -main [& args]
  (try
    (println (TMDB/movieSearch "The Shinning"))
    (catch Exception e (println e)))
);-main
`

## Available Functions ##
`
(defn personImages [person_id]
  (TMDB/person_images api_key person_id)
);personImages

(defn personCredits [person_id]
  (TMDB/person_credits api_key person_id)
);personCredits

(defn personInfo [person_id]
  (TMDB/person_info api_key person_id)
);personInfo

(defn personSearch
  ([person_query]
    (TMDB/search_people api_key person_query))
  ([person_query page]
   (TMDB/search_people api_key person_query page))
);personSearch

(defn movieSearch 
  ([title_query]
    (TMDB/search_title api_key title_query))
  ([title_query page]
    (TMDB/search_title api_key title_query page))
  ([title_query page language]
    (TMDB/search_title api_key title_query page language))
  ([title_query page language include_adult]
    (TMDB/search_title api_key title_query page language include_adult))
);movieSearch

(defn movieInfo [movie_id]
  (TMDB/movie_info api_key movie_id)
);movieInfo

(defn movieCollection [collection_id]
  (TMDB/collection api_key collection_id)
);movieCollection

(defn movieAll_Titles
  ([movie_id]
    (TMDB/alternative_titles api_key movie_id))
  ([movie_id country]
    (TMDB/alternative_titles api_key movie_id country))
);movieAll_Titles

(defn movieTranslations [movie_id]
  (TMDB/movie_translations api_key movie_id)
);movieTranslations

(defn movieTrailers [movie_id]
  (TMDB/movie_trailers api_key movie_id)
);movieTrailers

(defn movieRelease_Info [movie_id]
  (TMDB/movie_release_info api_key movie_id)
);movieRelease_Info

(defn movieKeywords [movie_id]
  (TMDB/movie_keywords api_key movie_id)
);movieKeywords

(defn movieImages [movie_id]
  (TMDB/movie_images api_key movie_id)
);movieImages

(defn movieCasts [movie_id]
  (TMDB/movie_casts api_key movie_id)
);movieCasts
`
