package com.drivecare.app

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

object ReminderUtils {

    private const val DATE_FORMAT = "dd-MM-yyyy"

    fun calculateStatus(dueDate: String): String {

        return try {

            val formatter =
                SimpleDateFormat(
                    DATE_FORMAT,
                    Locale.getDefault()
                )

            val today =
                formatter.parse(
                    formatter.format(Date())
                )

            val reminderDate =
                formatter.parse(dueDate)

            if (today == null || reminderDate == null) {

                return "Upcoming"
            }

            val difference =
                reminderDate.time - today.time

            val days =
                TimeUnit.MILLISECONDS
                    .toDays(difference)

            when {

                days > 0 ->
                    "$days Days Remaining"

                days == 0L ->
                    "Due Today"

                else ->
                    "Overdue"

            }

        } catch (e: Exception) {

            "Upcoming"
        }
    }
}