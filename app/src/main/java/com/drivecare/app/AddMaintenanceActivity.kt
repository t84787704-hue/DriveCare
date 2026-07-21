package com.drivecare.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddMaintenanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_maintenance)

        title = "Add Maintenance"

        val etMaintenanceName =
            findViewById<EditText>(R.id.etMaintenanceName)

        val btnSaveMaintenance =
            findViewById<Button>(R.id.btnSaveMaintenance)

        btnSaveMaintenance.setOnClickListener {

            val maintenanceName =
                etMaintenanceName.text.toString().trim()

            if (maintenanceName.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please Enter Maintenance Name",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val sharedPreferences: SharedPreferences =
                    getSharedPreferences(
                        "MaintenanceData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString(
                        "maintenance_name",
                        maintenanceName
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Maintenance Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}