package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MaintenanceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_maintenance_list
        )

        val btnAddMaintenance =
            findViewById<Button>(
                R.id.btnAddMaintenance
            )

        btnAddMaintenance.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddMaintenanceActivity::class.java
                )
            )
        }
    }
}