package com.example.rest_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() , ServiceCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_measurements.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val measurements = CoroutineScope(Dispatchers.IO).async {
                    // TO DO
                }.await()

                //after the asynchronous call, we can use the result and show it in the Main thread
                var measurementsStr = ""

                textView_measurements.text = measurementsStr
            }
        }

        button_postMeasurement.setOnClickListener {
            // TO DO
            // CoroutineScope MAIN launch
            // CoroutineScope IO async
        }
    }

    override fun onSuccess(measurements: ArrayList<Measurement>) {
        //after the asynchronous call, we can use the result and show it in the Main thread
       // TO DO
    }

    override fun onError(throwable: Throwable) {
        TODO("not implemented")
    }

    private fun getAllMeasurements(): ArrayList<Measurement> {
        // TO DO
        return arrayListOf<Measurement>()
    }

    private fun postMeasurement() {
       // TO DO
    }

    /*private fun getAllMeasurementsAsynch() {
        val client = RetrofitRestClient()

        client.getMeasurementsAsynch(this)
    }*/
}
