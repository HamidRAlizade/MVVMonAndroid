package com.hamidreza.alizade.mvvmonandroid.ui.quotes

import androidx.lifecycle.ViewModel
import com.hamidreza.alizade.mvvmonandroid.data.Quote
import com.hamidreza.alizade.mvvmonandroid.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun  getQoutes()=quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)



}