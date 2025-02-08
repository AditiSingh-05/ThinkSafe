package com.example.thinksafe

sealed class AppScreens (val route : String){
    object LoginScreen : AppScreens("login_screen")
    object SignUpScreen : AppScreens("signup_screen")
    object HomeScreen : AppScreens("home_screen")
    object AddNoteScreen : AppScreens("add_note_screen")
}