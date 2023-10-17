package chess.helper

enum class PieceType {
    R, N, B, Q, K, P
}

enum class Clan {
   WHITE, BLACK
}

enum class Player{
    WHITE, BLACK
}

class Piece(pieceType : PieceType? = null, clan: Clan? = null){
    var pieceType : PieceType?
    var clan : Clan?

    init {
        this.pieceType = pieceType
        this.clan = clan
    }
}

class Square(p : Piece? = null, row : Int? = null, col : Char? = null){
    var piece : Piece?
    var row : Int?
    var col: Char?

    init {
        piece = p
        this.row = row
        this.col = col
    }
}

class AttackedSquare(){
    var byWhiteAttackedSquares = mutableListOf<String>()
    var byBlackAttackedSquares = mutableListOf<String>()
}