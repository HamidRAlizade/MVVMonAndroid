package com.hamidreza.alizade.mvvmonandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hamidreza.alizade.mvvmonandroid.data.Quote
import com.hamidreza.alizade.mvvmonandroid.ui.quotes.QuotesViewModel
import com.hamidreza.alizade.mvvmonandroid.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()

    }

    private fun initializeUi() {
        val factory=InjectorUtils.provideQuotesViewModelFactory()
        val  viewModel= ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQoutes().observe(this, Observer {
            val stringBuilder=StringBuilder()
            it.forEach {
                stringBuilder.append("$it\n\n")

                textView_quotes.text=stringBuilder.toString()
            }
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
