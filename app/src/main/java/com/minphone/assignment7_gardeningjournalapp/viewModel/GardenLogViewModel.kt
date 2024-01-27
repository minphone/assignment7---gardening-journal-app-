package com.minphone.assignment7_gardeningjournalapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minphone.assignment7_gardeningjournalapp.model.Plant
import com.minphone.assignment7_gardeningjournalapp.repository.PlantRepository
import kotlinx.coroutines.launch

internal class GardenLogViewModel(application: Application) : AndroidViewModel(application) {

      private val repository: PlantRepository

      internal val plants: MutableLiveData<List<Plant>> = MutableLiveData()

      init {
            repository = PlantRepository(application)

            val samplePlants = mutableListOf<Plant>()

            samplePlants.add(
                  Plant(
                        id = 100,
                        name = "Rose",
                        type = "Flower",
                        wateringFrequency = 2,
                        plantingDate = "2023-01-01"
                  )
            )
            samplePlants.add(
                  Plant(
                        id = 101,
                        name = "Tomato",
                        type = "Vegetable",
                        wateringFrequency = 3,
                        plantingDate = "2023-02-15"
                  )
            )
            samplePlants.add(
                  Plant(
                        id = 102,
                        name = "Basil",
                        type = "Herb",
                        wateringFrequency = 1,
                        plantingDate = "2023-03-10"
                  )
            )

            samplePlants.forEach { insert(it) }
            getPlants()
      }

      private fun insert(plant: Plant) = viewModelScope.launch {
            repository.insert(plant)
      }

      private fun getPlants() = viewModelScope.launch {
            plants.value = repository.getAllPlants()
      }

}