(ns firn.core-test
  (:require [firn.build :as build]
            [me.raynes.fs :as fs]
            [firn.config :as config]))

(def test-dir      "test/firn/demo_org")
(def wiki-dir      "/users/tees/Dropbox/wiki")


(defn build-test-files
  [dir-to-build]
  (let [config (build/prepare-config dir-to-build)]
    (fs/delete-dir (config :dir-firn))
    (build/all-files {:dir-files dir-to-build})))

(build-test-files wiki-dir)
(build-test-files test-dir)

(config/prepare test-dir)
