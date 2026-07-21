package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmergencyActivity : AppCompatActivity() {

    private lateinit var tvEmergencyRecord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_emergency)

        title = "Emergency Contacts"

        tvEmergencyRecord =
            findViewById(R.id.tvEmergencyRecord)

        findViewById<Button>(R.id.btnAddEmergency)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddEmergencyActivity::class.java
                    )
                )
            }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences =
            getSharedPreferences(
                "EmergencyData",
                MODE_PRIVATE
            )

        val emergencyContact =
            sharedPreferences.getString(
                "emergency_contact",
                "No Emergency Contacts Added Yet."
            )

        tvEmergencyRecord.text =
            emergencyContact
    }
}