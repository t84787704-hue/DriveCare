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

class ReminderActivity : AppCompatActivity() {

    private lateinit var btnAddReminder: Button
    private lateinit var tvTotalReminders: TextView
    private lateinit var rvReminders: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_reminder)

        title = "Reminders"

        btnAddReminder =
            findViewById(R.id.btnAddReminder)

        tvTotalReminders =
            findViewById(R.id.tvTotalReminders)

        rvReminders =
            findViewById(R.id.rvReminders)

        rvReminders.layoutManager =
            LinearLayoutManager(this)

        btnAddReminder.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddReminderActivity::class.java
                )
            )

        }

        loadReminders()
    }


    override fun onResume() {
        super.onResume()

        loadReminders()
    }


    private fun loadReminders() {

        lifecycleScope.launch(Dispatchers.IO) {

            val reminderList =
                VehicleDatabase
                    .getDatabase(applicationContext)
                    .reminderDao()
                    .getAllReminders()

            withContext(Dispatchers.Main) {

                if (reminderList.isEmpty()) {

                    tvTotalReminders.text =
                        "No Reminders Added Yet."

                } else {

                    tvTotalReminders.text =
                        "Total Reminders : ${reminderList.size}"

                }

                rvReminders.adapter =
                    ReminderAdapter(
                        reminderList
                    )

            }

        }

    }

}