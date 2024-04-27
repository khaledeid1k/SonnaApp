package com.sonna.remote.download_manger

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class DownloaderFile(private val context: Context) {
    private val downloadManager = context.getSystemService(DownloadManager::class.java)
    fun downloadFile(url: String, hadithBookName: String): Long {
        val request = DownloadManager.Request(url.toUri())
            //val request = DownloadManager.Request("https://docs.google.com/document/d/1mzE8yiWoVUlwqbLN9COx6FwfiSDk2yLeoUKV_qQPlrU/edit?usp=drive_link".toUri())
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(hadithBookName)
            .setDestinationInExternalFilesDir(
                context,
                Environment.DIRECTORY_DOWNLOADS,
                hadithBookName
            )
        return downloadManager.enqueue(request)
    }
}