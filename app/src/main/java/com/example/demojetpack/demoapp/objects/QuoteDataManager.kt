package com.example.demojetpack.demoapp.objects

import android.content.Context
import android.widget.Switch
import androidx.compose.runtime.mutableStateOf
import com.example.demojetpack.demoapp.Pages
import com.example.demojetpack.demoapp.model.Quote
import com.google.gson.Gson

object QuoteDataManager {

    var  quotes = emptyArray<Quote>()
    var quotesLoaded = mutableStateOf(false) // for data loaded or not
    var currentQuote : Quote? = null //clicked quote item from list
    var currentPage = mutableStateOf(Pages.LIST) // manage pages  from list and quotes
    fun loadQuotesFromAssetFile(context: Context) {
        val assetManager = context.assets.open("quotes.json")
        val size: Int = assetManager.available()
        val bufferedReader = ByteArray(size)
        assetManager.read(bufferedReader)
        assetManager.close()
        val json = String(bufferedReader, Charsets.UTF_8)
        val gson = Gson()
        quotes = gson.fromJson(json, Array<Quote>::class.java)
        quotesLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LIST) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LIST
        }
    }

}