(ns analog.parse)

(def line->path-pattern #"(?:GET|POST|PUT|DELETE) (.*?) (?:HTTP)")

(defn line->path
  "Gets the URL path out of the line."
  [line]
  (second (re-find line->path-pattern line)))
