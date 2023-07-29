package com.chainreaction.moviesassignmentapp.common

import com.chainreaction.moviesassignmentapp.data.home.model.TvShowResponse
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow

internal fun List<TvShowResponse>.tvShowsResponseToTvShows(): List<TvShow> {

    val tvShowsList = arrayListOf<TvShow>()

    this.forEach { tvShowResponse ->
        tvShowsList.add(
            TvShow(
                name = tvShowResponse.name ?: "",
                id = tvShowResponse.id ?: 0,
                startDate = tvShowResponse.startDate ?: "",
                image = tvShowResponse.imageThumbnailPath ?: "",
                network = tvShowResponse.network ?: ""
            )
        )
    }
    return tvShowsList
}

