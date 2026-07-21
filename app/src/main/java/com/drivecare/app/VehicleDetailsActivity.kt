package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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


        // Receive Vehicle Data

        vehicleName =
            intent.getStringExtra("vehicleName") ?: ""

        vehicleType =
            intent.getStringExtra("vehicleType") ?: ""

        vehicleBrand =
            intent.getStringExtra("vehicleBrand") ?: ""

        vehicleModel =
            intent.getStringExtra("vehicleModel") ?: ""


        // Show Vehicle Data

        tvVehicleName.text = vehicleName
        tvVehicleType.text = "Type : $vehicleType"
        tvVehicleBrand.text = "Brand : $vehicleBrand"
        tvVehicleModel.text = "Model : $vehicleModel"


        // Edit Vehicle

        btnEditVehicle.setOnClickListener {

            Toast.makeText(
                this,
                "Edit Vehicle Coming Soon.",
                Toast.LENGTH_SHORT
            ).show()

        }


        // Delete Vehicle

        btnDeleteVehicle.setOnClickListener {

            Toast.makeText(
                this,
                "Delete Vehicle Coming Soon.",
                Toast.LENGTH_SHORT
            ).show()

        }


        // Maintenance History

        btnServiceHistory.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MaintenanceHistoryActivity::class.java
                )
            )

        }


        // Fuel History

        btnFuelHistory.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    FuelListActivity::class.java
                )
            )

        }


        // Vehicle Documents

        btnDocuments.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    DocumentsActivity::class.java
                )
            )

        }


        // Insurance Details

        btnInsurance.setOnClickListener {

            Toast.makeText(
                this,
                "Insurance Module Coming Soon.",
                Toast.LENGTH_SHORT
            ).show()

        }

    }
}