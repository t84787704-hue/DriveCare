package com.drivecare.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "maintenance_history")
data class Maintenance(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Vehicle Information
    val vehicleName: String,

    // Service Information
    val serviceTitle: String,
    val serviceType: String,
    val serviceDate: String,

    // Odometer Information
    val currentOdometer: String,

    // Cost Information
    val serviceCost: String,

    // Workshop Information
    val workshopName: String,

    // Additional Information
    val notes: String,

    // Date & Time
    val createdAt: Long =
        System.currentTimeMillis(),

    val updatedAt: Long =
        System.currentTimeMillis()

)