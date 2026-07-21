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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fuel_list)

        btnAddFuel =
            findViewById(R.id.btnAddFuel)

        tvTotalFuelEntries =
            findViewById(R.id.tvTotalFuelEntries)

        rvFuelEntries =
            findViewById(R.id.rvFuelEntries)

        rvFuelEntries.layoutManager =
            LinearLayoutManager(this)

        btnAddFuel.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddFuelActivity::class.java
                )
            )
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
                VehicleDatabase
                    .getDatabase(applicationContext)
                    .fuelDao()
                    .getAllFuelEntries()


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