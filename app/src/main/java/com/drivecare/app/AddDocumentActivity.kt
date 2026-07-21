package com.drivecare.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddDocumentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_document)

        title = "Add Vehicle Document"

        val etDocumentName =
            findViewById<EditText>(R.id.etDocumentName)

        val btnSaveDocument =
            findViewById<Button>(R.id.btnSaveDocument)

        btnSaveDocument.setOnClickListener {

            val documentName =
                etDocumentName.text.toString().trim()

            if (documentName.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please Enter Document Name",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val sharedPreferences: SharedPreferences =
                    getSharedPreferences(
                        "DocumentData",
                        MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .putString(
                        "document_name",
                        documentName
                    )
                    .apply()

                Toast.makeText(
                    this,
                    "Document Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}