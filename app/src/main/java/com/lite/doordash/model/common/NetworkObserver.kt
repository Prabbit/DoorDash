package com.lite.doordash.model.common

import android.arch.lifecycle.Observer

abstract class NetworkObserver: Observer<NetworkState> {

    override fun onChanged(t: NetworkState?) {
        when (t) {
            is NetworkState.Success-> onSuccess(t)
            is NetworkState.Error -> onError(t)
            is NetworkState.Loading -> onLoading()
            else -> IllegalStateException("NetworkState is not correct")
        }
    }

    abstract fun onSuccess(result: NetworkState.Success)
    abstract fun onError(result: NetworkState.Error)
    abstract fun onLoading()
}