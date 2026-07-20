package com.drivecare.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddVehicleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        val etVehicleName = findViewById<EditText>(R.id.etVehicleName)
        val etVehicleType = findViewById<EditText>(R.id.etVehicleType)
        val etBrand = findViewById<EditText>(R.id.etBrand)
        val etModel = findViewById<EditText>(R.id.etModel)
        val etYear = findViewById<EditText>(R.id.etYear)
        val etRegistration = findViewById<EditText>(R.id.etRegistration)
        val etFuelType = findViewById<EditText>(R.id.etFuelType)
        val btnSaveVehicle = findViewById<Button>(R.id.btnSaveVehicle)

        btnSaveVehicle.setOnClickListener {

            val vehicleName = etVehicleName.text.toString().trim()
            val vehicleType = etVehicleType.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val model = etModel.text.toString().trim()
            val year = etYear.text.toString().trim()
            val registration = etRegistration.text.toString().trim()
            val fuelType = etFuelType.text.toString().trim()

            if (vehicleName.isEmpty()) {
                etVehicleName.error = "Vehicle Name Required"
                return@setOnClickListener
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
                distanceUnit = "",
                notes = ""
            )

            CoroutineScope(Dispatchers.IO).launch {

                val database =
                    VehicleDatabase.getDatabase(applicationContext)

                database.vehicleDao().insertVehicle(vehicle)
            }

            Toast.makeText(
                this,
                "Vehicle Saved Successfully",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}