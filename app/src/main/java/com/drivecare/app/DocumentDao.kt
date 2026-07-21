package com.drivecare.app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DocumentDao {

    @Insert
    suspend fun insertDocument(
        document: Document
    )

    @Update
    suspend fun updateDocument(
        document: Document
    )

    @Delete
    suspend fun deleteDocument(
        document: Document
    )

    @Query(
        "SELECT * FROM documents ORDER BY createdAt DESC"
    )
    suspend fun getAllDocuments():
            List<Document>

    @Query(
        "SELECT * FROM documents WHERE id = :id"
    )
    suspend fun getDocumentById(
        id: Int
    ): Document?

    @Query(
        "SELECT * FROM documents WHERE vehicleName = :vehicleName ORDER BY createdAt DESC"
    )
    suspend fun getDocumentsByVehicle(
        vehicleName: String
    ): List<Document>

    @Query(
        "DELETE FROM documents"
    )
    suspend fun deleteAllDocuments()

}