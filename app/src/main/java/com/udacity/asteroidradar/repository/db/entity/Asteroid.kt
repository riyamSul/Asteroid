package com.udacity.asteroidradar.repository.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "asteroid_tbl")
data class Asteroid(
    @PrimaryKey
    val id : Long,
    val codename : String ,
    val closeApproachDate : String ,
    val absoluteMagnitude : Double,
    val estimatedDiameter : Double,
    val relativeVelocity : Double ,
    val distanceFromEarth : Double ,
    val isPotentiallyHazardous : Boolean
) : Parcelable
