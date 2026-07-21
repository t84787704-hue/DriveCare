package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var tvSettingRecord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        title = "Settings"

        tvSettingRecord =
            findViewById(R.id.tvSettingRecord)

        findViewById<Button>(R.id.btnAddSetting)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddSettingsActivity::class.java
                    )
                )
            }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences =
            getSharedPreferences(
                "SettingsData",
                MODE_PRIVATE
            )

        val settingText =
            sharedPreferences.getString(
                "setting_text",
                "No Settings Added Yet."
            )

        tvSettingRecord.text =
            settingText
    }
}