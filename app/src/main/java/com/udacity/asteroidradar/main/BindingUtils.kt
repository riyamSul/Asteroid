package com.udacity.asteroidradar.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.R

/*@BindingAdapter("codeName")
fun TextView.setCodeName (item : Asteroid) {
   text = item.codename
}

@BindingAdapter("approachDate")
fun TextView.setApproachDate(item: Asteroid) {
    text = item.closeApproachDate
}*/

@BindingAdapter("status")
fun ImageView.setStatus (item: Asteroid) {
    if (item.isPotentiallyHazardous)
        setImageResource(R.drawable.ic_status_potentially_hazardous)
    else
        setImageResource(R.drawable.ic_status_normal)
}