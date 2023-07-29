package com.chainreaction.moviesassignmentapp.domain.home.repository

import com.chainreaction.core.bases.ResultWrapper
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import kotlinx.coroutines.flow.Flow

interface IHomeLocalRepository {

    fun getTvShows(): Flow<ResultWrapper<List<TvShow>?>>
    fun insertTvShows(tvShows: List<TvShow>?): Flow<ResultWrapper<Unit?>>
}