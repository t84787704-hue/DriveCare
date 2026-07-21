package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // My Vehicles
        findViewById<Button>(R.id.btnMyVehicles).setOnClickListener {
            startActivity(Intent(this, VehicleListActivity::class.java))
        }

        // Service Reminders
        findViewById<Button>(R.id.btnServiceReminder).setOnClickListener {
            startActivity(Intent(this, ReminderListActivity::class.java))
        }

        // Fuel Tracker
        findViewById<Button>(R.id.btnFuelTracker).setOnClickListener {
            startActivity(Intent(this, FuelListActivity::class.java))
        }

        // Maintenance History
        findViewById<Button>(R.id.btnMaintenance).setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MaintenanceHistoryActivity::class.java
                )
            )
        }

        // Vehicle Documents
        findViewById<Button>(R.id.btnDocuments).setOnClickListener {
            startActivity(
                Intent(
                    this,
                    DocumentsActivity::class.java
                )
            )
        }

    }
}