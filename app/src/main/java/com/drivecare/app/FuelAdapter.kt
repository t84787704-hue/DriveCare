package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FuelAdapter(
    private val fuelList: List<FuelEntry>
) : RecyclerView.Adapter<FuelAdapter.FuelViewHolder>() {

    class FuelViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvVehicleName: TextView =
            itemView.findViewById(R.id.tvVehicleName)

        val tvFuelDetails: TextView =
            itemView.findViewById(R.id.tvFuelDetails)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FuelViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_fuel,
                parent,
                false
            )

        return FuelViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FuelViewHolder,
        position: Int
    ) {

        val fuel = fuelList[position]

        holder.tvVehicleName.text =
            fuel.vehicleName


        holder.tvFuelDetails.text =
            """
Fuel Date : ${fuel.fuelDate}

Fuel Type : ${fuel.fuelType}

Fuel Quantity : ${fuel.fuelQuantity} Liter

Amount Paid : ${fuel.amountPaid}

Current Odometer : ${fuel.currentOdometer}

Fuel Station : ${fuel.fuelStationName}

Notes : ${fuel.notes}
            """.trimIndent()

    }

    override fun getItemCount(): Int {

        return fuelList.size
    }
}