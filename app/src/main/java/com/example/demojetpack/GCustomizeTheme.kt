package com.example.demojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.demojetpack.ui.theme.DemoJetPackTheme

class GCustomizeTheme : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomizeDemoJetpackTheme()
            /*DemoJetPackTheme {
                  Text(text = "Nenshi Kalathiya", style = MaterialTheme.typography.bodyLarge)
             }*/

            //other way to pass component inside theme function from theme.kt file
            /*DemoJetPackTheme(content = {
                Text(text = "Nenshi Kalathiya")
            })*/
        }
    }
}



@Composable
fun CustomizeDemoJetpackTheme() {
   // extra knowledge to access some methods
   // LocalConfiguration.current.colorMode

   //context access in composable function & other function are also we can check with Local{prefix}
   //  LocalContext.current.applicationContext


    var theme = remember { mutableStateOf(false) }
    DemoJetPackTheme(theme.value) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(1f)
        ) {
            Text(
                text = "Nenshi Kalathiya",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(
                    text = "Change Theme",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.heading_gray)
                )
            }
        }
    }
}

@Preview
@Composable
fun showView(){
    CustomizeDemoJetpackTheme()
}