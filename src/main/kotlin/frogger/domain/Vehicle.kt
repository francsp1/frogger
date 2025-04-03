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

sealed class Vehicle(
    val at: Coordinate,
    val facing: VehicleDirection,
    val type: VehicleType
)


data class Car1(val column: Int)  : Vehicle(Coordinate(CAR1_ROW, column), VehicleDirection.RIGHT, VehicleType.CAR1)
data class Car2(val column: Int)  : Vehicle(Coordinate(CAR2_ROW, column), VehicleDirection.LEFT, VehicleType.CAR2)
data class Car3(val column: Int)  : Vehicle(Coordinate(CAR3_ROW, column), VehicleDirection.RIGHT, VehicleType.CAR3)
data class Car4(val column: Int)  : Vehicle(Coordinate(CAR4_ROW, column), VehicleDirection.RIGHT, VehicleType.CAR4)
data class Truck(val column: Int) : Vehicle(Coordinate(TRUCK_ROW, column), VehicleDirection.LEFT, VehicleType.TRUCK)




