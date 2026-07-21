package com.drivecare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddMaintenanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_add_maintenance
        )

        title = "Add Maintenance"
    }
}