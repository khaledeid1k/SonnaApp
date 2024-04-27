package com.sonna.remote.download_manger

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

class DownloadCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val downloadManager = context!!.getSystemService(DownloadManager::class.java)

        if (intent?.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
            if (id != -1L) {
                val query = DownloadManager.Query().apply {
                    setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL)
                    setFilterById(id)
                }
                val cursor = downloadManager.query(query)
                if (cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI)
                    val downloadFileLocalUri = cursor.getString(columnIndex)
                    if (downloadFileLocalUri != null) {
                        val file = Uri.parse(downloadFileLocalUri).path?.let { File(it) }
                        val downloadFilePath = file?.absolutePath
                        Log.d("downloadFile", "downloadedFilePath => $downloadFilePath")
                        Log.d("downloadFile", "file => $file")
                        try {
                            val inputStream = FileInputStream(file)
                            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                            var line: String?
                            while (bufferedReader.readLine().also { line = it } != null) {
                                Log.d("downloadFile", "line => $line")
                            }
                            bufferedReader.close()
                            inputStream.close()
                        } catch (e: IOException) {
                            Log.d("downloadFile", "IOException => File not found: ${e.message}")
                        }
                    }
                } else {
                    Log.d("downloadFile", "File not found or download failed")
                }
                cursor.close()
            }
        }

    }
}