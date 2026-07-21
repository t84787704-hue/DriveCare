package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        findViewById<Button>(R.id.btnAddMaintenance)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddMaintenanceActivity::class.java
                    )
                )
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