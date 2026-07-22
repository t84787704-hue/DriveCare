package com.drivecare.app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class VehicleAdapter(
    private val vehicleList: List<Vehicle>
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvVehicleName: TextView = itemView.findViewById(R.id.tvVehicleName)
        val tvVehicleBrand: TextView = itemView.findViewById(R.id.tvVehicleBrand)
        val tvVehicleModel: TextView = itemView.findViewById(R.id.tvVehicleModel)
        val tvRegistrationNumber: TextView = itemView.findViewById(R.id.tvRegistrationNumber)
        val tvVehicleDetails: TextView = itemView.findViewById(R.id.tvVehicleDetails)

        val btnEditVehicle: Button = itemView.findViewById(R.id.btnEditVehicle)
        val btnDeleteVehicle: Button = itemView.findViewById(R.id.btnDeleteVehicle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicleList[position]

        holder.tvVehicleName.text = vehicle.vehicleName
        holder.tvVehicleBrand.text = "Brand : ${vehicle.brand}"
        holder.tvVehicleModel.text = "Model : ${vehicle.model}"
        holder.tvRegistrationNumber.text = "Registration : ${vehicle.registrationNumber}"

        holder.tvVehicleDetails.text = """
Vehicle Type : ${vehicle.vehicleType}
Manufacturing Year : ${vehicle.manufacturingYear}
Engine Number : ${vehicle.engineNumber}
Chassis Number : ${vehicle.chassisNumber}
Fuel Type : ${vehicle.fuelType}
Odometer : ${vehicle.odometerReading}
Purchase Date : ${vehicle.purchaseDate}
Country : ${vehicle.country}
Distance Unit : ${vehicle.distanceUnit}
Insurance : ${vehicle.insuranceDetails}
Notes : ${vehicle.notes}
        """.trimIndent()

        // Whole item click → Details Screen
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VehicleDetailsActivity::class.java).apply {
                putExtra("vehicleId", vehicle.id)
                putExtra("vehicleName", vehicle.vehicleName)
                putExtra("vehicleType", vehicle.vehicleType)
                putExtra("vehicleBrand", vehicle.brand)
                putExtra("vehicleModel", vehicle.model)
            }
            holder.itemView.context.startActivity(intent)
        }

        // Edit Button
        holder.btnEditVehicle.setOnClickListener {
            val intent = Intent(holder.itemView.context, AddVehicleActivity::class.java).apply {
                putExtra("vehicleId", vehicle.id)
                putExtra("isEditMode", true)
            }
            holder.itemView.context.startActivity(intent)
        }

        // Delete Button
        holder.btnDeleteVehicle.setOnClickListener {
            deleteVehicle(holder.itemView.context, vehicle, position)
        }
    }

    private fun deleteVehicle(context: android.content.Context, vehicle: Vehicle, position: Int) {
        Toast.makeText(context, "Deleting...", Toast.LENGTH_SHORT).show()

        MainScope().launch {
            try {
                VehicleDatabase.getDatabase(context)
                    .vehicleDao()
                    .deleteVehicle(vehicle)

                Toast.makeText(context, "Vehicle Deleted Successfully!", Toast.LENGTH_SHORT).show()

                // Refresh list if possible
                if (context is VehicleListActivity) {
                    context.loadVehicles()
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Error deleting vehicle: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int = vehicleList.size
}