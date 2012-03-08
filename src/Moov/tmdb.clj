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
(ns Moov.tmdb
  (:use [Moov.http :only (httpGET)]))

(def urlCollection "http://api.themoviedb.org/3/collection/")
(def urlLatestMovie "http://api.themoviedb.org/3/latest/movie")
(def urlMovieInfo "http://api.themoviedb.org/3/movie/")
(def urlMovieSearch "http://api.themoviedb.org/3/search/movie")
(def urlPeopleSearch "http://api.themoviedb.org/3/search/person")
(def urlPersonInfo "http://api.themoviedb.org/3/person/")

(defn person_images
  "Make sure to try/catch for http/socket io."
  [api_key person_id]
  (httpGET (str urlPersonInfo
                person_id
                "/images"
                "?api_key=" api_key))
);person_images

(defn person_credits
  "Make sure to try/catch for http/socket io."
  [api_key person_id]
  (httpGET (str urlPersonInfo
                person_id
                "/credits"
                "?api_key=" api_key))
);person_credits

(defn person_info
  "Make sure to try/catch for http/socket io."
  [api_key person_id]
  (httpGET (str urlPersonInfo
                person_id
                "?api_key=" api_key))
);person_info

(defn search_people
  "Queries TMDB by people. Make sure to try/catch for http/socket io."
  ([api_key query]
    (httpGET (str urlPeopleSearch
                  "?api_key=" api_key
                  "&query=" query)))
  ([api_key query page]
    (httpGET (str urlPeopleSearch
                  "?api_key=" api_key
                  "&query=" query
                  "&page=" page)))
);search_people

(defn search_title
  "Queries TMDB by title. Make sure to try/catch for http/socket io."
  ([api_key query]
    (httpGET (str urlMovieSearch
                  "?api_key=" api_key
                  "&query=" query)))
  ([api_key query page]
    (httpGET (str urlMovieSearch
                  "?api_key=" api_key
                  "&query=" query
                  "&page=" page)))
  ([api_key query page language]
    (httpGET (str urlMovieSearch
                  "?api_key=" api_key
                  "&query=" query
                  "&page=" page
                  "&language=" language)))
  ([api_key query page language include_adult]
   (httpGET (str urlMovieSearch
                 "?api_key=" api_key
                 "&query=" query
                 "&page=" page
                 "&language=" language
                 "&include_adult=" include_adult)))
);search_title

(defn movie_info
  ([api_key movie_id]
    (httpGET (str urlMovieInfo
                  movie_id
                  "?api_key=" api_key)))
  ([api_key movie_id language]
    (httpGET (str urlMovieInfo
                  movie_id
                  "?api_key=" api_key
                  "&language=" language)))
);movie_info

(defn collection
  "Returns a movie collection. Make sure to try/catch for http/socket io."
  [api_key collection_id]
  (httpGET (str urlCollection
                collection_id
                "?api_key=" api_key))
);collection

(defn alternative_titles
  "Make sure to try/catch for http/socket io."
  ([api_key movie_id]
    (httpGET (str urlMovieInfo
                  movie_id
                  "/alternative_titles"
                  "?api_key=" api_key)))
  ([api_key movie_id country]
    (httpGET (str urlMovieInfo
                  movie_id
                  "/alternative_titles"
                  "?api_key=" api_key
                  "&language=" country)))
);alternative_titles

(defn movie_latest
  "Make sure to try/catch for http/socket io."
  [api_key]
  (httpGET (str urlLatestMovie
                "?api_key=" api_key))
);movie_latest

(defn movie_translations
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/translations"
                "?api_key=" api_key))
);movie_translations

(defn movie_trailers
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/trailers"
                "?api_key=" api_key))
);movie_trailers

(defn movie_release_info
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/releases"
                "?api_key=" api_key))
);movie_release_info


(defn movie_keywords
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/keywords"
                "?api_key=" api_key))
);movie_keywords

(defn movie_images
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/images"
                "?api_key=" api_key))
);movie_images

(defn movie_casts
  "Make sure to try/catch for http/socket io."
  [api_key movie_id]
  (httpGET (str urlMovieInfo
                movie_id
                "/casts"
                "?api_key=" api_key))
);movie_casts
