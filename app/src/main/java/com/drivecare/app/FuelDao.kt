package com.drivecare.app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FuelDao {

    @Insert
    suspend fun insertFuelEntry(
        fuelEntry: FuelEntry
    )

    @Update
    suspend fun updateFuelEntry(
        fuelEntry: FuelEntry
    )

    @Delete
    suspend fun deleteFuelEntry(
        fuelEntry: FuelEntry
    )

    @Query(
        "SELECT * FROM fuel_entries ORDER BY createdAt DESC"
    )
    suspend fun getAllFuelEntries():
            List<FuelEntry>

    @Query(
        "SELECT * FROM fuel_entries WHERE id = :id"
    )
    suspend fun getFuelEntryById(
        id: Int
    ): FuelEntry?

    @Query(
        "SELECT * FROM fuel_entries WHERE vehicleName = :vehicleName ORDER BY createdAt DESC"
    )
    suspend fun getFuelEntriesByVehicle(
        vehicleName: String
    ): List<FuelEntry>

    @Query(
        "DELETE FROM fuel_entries"
    )
    suspend fun deleteAllFuelEntries()
}