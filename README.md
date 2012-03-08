<h1>
Moov [moo-vee], (TMDB)The Movie Database API Wrapper
</h1>
<br />

<br />
** Quick Example **
<br />
`
<br />
; Clojure 1.3 /  no-deps, stdlib-only
<br />

<br />
(ns Moov.example
<br />
  (:use [Moov.core :as TMDB]))
<br />

<br />
(defn -main [& args]
<br />
  (try
<br />
    (println (TMDB/movieSearch "The Shinning"))
<br />
    (catch Exception e (println e)))
<br />
);-main
<br />
`
<br />

<br />
<h2> Available Functions 
</h2>
<br />
`
<br />
(defn personImages [person_id]
<br />
  (TMDB/person_images api_key person_id)
<br />
);personImages
<br />

<br />
(defn personCredits [person_id]
<br />
  (TMDB/person_credits api_key person_id)
<br />
);personCredits
<br />

<br />
(defn personInfo [person_id]
<br />
  (TMDB/person_info api_key person_id)
<br />
);personInfo
<br />

<br />
(defn personSearch
<br />
  ([person_query]
<br />
    (TMDB/search_people api_key person_query))
<br />
  ([person_query page]
<br />
   (TMDB/search_people api_key person_query page))
<br />
);personSearch
<br />

<br />
(defn movieSearch 
<br />
  ([title_query]
<br />
    (TMDB/search_title api_key title_query))
<br />
  ([title_query page]
<br />
    (TMDB/search_title api_key title_query page))
<br />
  ([title_query page language]
<br />
    (TMDB/search_title api_key title_query page language))
<br />
  ([title_query page language include_adult]
<br />
    (TMDB/search_title api_key title_query page language include_adult))
<br />
);movieSearch
<br />

<br />
(defn movieInfo [movie_id]
<br />
  (TMDB/movie_info api_key movie_id)
<br />
);movieInfo
<br />

<br />
(defn movieCollection [collection_id]
<br />
  (TMDB/collection api_key collection_id)
<br />
);movieCollection
<br />

<br />
(defn movieAll_Titles
<br />
  ([movie_id]
<br />
    (TMDB/alternative_titles api_key movie_id))
<br />
  ([movie_id country]
<br />
    (TMDB/alternative_titles api_key movie_id country))
<br />
);movieAll_Titles
<br />

<br />
(defn movieTranslations [movie_id]
<br />
  (TMDB/movie_translations api_key movie_id)
<br />
);movieTranslations
<br />

<br />
(defn movieTrailers [movie_id]
<br />
  (TMDB/movie_trailers api_key movie_id)
<br />
);movieTrailers
<br />

<br />
(defn movieRelease_Info [movie_id]
<br />
  (TMDB/movie_release_info api_key movie_id)
<br />
);movieRelease_Info
<br />

<br />
(defn movieKeywords [movie_id]
<br />
  (TMDB/movie_keywords api_key movie_id)
<br />
);movieKeywords
<br />

<br />
(defn movieImages [movie_id]
<br />
  (TMDB/movie_images api_key movie_id)
<br />
);movieImages
<br />

<br />
(defn movieCasts [movie_id]
<br />
  (TMDB/movie_casts api_key movie_id)
<br />
);movieCasts
<br />
`
