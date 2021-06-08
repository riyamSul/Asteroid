package com.udacity.asteroidradar.repository.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants.API_KEY
import com.udacity.asteroidradar.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//Retrofit builder with ScalerConvertorFactory and BASE_URL
private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

//Api Service Interface
interface AsteroidApiService {
    @GET(EndPoints.FEED)
    suspend fun getFeeds(
     @Query("start_date") startDate : String ,
     @Query("end_date") endDate : String ,
     @Query("api_key") apiKey : String = API_KEY
    ) : String
}

// Create the api object using retrofit and passing the interface we created
// We only need one instance for whole application so we use singel ton
object AsteroidApi {
    val retrofitService : AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}
