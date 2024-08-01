package com.example.demojetpack.SideEffectHandler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

class MDerivedState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                tableCreate()
        }
    }
}


@Composable
fun tableCreate(){
    var tableState = remember { mutableStateOf(5) }
    var multiplyIndex = produceState(initialValue = 1) {
        repeat(9){
            delay(1000)
            value += 1
        }
    }
    val message = derivedStateOf {
      "${tableState.value} * ${multiplyIndex.value} = ${tableState.value * multiplyIndex.value}"
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)){
       Text(text = message.value,
           style = MaterialTheme.typography.headlineSmall)
    }
}