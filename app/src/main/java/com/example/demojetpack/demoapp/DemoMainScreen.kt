package com.example.demojetpack.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demojetpack.demoapp.objects.QuoteDataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DemoMainScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            QuoteDataManager.loadQuotesFromAssetFile(applicationContext)
        }
        setContent {
            callInitialAppPages()
        }
    }
}

enum class Pages {
    LIST,
    DETAIL
}

@Preview
@Composable
fun callInitialAppPages() {
    if (QuoteDataManager.quotesLoaded.value) {
        if (QuoteDataManager.currentPage.value == Pages.LIST) {
            QuoteListScreen(QuoteDataManager.quotes) {
                QuoteDataManager.switchPages(it)
            }
        } else {
            QuoteDataManager.currentQuote?.let { DisplayQuotesDetails(quote = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = " Loading ......")
        }
    }
}



