package frogger.domain

data class Frogger(
    private val car1X: Int,
    private val car2X: Int,
    private val car3X: Int,
    private val car4X: Int,
    private val truckX: Int,
    val truck: Truck = Truck(truckX),
    val car1: Car1 = Car1(car1X),
    val car2: Car2 = Car2(car2X),
    val car3: Car3 = Car3(car3X),
    val car4: Car4 = Car4(car4X),
)

fun Frogger.step(): Frogger {

    return copy(car1 = Car1(car1.column + 1))
}