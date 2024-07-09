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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.demojetpack.ui.theme.DemoJetPackTheme

class FCustomizeTheme : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomizeDemoJetpackTheme()
            /*  DemoJetPackTheme {
                  Text(text = "Nenshi Kalathiya")
             }*/
            /*other way to pass component inside theme function from theme.kt file
            DemoJetPackTheme(content = {
                Text(text = "Nenshi Kalathiya")
            })*/
        }
    }
}

/*
side effect or problem in composable, while we use composable for  UI development
 do not add logic like variable value updation like count++ or API call  or SQL value call or any logic define methods inside composable function,
 because composable can be call multiple time so its update variable,call API, store SQL data kinda value call multiple time
*/

@Composable
fun CustomizeDemoJetpackTheme() {
   // extra knowladge to access some methods
   // LocalConfiguration.current.colorMode

   //context access in composable function & other function are also we can check with Local{prefix}
   //  LocalContext.current.applicationContext


    var theme = remember {
        mutableStateOf(false)
    }
    DemoJetPackTheme(theme.value) {
        Column(

            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
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