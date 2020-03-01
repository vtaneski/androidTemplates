package com.example.preferences

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = getPreferencesData()

        button.setOnClickListener {
            val property = editText.text.toString()
            savePreferenceData(property)
        }

        buttonClear.setOnClickListener {
            clearPreferencesData()
        }
    }

    private fun savePreferenceData(property: String) {
        // TO DO
    }

    private fun getPreferencesData(): String {
       // TO DO

        return ""
    }

    private fun clearPreferencesData() {
        // TO DO
    }
}
