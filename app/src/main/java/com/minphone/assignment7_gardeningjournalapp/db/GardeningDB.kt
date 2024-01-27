package com.minphone.assignment7_gardeningjournalapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.minphone.assignment7_gardeningjournalapp.model.Plant

@Database(entities = [Plant::class], version = 1, exportSchema = false)
abstract class GardeningDB : RoomDatabase() {
      abstract fun plantDao(): PlantDAO

      companion object {

            @Volatile

            private var INSTANCE: GardeningDB? = null

            fun getDatabase(context: Context): GardeningDB {

                  return INSTANCE ?: synchronized(this) {

                        val instance = Room.databaseBuilder(
                              context.applicationContext,
                              GardeningDB::class.java,
                              "GardeningDB"
                        ).build()

                        INSTANCE = instance
                        instance
                  }
            }
      }
}