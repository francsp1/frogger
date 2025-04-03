package frogger

import frogger.domain.*
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart
import frogger.view.*

const val REFRESH_TIME = 1000/1 // 40 fps (1000/40 = 25 ms)


fun main() {
    onStart {
        val canvas = Canvas(SCREEN_WIDTH, SCREEN_HEIGHT, BLACK)
        var game = Frogger(car1X= CAR1_START_X, car2X= CAR2_START_X, car3X= CAR3_START_X, car4X= CAR4_START_X, truckX= TRUCK_START_X)

        canvas.drawGame(game)

        canvas.onTimeProgress(REFRESH_TIME) {
            game = game.step()
            canvas.drawGame(game)
        }
        canvas.onKeyPressed { key ->
            when (key.char) {
                '1' -> game = game.copy(car1X= CAR1_START_X)
                '4' -> game = game.copy(car4X= CAR4_START_X)
                'q','Q' -> canvas.close()
            }
        }


    }
    onFinish { }
}

/*

 */
