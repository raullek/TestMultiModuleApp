package ru.sberbank.authorization.ui.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.launch
import ru.sberbank.authorization.domain.AuthorizationRepository
import ru.sberbank.authorization.helper.Result
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(private val authorizationRepository: AuthorizationRepository) :
    ViewModel() {
    val authResult = MutableLiveData<Result<AuthResult?>>()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
           val result = authorizationRepository.signUp(email,password)
            authResult.postValue(result)
        }
    }


}