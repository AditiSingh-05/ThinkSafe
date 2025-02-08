package com.example.thinksafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.thinksafe.ui.theme.ThinkSafeTheme
import com.example.thinksafe.viewmodel.AuthViewModel
import com.example.thinksafe.viewmodel.NotesViewModel
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            ThinkSafeTheme {
                val navController = rememberNavController() // Remembering the navigation controller
                NavGraph(navController , notesViewModel = NotesViewModel(), authViewModel = AuthViewModel())
            }
        }
    }
}
