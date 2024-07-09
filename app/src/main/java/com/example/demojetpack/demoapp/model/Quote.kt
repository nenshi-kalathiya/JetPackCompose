package com.example.demojetpack.demoapp.model

import java.io.Serializable

data class Quote(
    val message: String,
    val author: String
) : Serializable