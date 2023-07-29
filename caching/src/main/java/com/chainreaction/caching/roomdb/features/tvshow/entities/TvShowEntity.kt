package com.chainreaction.caching.roomdb.features.tvshow.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TvShowEntity")
data class TvShowEntity(
    @SerializedName("name")
    var name: String,

    @SerializedName("start_date")
    var startDate: String,

    @SerializedName("network")
    var network: String,

    @SerializedName("image_thumbnail_path")
    var image: String,

    @SerializedName("id")
    @PrimaryKey
    var id: Long,

    )
