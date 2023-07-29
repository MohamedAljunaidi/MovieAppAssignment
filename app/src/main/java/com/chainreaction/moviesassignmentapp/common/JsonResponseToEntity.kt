package com.chainreaction.moviesassignmentapp.common

import com.chainreaction.caching.roomdb.features.tvshow.entities.TvShowEntity
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow

internal fun List<TvShowEntity>.tvShowsEntityToTvShows(): List<TvShow> {
    val mostPopularList = arrayListOf<TvShow>()
    this.map {
        mostPopularList.add(
            TvShow(
                name = it.name,
                id = it.id,
                image = it.image,
                startDate = it.startDate,
                network = it.network
            )
        )
    }
    return mostPopularList
}

internal fun List<TvShow?>.tvShowToTvShowsEntity(): List<TvShowEntity> {
    val tvShowEntityList = arrayListOf<TvShowEntity>()
    this.map { mostPopular ->
        tvShowEntityList.add(
            TvShowEntity(
                name = mostPopular?.name ?: "",
                id = mostPopular?.id ?: 0,
                image = mostPopular?.image ?: "",
                startDate = mostPopular?.startDate ?: "",
                network = mostPopular?.network ?: ""
            )
        )
    }
    return tvShowEntityList
}

