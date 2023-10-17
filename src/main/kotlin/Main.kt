
import chess.ChessEngine
import chess.helper.Player

fun main() {
    val chess = ChessEngine()

    chess.setup()
    chess.printBoard(Player.BLACK)

}