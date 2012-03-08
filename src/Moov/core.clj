 ;-
 ; Copyright (c) 2012 Ryan Kelker and individual contributors.
 ; ( https://github.com/runexec/Moov )
 ; All rights reserved.
 ;
 ; Redistribution and use in source and binary forms, with or without
 ; modification, are permitted provided that the following conditions
 ; are met:
 ; 1. Redistributions of source code must retain the above copyright
 ; notice, this list of conditions and the following disclaimer
 ; in this position and unchanged.
 ; 2. Redistributions in binary form must reproduce the above copyright
 ; notice, this list of conditions and the following disclaimer in the
 ; documentation and/or other materials provided with the distribution.
 ; 3. The name of the author may not be used to endorse or promote products
 ; derived from this software withough specific prior written permission
 ;
 ; THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 ; IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 ; OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 ; IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 ; INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 ; NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 ; DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 ; THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 ; (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 ; THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ;
 ;
(ns Moov.core
  (:use [Moov.tmdb :as TMDB]))

(def api_key "__My__API__KEY__")

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


