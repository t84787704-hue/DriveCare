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

class MaintenanceHistoryActivity : AppCompatActivity() {

    private lateinit var btnAddMaintenance: Button
    private lateinit var tvTotalMaintenance: TextView
    private lateinit var rvMaintenance: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_maintenance_history
        )

        title = "Maintenance History"

        btnAddMaintenance =
            findViewById(R.id.btnAddMaintenance)

        tvTotalMaintenance =
            findViewById(R.id.tvTotalMaintenance)

        rvMaintenance =
            findViewById(R.id.rvMaintenance)

        rvMaintenance.layoutManager =
            LinearLayoutManager(this)


        btnAddMaintenance.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddMaintenanceActivity::class.java
                )
            )
        }

        loadMaintenance()
    }


    override fun onResume() {
        super.onResume()

        loadMaintenance()
    }


    private fun loadMaintenance() {

        lifecycleScope.launch(Dispatchers.IO) {

            val maintenanceList =
                VehicleDatabase
                    .getDatabase(applicationContext)
                    .maintenanceDao()
                    .getAllMaintenance()


            withContext(Dispatchers.Main) {

                if (maintenanceList.isEmpty()) {

                    tvTotalMaintenance.text =
                        "No Maintenance Records Added Yet."

                } else {

                    tvTotalMaintenance.text =
                        "Total Maintenance Records : ${maintenanceList.size}"
                }


                rvMaintenance.adapter =
                    MaintenanceAdapter(
                        maintenanceList
                    )
            }
        }
    }
}