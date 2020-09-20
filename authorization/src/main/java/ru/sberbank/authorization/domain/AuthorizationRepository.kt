package ru.sberbank.authorization.domain

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import ru.sberbank.authorization.data.datasource.FirebaseSource
import ru.sberbank.authorization.helper.Result
import javax.inject.Inject

interface AuthorizationRepository {
   suspend fun logIn(email: String, password: String): Result<AuthResult?>
   suspend fun signUp(email: String, password: String):Result<AuthResult?>
    fun logOut()
    fun currentUser():FirebaseUser

}

class AuthorizationRepositoryImpl @Inject constructor(
    private val firebaseSource: FirebaseSource
) : AuthorizationRepository {
  override suspend fun logIn(email: String, password: String): Result<AuthResult?> {
        return firebaseSource.logIn(email,password)
    }

    override suspend fun signUp(email: String, password: String): Result<AuthResult?> {
        return firebaseSource.signUp(email,password)
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }

    override fun currentUser(): FirebaseUser {
        TODO("Not yet implemented")
    }


}
