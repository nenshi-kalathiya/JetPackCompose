package com.example.demojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BBasicComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constant.TAG, "onCreate: BBasicComposable")
        setContent {
            SetBasicUIComponent(
                title = "Basic Components on JetPack Compose with multiple component wichis is used llike diffrent widgts like button, text," +
                        " Image, Radio button, checkbox, recyclerview")
        }
    }
}

@Composable
fun SetBasicUIComponent(title: String) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(500.dp)
            .shadow(5.dp)
    
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Call Icon",
            Modifier.size(50.dp),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.details_gray)),
            contentScale = ContentScale.Crop
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(15.dp)) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = title,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                color = colorResource(id = R.color.parpal),
                letterSpacing = TextUnit.Unspecified,
                softWrap = true,
                maxLines = 2,
                overflow = TextOverflow.Clip
            )

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.white),
                    containerColor = colorResource(id = R.color.pink),
                    disabledContainerColor = colorResource(id = R.color.black),
                    disabledContentColor = colorResource(id = R.color.parpal)
                ),
                //button should enable or disable
                enabled = true,
                border = BorderStroke(2.dp, color = Color.Blue),
                //padding around text
                contentPadding = PaddingValues(10.dp),
                //this is for corner shape giving
                shape = MaterialTheme.shapes.small,
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 30.dp,
                    disabledElevation = 5.dp
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "test",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(5.dp)
                )
                Text(text = "Test ")
                Text(text = "Best")
            }
            TextInput()

            Box (contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(id = R.drawable.ic_food),
                    contentDescription = "test",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "test",
                    modifier = Modifier
                        .size(90.dp)
                        .padding(5.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput() {
    val editedText = remember{mutableStateOf("")}
    TextField(
        value = editedText.value,
        onValueChange = {
            editedText.value = it
        },
        label = { Text(text = "Title") },
        enabled = true,
        readOnly = false
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewBasicUIComponent() {
    SetBasicUIComponent(title = "Basic Components on JetPack Compose")
}
