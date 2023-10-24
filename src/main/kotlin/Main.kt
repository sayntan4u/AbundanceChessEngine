
import chess.ChessEngine
import chess.helper.Player

fun main() {
    val chess = ChessEngine()

    chess.setup()

    chess.movePiece("e2", "e4")
    chess.movePiece("e7", "e5")
    chess.movePiece("e5", "e4")


//    val list = chess.availableMoves("e5")
//    println(list)

}