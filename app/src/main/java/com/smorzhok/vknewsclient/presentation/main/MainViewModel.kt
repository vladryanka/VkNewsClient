package com.smorzhok.vknewsclient.presentation.main

import androidx.lifecycle.ViewModel
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.id.AccessToken
import com.vk.id.VKID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel() : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> get() = _authState

    init {
        val isLoggedIn = getVkAccessToken() != null
        if (isLoggedIn) {
            _authState.value = AuthState.Authorized
        } else {
            _authState.value = AuthState.Unauthorized
        }
    }

    private fun getVkAccessToken(): AccessToken? {
        return VKID.Companion.instance.accessToken
    }

    fun performAuthResult(result: VKAuthenticationResult) {
        _authState.value = when (result) {
            is VKAuthenticationResult.Success -> {
                AuthState.Authorized
            }
            is VKAuthenticationResult.Failed -> {
                AuthState.Unauthorized
            }
        }
    }

}