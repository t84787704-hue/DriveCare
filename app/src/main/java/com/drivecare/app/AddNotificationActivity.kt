package com.drivecare.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_notification)

        title = "Add Notification"

        val etNotificationText =
            findViewById<EditText>(R.id.etNotificationText)

        val btnSaveNotification =
            findViewById<Button>(R.id.btnSaveNotification)

        btnSaveNotification.setOnClickListener {

            val notificationText =
                etNotificationText.text.toString().trim()

            if (notificationText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please Enter Notification",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val sharedPreferences: SharedPreferences =
                    getSharedPreferences(
                        "NotificationData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString(
                        "notification_text",
                        notificationText
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Notification Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}