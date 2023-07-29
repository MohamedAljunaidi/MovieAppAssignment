package com.chainreaction.moviesassignmentapp.data.home.repository

import com.chainreaction.moviesassignmentapp.data.home.HomeService
import com.chainreaction.core.bases.ResultWrapper
import com.chainreaction.moviesassignmentapp.common.tvShowsResponseToTvShows
import com.chainreaction.network.extensions.tryRequest
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository(private val homeService: HomeService) : IHomeRepository {

    override fun getTvShows(): Flow<ResultWrapper<List<TvShow>?>> = flow {

        val result = tryRequest(
            request = {
                homeService.getMostPopular()
            },
            dataToDomain = { response ->

                response?.tvShowResponses?.tvShowsResponseToTvShows()
            }
        )
        emit(result)
    }
}