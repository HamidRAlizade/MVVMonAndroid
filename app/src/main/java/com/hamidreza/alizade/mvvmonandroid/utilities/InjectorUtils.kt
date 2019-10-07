package com.hamidreza.alizade.mvvmonandroid.utilities

import com.hamidreza.alizade.mvvmonandroid.data.FakeDatabase
import com.hamidreza.alizade.mvvmonandroid.data.QuoteRepository
import com.hamidreza.alizade.mvvmonandroid.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory():QuotesViewModelFactory{

        val quoteRepository=QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}