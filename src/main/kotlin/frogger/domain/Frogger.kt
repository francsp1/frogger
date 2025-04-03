package frogger.domain

import frogger.view.*


data class Frogger(
    val truckX: Int = TRUCK_START_X,
    val car1X: Int = CAR1_START_X,
    val car2X: Int = CAR2_START_X,
    val car3X: Int = CAR3_START_X,
    val car4X: Int = CAR4_START_X,
    val truck: Vehicle = Vehicle(facing = VehicleDirection.LEFT, type = VehicleType.TRUCK),
    val car1: Vehicle = Vehicle(facing = VehicleDirection.RIGHT, type = VehicleType.CAR1),
    val car2: Vehicle = Vehicle(facing = VehicleDirection.LEFT, type = VehicleType.CAR2),
    val car3: Vehicle = Vehicle(facing = VehicleDirection.RIGHT, type = VehicleType.CAR3),
    val car4: Vehicle = Vehicle(facing = VehicleDirection.LEFT, type = VehicleType.CAR4),
)

fun Frogger.step(): Frogger {
    return copy(car1X = car1X + 1)
}