package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VehicleListActivity : AppCompatActivity() {

    private lateinit var btnAddVehicle: Button
    private lateinit var tvNoVehicles: TextView
    private lateinit var rvVehicles: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)

        btnAddVehicle = findViewById(R.id.btnAddVehicle)
        tvNoVehicles = findViewById(R.id.tvNoVehicles)
        rvVehicles = findViewById(R.id.rvVehicles)

        rvVehicles.layoutManager = LinearLayoutManager(this)

        btnAddVehicle.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddVehicleActivity::class.java
                )
            )
        }

        loadVehicles()
    }

    override fun onResume() {
        super.onResume()
        loadVehicles()
    }

    private fun loadVehicles() {

        lifecycleScope.launch(Dispatchers.IO) {

            val vehicleList = VehicleDatabase
                .getDatabase(applicationContext)
                .vehicleDao()
                .getAllVehicles()

            withContext(Dispatchers.Main) {

                if (vehicleList.isEmpty()) {

                    tvNoVehicles.text =
                        "No Vehicles Added Yet."

                } else {

                    tvNoVehicles.text =
                        "Total Vehicles : ${vehicleList.size}"

                }

                rvVehicles.adapter =
                    VehicleAdapter(vehicleList)
            }
        }
    }
}