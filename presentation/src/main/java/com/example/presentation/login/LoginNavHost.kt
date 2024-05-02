package com.example.presentation.login

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
                navController.navigate(LoginRoute.LogInScreen.name)
            })
        }

        composable(
            route = LoginRoute.LogInScreen.name
        ){
            LoginScreen(
                id = "deseruisse",
                password = "mi",
                onIdChange = {},
                onPasswordChange = {},
                onNavigateToSignUpScreen = {}
            )

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