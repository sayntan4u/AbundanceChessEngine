
import chess.ChessEngine
import chess.helper.Player

fun main() {
    val chess = ChessEngine()

    chess.setup()
    chess.printBoard()

    var list = chess.availableMoves("e7")
    println(list)

}