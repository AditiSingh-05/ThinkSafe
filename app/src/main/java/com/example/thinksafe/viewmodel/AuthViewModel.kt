package com.example.thinksafe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore




class AuthViewModel:ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _user = MutableLiveData< FirebaseUser?>()
    val user : LiveData<FirebaseUser?> = _user

    init{
        _user.value = auth.currentUser
    }
    fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            onResult(task.isSuccessful, task.exception?.message)
        }
    }

    fun signUp(email: String, password: String, name: String, onResult: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = auth.currentUser?.uid
                if (userId != null) {
                    val user = hashMapOf("name" to name, "email" to email)
                    FirebaseFirestore.getInstance().collection("users").document(userId).set(user)
                        .addOnSuccessListener { onResult(true, null) }
                        .addOnFailureListener { e -> onResult(false, e.message) }
                }
            } else {
                onResult(false, task.exception?.message)
            }
        }
    }

    fun logout() {
        auth.signOut()
        _user.value = null
    }




}