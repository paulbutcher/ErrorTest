(ns errortest.core
  (:require [goog.debug.ErrorReporter :as reporter]))

(reporter/install "/logError") 
(.foobar js/window)
