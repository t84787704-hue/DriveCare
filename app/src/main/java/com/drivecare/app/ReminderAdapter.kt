package com.drivecare.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReminderAdapter(
    private val reminderList: List<Reminder>
) : RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {

    class ReminderViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvVehicleName: TextView =
            itemView.findViewById(R.id.tvVehicleName)

        val tvReminderTitle: TextView =
            itemView.findViewById(R.id.tvReminderTitle)

        val tvReminderDetails: TextView =
            itemView.findViewById(R.id.tvReminderDetails)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReminderViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_reminder,
                parent,
                false
            )

        return ReminderViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ReminderViewHolder,
        position: Int
    ) {

        val reminder = reminderList[position]

        holder.tvVehicleName.text =
            reminder.vehicleName

        holder.tvReminderTitle.text =
            reminder.reminderTitle

        holder.tvReminderDetails.text =
            """
Reminder Type : ${reminder.reminderType}

Due Date : ${reminder.dueDate}

Current Odometer : ${reminder.currentOdometer}

Next Service : ${reminder.nextServiceOdometer}

Status : ${reminder.status}

Notes : ${reminder.notes}
            """.trimIndent()

    }

    override fun getItemCount(): Int {

        return reminderList.size
    }
}