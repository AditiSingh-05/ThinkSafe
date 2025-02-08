package com.example.thinksafe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thinksafe.AppScreens
import com.example.thinksafe.viewmodel.AuthViewModel
import com.example.thinksafe.viewmodel.NotesViewModel

@Composable
fun HomeScreen(authViewModel: AuthViewModel, notesViewModel: NotesViewModel, navController: NavController) {
    val userName = authViewModel.userName.observeAsState("User").value // ✅ Correct

    LaunchedEffect(Unit) {
        authViewModel.fetchUserName()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome, $userName",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(
            onClick = { navController.navigate(AppScreens.AddNoteScreen.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Note")
        }

        Button(
            onClick = {
                authViewModel.logout()
                navController.navigate("loginScreen")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Logout")
        }
    }
}

