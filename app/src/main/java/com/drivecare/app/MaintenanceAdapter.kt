package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaintenanceAdapter(
    private val maintenanceList: List<Maintenance>
) : RecyclerView.Adapter<MaintenanceAdapter.MaintenanceViewHolder>() {

    class MaintenanceViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val tvServiceTitle: TextView =
            itemView.findViewById(R.id.tvServiceTitle)

        val tvServiceType: TextView =
            itemView.findViewById(R.id.tvServiceType)

        val tvServiceDate: TextView =
            itemView.findViewById(R.id.tvServiceDate)

        val tvMaintenanceDetails: TextView =
            itemView.findViewById(R.id.tvMaintenanceDetails)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MaintenanceViewHolder {

        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.item_maintenance,
            parent,
            false
        )

        return MaintenanceViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MaintenanceViewHolder,
        position: Int
    ) {

        val maintenance =
            maintenanceList[position]

        holder.tvServiceTitle.text =
            maintenance.serviceTitle

        holder.tvServiceType.text =
            "Service Type : ${maintenance.serviceType}"

        holder.tvServiceDate.text =
            "Service Date : ${maintenance.serviceDate}"

        holder.tvMaintenanceDetails.text =
            """
Vehicle : ${maintenance.vehicleName}
Current Odometer : ${maintenance.currentOdometer}
Service Cost : ${maintenance.serviceCost}
Workshop Name : ${maintenance.workshopName}
Notes : ${maintenance.notes}
            """.trimIndent()

    }

    override fun getItemCount(): Int {
        return maintenanceList.size
    }

}