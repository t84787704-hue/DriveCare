package com.drivecare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_notification)

        title = "Add Notification"
    }
}