package com.drivecare.app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MaintenanceDao {

    @Insert
    suspend fun insertMaintenance(
        maintenance: Maintenance
    )

    @Update
    suspend fun updateMaintenance(
        maintenance: Maintenance
    )

    @Delete
    suspend fun deleteMaintenance(
        maintenance: Maintenance
    )

    @Query(
        "SELECT * FROM maintenance_history " +
                "ORDER BY createdAt DESC"
    )
    suspend fun getAllMaintenance():
            List<Maintenance>


    @Query(
        "SELECT * FROM maintenance_history " +
                "WHERE vehicleName = :vehicleName " +
                "ORDER BY createdAt DESC"
    )
    suspend fun getMaintenanceByVehicle(
        vehicleName: String
    ): List<Maintenance>


    @Query(
        "SELECT * FROM maintenance_history " +
                "WHERE id = :id"
    )
    suspend fun getMaintenanceById(
        id: Int
    ): Maintenance?


    @Query(
        "DELETE FROM maintenance_history"
    )
    suspend fun deleteAllMaintenance()

}