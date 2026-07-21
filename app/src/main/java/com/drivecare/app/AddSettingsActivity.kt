package com.drivecare.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_settings)

        title = "Settings"

        val etSettingText =
            findViewById<EditText>(R.id.etSettingText)

        val btnSaveSetting =
            findViewById<Button>(R.id.btnSaveSetting)

        btnSaveSetting.setOnClickListener {

            val settingText =
                etSettingText.text.toString().trim()

            if (settingText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please Enter Setting",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val sharedPreferences =
                    getSharedPreferences(
                        "SettingsData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString(
                        "setting_text",
                        settingText
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Setting Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}