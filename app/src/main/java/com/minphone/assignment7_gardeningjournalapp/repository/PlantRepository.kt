package com.minphone.assignment7_gardeningjournalapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.minphone.assignment7_gardeningjournalapp.db.GardeningDB
import com.minphone.assignment7_gardeningjournalapp.db.PlantDAO
import com.minphone.assignment7_gardeningjournalapp.model.Plant

internal class PlantRepository(application: Application) {
      private val dao: PlantDAO

      init {
            val database = GardeningDB.getDatabase(application)
            dao = database.plantDao()
      }

      suspend fun insert(plant: Plant) {
            dao.insert(plant)
      }

      suspend fun update(plant: Plant) {
            dao.update(plant)
      }

      suspend fun delete(plant: Plant) {
            dao.delete(plant.id)
      }

      suspend fun getPlantById(plantId: Int): Plant {
            return dao.getPlantById(plantId)
      }

      suspend fun getAllPlants(): List<Plant> {
            return dao.getAllPlants()
      }
}