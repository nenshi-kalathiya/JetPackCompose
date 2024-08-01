package com.example.demojetpack.SideEffectHandler

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

class JRememberUpdateState() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            composableCall()
        }
    }
}

@Composable
fun composableCall(){
    Column {
        //appCounter()
        mainComponent()
    }
}
@Composable
fun appCounter() {
    var count = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        count.value = 10
    }
    Counter(count = count.value)
}

@Composable
fun Counter(count: Int) {
    /* when we have requirement like you are running one component after that your value is
     change you  want to use that value and run second component that time You don't want
     to call again and again long process that time u can not use LaunchEffect()
     rememberUpdatedState is used */
    val status = rememberUpdatedState(newValue = count)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.e("Nenshi", "Counter value is ${status.value.toString()}")
    }
    Text(text = count.toString())
}


//Whenever you want to update method while state changed use  by rememberUpdatedState

fun a() = { Log.e("Nenshi", "A: Called Function A in the App") }

fun b() = { Log.e("Nenshi", "B: Called Function B in the App") }

@Composable
fun mainComponent() {
    var state = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to Change State")
    }
    //subComponentCalled(state.value)
    //not working
}

@Composable
fun subComponentCalled(onTimeOut:()->Unit) {
    val currentStateOnTimeOut by rememberUpdatedState(newValue = onTimeOut)
    // while u are assigning method directly us "by"
    LaunchedEffect(key1 = true) {
        delay(5000)
        currentStateOnTimeOut()
    }
}
