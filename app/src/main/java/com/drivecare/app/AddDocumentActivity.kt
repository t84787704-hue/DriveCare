package com.drivecare.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddDocumentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_document)

        title = "Add Vehicle Document"
    }
}