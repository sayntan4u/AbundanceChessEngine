package chess

import chess.helper.*

class ChessEngine {

    val board = mutableListOf<Square>()
    val occupiedSquares = OccupiedSquare()

    var side = Player.WHITE

    init {

    }

    fun setup(){
                for(row in 8 downTo 1){
                    for(col in listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')){
                        val sqr = Square(row = row, col = col)
                        when(row){
                            8 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.BLACK
                                occupiedSquares.blackOccupiedSquares.add(sqr.pos.toString())
                                when(col){
                                    'a','h' -> {
                                        sqr.piece?.pieceType = PieceType.R}
                                    'b','g' -> {
                                        sqr.piece?.pieceType = PieceType.N}
                                    'c','f' -> {
                                        sqr.piece?.pieceType = PieceType.B}
                                    'd' -> {
                                        sqr.piece?.pieceType = PieceType.Q}
                                    'e' -> {
                                        sqr.piece?.pieceType = PieceType.K
                                    }
                                }

                            }
                            7 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.BLACK
                                occupiedSquares.blackOccupiedSquares.add(sqr.pos.toString())
                                sqr.piece?.pieceType = PieceType.P
                            }
                            //Test Starts
                            /*5 -> {
                                if(col == 'e'){
                                    sqr.piece = Piece()
                                    sqr.piece?.clan = Clan.BLACK
                                    occupiedSquares.blackOccupiedSquares.add(sqr.pos.toString())
                                    sqr.piece?.pieceType = PieceType.Q
                                }
                            }*/
                            //Test ends
                            2 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.WHITE
                                occupiedSquares.whiteOccupiedSquares.add(sqr.pos.toString())
                                sqr.piece?.pieceType = PieceType.P
                            }
                            1 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.WHITE
                                occupiedSquares.whiteOccupiedSquares.add(sqr.pos.toString())
                                when(col){
                                    'a','h' -> {
                                        sqr.piece?.pieceType = PieceType.R}
                                    'b','g' -> {
                                        sqr.piece?.pieceType = PieceType.N}
                                    'c','f' -> {
                                        sqr.piece?.pieceType = PieceType.B}
                                    'd' -> {
                                        sqr.piece?.pieceType = PieceType.Q}
                                    'e' -> {
                                        sqr.piece?.pieceType = PieceType.K
                                    }
                                }
                            }
                        }
                        board.add(sqr)
                    }
                }

        printBoard()
    }

    fun printBoard(side : Player = Player.WHITE){
        println("_______BOARD_______")
        if(side == Player.WHITE){
            var i = 1
            var j = 8
            for(sqr in board){
                if(sqr.piece?.pieceType != null){
                    if(sqr.piece?.clan == Clan.WHITE){
                        if(i==1){
                            print(j.toString() + " " +sqr.piece?.pieceType.toString().toLowerCase() + " ")
                        }else{
                            print(sqr.piece?.pieceType.toString().toLowerCase() + " ")
                        }

                    }
                    else{
                        if(i==1){
                            print(j.toString() + " " +sqr.piece?.pieceType.toString() + " ")
                        }else{
                            print(sqr.piece?.pieceType.toString() + " ")
                        }

                    }
                }
                else{
                    if(i==1){
                        print(j.toString() + " . ")
                    }else{
                        print(". ")
                    }
                }

                i++
                if(i>8){
                    println()
                    j--
                    i=1
                }
            }
            println("  _______________")
            println("  a b c d e f g h")
        }
        else{
            var i = 1
            var j = 1
            for(sqr in board.reversed()){
                if(sqr.piece != null){
                    if(sqr.piece?.clan == Clan.WHITE){
                        if(i==1){
                            print(j.toString() + " " +sqr.piece?.pieceType.toString().toLowerCase() + " ")
                        }else{
                            print(sqr.piece?.pieceType.toString().toLowerCase() + " ")
                        }
                    }
                    else{
                        if(i==1){
                            print(j.toString() + " " +sqr.piece?.pieceType.toString() + " ")
                        }else{
                            print(sqr.piece?.pieceType.toString() + " ")
                        }

                    }
                }
                else{
                    if(i==1){
                        print(j.toString() + " . ")
                    }else{
                        print(". ")
                    }
                }

                i++
                if(i>8){
                    println()
                    j++
                    i=1
                }
            }
            println("  _______________")
            println("  h g f e d c b a")

        }

        println("___________________")

        println("white occupied: " + occupiedSquares.whiteOccupiedSquares)
        println("black occupied: " + occupiedSquares.blackOccupiedSquares)
    }

    fun getPieceAt(pos:String) : Piece{
        val piece = Piece()
        for(sqr in board){
           if(sqr.pos == pos){
               piece.pieceType = sqr.piece?.pieceType
               piece.clan = sqr.piece?.clan
           }
        }
        return piece
    }

    fun getRow(pos: String) : Int{
        return pos[1].toString().toInt()
    }

    fun getCol(pos: String) : Char{
        return pos[0].toChar()
    }


    fun availableMoves(pos : String) : List<String>{
        var moves = mutableListOf<String>()
        var move = ""

        val piece = getPieceAt(pos)
        val row = getRow(pos)
        val col = getCol(pos)

        println(piece.pieceType)
//        println(col)
//        println(row)


        when(piece.pieceType){
            PieceType.P -> {
                if(piece.clan == Clan.WHITE) {

                    //straight move
                    if (row == 2) {
                        move = "${col}${(row + 1)}"

                        var emptySquare = true
                        for (sqr in board){
                            if(sqr.pos == move && sqr.piece != null){
                                emptySquare = false
                                break
                            }
                        }
                        if(emptySquare){
                            moves.add(move)
                            move = "${col}${(row + 2)}"

                            emptySquare = true
                            for (sqr in board){
                                if(sqr.pos == move && sqr.piece != null){
                                    emptySquare = false
                                    break
                                }
                            }
                            if(emptySquare){
                                moves.add(move)
                            }
                        }


                    }
                    else {
                        move = "${col}${(row) + 1}"

                        var emptySquare = true
                        for (sqr in board){
                            if(sqr.pos == move && sqr.piece != null){
                                emptySquare = false
                                break
                            }
                        }
                        if(emptySquare){
                            moves.add(move)
                        }
                    }

                    //diagonal left check
                    if(col > 'a'){
                        move = "${col - 1}${(row + 1)}"

                        var enemySquare = false
                        for (sqr in board){

                            if(sqr.pos == move && sqr.piece!= null && sqr.piece?.clan == Clan.BLACK){
                                enemySquare = true
                                break
                            }
                        }
                        if(enemySquare){
                            moves.add(move)
                        }
                    }

                    //diagonal right check
                    if(col < 'h'){
                        move = "${col + 1}${(row + 1)}"



                        var enemySquare = false
                        for (sqr in board){

                            if(sqr.pos == move && sqr.piece!= null && sqr.piece?.clan == Clan.BLACK){
                                enemySquare = true
                                break
                            }
                        }
                        if(enemySquare){
                            moves.add(move)
                        }
                    }


                }

                if(piece.clan == Clan.BLACK) {
                    if (row == 7) {
                        move = "${col}${(row - 1)}"

                        var emptySquare = true
                        for (sqr in board){
                            if(sqr.pos == move && sqr.piece != null){
                                emptySquare = false
                                break
                            }
                        }
                        if(emptySquare){
                            moves.add(move)
                            move = "${col}${(row - 2)}"

                            emptySquare = true
                            for (sqr in board){
                                if(sqr.pos == move && sqr.piece != null){
                                    emptySquare = false
                                    break
                                }
                            }
                            if(emptySquare){
                                moves.add(move)
                            }


                        }
                    }
                    else {
                        move = "${col}${(row) - 1}"

                        var emptySquare = true
                        for (sqr in board){
                            if(sqr.pos == move && sqr.piece != null){
                                emptySquare = false
                                break
                            }
                        }
                        if(emptySquare){
                            moves.add(move)
                        }
                    }

                    //diagonal left check
                    if(col > 'a'){
                        move = "${col - 1}${(row - 1)}"

                        var enemySquare = false
                        for (sqr in board){

                            if(sqr.pos == move && sqr.piece!= null && sqr.piece?.clan == Clan.WHITE){
                                enemySquare = true
                                break
                            }
                        }
                        if(enemySquare){
                            moves.add(move)
                        }
                    }

                    //diagonal right check
                    if(col < 'h'){
                        move = "${col + 1}${(row - 1)}"

                        var enemySquare = false
                        for (sqr in board){

                            if(sqr.pos == move && sqr.piece!= null && sqr.piece?.clan == Clan.WHITE){
                                enemySquare = true
                                break
                            }
                        }
                        if(enemySquare){
                            moves.add(move)
                        }
                    }
                }
            }
            PieceType.R -> {
                var i = col

                //left move
                while(i > 'a'){
                    i--
                    move = "${i}${row}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }


                }

                i=col
                //right move
                while(i < 'h'){
                    i++
                    move = "${i}${row}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //up move
                var j=row
                while(j < 8){
                    j++
                    move = "${col}${(j)}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //down move
                j=row
                while(j>1){
                    j--
                    move = "${col}${(j)}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }
            PieceType.N -> {
                //left
                if(col > 'b') {
                    if (row < 8) {
                        move = "${col - 2}${row + 1}"
                        moves.add(move)
                    }
                    if (row > 1) {
                        move = "${col - 2}${row - 1}"
                        moves.add(move)
                    }
                }

                //right
                if(col < 'g') {
                    if ((row + 1) < 9) {
                        move = "${col + 2}${row + 1}"
                        moves.add(move)
                    }
                    if ((row - 1) > 0) {
                        move = "${col + 2}${row - 1}"
                        moves.add(move)
                    }
                }

                //Up
                if(row < 7){
                    if(col>'a'){
                        move = "${col - 1}${row + 2}"
                        moves.add(move)
                    }
                    if(col<'h'){
                        move = "${col + 1}${row + 2}"
                        moves.add(move)
                    }
                }

                //Down
                if(row > 2){
                    if(col>'a'){
                        move = "${col - 1}${row - 2}"
                        moves.add(move)
                    }
                    if(col<'h'){
                        move = "${col + 1}${row - 2}"
                        moves.add(move)
                    }
                }
            }
            PieceType.B -> {

                //top left move
                var i = col
                var j = row
                while(i > 'a'){
                    i--
                    j++
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //top right move
                i = col
                j = row
                while(i < 'h'){
                    i++
                    j++
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //bottom right move
                i = col
                j = row
                while(j > 1){
                    i++
                    j--
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }

                //bottom left move
                i = col
                j = row
                while(j > 1){
                    i--
                    j--
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }
            PieceType.K -> {}
            PieceType.Q -> {
                var i = col

                //left move
                while(i > 'a'){
                    i--
                    move = "${i}${row}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }


                }

                i=col
                //right move
                while(i < 'h'){
                    i++
                    move = "${i}${row}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //up move
                var j=row
                while(j < 8){
                    j++
                    move = "${col}${(j)}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //down move
                j=row
                while(j>1){
                    j--
                    move = "${col}${(j)}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }

                //top left move
                 i = col
                 j = row
                while(i > 'a'){
                    i--
                    j++
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //top right move
                i = col
                j = row
                while(i < 'h'){
                    i++
                    j++
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }

                }

                //bottom right move
                i = col
                j = row
                while(j > 1){
                    i++
                    j--
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }

                //bottom left move
                i = col
                j = row
                while(j > 1){
                    i--
                    j--
                    move = "${i}${j}"
                    if(piece.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(piece.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                            break
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            break
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }


            }
            null -> TODO()
        }

        //remove moves if occupied by same clan
        for(sqr in board){
            if(sqr.piece != null && sqr.piece?.clan == piece.clan && sqr.pos in moves){
                moves.remove(sqr.pos)
            }
        }

        return moves.toList()
    }

    fun movePiece(from : String, to : String){
        val fromPiece = getPieceAt(from)
        val toPiece = getPieceAt(to)

        for (sqr in board){
            if(sqr.pos == to){
                sqr.piece = fromPiece
            }

            if(sqr.pos == from){
                if(toPiece.pieceType == null){
                    sqr.piece = toPiece
                }
                else{
                    sqr.piece = null
                }

            }
        }

        if(toPiece.pieceType == null){
            if(fromPiece.clan == Clan.WHITE){
                occupiedSquares.whiteOccupiedSquares.remove(from)
                occupiedSquares.whiteOccupiedSquares.add(to)
            }
            else{
                occupiedSquares.blackOccupiedSquares.remove(from)
                occupiedSquares.blackOccupiedSquares.add(to)
            }
        }
        else{
            if(fromPiece.clan == Clan.WHITE){
                occupiedSquares.whiteOccupiedSquares.remove(from)
                occupiedSquares.whiteOccupiedSquares.add(to)

                occupiedSquares.blackOccupiedSquares.remove(to)

            }
            else{
                occupiedSquares.blackOccupiedSquares.remove(from)
                occupiedSquares.blackOccupiedSquares.add(to)

                occupiedSquares.whiteOccupiedSquares.remove(to)
            }
        }

        printBoard()

    }

}