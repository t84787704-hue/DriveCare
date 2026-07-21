package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MaintenanceHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_maintenance_history
        )

        title = "Maintenance History"

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
}