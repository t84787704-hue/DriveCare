package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddVehicleActivity : AppCompatActivity() {

    private lateinit var etVehicleName: EditText
    private lateinit var etVehicleType: EditText
    private lateinit var etBrand: EditText
    private lateinit var etModel: EditText
    private lateinit var etYear: EditText
    private lateinit var etRegistration: EditText
    private lateinit var etFuelType: EditText
    private lateinit var btnSaveVehicle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        etVehicleName = findViewById(R.id.etVehicleName)
        etVehicleType = findViewById(R.id.etVehicleType)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        etYear = findViewById(R.id.etYear)
        etRegistration = findViewById(R.id.etRegistration)
        etFuelType = findViewById(R.id.etFuelType)
        btnSaveVehicle = findViewById(R.id.btnSaveVehicle)

        btnSaveVehicle.setOnClickListener {
            saveVehicle()
        }
    }

    private fun saveVehicle() {

        val vehicleName = etVehicleName.text.toString().trim()
        val vehicleType = etVehicleType.text.toString().trim()
        val brand = etBrand.text.toString().trim()
        val model = etModel.text.toString().trim()
        val year = etYear.text.toString().trim()
        val registration = etRegistration.text.toString().trim()
        val fuelType = etFuelType.text.toString().trim()

        if (vehicleName.isEmpty()
            || vehicleType.isEmpty()
            || brand.isEmpty()
            || model.isEmpty()
            || year.isEmpty()
            || registration.isEmpty()
            || fuelType.isEmpty()
        ) {
            Toast.makeText(
                this,
                "Please fill all fields.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val vehicle = Vehicle(
            vehicleName = vehicleName,
            vehicleType = vehicleType,
            brand = brand,
            model = model,
            manufacturingYear = year,
            registrationNumber = registration,
            fuelType = fuelType,
            odometerReading = "",
            purchaseDate = "",
            insuranceDetails = "",
            vehiclePhoto = "",
            country = "",
            distanceUnit = "KM",
            notes = ""
        )

        lifecycleScope.launch {

            try {

                VehicleDatabase
                    .getDatabase(applicationContext)
                    .vehicleDao()
                    .insertVehicle(vehicle)

                Toast.makeText(
                    this@AddVehicleActivity,
                    "Vehicle Saved Successfully.",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this@AddVehicleActivity,
                        VehicleListActivity::class.java
                    )
                )

                finish()

            } catch (e: Exception) {

                Toast.makeText(
                    this@AddVehicleActivity,
                    "Error : ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}