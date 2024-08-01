package com.example.demojetpack.demoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demojetpack.R
import com.example.demojetpack.demoapp.model.Quote

@Composable
fun QuoteListScreen(quoteList: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column() {
        Text(
            text = stringResource(id = R.string.quotes_app),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(15.dp, 20.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.headlineMedium
        )
        QuoteList(quoteList = quoteList, onClick)
    }
}

@Composable
fun QuoteList(quoteList: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(quoteList) { quote ->
            SingleItemQuotes(quote = quote) {
                onClick(quote)
            }
        }
    })
}