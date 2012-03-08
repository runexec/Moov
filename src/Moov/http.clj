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
(ns Moov.http
  (:use [clojure.string :only (join)]))

(defn httpGET [url]
  (let 
    [ url (new java.net.URL url)
      conn (doto (. url openConnection)
             (.setConnectTimeout 20000)
             (.setReadTimeout 15000)
             (.setDefaultUseCaches false)
             (.setRequestProperty
               "User-Agent"
               "Mozilla/5.0 (X11; Linux x86_64; rv:10.0.2) Gecko/20100101 Firefox/10.0.2")
             (.setRequestProperty
               "Accept-Language"
               "en-us,en;q=0.5")
             (.setRequestProperty
               "Accept"
               "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")) 
      is (. conn getInputStream)
      encoding (. conn getContentEncoding) ]
    (if (= "gzip" encoding)
      (with-open [rdr (clojure.java.io/reader
                        (new java.util.zip.GZIPInputStream is))]
        (join "\n" 
              (reduce conj [] (line-seq rdr)) ))
      (with-open [rdr (clojure.java.io/reader is)]
        (join "\n"
              (reduce conj [] (line-seq rdr)) ))
    )
  ))
