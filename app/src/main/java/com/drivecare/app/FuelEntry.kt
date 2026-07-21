package com.drivecare.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fuel_entries")
data class FuelEntry(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Vehicle Information
    val vehicleName: String,

    // Fuel Information
    val fuelDate: String,
    val fuelType: String,
    val fuelQuantity: String,
    val amountPaid: String,

    // Odometer Information
    val currentOdometer: String,

    // Optional Information
    val fuelStationName: String,
    val notes: String,

    // Date & Time
    val createdAt: Long =
        System.currentTimeMillis()
)