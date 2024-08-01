package com.example.demojetpack.SideEffectHandler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class LProduceState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//          MainComponent()
            LoaderComponent()
        }
    }
}

@Composable
fun MainComponent() {
//    var state = remember { mutableStateOf(0) }
//    LaunchedEffect(key1 = Unit) {

    var state = produceState(initialValue = 0) {
        //produce state is while we pass livedata as state or flow update
        // automatically like observer
        for (i in 1..10) {
            delay(1000)
            //state.value++
            value += 1
        }
    }
    Text(
        text = state.value.toString(), style = MaterialTheme.typography.bodyLarge
    )
}

@Preview
@Composable
fun LoaderComponent() {
    val degree = produceState(initialValue = 0){
        while(true){
            delay(50)
            value = (value+10)%360
        }
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f),
        content ={
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                        .rotate(degree.value.toFloat()))

                Text(text = "Loading")
            }
        })
}