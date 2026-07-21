package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(
    private val vehicleList: List<Vehicle>
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tvVehicleName: TextView =
            itemView.findViewById(R.id.tvVehicleName)

        val tvVehicleBrand: TextView =
            itemView.findViewById(R.id.tvVehicleBrand)

        val tvVehicleModel: TextView =
            itemView.findViewById(R.id.tvVehicleModel)

        val tvRegistrationNumber: TextView =
            itemView.findViewById(R.id.tvRegistrationNumber)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehicleViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_vehicle,
                parent,
                false
            )

        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: VehicleViewHolder,
        position: Int
    ) {

        val vehicle = vehicleList[position]

        holder.tvVehicleName.text =
            vehicle.vehicleName

        holder.tvVehicleBrand.text =
            "Brand : ${vehicle.brand}"

        holder.tvVehicleModel.text =
            "Model : ${vehicle.model}"

        holder.tvRegistrationNumber.text =
            "Registration : ${vehicle.registrationNumber}"
    }

    override fun getItemCount(): Int {

        return vehicleList.size
    }
}