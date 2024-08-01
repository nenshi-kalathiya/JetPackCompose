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
            /* side effect or problem in composable, while we use composable for  UI development
                do not add logic like variable value updation like count++ or API call  or SQL value call or any logic define methods inside composable function,
                because composable can be call multiple time so its update variable,call API, store SQL data kinda value call multiple time */
            ReComposable()
        }
    }
}
/*
    Recomposition  meaning  again and again  ui and update ui
    first time initial call composition
    then again again call meas recomposition
    stateObject helps to understand jetpack to call again and again for only those ui which has any changes
    it help to performance and it call intelligent composition

    rules or best practice for composition use
    do not add any havey option in composition method because it do recomposition so impact lagging in UI
    composition methods not call one by one it can be call in any order so do not make it dependent or use any dependent parameter from outside

*/
@Composable
fun ReComposable() {
    Log.d(Constant.TAG, "ReComposable: Initial Call")
    val stateForNow = remember { mutableStateOf(0.0) }
    Button(onClick = {
        stateForNow.value = Math.random()
    }) {
        Log.d(Constant.TAG, "ReComposable: ReCall again")
        Text(text = stateForNow.value.toString())
    }
}