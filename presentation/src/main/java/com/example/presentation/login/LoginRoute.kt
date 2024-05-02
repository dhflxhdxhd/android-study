package com.example.presentation.login

sealed class LoginRoute (val name : String){
    object WelcomeScreen: LoginRoute("WelcomeScreen")
    object LogInScreen: LoginRoute("LogInScreen")
    object SignUpScreen: LoginRoute("SignUpScreen")

}