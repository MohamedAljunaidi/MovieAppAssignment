package com.chainreaction.moviesassignmentapp.data.home

import com.chainreaction.moviesassignmentapp.data.home.model.MostPopularResponse
import com.chainreaction.network.result.NetworkResult
import com.chainreaction.network.services.ApiManager
import javax.inject.Inject

class HomeService @Inject constructor(private val apiManager: ApiManager) {

    companion object {

        private const val PAGE = "page"
        private const val PATH_EVENT_DETAILS =
            "most-popular"
    }

    suspend fun getMostPopular(): NetworkResult<MostPopularResponse> {
        return apiManager.getRequest(
            PATH_EVENT_DETAILS,
            queryParamsMap = mapOf(
                PAGE to "1"
            )
        )
    }
}