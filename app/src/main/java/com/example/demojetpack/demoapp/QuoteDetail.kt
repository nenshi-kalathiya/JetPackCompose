package com.example.demojetpack.demoapp

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.demojetpack.R
import com.example.demojetpack.demoapp.model.Quote
import com.example.demojetpack.demoapp.objects.QuoteDataManager

@Composable
fun DisplayItemQuotes(quote: Quote) {

    BackHandler() {
        QuoteDataManager.switchPages(quote)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    listOf(
                        colorResource(id = R.color.parpal),
                        colorResource(id = R.color.pink)
                    )
                )
            )
    ) {
        Card(
            modifier = Modifier
                .padding(30.dp)
                .background(
                    color = colorResource(
                        id = R.color.white
                    )
                ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)

        ) {
            Column(modifier = Modifier.background(colorResource(id = R.color.white))) {
                Image(
                    painter = painterResource(id = R.drawable.ic_quote),
                    alignment = Alignment.Center,
                    contentDescription = "Quote Image",
                    modifier = Modifier
                        .size(100.dp)
                        .rotate(180F)
                        .padding(25.dp)
                )

                Text(
                    text = quote.message,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(15.dp, 10.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.details_gray),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(15.dp, 10.dp),
                )
            }

        }
    }
}