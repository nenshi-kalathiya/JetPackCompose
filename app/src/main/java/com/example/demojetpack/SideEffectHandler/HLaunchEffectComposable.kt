package com.example.demojetpack.SideEffectHandler

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.demojetpack.Constant
import kotlinx.coroutines.delay

class HComposableSideEffectHandlers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            listAllCompose()
        }
    }
}
@Preview
@Composable
fun listAllCompose(){
    Column {
        ListComposable()
        Spacer(modifier = Modifier.fillMaxHeight(.2f) )
        LaunchEffectComposable()
        Spacer(modifier = Modifier.fillMaxHeight(.2f) )
        Countclick()
    }
}


fun fetchArrayItems(): List<String> {
    return listOf("One", "Two", "Three", "Four", "Five")
}

@Composable
fun ListComposable() {
    /*this is showing that we do API call or listing data in side composable fun
    it means this API call happen everytime when any updation happen in composable which is not good. It is called side effect
    some time it is required to do call in composable for that we have some sideeffect handle we can use*/
    val listSate = remember {
        mutableStateOf(emptyList<String>())
    }
    //one time call that time use this effect handler
    LaunchedEffect(key1 = Unit){
        listSate.value = fetchArrayItems()
    }
    LazyColumn(content = {
        items(listSate.value) { item ->
            Text(text = item)
        }
    })
}

//one more example how many time called data
//lunch effect used either you want to do call only one time or on some condition value changes that time only
@Composable
fun Countclick(){
    var count = remember {
        mutableStateOf(0)
    }
    var key = count.value%3 == 0
    LaunchedEffect(key1 = key){
        Log.e(Constant.TAG, "Countclick: ${count.value} " )
    }
    Column() {
        Button(onClick = {count.value++}) {
            Text(text ="Increment Count Click")
        }
        Text(text ="Your count is ${count.value}")
    }
}

@Composable
fun LaunchEffectComposable(){
    val  count = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = Unit){
        Log.e(Constant.TAG, "LaunchEffectComposable:  Counter Start")
        try {
            for (i in 1.. 10){
                count.value++
                delay(1000)
            }
        }catch (e : Exception){
            Log.e(Constant.TAG, "LaunchEffectComposable:  ${e.message.toString()}" )
        }
    }

    var text = "Counter running on value ${count.value}"
    if(count.value == 0){
        Log.e(Constant.TAG, "LaunchEffectComposable: Counter is stopped")
    }
    Text(text = text, fontSize = 20.sp)
}