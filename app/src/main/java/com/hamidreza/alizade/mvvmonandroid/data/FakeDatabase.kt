package com.hamidreza.alizade.mvvmonandroid.data

class FakeDatabase private constructor() {
    var quoteDao = FakeQuoteDao()
        private set
    companion object{
        @Volatile private  var instance:FakeDatabase?=null

        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}