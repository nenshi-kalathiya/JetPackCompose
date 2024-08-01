package com.example.demojetpack.SideEffectHandler

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demojetpack.R

class KDisposableCleaners() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firstExDisposableEffect()
            secondExDisposableEffect()
            thirdExDisposableEffect()
        }
    }
}

//when u used side effect ..that goes outside of the component
//kind of side effect where cleanup required before leaving composition
@Composable
fun firstExDisposableEffect() {
    val state = remember { mutableStateOf(false) }

    DisposableEffect(key1 = state.value) {
        Log.e(
            "Nenshi",
            "Disposable Started"
        ) // called first as initial call then second time while state change
        onDispose {
            Log.e(
                "Nenshi",
                "Disposable Stopped"
            ) // called while button click...state changed ...stopped task
        }
    }

    Button(onClick = {
        state.value = !state.value
    }) {
        Text(text = "Change State")
    }
}

@Composable
fun secondExDisposableEffect() {
    val context = LocalContext.current

//    DisposableEffect(key1 = Unit) {
//        val medialPlayer = MediaPlayer.create(context, R.raw.sona)
//        medialPlayer.start()
//        onDispose {
//            medialPlayer.stop()
//            medialPlayer.release()
//        }
//    }
}

@Composable
fun thirdExDisposableEffect() {
    KeyBoardComposable()
    //TextField(value = "Enter here Some", onValueChange ={} )
}

@Composable
fun KeyBoardComposable() {
    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listner = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.e("Nenshi", "KeyBoardComposable: is keyboard visible $isKeyboardVisible")
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listner)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listner)
                //used like this while you want to release unnecessary object of listeners or any class
        }
    }
}



