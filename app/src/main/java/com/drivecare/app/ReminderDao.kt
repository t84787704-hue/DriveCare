package com.drivecare.app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReminderDao {

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Query("SELECT * FROM reminders ORDER BY dueDate ASC")
    suspend fun getAllReminders(): List<Reminder>

    @Query("SELECT * FROM reminders WHERE id = :id")
    suspend fun getReminderById(id: Int): Reminder?

    @Query("DELETE FROM reminders")
    suspend fun deleteAllReminders()


    // Upcoming Reminders
    @Query("SELECT * FROM reminders WHERE status = 'Upcoming'")
    suspend fun getUpcomingReminders(): List<Reminder>


    // Due Today
    @Query("SELECT * FROM reminders WHERE status = 'Due Today'")
    suspend fun getTodayReminders(): List<Reminder>


    // Overdue Reminders
    @Query("SELECT * FROM reminders WHERE status = 'Overdue'")
    suspend fun getOverdueReminders(): List<Reminder>


    // Completed Reminders
    @Query("SELECT * FROM reminders WHERE status = 'Completed'")
    suspend fun getCompletedReminders(): List<Reminder>

}