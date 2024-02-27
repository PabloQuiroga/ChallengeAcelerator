package com.siar.myappacelerator.ui.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.siar.myappacelerator.domain.model.User
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
            navigateToSecondScreen(navController, objToJson(it))
        }
    }
}

fun NavGraphBuilder.addSecondScreen(){
    composable(
        AppScreens.SecondScreen.route,
        arguments = listOf(
            navArgument("user", { defaultValue = ""})
        )
    ){
        val args = it.arguments?.getString("user")
        args?.let {
            val userArgs = jsonToObj(it)
            SecondScreen(
                hiltViewModel(),
                userArgs
            )
        }

    }
}

fun navigateToSecondScreen(navController: NavHostController, user: String){
    navController.navigate(AppScreens.SecondScreen.createRoute(user))
}


// utilities
private fun objToJson(obj: User) = Gson().toJson(obj)
private fun jsonToObj(json: String) = Gson().fromJson(json, User::class.java)
