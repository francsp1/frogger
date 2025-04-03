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