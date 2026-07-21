package com.drivecare.app

object MileageUtils {

    // Distance Travelled

    fun calculateDistance(
        previousOdometer: Double,
        currentOdometer: Double
    ): Double {

        return currentOdometer - previousOdometer
    }


    // KM Per Liter

    fun calculateMileage(
        distance: Double,
        fuelQuantity: Double
    ): Double {

        if (fuelQuantity <= 0.0) {

            return 0.0
        }

        return distance / fuelQuantity
    }


    // Cost Per KM

    fun calculateCostPerKm(
        amountPaid: Double,
        distance: Double
    ): Double {

        if (distance <= 0.0) {

            return 0.0
        }

        return amountPaid / distance
    }


    // Monthly Expenses

    fun calculateMonthlyExpenses(
        amountList: List<Double>
    ): Double {

        return amountList.sum()
    }


    // Yearly Expenses

    fun calculateYearlyExpenses(
        amountList: List<Double>
    ): Double {

        return amountList.sum()
    }

}