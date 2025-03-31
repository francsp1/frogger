package frogger

import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart
import frogger.domain.Frogger
import frogger.view.SCREEN_HEIGHT
import frogger.view.SCREEN_WIDTH
import frogger.view.drawGame

const val REFRESH_TIME = 25// 40 fps (1000/40 = 25 ms)

const val CAR1_START_X = 0
const val CAR4_START_X = 0

fun main() {
    onStart {
        println("Width: $SCREEN_WIDTH")
        println("Height: $SCREEN_HEIGHT")
        val canvas = Canvas(SCREEN_WIDTH, SCREEN_HEIGHT, BLACK)
        var game = Frogger(car1X= CAR1_START_X, car4X= CAR4_START_X)

        canvas.drawGame(game)
        /*
        canvas.onTimeProgress(REFRESH_TIME) {
            game = game.step()
            canvas.drawGame(game)
        }
        */

        /*
        canvas.onKeyPressed { key ->
            when (key.char) {
                '1' -> game = game.copy(car1X= CAR1_START_X)
                '4' -> game = game.copy(car4X= CAR4_START_X)
                'q','Q' -> canvas.close()
            }
        }
        */
    }
    onFinish { }
}


