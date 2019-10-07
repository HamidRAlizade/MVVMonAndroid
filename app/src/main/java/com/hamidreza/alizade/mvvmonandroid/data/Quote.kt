package com.hamidreza.alizade.mvvmonandroid.data

data class Quote(val quoteText: String,val author:String) {

    override fun toString(): String {
        return "Quote(quoteText='$quoteText', author='$author')"
    }
}