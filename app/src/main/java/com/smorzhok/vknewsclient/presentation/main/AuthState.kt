package com.smorzhok.vknewsclient.presentation.main

sealed class AuthState {
    object Authorized: AuthState()
    object Unauthorized: AuthState()
    object Initial: AuthState()
}