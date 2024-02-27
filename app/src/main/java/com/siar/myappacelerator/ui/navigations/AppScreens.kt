package com.siar.myappacelerator.ui.navigations

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 09/02/2024
 *****/
sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen?user={user}"){
        fun createRoute(user: String) = "second_screen?user=$user"
    }
}
