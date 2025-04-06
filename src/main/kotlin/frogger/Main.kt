package frogger

import frogger.domain.*
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart
import frogger.view.*
import java.lang.Thread.sleep
import kotlin.system.exitProcess

const val REFRESH_TIME = 1000/40 // 40 fps (1000/40 = 25 ms)


fun main() {
    onStart {
        val canvas = Canvas(SCREEN_WIDTH, SCREEN_HEIGHT, BLACK)
        var game = Frogger()

        canvas.drawGame(game)

        canvas.onTimeProgress(REFRESH_TIME) {
            canvas.drawGame(game)
            game = game.step()
        }
        canvas.onKeyPressed { key ->
            when (key.char) {
                '1' -> {
                    val game1 = Frogger(car1X = CAR1_START_X)
                    val game2 = game.copy(car1X = CAR1_START_X)
                    game = game2
                    //game = game.copy(car1X = CAR1_START_X)
                    //canvas.drawGame(game)
                }
                '4' ->  {
                    game = game.copy(car4X= CAR4_START_X)
                    //canvas.drawGame(game)
                }
                'q','Q' -> canvas.close()
            }
        }
    }
    onFinish { }
}

