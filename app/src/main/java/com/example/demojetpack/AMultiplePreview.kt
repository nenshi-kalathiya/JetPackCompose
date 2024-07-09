package com.example.demojetpack

import android.content.res.Configuration.UI_MODE_TYPE_WATCH
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class AMultiplePreview : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constant.TAG, "onCreate: AMultiplePreview")
        setContent {
            MainUIDevelopment(name = "Nenshi")
        }
    }
}


@Composable
fun MainUIDevelopment(name : String){
    Text(text = "Hello $name, Welcome to the dashboard")
}

/*basic preview with phone default UI while showSystemUI is true,
name gives identity to each ui
show background gibes white background to show*/
@Preview(showBackground = true, showSystemUi = true, name = "basicUI_1")
@Composable
fun PreviewUIDevelopment1(){
    MainUIDevelopment("Nenshi")
}

/* height and with gives specific height and width to view */
@Preview(showBackground = true, widthDp = 200, heightDp = 200, name = "basicUI_2")
@Composable
fun PreviewUIDevelopment2(){
    MainUIDevelopment("Ravi")
}

//preview while nothing you pass
@Preview
@Composable
private fun PreviewUIDevelopment3(){
    MainUIDevelopment("Prince")
}

//UI mode : you can select specific preview mode while run app for UI
//pass background color in long datatype
@Preview(name = "basicUI_4", showBackground = true, uiMode = UI_MODE_TYPE_WATCH, backgroundColor = 0x0F00FF00)
@Composable
fun PreviewUIDevelopment4(){
    MainUIDevelopment("Nilesh")
}


