package com.example.demojetpack.SideEffectHandler

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.demojetpack.Constant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class IRememberCoroutineScope : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            useRememberScope()
        }
    }
}

@Composable
fun useRememberScope() {
    val counter = remember { mutableStateOf(0) }
    var scope = rememberCoroutineScope()
    var text = "counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Column {
        Text(text = text)
        Button(onClick = {counter.value++}) {
            Text(text ="Increment Count Click")
        }
        Button(onClick = {
            scope.launch {
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.e(Constant.TAG, "LaunchEffectComposable:  ${e.message.toString()}")
                }
            }
        }){
            Text(text = text)
        }
    }
}
