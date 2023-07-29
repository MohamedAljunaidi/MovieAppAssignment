package com.chainreaction.caching.roomdb.common

import android.content.Context
import androidx.room.Room
import com.chainreaction.caching.roomdb.common.DatabaseRoom

object RoomClient {

    fun createDatabaseRoom(
        context:Context
    ): DatabaseRoom {
        return  Room
            .databaseBuilder(context, DatabaseRoom::class.java, RoomConstants.DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }

}