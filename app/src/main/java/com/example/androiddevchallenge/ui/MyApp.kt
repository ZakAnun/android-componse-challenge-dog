package com.example.androiddevchallenge.ui

import androidx.compose.animation.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyApp() {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Adopt a Dog")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        val viewModel: MainViewModel = viewModel()
        val currentDog = viewModel.currentDog
        DogList(viewModel.dogs) { dog ->
            if (currentDog == null) {
                viewModel.showDog(dog)
            }
        }
        AnimatedVisibility(visible = currentDog != null,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()) {
            if (currentDog != null) {
                DogDetails(currentDog) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("You have adopted ${currentDog.name}")
                    }
                }
            }
        }
    }
}