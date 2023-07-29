package com.chainreaction.moviesassignmentapp.domain.home.usecases

import com.chainreaction.core.bases.BaseUseCase
import com.chainreaction.core.bases.ResultWrapper
import com.chainreaction.core.extensions.networkBoundResource
import com.chainreaction.core.extensions.resultWrapperData
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeLocalRepository
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

class GetTvShowsUseCase @Inject constructor(
    private val remoteRepository: IHomeRepository,
    private val localRepository: IHomeLocalRepository
) : BaseUseCase<String, Flow<ResultWrapper<List<TvShow>?>>> {

    private var response: Flow<ResultWrapper<List<TvShow>?>> = emptyFlow()

    override suspend fun invoke(params: String?): Flow<ResultWrapper<List<TvShow>?>> =
        networkBoundResource(
            queryDb = {
                localRepository.getTvShows()
            },
            fetchApi = {
                remoteRepository.getTvShows()
            },
            saveApiResult = { fetchResult ->
                fetchResult.collect { resultWrapper ->
                    this.response = flowOf(resultWrapper)

                    resultWrapperData(resultWrapper, { mostPopulars ->
                        localRepository.insertTvShows(
                            tvShows = mostPopulars
                        ).collect()
                    }, {
                        localRepository.getTvShows()
                    })
                }
            }, onQueryDbError = {
                response
            }
        )
}

