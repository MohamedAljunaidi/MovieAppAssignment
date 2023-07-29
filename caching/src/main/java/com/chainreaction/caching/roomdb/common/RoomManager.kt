package com.chainreaction.caching.roomdb.common

import com.chainreaction.caching.manager.BaseManager
import com.chainreaction.caching.roomdb.features.tvshow.entities.TvShowEntity
import com.chainreaction.caching.util.safeLocalDataCall
import com.chainreaction.core.bases.ResultWrapper
import javax.inject.Inject

class RoomManager @Inject constructor(private val databaseRoom: DatabaseRoom) : BaseManager {

    override suspend fun insertTvShows(tvShowEntity: List<TvShowEntity>): ResultWrapper<Unit> =
        safeLocalDataCall { databaseRoom.tvShowDao().insert(tvShowEntity) }

    override suspend fun getTvShows() =
        safeLocalDataCall { databaseRoom.tvShowDao().getTvShows() }

}