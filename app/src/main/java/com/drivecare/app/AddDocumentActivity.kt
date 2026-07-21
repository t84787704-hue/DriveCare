package com.drivecare.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddDocumentActivity : AppCompatActivity() {

    private lateinit var etVehicleName: EditText
    private lateinit var etDocumentTitle: EditText
    private lateinit var etDocumentType: EditText
    private lateinit var etDocumentNumber: EditText
    private lateinit var etIssueDate: EditText
    private lateinit var etExpiryDate: EditText
    private lateinit var etNotes: EditText

    private lateinit var btnSaveDocument: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_add_document
        )

        title = "Add Document"


        etVehicleName =
            findViewById(R.id.etVehicleName)

        etDocumentTitle =
            findViewById(R.id.etDocumentTitle)

        etDocumentType =
            findViewById(R.id.etDocumentType)

        etDocumentNumber =
            findViewById(R.id.etDocumentNumber)

        etIssueDate =
            findViewById(R.id.etIssueDate)

        etExpiryDate =
            findViewById(R.id.etExpiryDate)

        etNotes =
            findViewById(R.id.etNotes)

        btnSaveDocument =
            findViewById(R.id.btnSaveDocument)


        btnSaveDocument.setOnClickListener {

            saveDocument()

        }

    }


    private fun saveDocument() {

        val document = Document(

            vehicleName =
                etVehicleName.text.toString(),

            documentTitle =
                etDocumentTitle.text.toString(),

            documentType =
                etDocumentType.text.toString(),

            documentNumber =
                etDocumentNumber.text.toString(),

            issueDate =
                etIssueDate.text.toString(),

            expiryDate =
                etExpiryDate.text.toString(),

            notes =
                etNotes.text.toString()

        )


        lifecycleScope.launch(Dispatchers.IO) {

            VehicleDatabase
                .getDatabase(applicationContext)
                .documentDao()
                .insertDocument(document)


            runOnUiThread {

                Toast.makeText(
                    this@AddDocumentActivity,
                    "Document Saved Successfully.",
                    Toast.LENGTH_SHORT
                ).show()

                finish()

            }

        }

    }

}