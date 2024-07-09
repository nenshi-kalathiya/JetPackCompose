package com.example.demojetpack.demoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demojetpack.R
import com.example.demojetpack.demoapp.model.Quote

@Composable
fun SingleItemQuotes(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .background(
                color = colorResource(
                    id = R.color.white
                )
            )
            .fillMaxSize(1f)
            .clickable {
                onClick(quote)
            },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .background(colorResource(id = R.color.white))
        ) {
            Image(
                imageVector = Icons.Filled.Close,
                colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                alignment = Alignment.Center,
                contentDescription = "Quote Image",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(180F)
                    .padding(10.dp)
                    .fillMaxSize(.1f)
                    .background(colorResource(id = R.color.black))
            )

            Column(modifier = Modifier.background(colorResource(id = R.color.white))
                .fillMaxSize(1f)) {
                Text(
                    text = quote.message,
                    modifier = Modifier.padding(10.dp, 10.dp)
                )
                Box(modifier = Modifier.background(colorResource(id = R.color.heading_gray)))
                Text(
                    text = "-${quote.author}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.details_gray),
                    modifier = Modifier.padding(10.dp, 5.dp)
                        .align(Alignment.End),

                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSingleItemQuotes() {
    SingleItemQuotes(
        Quote(
            "Genious is one percent inspiration and ninety-nine percent prespiration.",
            "Thomas Edison"
        ), {})
}