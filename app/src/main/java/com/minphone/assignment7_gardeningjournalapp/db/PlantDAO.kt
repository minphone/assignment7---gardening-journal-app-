package com.minphone.assignment7_gardeningjournalapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.minphone.assignment7_gardeningjournalapp.model.Plant

@Dao
interface PlantDAO {

      @Query("SELECT * FROM plants")
      suspend fun getAllPlants(): List<Plant>

      @Insert(onConflict = OnConflictStrategy.REPLACE)
      suspend fun insert(plant: Plant)

      @Update
      suspend fun update(plant: Plant)

      @Query("DELETE FROM plants")
      suspend fun deleteAll()


      @Query("DELETE FROM plants WHERE id = :plantId")
      suspend fun delete(plantId: Int)

      @Query("SELECT * FROM plants WHERE id = :plantId")
      suspend fun getPlantById(plantId: Int): Plant

}