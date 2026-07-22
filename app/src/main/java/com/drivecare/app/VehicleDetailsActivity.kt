package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleDetailsActivity : AppCompatActivity() {

    private lateinit var tvVehicleName: TextView
    private lateinit var tvVehicleType: TextView
    private lateinit var tvVehicleBrand: TextView
    private lateinit var tvVehicleModel: TextView

    private lateinit var btnEditVehicle: Button
    private lateinit var btnDeleteVehicle: Button
    private lateinit var btnServiceHistory: Button
    private lateinit var btnFuelHistory: Button
    private lateinit var btnDocuments: Button
    private lateinit var btnInsurance: Button

    private var vehicleId: Int = 0

    private var vehicleName: String = ""
    private var vehicleType: String = ""
    private var vehicleBrand: String = ""
    private var vehicleModel: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)

        title = "Vehicle Details"

        tvVehicleName = findViewById(R.id.tvVehicleName)
        tvVehicleType = findViewById(R.id.tvVehicleType)
        tvVehicleBrand = findViewById(R.id.tvVehicleBrand)
        tvVehicleModel = findViewById(R.id.tvVehicleModel)

        btnEditVehicle = findViewById(R.id.btnEditVehicle)
        btnDeleteVehicle = findViewById(R.id.btnDeleteVehicle)
        btnServiceHistory = findViewById(R.id.btnServiceHistory)
        btnFuelHistory = findViewById(R.id.btnFuelHistory)
        btnDocuments = findViewById(R.id.btnDocuments)
        btnInsurance = findViewById(R.id.btnInsurance)

        vehicleId = intent.getIntExtra("vehicleId", 0)
        vehicleName = intent.getStringExtra("vehicleName") ?: ""
        vehicleType = intent.getStringExtra("vehicleType") ?: ""
        vehicleBrand = intent.getStringExtra("vehicleBrand") ?: ""
        vehicleModel = intent.getStringExtra("vehicleModel") ?: ""

        tvVehicleName.text = vehicleName
        tvVehicleType.text = "Type : $vehicleType"
        tvVehicleBrand.text = "Brand : $vehicleBrand"
        tvVehicleModel.text = "Model : $vehicleModel"

        btnEditVehicle.setOnClickListener {
            val editIntent = Intent(this, AddVehicleActivity::class.java).apply {
                putExtra("vehicleId", vehicleId)
                putExtra("isEditMode", true)
            }
            startActivity(editIntent)
            finish()
        }

        btnDeleteVehicle.setOnClickListener {
            deleteVehicle()
        }

        btnServiceHistory.setOnClickListener {
            startActivity(Intent(this, MaintenanceHistoryActivity::class.java))
        }

        btnFuelHistory.setOnClickListener {
            startActivity(Intent(this, FuelListActivity::class.java))
        }

        btnDocuments.setOnClickListener {
            startActivity(Intent(this, DocumentsActivity::class.java))
        }

        btnInsurance.setOnClickListener {
            Toast.makeText(this, "Insurance Module Coming Soon.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteVehicle() {
        if (vehicleId == 0) {
            Toast.makeText(this, "Invalid Vehicle ID", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val vehicle = VehicleDatabase
                .getDatabase(applicationContext)
                .vehicleDao()
                .getVehicleById(vehicleId)

            if (vehicle != null) {
                VehicleDatabase
                    .getDatabase(applicationContext)
                    .vehicleDao()
                    .deleteVehicle(vehicle)

                runOnUiThread {
                    Toast.makeText(this@VehicleDetailsActivity, "Vehicle Deleted Successfully.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                runOnUiThread {
                    Toast.makeText(this@VehicleDetailsActivity, "Vehicle not found!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}