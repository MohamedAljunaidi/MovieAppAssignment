package com.chainreaction.caching.roomdb.features.tvshow.dao

import androidx.room.Dao
import androidx.room.Query
import com.chainreaction.caching.roomdb.common.BaseDao
import com.chainreaction.caching.roomdb.features.tvshow.entities.TvShowEntity

@Dao
interface TvShowDao : BaseDao<TvShowEntity> {

    @Query("SELECT * FROM TvShowEntity")
    fun getTvShows(): List<TvShowEntity>

}
