package com.chainreaction.caching.roomdb.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chainreaction.caching.roomdb.features.tvshow.dao.TvShowDao
import com.chainreaction.caching.roomdb.features.tvshow.entities.TvShowEntity

@Database(
    entities = [TvShowEntity::class],
    version = RoomConstants.DATABASE_VERSION
)
abstract class DatabaseRoom : RoomDatabase() {

    abstract fun tvShowDao(): TvShowDao
}
