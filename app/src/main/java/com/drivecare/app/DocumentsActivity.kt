package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DocumentsActivity : AppCompatActivity() {

    private lateinit var tvDocumentRecord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_documents)

        title = "Vehicle Documents"

        tvDocumentRecord =
            findViewById(R.id.tvDocumentRecord)

        findViewById<Button>(R.id.btnAddDocument)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        AddDocumentActivity::class.java
                    )
                )
            }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences =
            getSharedPreferences(
                "DocumentData",
                MODE_PRIVATE
            )

        val documentName =
            sharedPreferences.getString(
                "document_name",
                "No Vehicle Documents Added Yet."
            )

        tvDocumentRecord.text =
            documentName
    }
}