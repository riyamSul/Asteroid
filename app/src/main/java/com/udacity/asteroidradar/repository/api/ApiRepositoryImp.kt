package com.udacity.asteroidradar.repository.api

import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.repository.db.AppLocalDb
import org.json.JSONObject

class ApiRepositoryImp private constructor(): ApiRepository {

    override suspend fun getAsteroids(): ArrayList<Asteroid> {
        var days = getNextSevenDaysFormattedDates()
        // Call api
        var result = parseAsteroidsJsonResult(JSONObject(asteroidApiService.getFeeds(
            days.first(),
            days.last())))
       return result
    }

    val asteroidApiService : AsteroidApiService

    init {
       asteroidApiService = AsteroidApi.retrofitService
    }

    //Create singleton
    companion object {
            val instance = ApiRepositoryImp()
    }
}