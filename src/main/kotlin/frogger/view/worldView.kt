package frogger.view

import frogger.domain.Frogger
import pt.isel.canvas.Canvas

fun Canvas.drawGame(frogger: Frogger) {
    erase()
    drawWater()
    drawMaze()
    drawVehicles(frogger)
    drawGrid()

    //drawHero(hero)
}

fun Canvas.drawSprite(
    fileName: String,
    spriteX: Int,
    spriteY: Int,
    spriteXWidth: Int,
    spriteYHeight: Int,
    screenXLeft: Int,
    screenYTop: Int,
) {
    drawImage("${fileName}|${spriteX},${spriteY},${spriteXWidth},${spriteYHeight}",
        xLeft = screenXLeft,
        yTop = screenYTop,
        width = (spriteXWidth * SCALE).toInt(),
        height = (spriteYHeight * SCALE).toInt()
    )
}