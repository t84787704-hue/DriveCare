package com.drivecare.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddFuelActivity : AppCompatActivity() {

    private lateinit var etVehicleName: EditText
    private lateinit var etFuelDate: EditText
    private lateinit var etFuelType: EditText
    private lateinit var etFuelQuantity: EditText
    private lateinit var etAmountPaid: EditText
    private lateinit var etCurrentOdometer: EditText
    private lateinit var etFuelStationName: EditText
    private lateinit var etNotes: EditText

    private lateinit var btnSaveFuel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_fuel)

        etVehicleName =
            findViewById(R.id.etVehicleName)

        etFuelDate =
            findViewById(R.id.etFuelDate)

        etFuelType =
            findViewById(R.id.etFuelType)

        etFuelQuantity =
            findViewById(R.id.etFuelQuantity)

        etAmountPaid =
            findViewById(R.id.etAmountPaid)

        etCurrentOdometer =
            findViewById(R.id.etCurrentOdometer)

        etFuelStationName =
            findViewById(R.id.etFuelStationName)

        etNotes =
            findViewById(R.id.etNotes)

        btnSaveFuel =
            findViewById(R.id.btnSaveFuel)


        btnSaveFuel.setOnClickListener {

            saveFuelEntry()
        }
    }


    private fun saveFuelEntry() {

        val fuelEntry = FuelEntry(

            vehicleName =
                etVehicleName.text.toString(),

            fuelDate =
                etFuelDate.text.toString(),

            fuelType =
                etFuelType.text.toString(),

            fuelQuantity =
                etFuelQuantity.text.toString(),

            amountPaid =
                etAmountPaid.text.toString(),

            currentOdometer =
                etCurrentOdometer.text.toString(),

            fuelStationName =
                etFuelStationName.text.toString(),

            notes =
                etNotes.text.toString()
        )


        lifecycleScope.launch(Dispatchers.IO) {

            VehicleDatabase
                .getDatabase(applicationContext)
                .fuelDao()
                .insertFuelEntry(fuelEntry)

            runOnUiThread {

                Toast.makeText(
                    this@AddFuelActivity,
                    "Fuel Entry Saved Successfully.",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}