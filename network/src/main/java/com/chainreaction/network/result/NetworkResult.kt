package com.chainreaction.network.result

import com.chainreaction.network.common.NetworkException

sealed class NetworkResult<out T> {

    data class Success<T>(val data: T?) : NetworkResult<T>()

    data class Error(val error: NetworkException) : NetworkResult<Nothing>()

}