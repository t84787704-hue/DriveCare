package com.drivecare.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DocumentsActivity : AppCompatActivity() {

    private lateinit var btnAddDocument: Button
    private lateinit var tvTotalDocuments: TextView
    private lateinit var rvDocuments: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_documents
        )

        title = "Vehicle Documents"

        btnAddDocument =
            findViewById(R.id.btnAddDocument)

        tvTotalDocuments =
            findViewById(R.id.tvTotalDocuments)

        rvDocuments =
            findViewById(R.id.rvDocuments)

        rvDocuments.layoutManager =
            LinearLayoutManager(this)


        btnAddDocument.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddDocumentActivity::class.java
                )
            )

        }

        loadDocuments()

    }


    override fun onResume() {
        super.onResume()

        loadDocuments()
    }


    private fun loadDocuments() {

        lifecycleScope.launch(Dispatchers.IO) {

            val documentList =
                VehicleDatabase
                    .getDatabase(applicationContext)
                    .documentDao()
                    .getAllDocuments()


            withContext(Dispatchers.Main) {

                if (documentList.isEmpty()) {

                    tvTotalDocuments.text =
                        "No Documents Added Yet."

                } else {

                    tvTotalDocuments.text =
                        "Total Documents : ${documentList.size}"

                }

                rvDocuments.adapter =
                    DocumentsAdapter(
                        documentList
                    )

            }

        }

    }

}