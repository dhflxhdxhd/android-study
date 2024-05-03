package com.example.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel(), ContainerHost<LoginState, LoginSideEffect> {

    override val container: Container<LoginState, LoginSideEffect> = container(
        initialState = LoginState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
                intent {
                    postSideEffect(LoginSideEffect.Toast(message = throwable.message.orEmpty()))
                }
            }
        }

    )

    fun onLoginClick() = intent {
        Log.e("honam" ,"onLoginClick")
        val id = state.id
        val password = state.password
        val token : String = loginUseCase(id, password).getOrThrow()
//        postSideEffect(LoginSideEffect.Toast("$token 인지 아니니지 무튼"))
    }

    fun onIdChange(id: String) = intent {
        Log.d("honam viewModel", id)
        reduce {
            state.copy(id = id)
        }
    }

    fun onPasswordChange(password: String) = intent {
        Log.d("honam viewModel", password)
        reduce {
            state.copy(password = password)
        }
    }
}

data class LoginState(
    val id: String = "",
    val password: String = ""
)

sealed interface LoginSideEffect {
    class Toast(val message : String) : LoginSideEffect
}