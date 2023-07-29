package com.chainreaction.caching.roomdb.common

import com.chainreaction.caching.roomdb.features.tvshow.entities.TvShowEntity
import com.chainreaction.core.bases.ResultWrapper

interface IRoomManager {

    suspend fun insertTvShows(tvShowEntity: List<TvShowEntity>): ResultWrapper<Unit>? = null
    suspend fun getTvShows(): ResultWrapper<List<TvShowEntity>>? = null
}