package com.chainreaction.caching.util

import android.R.attr.description
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.chainreaction.caching.roomdb.common.RoomConstants
import java.io.File
import java.io.IOException


/**
 * Created by Mohammad Aljunaidi on 18/03/2023.
 */

fun Activity.backupDatabase() {
    // Get the database file
    val dbFile = this.getDatabasePath(RoomConstants.DATABASE_NAME)

    try {

        // Copy database file to a temp file in (filesDir)
        val parent = File(this.filesDir, "databases_temp")
        val file = File(parent, "My DB")
        if (file.exists().not())
            dbFile.copyTo(file)

        // Get Uri of the copied database file from filesDir to be used in email intent
        val uri = getUri(this.applicationContext, file)


        this.shareData( uri)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

private fun getUri(context: Context, file: File): Uri {
    var uri = Uri.fromFile(file)
    if (Build.VERSION.SDK_INT >= 24) {
        uri = FileProvider.getUriForFile(
            context,
            "com.android.example.provider", file
        )
    }
    return uri
}

fun Activity.shareData(attachment: Uri) {
    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_STREAM, attachment)
        type = "text/*"
    }
    startActivity(Intent.createChooser(shareIntent, null))
}