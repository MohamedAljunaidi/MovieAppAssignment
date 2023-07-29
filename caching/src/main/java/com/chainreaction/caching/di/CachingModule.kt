package com.chainreaction.caching.di

import android.content.Context
import com.chainreaction.caching.manager.CachingManager
import com.chainreaction.caching.roomdb.common.DatabaseRoom
import com.chainreaction.caching.roomdb.common.RoomClient
import com.chainreaction.caching.roomdb.common.RoomManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CachingModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DatabaseRoom {
        return RoomClient.createDatabaseRoom(appContext)
    }

    @Provides
    @Singleton
    fun provideCachingManager(
        roomManager: RoomManager
    ): CachingManager {
        return CachingManager( roomManager)
    }
}