package com.udacity.asteroidradar.repository

import com.udacity.asteroidradar.Asteroid

interface AppRepositoryManager {

    suspend fun getAsteroid () : ArrayList<Asteroid>

    suspend fun insertAllAsteroid (asteroid:ArrayList<Asteroid>)
}