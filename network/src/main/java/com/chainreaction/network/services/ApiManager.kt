package com.chainreaction.network.services

import com.chainreaction.network.extensions.getModel
import com.chainreaction.network.extensions.map
import com.chainreaction.network.extensions.safeApiCall
import com.chainreaction.network.result.NetworkResult
import javax.inject.Inject

class ApiManager @Inject constructor(
    val services: ApiRequests,
) {

    suspend inline fun <reified T> getRequest(
        url: String,
        headersMap: Map<String, String>? = mapOf(),
        queryParamsMap: Map<String, Any?>? = mapOf()
    ): NetworkResult<T> =
        safeApiCall {
            services.getRequest(
                url = url,
                headersMap = headersMap,
                queryParamsMap = queryParamsMap
            )
        }.map { response ->
                response?.body()?.getModel()
            }
}