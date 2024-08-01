package com.example.demojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class  FStateObject() : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationScreen()
        }
    }
}

@Preview
@Composable
fun NotificationScreen() {
    //state full composable because state defined here
    var notificationCount = remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(notificationCount.value, {notificationCount.value++})
        MessageNotification(notificationCount = notificationCount.value)
    }

}
//state less composable because it has not any sate
//@Composable
//fun NotificationCounter() {
//    Column {
//        // count used as  as state object with mutableSatetOF() to  update count in UI
//        var count  = remember { mutableStateOf(0) }
////        var count  = rememberSaveable{ mutableStateOf(0) } //save state even activity restart
//        Text(text = "Yoy have  ${count.value} Notifications, Please check")
//        Button(onClick = {
//            count.value++
//        }) {
//            Text(text = "Notification Sent")
//        }
//    }
//}

//state less composable because it has not any sate
@Composable
fun NotificationCounter(notificationCount: Int, notificationCountIncrement: () -> Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have total $notificationCount Notifications!!")
        Button(onClick = { notificationCountIncrement() }) {
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
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Message sent for $notificationCount Notifications")
        }
    }
}
