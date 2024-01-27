package com.minphone.assignment7_gardeningjournalapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minphone.assignment7_gardeningjournalapp.model.Plant
import com.minphone.assignment7_gardeningjournalapp.repository.PlantRepository
import kotlinx.coroutines.launch

internal class PlantDetailsViewModel(application: Application) : AndroidViewModel(application) {

      private val repository: PlantRepository
      internal val plant: MutableLiveData<Plant> = MutableLiveData()

      init {
            repository = PlantRepository(application)
      }

      internal fun getPlantById(plantId: Int) = viewModelScope.launch {
            plant.value = repository.getPlantById(plantId)
      }

}