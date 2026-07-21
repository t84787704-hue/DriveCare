package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MaintenanceHistoryActivity : AppCompatActivity() {

    private lateinit var tvMaintenanceRecord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_maintenance_history
        )

        title = "Maintenance History"

        tvMaintenanceRecord =
            findViewById(R.id.tvMaintenanceRecord)

        // Add Maintenance
        findViewById<Button>(R.id.btnAddMaintenance)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddMaintenanceActivity::class.java
                    )
                )
            }

        // Delete Maintenance Record
        findViewById<Button>(R.id.btnDeleteMaintenance)
            .setOnClickListener {

                val sharedPreferences =
                    getSharedPreferences(
                        "MaintenanceData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .remove("maintenance_name")
                    .apply()

                tvMaintenanceRecord.text =
                    "No Maintenance Records Added Yet."

                Toast.makeText(
                    this,
                    "Maintenance Record Deleted Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences =
            getSharedPreferences(
                "MaintenanceData",
                MODE_PRIVATE
            )

        val maintenanceName =
            sharedPreferences.getString(
                "maintenance_name",
                "No Maintenance Records Added Yet."
            )

        tvMaintenanceRecord.text =
            maintenanceName
    }
}