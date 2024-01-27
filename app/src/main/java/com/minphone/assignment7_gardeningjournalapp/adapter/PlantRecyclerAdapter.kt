package com.minphone.assignment7_gardeningjournalapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minphone.assignment7_gardeningjournalapp.databinding.ViewholderPlantBinding
import com.minphone.assignment7_gardeningjournalapp.model.Plant

class PlantRecyclerAdapter(
      private val plants: List<Plant>,
      private val listener: AdapterClickListener
) : RecyclerView.Adapter<PlantRecyclerAdapter.ViewHolder>() {


      class ViewHolder(
            private val binding: ViewholderPlantBinding,
            private val listener: AdapterClickListener
      ) : RecyclerView.ViewHolder(binding.root) {

            private lateinit var plant: Plant

            init {
                  binding.root.setOnClickListener {
                        listener.onItemClicked(plantId = plant.id)
                  }
            }

            fun bind(plant: Plant) {
                  this.plant = plant
                  binding.tvPlantName.text = plant.name
                  binding.tvWateredDate.text = plant.plantingDate
            }
      }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ViewholderPlantBinding.inflate(
                  LayoutInflater.from(parent.context), parent, false
            )
            return ViewHolder(binding, listener)
      }

      override fun getItemCount(): Int = plants.size

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(plants[position])
      }
}

interface AdapterClickListener {
      fun onItemClicked(plantId: Int)
}