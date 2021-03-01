package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DogList(dogs: List<Dog>, onDogClick: (Dog) -> Unit = {}) {
    LazyColumn(
        Modifier.padding()
    ) {
        items(dogs) { dog ->
            DogItem(
                dog,
                Modifier
                    .clickable {
                        onDogClick(dog)
                    }
                    .height(140.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    Card(modifier) {
        Image(
            painter = painterResource(id = dog.picture),
            contentDescription = "dog background",
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(
                    start = 0.dp, top = 2.dp,
                    end = 0.dp, bottom = 2.dp
                ),
            alpha = 0.3f,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(1f)
        ) {
            Image(
                painterResource(dog.picture),
                "Picture of dog: ${dog.name}",
                Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(8.dp)) {
                Text("name: ${dog.name}", style = MaterialTheme.typography.h5)
                Text("breed: ${dog.breed}")
                Text("age: ${dog.age}")
            }
        }
    }
}

@Preview
@Composable
fun DogListPreview() {
    val dogs = listOf(
        Dog(
            "Apple", "German Shepherd", "Apple is a lovely dog~",
            "Adult", "Male", "Large", com.example.androiddevchallenge.R.drawable.dog_myq
        ),
        Dog(
            "Banner", "Bulldog", "Banner very nice and wish a new family~",
            "Puppy", "Female", "Small", com.example.androiddevchallenge.R.drawable.dog_dn
        )
    )
    MyTheme {
        DogList(dogs)
    }
}

@Preview
@Composable
fun DogListPreviewDark() {
    val dogs = listOf(
        Dog(
            "Apple", "German Shepherd", "Apple is a lovely dog~",
            "Adult", "Male", "Large", R.drawable.dog_myq
        ),
        Dog(
            "Banner", "Bulldog", "Banner very nice and wish a new family~",
            "Puppy", "Female", "Small", R.drawable.dog_dn
        )
    )
    MyTheme(darkTheme = true) {
        DogList(dogs)
    }
}

@Preview
@Composable
fun DogItemPreview() {
    MyTheme {
        DogItem(
            Dog(
                "Apple", "German Shepherd", "Apple is a lovely dog~",
                "Adult", "Male", "Large", R.drawable.dog_myq
            )
        )
    }
}

@Preview
@Composable
fun DogItemPreviewDark() {
    MyTheme(darkTheme = true) {
        DogItem(
            Dog(
                "Apple", "German Shepherd", "Apple is a lovely dog~",
                "Adult", "Male", "Large", R.drawable.dog_myq
            )
        )
    }
}