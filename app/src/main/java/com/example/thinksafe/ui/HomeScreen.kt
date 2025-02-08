package com.example.thinksafe.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.thinksafe.AppScreens
import com.example.thinksafe.viewmodel.AuthViewModel
import com.example.thinksafe.viewmodel.NotesViewModel

@Composable
fun HomeScreen(authViewModel: AuthViewModel, notesViewModel: NotesViewModel, navController: NavController) {
    Column {
        Text("Welcome, ${authViewModel.user.value?.email ?: "Guest"}")

        Button(onClick = { navController.navigate(AppScreens.AddNoteScreen.route) }) {
            Text("Add Note")
        }

        Button(onClick = {
            authViewModel.logout()
            navController.navigate("loginScreen")
        }) {
            Text("Logout")
        }
    }
}
