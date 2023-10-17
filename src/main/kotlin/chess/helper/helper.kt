package chess.helper

enum class Piece {
    R, N, B, Q, K, P
}

enum class Clan {
   WHITE, BLACK
}

enum class Player{
    WHITE, BLACK
}

class Square(p : Piece? = null, c : Clan? = null, row : Int? = null, col : Char? = null){
    var piece : Piece?
    var clan : Clan?
    var row : Int?
    var col: Char?

    init {
        piece = p
        clan = c
        this.row = row
        this.col = col
    }
}

class AttackedSquare(){
    var byWhiteAttackedSquares = mutableListOf<String>()
    var byBlackAttackedSquares = mutableListOf<String>()
}