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

class FuelListActivity : AppCompatActivity() {

    private lateinit var btnAddFuel: Button
    private lateinit var tvTotalFuelEntries: TextView
    private lateinit var rvFuelEntries: RecyclerView

    private var vehicleName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fuel_list)

        vehicleName =
            intent.getStringExtra("vehicleName") ?: ""

        title =
            if (vehicleName.isNotEmpty()) {
                "$vehicleName - Fuel History"
            } else {
                "Fuel History"
            }

        btnAddFuel =
            findViewById(R.id.btnAddFuel)

        tvTotalFuelEntries =
            findViewById(R.id.tvTotalFuelEntries)

        rvFuelEntries =
            findViewById(R.id.rvFuelEntries)

        rvFuelEntries.layoutManager =
            LinearLayoutManager(this)


        btnAddFuel.setOnClickListener {

            val intent = Intent(
                this,
                AddFuelActivity::class.java
            )

            intent.putExtra(
                "vehicleName",
                vehicleName
            )

            startActivity(intent)
        }

        loadFuelEntries()
    }

    override fun onResume() {
        super.onResume()

        loadFuelEntries()
    }


    private fun loadFuelEntries() {

        lifecycleScope.launch(Dispatchers.IO) {

            val fuelList =

                if (vehicleName.isNotEmpty()) {

                    VehicleDatabase
                        .getDatabase(applicationContext)
                        .fuelDao()
                        .getFuelEntriesByVehicle(
                            vehicleName
                        )

                } else {

                    VehicleDatabase
                        .getDatabase(applicationContext)
                        .fuelDao()
                        .getAllFuelEntries()

                }


            withContext(Dispatchers.Main) {

                if (fuelList.isEmpty()) {

                    tvTotalFuelEntries.text =
                        "No Fuel Entries Added Yet."

                } else {

                    tvTotalFuelEntries.text =
                        "Total Fuel Entries : ${fuelList.size}"
                }

                rvFuelEntries.adapter =
                    FuelAdapter(fuelList)

            }
        }
    }
}