(ns errortest.core
  (:require [goog.debug.ErrorReporter :as reporter]))

(enable-console-print!)

(reporter/install "logError") 
(.foobar js/window)
