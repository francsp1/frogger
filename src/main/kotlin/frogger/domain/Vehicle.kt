package frogger.domain

enum class VehicleType {
    CAR1,
    CAR2,
    CAR3,
    CAR4,
    TRUCK
}

enum class VehicleDirection {
    LEFT,
    RIGHT,
}

const val TRUCK_ROW = 9
const val CAR1_ROW = 10
const val CAR2_ROW = 11
const val CAR3_ROW = 12
const val CAR4_ROW = 13

data class Vehicle(
    val facing: VehicleDirection,
    val type: VehicleType
)
