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
    drawHomes()
    drawSidewalks()
}

/**
 * Draws the water section of the screen area represented by [Canvas]
 */
fun Canvas.drawWater() {
    drawRect(0,0, SCREEN_WIDTH, (SCREEN_HEIGHT/2) + (CELL_SIZE/2), color = 0x000047)
}

/**
 * Draws the sidewalks on the screen area represented by [Canvas]
 */
fun Canvas.drawSidewalks() {
    for (column in 0 until MAZE_WIDTH) {
        // Upper Sidewalk
        drawLayoutSprite(line = 8, column = column,135, 196)
        // Lower Sidewalk
        drawLayoutSprite(line = 14, column = column,135, 196)
    }
}

/**
 * Draws the homes (Frog's safe spots) on the screen area represented by [Canvas]
 */

fun Canvas.drawHomes() {
    drawImage(
        "frogger|35,188,8,24",
        xLeft = CELL_SIZE,
        yTop = CELL_SIZE,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}

/**
 * Draws the sprite located at [line] and [column] on the layout sprite sheet on the given [screenPosition]
 */
private fun Canvas.drawLayoutSpriteWithPoint(line: Int, column: Int, screenPosition: Point) {
    val spriteX = column * CELL_SIZE + column
    val spriteY = line * CELL_SIZE + line
    drawImage(
        "frogger|$spriteX,$spriteY,$CELL_SIZE,$CELL_SIZE",
        xLeft = screenPosition.x,
        yTop = screenPosition.y,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}

/**
 * Draws the sprite located at [line] and [column] on the layout sprite sheet on the given [screenPosition]
 */
private fun Canvas.drawLayoutSprite(line: Int, column: Int, spriteX: Int, spriteY: Int) {
    drawImage(
        "frogger|$spriteX,$spriteY,${ORIGINAL_CELL_SIZE},${ORIGINAL_CELL_SIZE}",
        xLeft = column * CELL_SIZE,
        yTop = line * CELL_SIZE,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}

/**
 * Draws a grid on the screen area represented by [Canvas]
 */
fun Canvas.drawGrid() {
    for (index in 0 until MAZE_HEIGHT) {
        drawLine(
            xFrom = 0,
            yFrom = CELL_SIZE * index,
            xTo = SCREEN_WIDTH,
            yTo = CELL_SIZE * index,
            color = WHITE,
            thickness = 1
        )
    }
    for (index in 0 until MAZE_WIDTH) {
        drawLine(
            xFrom = CELL_SIZE * index,
            yFrom = 0,
            xTo = CELL_SIZE * index,
            yTo = SCREEN_HEIGHT,
            color = WHITE,
            thickness = 1
        )
    }
}