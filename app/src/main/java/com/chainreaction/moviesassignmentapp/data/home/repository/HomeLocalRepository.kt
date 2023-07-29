package com.chainreaction.moviesassignmentapp.data.home.repository

import com.chainreaction.caching.manager.CachingManager
import com.chainreaction.caching.manager.ProviderEnum
import com.chainreaction.caching.util.tryMapperQuery
import com.chainreaction.core.bases.ResultWrapper
import com.chainreaction.moviesassignmentapp.common.tvShowToTvShowsEntity
import com.chainreaction.moviesassignmentapp.common.tvShowsEntityToTvShows
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeLocalRepository(private val cachingManager: CachingManager) :
    IHomeLocalRepository {

    override fun getTvShows(): Flow<ResultWrapper<List<TvShow>?>> = flow {
        val result = tryMapperQuery({
            cachingManager.getProvider(ProviderEnum.ROOM).getTvShows()
        })
        { tvShowEntity ->
            tvShowEntity?.tvShowsEntityToTvShows()
        }
        emit(result)
    }

    override fun insertTvShows(tvShows: List<TvShow>?): Flow<ResultWrapper<Unit?>> =
        flow {
            val result = tryMapperQuery({
                tvShows?.tvShowToTvShowsEntity()?.let {
                    cachingManager.getProvider(ProviderEnum.ROOM)
                        .insertTvShows(it)
                }
            }) {}
            emit(result)
        }


}
