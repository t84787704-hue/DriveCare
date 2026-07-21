package com.drivecare.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMaintenanceActivity : AppCompatActivity() {

    private lateinit var etVehicleName: EditText
    private lateinit var etServiceTitle: EditText
    private lateinit var etServiceType: EditText
    private lateinit var etServiceDate: EditText
    private lateinit var etCurrentOdometer: EditText
    private lateinit var etServiceCost: EditText
    private lateinit var etWorkshopName: EditText
    private lateinit var etNotes: EditText

    private lateinit var btnSaveMaintenance: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_add_maintenance
        )

        title = "Add Maintenance"

        etVehicleName =
            findViewById(R.id.etVehicleName)

        etServiceTitle =
            findViewById(R.id.etServiceTitle)

        etServiceType =
            findViewById(R.id.etServiceType)

        etServiceDate =
            findViewById(R.id.etServiceDate)

        etCurrentOdometer =
            findViewById(R.id.etCurrentOdometer)

        etServiceCost =
            findViewById(R.id.etServiceCost)

        etWorkshopName =
            findViewById(R.id.etWorkshopName)

        etNotes =
            findViewById(R.id.etNotes)

        btnSaveMaintenance =
            findViewById(R.id.btnSaveMaintenance)


        btnSaveMaintenance.setOnClickListener {

            saveMaintenance()
        }
    }


    private fun saveMaintenance() {

        val maintenance = Maintenance(

            vehicleName =
                etVehicleName.text.toString(),

            serviceTitle =
                etServiceTitle.text.toString(),

            serviceType =
                etServiceType.text.toString(),

            serviceDate =
                etServiceDate.text.toString(),

            currentOdometer =
                etCurrentOdometer.text.toString(),

            serviceCost =
                etServiceCost.text.toString(),

            workshopName =
                etWorkshopName.text.toString(),

            notes =
                etNotes.text.toString()

        )


        lifecycleScope.launch(Dispatchers.IO) {

            VehicleDatabase
                .getDatabase(applicationContext)
                .maintenanceDao()
                .insertMaintenance(
                    maintenance
                )

            runOnUiThread {

                Toast.makeText(
                    this@AddMaintenanceActivity,
                    "Maintenance Saved Successfully.",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}