(ns analog.parse-test
  (:require [analog.parse :refer :all]
            [clojure.test :refer :all]))

(def sample-lines
  ["1.2.3.4 - - [01/Jan/2014:01:01:01 +0000] \"GET /a HTTP/1.1\" 200 1 \"A browser\""
   "2.3.4.5 - - [01/Jan/2014:01:01:02 +0000] \"GET /b HTTP/1.1\" 200 1 \"A browser\""
   "2.3.4.5 - - [01/Jan/2014:01:01:02 +0000] \"GET /b/c/d HTTP/1.1\" 200 1 \"A browser\""])

(deftest line->path-tests
  (testing "parsing all the sample lines"
    (is (= (line->path (nth sample-lines 0)) "/a"))
    (is (= (line->path (nth sample-lines 1)) "/b"))
    (is (= (line->path (nth sample-lines 2)) "/b/c/d"))))
