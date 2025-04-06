package frogger.view

import frogger.domain.*
import pt.isel.canvas.Canvas

/**
 * Dimension in pixels of the car sprites (without scaling)
 */
const val ORIGINAL_VEHICLE_SIZE = ORIGINAL_CELL_SIZE

/**
 * Dimension in pixels of the car sprites with a scale factor applied (Actual size shown on the screen)
 */
const val VEHICLE_SIZE = (ORIGINAL_VEHICLE_SIZE * SCALE).toInt()

/**
 * Draws the given [vehicle] on the screen area represented by [Canvas]
 */

const val TRUCK_START_X = MAZE_WIDTH - 1
const val CAR1_START_X = 0
const val CAR2_START_X = MAZE_WIDTH - 1
const val CAR3_START_X = 0
const val CAR4_START_X = MAZE_WIDTH - 1


fun Canvas.drawVehicle(vehicle: Vehicle, vehicleColumn: Int) {
    val position = Point(
        x = vehicleColumn * VEHICLE_SIZE,
        y = when (vehicle.type) {
            VehicleType.TRUCK -> TRUCK_ROW * VEHICLE_SIZE
            VehicleType.CAR1 -> CAR1_ROW * VEHICLE_SIZE
            VehicleType.CAR2 -> CAR2_ROW * VEHICLE_SIZE
            VehicleType.CAR3 -> CAR3_ROW * VEHICLE_SIZE
            VehicleType.CAR4 -> CAR4_ROW * VEHICLE_SIZE
        }
    )
    drawVehicleSprite(vehicle.type, position)
}

fun Canvas.drawVehicleSprite(type: VehicleType, position: Point) {
    val spriteColumn = when (type) {
        VehicleType.CAR1 -> 2
        VehicleType.CAR2 -> 0
        VehicleType.CAR3 -> 3
        VehicleType.CAR4 -> 1
        VehicleType.TRUCK -> 4
    }
    val spriteXSize = when (type) {
        VehicleType.TRUCK -> ORIGINAL_VEHICLE_SIZE * 2
        else -> ORIGINAL_VEHICLE_SIZE
    }

    val width = when (type) {
        VehicleType.TRUCK -> VEHICLE_SIZE * 2
        else -> VEHICLE_SIZE
    }

    val spriteX = 1 + (ORIGINAL_VEHICLE_SIZE * spriteColumn) + (2 * spriteColumn)
    val spriteY = 116
    drawImage(
        "frogger|${spriteX},${spriteY},${spriteXSize},${ORIGINAL_VEHICLE_SIZE}",
        xLeft = position.x,
        yTop = position.y,
        width = width,
        height = VEHICLE_SIZE
    )
}

