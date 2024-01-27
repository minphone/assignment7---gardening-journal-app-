package com.minphone.assignment7_gardeningjournalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
      @PrimaryKey(autoGenerate = true)
      val id: Int,
      val name: String,
      val type: String,
      val wateringFrequency: Int,
      val plantingDate: String
)