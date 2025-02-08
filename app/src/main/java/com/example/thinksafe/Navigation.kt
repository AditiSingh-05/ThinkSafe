package com.example.thinksafe

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thinksafe.ui.AddNoteScreen
import com.example.thinksafe.ui.HomeScreen
import com.example.thinksafe.ui.LoginScreen
import com.example.thinksafe.ui.SignUpScreen
import com.example.thinksafe.viewmodel.AuthViewModel
import com.example.thinksafe.viewmodel.NotesViewModel

@Composable
fun NavGraph(navController: NavController, notesViewModel: NotesViewModel, authViewModel: AuthViewModel) {
    val navController = rememberNavController() // Navigation controller
    NavHost(navController, startDestination = AppScreens.LoginScreen.route) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(authViewModel = authViewModel,navController)
        }
        composable(AppScreens.SignUpScreen.route) {
            SignUpScreen(authViewModel = authViewModel,navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(authViewModel = authViewModel, notesViewModel = notesViewModel,navController)
        }
        composable(AppScreens.AddNoteScreen.route) {
            AddNoteScreen( authViewModel = authViewModel,notesViewModel = notesViewModel,navController)
        }
    }
}