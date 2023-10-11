package com.ihrsachin.apostle.permissions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class StoragePermission (private val context : Context){

    private val STORAGE_CONSTANT = 222

    fun checkPermission(): Boolean {
        return if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            // android below 10
            val write =
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val read =
                ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)

            write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED
        } else {
            // android 10+, request permission through MediaStore API
            Environment.isExternalStorageManager()
        }
    }

    fun requestPermission() {

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            // android below 10
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                STORAGE_CONSTANT
            )
        } else {
            // android 10+, request permission through MediaStore API
            try {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.addCategory("android.intent.category.DEFAULT")
                intent.data =
                    Uri.parse(String.format("package:%s", (context as Activity).packageName))
                context.startActivityForResult(intent, STORAGE_CONSTANT)
            } catch (e: Exception) {
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                (context as Activity).startActivityForResult(intent, STORAGE_CONSTANT)
            }
        }
    }

    fun showDialogue(){

    }
}

