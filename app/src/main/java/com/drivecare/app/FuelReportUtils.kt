package com.drivecare.app

object FuelReportUtils {

    // Total Fuel Cost

    fun getTotalFuelCost(
        amountList: List<Double>
    ): Double {

        return amountList.sum()
    }


    // Total Fuel Quantity

    fun getTotalFuelQuantity(
        fuelList: List<Double>
    ): Double {

        return fuelList.sum()
    }


    // Total Distance

    fun getTotalDistance(
        distanceList: List<Double>
    ): Double {

        return distanceList.sum()
    }


    // Average Mileage

    fun getAverageMileage(
        mileageList: List<Double>
    ): Double {

        if (mileageList.isEmpty()) {

            return 0.0
        }

        return mileageList.average()
    }


    // Highest Mileage

    fun getHighestMileage(
        mileageList: List<Double>
    ): Double {

        if (mileageList.isEmpty()) {

            return 0.0
        }

        return mileageList.maxOrNull() ?: 0.0
    }


    // Lowest Mileage

    fun getLowestMileage(
        mileageList: List<Double>
    ): Double {

        if (mileageList.isEmpty()) {

            return 0.0
        }

        return mileageList.minOrNull() ?: 0.0
    }

}