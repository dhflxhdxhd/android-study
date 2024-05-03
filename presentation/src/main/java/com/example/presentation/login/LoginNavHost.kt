package com.example.presentation.login

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginNavHost() {
    val navController : NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = LoginRoute.WelcomeScreen.name){
        composable(
            route = LoginRoute.WelcomeScreen.name
        ){
            WelcomeScreen( onNavigateToLoginScreen = {
                Log.e("honam", "로그인 페이지로 이동")
                navController.navigate(LoginRoute.LogInScreen.name)
            })
        }

        composable(
            route = LoginRoute.LogInScreen.name
        ){
            LoginScreen()

        }

        composable(
            route = LoginRoute.SignUpScreen.name
        ){
            SignUpScreen(
                id = "test",
                username = "Charles",
                password1 = "test1234",
                password2 = "test1234",
                onIdChange = {},
                onUsernameChange = {},
                onPassword1Change = {},
                onPassword2Change = {},
                onSignUpClick = {})
        }
    }
}