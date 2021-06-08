package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.databinding.ListItemAsteroidBinding

// todo create custom viewHolder
class AsteroidAdapter : ListAdapter<Asteroid,AsteroidAdapter.ViewHolder>(AsteroidDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor (val binding: ListItemAsteroidBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Asteroid) {
           binding.asteroid = item
           binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAsteroidBinding.inflate(layoutInflater , parent , false)
                return ViewHolder(binding)
            }
        }
    }


}


class AsteroidDiffCallBack : DiffUtil.ItemCallback<Asteroid>() {

    //To figure out if an item was added ,  moved or removed
    override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
       return oldItem == newItem
    }

}