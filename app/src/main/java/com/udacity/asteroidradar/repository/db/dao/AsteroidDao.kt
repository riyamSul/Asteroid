package com.udacity.asteroidradar.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.udacity.asteroidradar.repository.db.entity.Asteroid

@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(vararg asteroid: Asteroid)
}