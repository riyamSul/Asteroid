package com.udacity.asteroidradar.repository

import android.app.Application
import android.content.Context
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.repository.api.ApiRepositoryImp
import com.udacity.asteroidradar.repository.db.AppLocalDb

class AppRepositoryManagerImp private constructor(context: Context) : AppRepositoryManager {
    private val apiRepositoryImp : ApiRepositoryImp
    private val appLocalDb : AppLocalDb


    init {
        apiRepositoryImp = ApiRepositoryImp.instance
        appLocalDb = AppLocalDb.getDataBase(context)

    }

    override suspend fun getAsteroid(): ArrayList<Asteroid> {
        return apiRepositoryImp.getAsteroids();
    }

    override suspend fun insertAllAsteroid(asteroid: ArrayList<Asteroid>) {
        appLocalDb.asteroidDao.insertFeed(asteroid)
    }

    companion object {

        fun getInstance (context: Context) : AppRepositoryManagerImp {
            val instance = AppRepositoryManagerImp(context)

        }
    }

}