package com.chainreaction.moviesassignmentapp.data.home.model


import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("country")
    var country: String? = "",
    @SerializedName("end_date")
    var endDate: String? = "",
    @SerializedName("id")
    var id: Long? = 0,
    @SerializedName("image_thumbnail_path")
    var imageThumbnailPath: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("network")
    var network: String? = "",
    @SerializedName("permalink")
    var permalink: String? = "",
    @SerializedName("start_date")
    var startDate: String? = "",
    @SerializedName("status")
    var status: String? = ""
)