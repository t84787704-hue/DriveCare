package com.drivecare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MaintenanceHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_maintenance_history
        )

        title = "Maintenance History"
    }
}