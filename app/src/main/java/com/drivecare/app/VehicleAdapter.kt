package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(
    private var vehicleList: List<Vehicle>
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvVehicleName: TextView =
            itemView.findViewById(R.id.tvVehicleName)

        val tvVehicleType: TextView =
            itemView.findViewById(R.id.tvVehicleType)

        val tvVehicleBrand: TextView =
            itemView.findViewById(R.id.tvVehicleBrand)
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

        holder.tvVehicleType.text =
            vehicle.vehicleType

        holder.tvVehicleBrand.text =
            vehicle.brand
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    fun updateVehicles(
        newVehicleList: List<Vehicle>
    ) {
        vehicleList = newVehicleList
        notifyDataSetChanged()
    }
}