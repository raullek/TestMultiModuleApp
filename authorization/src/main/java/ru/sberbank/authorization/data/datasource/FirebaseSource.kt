package ru.sberbank.authorization.data.datasource

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import ru.sberbank.authorization.helper.Result
import ru.sberbank.authorization.helper.await
import javax.inject.Inject

class FirebaseSource @Inject constructor() {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    suspend fun logIn(email: String, password: String): Result<AuthResult?> {
        return try {
            Result.loading(null)
            val data = firebaseAuth
                .signInWithEmailAndPassword(email, password)
                .await()
            Result.success(data)
        } catch (e: Exception) {
            Result.error("")
        }
    }

    suspend fun signUp(email: String, password: String): Result<AuthResult?> {
        return try {
            val data = firebaseAuth
                .createUserWithEmailAndPassword(email, password)
                .await()
            Result.success(data)
        } catch (e: Exception) {
            Result.error(e.message.toString())
        }
    }

    fun logout() = firebaseAuth.signOut()

    fun currentUser() = firebaseAuth.currentUser


}