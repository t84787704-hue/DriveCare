package com.drivecare.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Vehicle::class,
        Reminder::class,
        FuelEntry::class,
        Maintenance::class
    ],
    version = 2,
    exportSchema = false
)
abstract class VehicleDatabase : RoomDatabase() {

    // Vehicle Module
    abstract fun vehicleDao(): VehicleDao

    // Service Reminder Module
    abstract fun reminderDao(): ReminderDao

    // Fuel Tracker Module
    abstract fun fuelDao(): FuelDao

    // Maintenance History Module
    abstract fun maintenanceDao(): MaintenanceDao


    companion object {

        @Volatile
        private var INSTANCE: VehicleDatabase? = null

        fun getDatabase(
            context: Context
        ): VehicleDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        VehicleDatabase::class.java,
                        "drivecare_database"
                    )

                        // Future Updates
                        .fallbackToDestructiveMigration()

                        .build()

                INSTANCE = instance

                instance
            }
        }
    }
}