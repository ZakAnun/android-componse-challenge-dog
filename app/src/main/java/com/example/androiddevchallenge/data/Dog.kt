package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

class Dog(
    val name: String,
    val breed: String,
    val description: String,
    val age: String,
    val gender: String,
    val size: String,
    @DrawableRes val picture: Int
)