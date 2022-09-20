package com.joshMuleshi.ecodim.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joshMuleshi.ecodim.presentation.auth.AuthScreen
import com.joshMuleshi.ecodim.presentation.home.Homescreen
import com.joshMuleshi.ecodim.presentation.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screen.Auth.route) {
            AuthScreen(navController = navController)
        }
        composable(route = Screen.Home.route){
            Homescreen(navController = navController)
        }
        composable(route = Screen.Result.route){

        }
    }
}
