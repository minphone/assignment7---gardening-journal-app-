package com.minphone.assignment7_gardeningjournalapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.minphone.assignment7_gardeningjournalapp.model.Plant
import com.minphone.assignment7_gardeningjournalapp.repository.PlantRepository
import kotlinx.coroutines.launch

internal class AddPlantViewModel(application: Application) : AndroidViewModel(application) {

      private val repository: PlantRepository

      init {
            repository = PlantRepository(application)
      }

      internal fun addPlant(plant: Plant) = viewModelScope.launch {
            repository.insert(plant)
      }

}