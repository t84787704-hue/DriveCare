package com.drivecare.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_emergency)

        title = "Add Emergency Contact"

        val etEmergencyName =
            findViewById<EditText>(R.id.etEmergencyName)

        val etEmergencyNumber =
            findViewById<EditText>(R.id.etEmergencyNumber)

        val btnSaveEmergency =
            findViewById<Button>(R.id.btnSaveEmergency)

        btnSaveEmergency.setOnClickListener {

            val name =
                etEmergencyName.text.toString().trim()

            val number =
                etEmergencyNumber.text.toString().trim()

            if (name.isEmpty() || number.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val sharedPreferences: SharedPreferences =
                    getSharedPreferences(
                        "EmergencyData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString(
                        "emergency_contact",
                        "$name\n$number"
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Emergency Contact Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}