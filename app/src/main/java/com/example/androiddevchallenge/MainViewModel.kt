package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Dog

class MainViewModel: ViewModel() {

    val dogs by mutableStateOf(
        listOf(
            Dog(
                "Apple", "German Shepherd", "Apple is a lovely dog~",
                "Adult", "Male", "Large", R.drawable.dog_myq),
            Dog(
                "Banner", "Bulldog", "Banner very nice and wish a new family~",
                "Puppy", "Female", "Small", R.drawable.dog_dn),
            Dog(
                "Cherry", "Poodle", "Happy everyday~",
                "Young", "Male", "Small", R.drawable.dog_gb),
            Dog(
                "Damson", "Siberian husky", "Make fun together~",
                "Puppy", "Female", "Small", R.drawable.dog_hsq),
            Dog(
                "Grape", "Chihuahua", "ah Ha Ha Ha Ha Ha Ha~",
                "Adult", "Female", "Small", R.drawable.dog_jww),
            Dog(
                "Haw", "Hound", "Running outside together~",
                "Puppy", "Male", "Medium", R.drawable.dog_lq),
            Dog(
                "Kiwifruit", "BerneseMountainDog", "Kiwifruit want to heal you~",
                "Young", "Male", "Large", R.drawable.dog_besq),
            Dog(
                "Lemon", "Labrador Retriever", "Live together~",
                "Young", "Female", "Medium | Large", R.drawable.dog_lbld)
        )
    )

    var currentDog: Dog? by mutableStateOf(null)

    fun showDog(dog: Dog) {
        currentDog = dog
    }

    fun closeDog() {
        currentDog = null
    }
}