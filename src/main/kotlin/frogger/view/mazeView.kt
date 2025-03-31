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
 * Dimension in pixels of the maze cell's sprites with a scale factor (Actual size shown on the screen)
 */
const val CELL_SIZE = (ORIGINAL_CELL_SIZE * SCALE).toInt()

/**
 * The maze's scaled scren width
 */
const val SCREEN_WIDTH = (CELL_SIZE * MAZE_WIDTH)

/**
 * The maze's scaled screen height
 */
const val SCREEN_HEIGHT = (CELL_SIZE * MAZE_HEIGHT)


/**
 * Draws the maze on the screen area represented by [Canvas]
 */
fun Canvas.drawMaze() {
    this.drawGrid()
}

/**
 * Draws the water section of the screen area represented by [Canvas]
 */
fun Canvas.drawWater() {
    this.drawRect(0,0, SCREEN_WIDTH, SCREEN_HEIGHT /2, color = 0x000047)
}

/**
 * Draws a grid on the screen area represented by [Canvas]
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
            yTo = SCREEN_HEIGHT,
            color = WHITE,
            thickness = 1
        )
    }
}