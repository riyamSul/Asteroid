package com.udacity.asteroidradar.repository.api

import com.udacity.asteroidradar.Asteroid

interface ApiRepository {
    suspend fun getAsteroids() : ArrayList<Asteroid>
}