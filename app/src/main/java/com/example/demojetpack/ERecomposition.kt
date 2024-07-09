package com.example.demojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

class ERecomposition : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ReComposable()
//            StateConcept()
            MainSateHosting()
        }
    }
}

@Composable
fun MainSateHosting() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var notificationCount: MutableState<Int> = rememberSaveable {
            mutableStateOf(0)
        }

        StateConcept(notificationCount.value, { notificationCount.value++ })
        MessageNotification(notificationCount.value)
    }
}

/*statefull Compsable because it has state (val stateForNow = remember {
        mutableStateOf(0.0)
    })

    It is also following unidirectional floas as data is passing from top to bottom
    Event comes from bottom to top for example button click happen at below and pass on top(parent) to get value
 */
@Composable
fun ReComposable() {
    Log.d(Constant.TAG, "ReComposable: Initial Call")
    val stateForNow = remember {
        mutableStateOf(0.0)
    }
    Button(onClick = {
        stateForNow.value = Math.random()
    }) {
        Log.d(Constant.TAG, "ReComposable: ReCall again")
        Text(text = stateForNow.value.toString())
    }
}

//state less composable because it has not any sate
@Composable
fun StateConcept(notificationCount: Int, notificationCountIncrement: () -> Int) {
    //screen rotate time composable create again so count can be again create with 0 value
    //use rememberSaveable so count value saved each time and take that value by increasing
    //rememberSaveable when we pass any object need to make sure either parsalaizable sirializable
//    var notificationCount : MutableState<Int> = rememberSaveable {
//        mutableStateOf(0)
//    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have total $notificationCount Notifications!!")
        Button(onClick = { notificationCountIncrement()}) {
            Text(text = "Send Notification")
        }
    }
}

//state less composable because it has not any sate
@Composable
fun MessageNotification(notificationCount: Int) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier.background(color = colorResource(id = R.color.white))
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)) {
            Text(text = "Messge sent for $notificationCount Notifications")
        }
    }
}

/*

package com.example.demojetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ERecomposition : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ReComposable()
            MainSateHosting()
        }
    }
}

@Composable
fun MainSateHosting(){
Column(verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
) {
    var notificationCount : MutableState<Int> = rememberSaveable {
        mutableStateOf(0)
    }

    Remebersvarable(notificationCount.value, { notificationCount.value++ })
    MessageNotification(notificationCount.value)
}
}
@Composable
fun ReComposable() {
    Log.d(Constant.TAG, "ReComposable: Initial Call")
    val stateForNow = remember {
        mutableStateOf(0.0)
    }
    Button(onClick = {
        stateForNow.value = Math.random()
    }) {
        Log.d(Constant.TAG, "ReComposable: ReCall again")
        Text(text = stateForNow.value.toString())
    }
}

@Composable
fun Remebersvarable(notificationCount: Int, lambdaFunIncrement: () -> Unit) {
    //screen rotate time composable create again so count can be again create with 0 value
    //use rememberSaveable so count value saved each time and take that value by increasing
    //rememberSaveable when we pass any object need to make sure either parsalaizable sirializable
//    var notificationCount : MutableState<Int> = rememberSaveable {
//        mutableStateOf(0)
//    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "You have total ${notificationCount} Notifications!!")
        Button(onClick = { lambdaFunIncrement }) {
            Text(text = "Send Notification")
        }
    }
}


 */