
import chess.ChessEngine
import chess.helper.Player

fun main() {
    val chess = ChessEngine()

    chess.setup()

    chess.movePiece("e2", "e4")
    chess.movePiece("d7", "d5")


}