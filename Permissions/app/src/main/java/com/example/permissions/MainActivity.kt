package com.example.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    private val util = PermissionUtil(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave.setOnClickListener {
            saveExternalDataStreamPermissions()
        }

        buttonRead.setOnClickListener {
            readExternalDataStreamPermissions()
        }
    }

    /**
     * This method is called when a user Allow or Deny our requested permissions.
     * So it will help us to move forward if the permissions are granted.
     */
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            util.WRITE_EXTERNAL_PERMISSION_ID -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Granted. Start saving the file
                    val fileName = "File1"
                    val fileContent = "Content of file1"
                    saveExternalDataStream(fileName, fileContent)
                } else {
                    // Check if you need to show additional explanation
                    // TO DO
                }
            }
            util.READ_EXTERNAL_PERMISSION_ID -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Granted. Start reading the file
                    val fileName = "File1"
                    readExternalDataStream(fileName)
                } else {
                    // Check if you need to show additional explanation
                    // TO DO
                }
            }
        }
    }

    /**
     * Saves data to file in external storage
     */
    private fun saveExternalDataStreamPermissions() {
        val fileName = "File1"
        val fileContent = "Content of File1"

        if (fileName.trim() != "") {
            when (util.checkWriteExternalPermissions()) {
                true -> {
                    // if we already have permissions
                }
                false -> {
                    // if we do not have permissions
                    // ask for permissions
                }
            }
        } else{
            Toast.makeText(applicationContext,"file name cannot be blank", Toast.LENGTH_LONG).show()
        }
    }

    private fun saveExternalDataStream(fileName: String, fileContent: String) {
        Toast.makeText(applicationContext, "data save", Toast.LENGTH_SHORT).show()
    }

    /**
     * Reads data from a file in external storage
     */
    private fun readExternalDataStreamPermissions() {
        val fileName = "File1"

        if (fileName.trim() != "") {
            when (util.checkReadExternalPermissions()) {
                true -> {
                    // if we already have permissions
                }
                false -> {
                    // if we do not have permissions
                    // ask for permissions
                }
            }
        }else{
            Toast.makeText(applicationContext,"file name cannot be blank", Toast.LENGTH_LONG).show()
        }
    }

    private fun readExternalDataStream(fileName: String) {
        Toast.makeText(applicationContext,"Reading file...", Toast.LENGTH_LONG).show()
    }
}
