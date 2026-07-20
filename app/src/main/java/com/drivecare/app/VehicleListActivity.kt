package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VehicleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)

        val btnAddVehicle = findViewById<Button>(R.id.btnAddVehicle)

        btnAddVehicle.setOnClickListener {

            val intent = Intent(
                this,
                AddVehicleActivity::class.java
            )

            startActivity(intent)
        }
    }
}