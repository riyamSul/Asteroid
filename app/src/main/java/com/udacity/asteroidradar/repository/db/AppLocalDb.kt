package com.udacity.asteroidradar.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.repository.db.dao.AsteroidDao
import com.udacity.asteroidradar.repository.db.entity.Asteroid

@Database(entities = [Asteroid::class] , version = 1)
abstract class AppLocalDb : RoomDatabase(){

    abstract val asteroidDao : AsteroidDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: AppLocalDb

        fun getDataBase(context: Context): AppLocalDb {
            synchronized(AppLocalDb::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppLocalDb::class.java,
                        "asteroidDb.db"
                    ).build()
                }
                return INSTANCE
            }
        }

    }
}