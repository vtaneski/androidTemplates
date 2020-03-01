package com.example.rest_retrofit

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

const val user_email = "dummy@user.si"
const val base_url = "http://164.8.250.18:8080/measurements/"
const val api_key = "API-Key: 16ec1e09-aa26-446c-b6fa-f73fa89fee53"

interface RetrofitService {

    // TO DO
    // getMeasurements

    //TO DO
    // postMeasurement

    @Headers("user: $user_email", api_key)
    @DELETE("rest/measurements/{id}")
    fun deleteMeasurement(@Path("id") id: String): Call<Void>
}

class RetrofitRestClient {

    public fun addMeasurement(m: Measurement) {
        // TO DO
        // postMeasurement execute
    }

    public fun getAllMeasurements() : ArrayList<Measurement> {
        // TO DO
        // getAllMEasurements execute
        return arrayListOf<Measurement>()
    }

    private fun getService() :RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

    private fun convert(r :List<Measurement>?) :ArrayList<Measurement> {
        var res= arrayListOf<Measurement>()
        r?.forEach {
            res.add(Measurement(it.comment, it.geo, it.id, it. label ,
                it.measurementType, it.timeStamp, it.unit, it.userEmail, it.value))
        }
        return res;
    }

    //ASINHRONO
    /*fun getMeasurementsAsynch(callback: ServiceCallback){
        Log.i("RetrofitService","RetrofitRestClient.getMeasurementsAsynch")
        var measurements: ArrayList<Measurement>? = null

        getService().getMeasurements().enqueue(object : Callback<List<Measurement>> {
            override fun onResponse(call: Call<List<Measurement>>, response: Response<List<Measurement>>) {
                if (response.code() == 200) {
                    Log.i("RetrofitService","Response: ${response.body()}")
                    measurements = convert(response.body())

                    callback.onSuccess(measurements ?: arrayListOf<Measurement>())
                }
            }

            override fun onFailure(call: Call<List<Measurement>>, t: Throwable) {
            }
        })
    }*/
}
