package com.chainreaction.moviesassignmentapp.di

import com.chainreaction.caching.manager.CachingManager
import com.chainreaction.moviesassignmentapp.data.home.HomeService
import com.chainreaction.moviesassignmentapp.data.home.repository.HomeLocalRepository
import com.chainreaction.moviesassignmentapp.data.home.repository.HomeRepository
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeLocalRepository
import com.chainreaction.moviesassignmentapp.domain.home.repository.IHomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun getHomeRepository(homeService: HomeService): IHomeRepository {
        return HomeRepository(homeService)
    }

    @Provides
    @ViewModelScoped
    fun getHomeLocalRepository(cachingManager: CachingManager): IHomeLocalRepository {
        return HomeLocalRepository(cachingManager)
    }


}