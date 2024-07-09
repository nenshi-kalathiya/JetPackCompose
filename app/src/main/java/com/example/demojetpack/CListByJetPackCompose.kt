package com.example.demojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CListByJetPackCompose : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            listItemStatic()
        }
    }
}

@Composable
fun listItemStatic() {
    Column {
        SetItemInList(
            imageId = R.drawable.ic_profile,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
        SetItemInList(
            imageId = R.drawable.ic_food,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
        SetItemInList(
            imageId = R.drawable.ic_eating,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
        SetItemInList(
            imageId = R.drawable.ic_profile,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
        SetItemInList(
            imageId = R.drawable.ic_food,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
        SetItemInList(
            imageId = R.drawable.ic_profile,
            title = "Ravi Navadiya",
            description = "Software Developer"
        )
    }
}

@Composable
fun SetItemInList(imageId: Int, title: String, description: String) {
    Card(
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.background(
            color = colorResource(
                id = R.color.white
            )
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Profile Picture",
                alignment = Alignment.Center,
                modifier = Modifier.size(50.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.heading_gray)
                )
                Text(
                    text = description,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Normal,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.sudetails_gray)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListItemComponent() {
    listItemStatic()
}
