package frogger.view

import frogger.domain.MAZE_HEIGHT
import frogger.domain.MAZE_WIDTH
import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * The maze's scale factor
 */
private const val SCALE:Double = (3.85)

/**
 * Dimension in pixels of the maze cell's sprites (without scaling)
 */
private const val ORIGINAL_CELL_SIZE = (16)

/**
 * The maze's scaled cell size
 */
const val CELL_SIZE = (ORIGINAL_CELL_SIZE * SCALE).toInt()

/**
 * The maze's original screen width (without scaling)
 */
private const val ORIGINAL_SCREEN_WIDTH = (ORIGINAL_CELL_SIZE * MAZE_WIDTH)

/**
 * The maze's original screen height (without scaling)
 */
private const val ORIGINAL_SCREEN_HEIGHT = (ORIGINAL_CELL_SIZE * MAZE_HEIGHT)

/**
 * The maze's scaled scren width
 */
const val SCREEN_WIDTH = ((ORIGINAL_SCREEN_WIDTH * SCALE).toInt())

/**
 * The maze's scaled screen height
 */
const val SCREEN_HEIGTH = ((ORIGINAL_SCREEN_HEIGHT * SCALE).toInt())

fun Canvas.drawMaze() {
    this.drawGrid()
}

/**
 * Draws a grid on the screen area represented by
 */
private fun Canvas.drawGrid() {
    for (index in 0 until MAZE_HEIGHT) {
        this.drawLine(
            xFrom = 0,
            yFrom = CELL_SIZE * index,
            xTo = SCREEN_WIDTH,
            yTo = CELL_SIZE * index,
            color = WHITE,
            thickness = 1
        )
    }
    for (index in 0 until MAZE_WIDTH) {
        this.drawLine(
            xFrom = CELL_SIZE * index,
            yFrom = 0,
            xTo = CELL_SIZE * index,
            yTo = SCREEN_HEIGTH,
            color = WHITE,
            thickness = 1
        )
    }
}