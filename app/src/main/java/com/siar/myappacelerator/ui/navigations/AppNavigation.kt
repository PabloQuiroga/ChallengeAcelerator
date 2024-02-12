package com.siar.myappacelerator.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.siar.myappacelerator.ui.screens.first.FirstScreen
import com.siar.myappacelerator.ui.screens.second.SecondScreen

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 09/02/2024
 *****/
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.FirstScreen.route
    ){

        addFirstScreen(navController)

        addSecondScreen(navController)
    }
}

fun NavGraphBuilder.addFirstScreen(navController: NavHostController){
    composable(
        AppScreens.FirstScreen.route
    ){
        FirstScreen{
            navController.navigate(AppScreens.SecondScreen.createRoute("Daniel")) //TODO revisar esto
        }
    }
}

fun NavGraphBuilder.addSecondScreen(navController: NavHostController){
    composable(
        AppScreens.SecondScreen.route,
        arguments = listOf(
            navArgument("name", { defaultValue = ""})
        )
    ){
        SecondScreen(
            it.arguments?.getString("name") ?: "nulo", //nulo is only for test
        )
    }
}