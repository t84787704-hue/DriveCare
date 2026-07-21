package com.drivecare.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Vehicle Information
    val vehicleName: String,

    // Reminder Information
    val reminderTitle: String,
    val reminderType: String,

    // Date Based Reminder
    val dueDate: String,

    // Mileage Based Reminder
    val currentOdometer: String,
    val nextServiceOdometer: String,

    // Additional Information
    val notes: String,

    // Reminder Status
    val status: String = "Upcoming",

    // Date & Time
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)