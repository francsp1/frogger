package frogger.view

import frogger.domain.Frogger
import pt.isel.canvas.Canvas

fun Canvas.drawGame(Frogger: Frogger) {
    erase()
    drawWater()
    drawMaze()
    //drawHero(hero)
}