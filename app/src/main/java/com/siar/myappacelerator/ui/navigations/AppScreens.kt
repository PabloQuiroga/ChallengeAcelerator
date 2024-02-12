package com.siar.myappacelerator.ui.navigations

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 09/02/2024
 *****/
sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen?name={name}"){
        fun createRoute(name: String) = "second_screen?name=$name"
    }
}