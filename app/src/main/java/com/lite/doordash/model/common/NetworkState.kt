package com.lite.doordash.model.common

sealed class NetworkState {
    data class Success(val data: Any? = null) : NetworkState()
    data class Error(val errorData: Any? = null, val errorMessage: String? = null) : NetworkState()
    class Loading(val message: String?=null) : NetworkState()
}