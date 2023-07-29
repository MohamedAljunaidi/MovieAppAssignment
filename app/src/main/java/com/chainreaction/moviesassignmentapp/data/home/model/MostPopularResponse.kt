package com.chainreaction.moviesassignmentapp.data.home.model


import com.google.gson.annotations.SerializedName

data class MostPopularResponse(
    @SerializedName("page")
    var page: Int?=0,
    @SerializedName("pages")
    var pages: Int?=0,
    @SerializedName("total")
    var total: String?="",
    @SerializedName("tv_shows")
    var tvShowResponses: List<TvShowResponse>? = listOf()
)