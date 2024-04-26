package com.sonna.remote.download_manger

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class DownloaderFile(private val context: Context) {
    private val downloadManger = context.getSystemService(DownloadManager::class.java)
    fun downloadFile(url: String, hadithBookName: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(hadithBookName)
            .setDestinationInExternalFilesDir(
                context,
                Environment.DIRECTORY_DOWNLOADS,
                hadithBookName
            )


        return downloadManger.enqueue(request)
    }
}