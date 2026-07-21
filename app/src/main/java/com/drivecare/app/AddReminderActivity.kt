package com.drivecare.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddReminderActivity : AppCompatActivity() {

    private lateinit var etVehicleName: EditText
    private lateinit var etReminderTitle: EditText
    private lateinit var etReminderType: EditText
    private lateinit var etDueDate: EditText
    private lateinit var etCurrentOdometer: EditText
    private lateinit var etNextServiceOdometer: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnSaveReminder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder)

        etVehicleName = findViewById(R.id.etVehicleName)
        etReminderTitle = findViewById(R.id.etReminderTitle)
        etReminderType = findViewById(R.id.etReminderType)
        etDueDate = findViewById(R.id.etDueDate)
        etCurrentOdometer = findViewById(R.id.etCurrentOdometer)
        etNextServiceOdometer =
            findViewById(R.id.etNextServiceOdometer)
        etNotes = findViewById(R.id.etNotes)
        btnSaveReminder = findViewById(R.id.btnSaveReminder)

        btnSaveReminder.setOnClickListener {
            saveReminder()
        }
    }

    private fun saveReminder() {

        val vehicleName =
            etVehicleName.text.toString().trim()

        val reminderTitle =
            etReminderTitle.text.toString().trim()

        val reminderType =
            etReminderType.text.toString().trim()

        val dueDate =
            etDueDate.text.toString().trim()

        val currentOdometer =
            etCurrentOdometer.text.toString().trim()

        val nextServiceOdometer =
            etNextServiceOdometer.text.toString().trim()

        val notes =
            etNotes.text.toString().trim()


        if (vehicleName.isEmpty()
            || reminderTitle.isEmpty()
            || reminderType.isEmpty()
            || dueDate.isEmpty()
        ) {

            Toast.makeText(
                this,
                "Please fill all required fields.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }


        val reminder = Reminder(

            vehicleName = vehicleName,

            reminderTitle = reminderTitle,

            reminderType = reminderType,

            dueDate = dueDate,

            currentOdometer = currentOdometer,

            nextServiceOdometer =
                nextServiceOdometer,

            notes = notes

        )


        lifecycleScope.launch {

            try {

                VehicleDatabase
                    .getDatabase(applicationContext)
                    .reminderDao()
                    .insertReminder(reminder)


                Toast.makeText(
                    this@AddReminderActivity,
                    "Reminder Saved Successfully.",
                    Toast.LENGTH_SHORT
                ).show()

                finish()

            } catch (e: Exception) {

                Toast.makeText(
                    this@AddReminderActivity,
                    "Error : ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}