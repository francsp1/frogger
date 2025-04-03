package frogger.view

import frogger.domain.Coordinate

/**
 * Represents coordinates on the screen and on the game's sprites
 */
data class Point(val x: Int, val y: Int)

/**
 * Converts the given maze coordinate to its respective [Point] instance.
 */
fun coordinateToPoint(at: Coordinate) =
    Point(x = (at.column * CELL_SIZE).toInt(), y = (at.row * CELL_SIZE).toInt())
