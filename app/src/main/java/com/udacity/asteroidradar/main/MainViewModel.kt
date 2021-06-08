package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.repository.AppRepositoryManagerImp
import com.udacity.asteroidradar.repository.db.AppLocalDb
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(application : Application): AndroidViewModel(application) {

    //private var _asteroidList = MutableLiveData<MutableList<Asteroid>>()
    private var _asteroidList = MutableLiveData<MutableList<Asteroid>>()
    val asteroidList : LiveData<MutableList<Asteroid>>
    get() = _asteroidList

    private val repository : AppRepositoryManagerImp
    private val appLocalDb : AppLocalDb
    init {
        repository = AppRepositoryManagerImp.getInstance(application.applicationContext)
        appLocalDb = AppLocalDb.getDataBase(application.applicationContext)
        getAsteroids()
    }

    private fun getAsteroids() {
        viewModelScope.launch {
            try {
                var result = repository.getAsteroid()
                _asteroidList.value = result.toMutableList()
                repository.insertAllAsteroid(result)
                //appLocalDb.asteroidDao.insertFeed(result)
            } catch (e : Exception) {
                _asteroidList.value = null
            }
        }

    /*    var mAsteroidList : MutableList<Asteroid>

        mAsteroidList = mutableListOf(
                Asteroid(1 , "Test1" , "1" ,1.1,
                        1.2,8.6,10.0,false)
                , Asteroid(1 , "Test2" , "1" ,1.1,
                1.2,8.6,10.0,true)

        )

        _asteroidList.value = mAsteroidList*/
    }
}