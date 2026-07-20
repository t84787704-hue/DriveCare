package com.drivecare.app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Vehicle::class],
    version = 1,
    exportSchema = false
)
abstract class VehicleDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

}