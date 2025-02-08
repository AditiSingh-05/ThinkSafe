package com.example.thinksafe.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.thinksafe.model.Note
import com.example.thinksafe.viewmodel.NotesViewModel

@Composable
fun AddNoteScreen(notesViewModel: NotesViewModel, navController: NavController) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        TextField(value = content, onValueChange = { content = it }, label = { Text("Content") })

        Button(onClick = {
            val newNote = Note(title = title, content = content, userId = "USER_ID")
            notesViewModel.addNote(newNote)
            navController.popBackStack()
        }) {
            Text("Save Note")
        }
    }
}
