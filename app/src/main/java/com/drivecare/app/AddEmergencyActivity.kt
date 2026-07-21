package com.drivecare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_emergency)

        title = "Add Emergency Contact"
    }
}