package com.siar.myappacelerator.ui.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.siar.myappacelerator.ui.screens.first.FirstScreen
import com.siar.myappacelerator.ui.screens.first.FirstViewModel
import com.siar.myappacelerator.ui.screens.second.SecondScreen

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 23/02/2024
 *****/
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.FirstScreen.route
    ){
        addFirstScreen(navController)
        addSecondScreen()
    }
}

fun NavGraphBuilder.addFirstScreen(navController: NavHostController){
    composable(
        AppScreens.FirstScreen.route
    ){
        val viewModel: FirstViewModel = hiltViewModel()
        FirstScreen(
            uiState = viewModel.uiState
        ){
            navigateToSecondScreen(navController, it)
        }
    }
}

fun NavGraphBuilder.addSecondScreen(){
    composable(
        AppScreens.SecondScreen.route,
        arguments = listOf(
            navArgument("name", { defaultValue = ""})
        )
    ){
        SecondScreen(
            hiltViewModel(),
            it.arguments?.getString("name") ?: "nulo", //nulo is only for test
        )
    }
}

fun navigateToSecondScreen(navController: NavHostController, name: String){
    navController.navigate(AppScreens.SecondScreen.createRoute(name))
}
