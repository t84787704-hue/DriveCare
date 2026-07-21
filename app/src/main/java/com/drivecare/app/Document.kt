package com.drivecare.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "documents")
data class Document(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Vehicle Information
    val vehicleName: String,

    // Document Information
    val documentTitle: String,
    val documentType: String,
    val documentNumber: String,

    // Dates
    val issueDate: String,
    val expiryDate: String,

    // Additional Information
    val notes: String,

    // Date & Time
    val createdAt: Long =
        System.currentTimeMillis()
)