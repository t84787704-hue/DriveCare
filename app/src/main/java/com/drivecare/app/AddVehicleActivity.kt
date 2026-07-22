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
    private lateinit var etEngineNumber: EditText
    private lateinit var etChassisNumber: EditText
    private lateinit var etFuelType: EditText
    private lateinit var etOdometer: EditText
    private lateinit var etPurchaseDate: EditText
    private lateinit var etCountry: EditText
    private lateinit var etDistanceUnit: EditText
    private lateinit var etInsuranceDetails: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnSaveVehicle: Button

    private var isEditMode = false
    private var editingVehicleId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        initViews()

        // Check if Edit Mode
        isEditMode = intent.getBooleanExtra("isEditMode", false)
        editingVehicleId = intent.getIntExtra("vehicleId", 0)

        if (isEditMode && editingVehicleId != 0) {
            title = "Edit Vehicle"
            btnSaveVehicle.text = "Update Vehicle"
            loadVehicleData()
        } else {
            title = "Add New Vehicle"
            btnSaveVehicle.text = "Save Vehicle"
        }

        btnSaveVehicle.setOnClickListener {
            saveVehicle()
        }
    }

    private fun initViews() {
        etVehicleName = findViewById(R.id.etVehicleName)
        etVehicleType = findViewById(R.id.etVehicleType)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        etYear = findViewById(R.id.etYear)
        etRegistration = findViewById(R.id.etRegistration)
        etEngineNumber = findViewById(R.id.etEngineNumber)
        etChassisNumber = findViewById(R.id.etChassisNumber)
        etFuelType = findViewById(R.id.etFuelType)
        etOdometer = findViewById(R.id.etOdometer)
        etPurchaseDate = findViewById(R.id.etPurchaseDate)
        etCountry = findViewById(R.id.etCountry)
        etDistanceUnit = findViewById(R.id.etDistanceUnit)
        etInsuranceDetails = findViewById(R.id.etInsuranceDetails)
        etNotes = findViewById(R.id.etNotes)
        btnSaveVehicle = findViewById(R.id.btnSaveVehicle)
    }

    private fun loadVehicleData() {
        lifecycleScope.launch {
            val vehicle = VehicleDatabase
                .getDatabase(applicationContext)
                .vehicleDao()
                .getVehicleById(editingVehicleId)

            vehicle?.let {
                etVehicleName.setText(it.vehicleName)
                etVehicleType.setText(it.vehicleType)
                etBrand.setText(it.brand)
                etModel.setText(it.model)
                etYear.setText(it.manufacturingYear)
                etRegistration.setText(it.registrationNumber)
                etEngineNumber.setText(it.engineNumber)
                etChassisNumber.setText(it.chassisNumber)
                etFuelType.setText(it.fuelType)
                etOdometer.setText(it.odometerReading)
                etPurchaseDate.setText(it.purchaseDate)
                etCountry.setText(it.country)
                etDistanceUnit.setText(it.distanceUnit)
                etInsuranceDetails.setText(it.insuranceDetails)
                etNotes.setText(it.notes)
            }
        }
    }

    private fun saveVehicle() {
        val vehicleName = etVehicleName.text.toString().trim()
        val vehicleType = etVehicleType.text.toString().trim()
        val brand = etBrand.text.toString().trim()
        val model = etModel.text.toString().trim()
        val year = etYear.text.toString().trim()
        val registration = etRegistration.text.toString().trim()
        val engineNumber = etEngineNumber.text.toString().trim()
        val chassisNumber = etChassisNumber.text.toString().trim()
        val fuelType = etFuelType.text.toString().trim()
        val odometer = etOdometer.text.toString().trim()
        val purchaseDate = etPurchaseDate.text.toString().trim()
        val country = etCountry.text.toString().trim()
        val distanceUnit = etDistanceUnit.text.toString().trim()
        val insuranceDetails = etInsuranceDetails.text.toString().trim()
        val notes = etNotes.text.toString().trim()

        if (vehicleName.isEmpty() || vehicleType.isEmpty() || brand.isEmpty() || 
            model.isEmpty() || year.isEmpty() || registration.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields.", Toast.LENGTH_SHORT).show()
            return
        }

        val vehicle = Vehicle(
            id = if (isEditMode) editingVehicleId else 0,  // Important for update
            vehicleName = vehicleName,
            vehicleType = vehicleType,
            brand = brand,
            model = model,
            manufacturingYear = year,
            registrationNumber = registration,
            engineNumber = engineNumber,
            chassisNumber = chassisNumber,
            fuelType = fuelType,
            odometerReading = odometer,
            purchaseDate = purchaseDate,
            insuranceDetails = insuranceDetails,
            vehiclePhoto = "",
            country = country,
            distanceUnit = distanceUnit,
            notes = notes
        )

        lifecycleScope.launch {
            try {
                val dao = VehicleDatabase.getDatabase(applicationContext).vehicleDao()

                if (isEditMode) {
                    dao.updateVehicle(vehicle)
                    Toast.makeText(this@AddVehicleActivity, "Vehicle Updated Successfully.", Toast.LENGTH_SHORT).show()
                } else {
                    dao.insertVehicle(vehicle)
                    Toast.makeText(this@AddVehicleActivity, "Vehicle Saved Successfully.", Toast.LENGTH_SHORT).show()
                }

                startActivity(Intent(this@AddVehicleActivity, VehicleListActivity::class.java))
                finish()

            } catch (e: Exception) {
                Toast.makeText(this@AddVehicleActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}