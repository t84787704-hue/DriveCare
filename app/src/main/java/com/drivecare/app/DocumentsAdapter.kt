package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DocumentsAdapter(
    private val documentList: List<Document>
) : RecyclerView.Adapter<DocumentsAdapter.DocumentViewHolder>() {

    class DocumentViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val tvDocumentTitle: TextView =
            itemView.findViewById(R.id.tvDocumentTitle)

        val tvDocumentType: TextView =
            itemView.findViewById(R.id.tvDocumentType)

        val tvDocumentNumber: TextView =
            itemView.findViewById(R.id.tvDocumentNumber)

        val tvDocumentDetails: TextView =
            itemView.findViewById(R.id.tvDocumentDetails)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocumentViewHolder {

        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.item_document,
            parent,
            false
        )

        return DocumentViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DocumentViewHolder,
        position: Int
    ) {

        val document =
            documentList[position]

        holder.tvDocumentTitle.text =
            document.documentTitle

        holder.tvDocumentType.text =
            "Document Type : ${document.documentType}"

        holder.tvDocumentNumber.text =
            "Document Number : ${document.documentNumber}"

        holder.tvDocumentDetails.text =
            """
Vehicle : ${document.vehicleName}

Issue Date : ${document.issueDate}

Expiry Date : ${document.expiryDate}

Notes : ${document.notes}
            """.trimIndent()

    }

    override fun getItemCount(): Int {

        return documentList.size
    }

}