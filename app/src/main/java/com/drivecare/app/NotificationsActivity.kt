package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotificationsActivity : AppCompatActivity() {

    private lateinit var tvNotificationRecord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_notifications)

        title = "Notifications"

        tvNotificationRecord =
            findViewById(R.id.tvNotificationRecord)

        findViewById<Button>(R.id.btnAddNotification)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddNotificationActivity::class.java
                    )
                )
            }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences =
            getSharedPreferences(
                "NotificationData",
                MODE_PRIVATE
            )

        val notificationText =
            sharedPreferences.getString(
                "notification_text",
                "No Notifications Added Yet."
            )

        tvNotificationRecord.text =
            notificationText
    }
}