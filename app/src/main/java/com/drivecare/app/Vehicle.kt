package com.drivecare.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class Vehicle(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val vehicleName: String,
    val vehicleType: String,
    val brand: String,
    val model: String,
    val manufacturingYear: String,
    val registrationNumber: String,
    val engineNumber: String,
    val chassisNumber: String,
    val fuelType: String,
    val odometerReading: String,
    val purchaseDate: String,
    val insuranceDetails: String,
    val vehiclePhoto: String,
    val country: String,
    val distanceUnit: String,
    val notes: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()

)