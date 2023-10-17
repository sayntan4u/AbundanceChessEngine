package chess

import chess.helper.*

class ChessEngine {

    var board = mutableListOf<Square>()

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
                                sqr.piece?.pieceType = PieceType.P
                            }
                            2 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.WHITE
                                sqr.piece?.pieceType = PieceType.P
                            }
                            1 -> {
                                sqr.piece = Piece()
                                sqr.piece?.clan = Clan.WHITE
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
    }

    fun printBoard(side : Player = Player.WHITE){
        println("_______BOARD_______")
        if(side == Player.WHITE){
            var i = 1
            var j = 8
            for(sqr in board){
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
    }

    fun availableMoves(pos : String) : List<String>{
        var moves = mutableListOf<String>()



        return moves.toList()
    }


    /*
    fun checkAvailableMove(state : SquareState) {

        var moves = mutableListOf<String>()
        var move = ""

        //check pawn moves
        if(state.piece == Piece.P){

            if(state.clan == Clan.WHITE) {

                //straight move
                if (state.posRow == 2) {
                    move = "${state.posCol}${(state.posRow.toInt() + 1)}"

                    var emptySquare = true
                    for (sqr in boardState){
                        if(sqr.pos == move && sqr.piece != Piece.EMPTY){
                            emptySquare = false
                            break
                        }
                    }
                    if(emptySquare){
                        moves.add(move)
                        move = "${state.posCol}${(state.posRow.toInt() + 2)}"

                        emptySquare = true
                        for (sqr in boardState){
                            if(sqr.pos == move && sqr.piece != Piece.EMPTY){
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
                    move = "${state.posCol}${(state.posRow.toInt() + 1)}"

                    var emptySquare = true
                    for (sqr in boardState){
                        if(sqr.pos == move && sqr.piece != Piece.EMPTY){
                            emptySquare = false
                            break
                        }
                    }
                    if(emptySquare){
                        moves.add(move)
                    }
                }

                //diagonal left check
                if(state.posCol > 'a'){
                    move = "${state.posCol - 1}${(state.posRow.toInt() + 1)}"

                    var enemySquare = false
                    for (sqr in boardState){

                        if(sqr.pos == move && sqr.piece!= Piece.EMPTY && sqr.clan == Clan.BLACK){
                            enemySquare = true
                            break
                        }
                    }
                    if(enemySquare){
                        moves.add(move)
                    }
                }

                //diagonal right check
                if(state.posCol < 'h'){
                    move = "${state.posCol + 1}${(state.posRow.toInt() + 1)}"



                    var enemySquare = false
                    for (sqr in boardState){

                        if(sqr.pos == move && sqr.piece!= Piece.EMPTY && sqr.clan == Clan.BLACK){
                            enemySquare = true
                            break
                        }
                    }
                    if(enemySquare){
                        moves.add(move)
                    }
                }


            }

            if(state.clan == Clan.BLACK) {
                if (state.posRow == 7) {
                    move = "${state.posCol}${(state.posRow.toInt() - 1)}"

                    var emptySquare = true
                    for (sqr in boardState){
                        if(sqr.pos == move && sqr.piece != Piece.EMPTY){
                            emptySquare = false
                            break
                        }
                    }
                    if(emptySquare){
                        moves.add(move)
                        move = "${state.posCol}${(state.posRow.toInt() - 2)}"

                        emptySquare = true
                        for (sqr in boardState){
                            if(sqr.pos == move && sqr.piece != Piece.EMPTY){
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
                    move = "${state.posCol}${(state.posRow.toInt() - 1)}"

                    var emptySquare = true
                    for (sqr in boardState){
                        if(sqr.pos == move && sqr.piece != Piece.EMPTY){
                            emptySquare = false
                            break
                        }
                    }
                    if(emptySquare){
                        moves.add(move)
                    }
                }

                //diagonal left check
                if(state.posCol > 'a'){
                    move = "${state.posCol - 1}${(state.posRow.toInt() - 1)}"

                    var enemySquare = false
                    for (sqr in boardState){

                        if(sqr.pos == move && sqr.piece!= Piece.EMPTY && sqr.clan == Clan.WHITE){
                            enemySquare = true
                            break
                        }
                    }
                    if(enemySquare){
                        moves.add(move)
                    }
                }

                //diagonal right check
                if(state.posCol < 'h'){
                    move = "${state.posCol + 1}${(state.posRow.toInt() - 1)}"

                    var enemySquare = false
                    for (sqr in boardState){

                        if(sqr.pos == move && sqr.piece!= Piece.EMPTY && sqr.clan == Clan.WHITE){
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

        //check Knight moves
        if(state.piece == Piece.N){
            var curRow = state.posRow
            var curCol = state.posCol

            //left
            if(curCol > 'b'){
                if((state.posRow + 1) < 9)
                {
                    move = "${state.posCol - 2}${state.posRow + 1}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){

                        }
                        else{
                            moves.add(move)
                        }
                    }

                }
                if((state.posRow - 1) > 0){
                    move = "${state.posCol - 2}${state.posRow - 1}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){

                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }


            //right
            if(curCol < 'g'){
                if((state.posRow + 1) < 9) {
                    move = "${state.posCol + 2}${state.posRow + 1}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){

                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
                if((state.posRow - 1) > 0) {
                    move = "${state.posCol + 2}${state.posRow - 1}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){

                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }


            //Up
            if(curRow < 7){
                move = "${state.posCol - 1}${state.posRow + 2}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){

                    }
                    else{
                        moves.add(move)
                    }
                }

                move = "${state.posCol + 1}${state.posRow + 2}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){

                    }
                    else{
                        moves.add(move)
                    }
                }

            }


            //Down
            if(curRow > 2) {
                move = "${state.posCol - 1}${state.posRow - 2}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){

                    }
                    else{
                        moves.add(move)
                    }
                }

                move = "${state.posCol + 1}${state.posRow - 2}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){

                    }
                    else{
                        moves.add(move)
                    }
                }
            }


        }

        //check Bishop moves
        if(state.piece == Piece.B){
            var curRow = state.posRow
            var curCol = state.posCol

            //top left move
            var i = curCol
            var j = curRow
            while(i > 'a'){
                i--
                j++
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(i < 'h'){
                i++
                j++
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(j > 1){
                i++
                j--
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(j > 1){
                i--
                j--
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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

        //check Rook moves
        if(state.piece == Piece.R){
            var curRow = state.posRow
            var curCol = state.posCol

            var i = curCol
            //left move
            while(i > 'a'){
                i--
                move = "${i}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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

            i=curCol
            //right move
            while(i < 'h'){
                i++
                move = "${i}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            var j=curRow
            while(j < 8){
                j++
                move = "${state.posCol}${(j)}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            j=curRow
            while(j>1){
                j--
                move = "${state.posCol}${(j)}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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

        //check King moves
        if(state.piece == Piece.K) {
            var curRow = state.posRow
            var curCol = state.posCol

            //left move
            if(curCol > 'a'){
                move = "${state.posCol - 1}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                    }
                    else{
                        moves.add(move)
                    }
                }

                if(curRow > 1){
                    move = "${state.posCol - 1}${(state.posRow.toInt() - 1)}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
                if(curRow < 8){
                    move = "${state.posCol - 1}${(state.posRow.toInt() + 1)}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }

            //right move
            if(curCol < 'h'){
                move = "${state.posCol + 1}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                    }
                    else{
                        moves.add(move)
                    }
                }

                if(curRow > 1){
                    move = "${state.posCol + 1}${(state.posRow.toInt() - 1)}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
                if(curRow < 8){
                    move = "${state.posCol + 1}${(state.posRow.toInt() + 1)}"
                    if(state.clan == Clan.WHITE){
                        if(move in occupiedSquares.whiteOccupiedSquares){

                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                            moves.add(move)

                        }
                        else{
                            moves.add(move)
                        }
                    }
                    if(state.clan == Clan.BLACK){
                        if(move in occupiedSquares.whiteOccupiedSquares){
                            moves.add(move)
                        }
                        else if(move in occupiedSquares.blackOccupiedSquares){
                        }
                        else{
                            moves.add(move)
                        }
                    }
                }
            }

            //top move
            if(curRow < 8){
                move = "${state.posCol}${(state.posRow.toInt() + 1)}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                    }
                    else{
                        moves.add(move)
                    }
                }
            }

            //bottom move
            if(curRow > 1){
                move = "${state.posCol}${(state.posRow.toInt() - 1)}"
                if(state.clan == Clan.WHITE){
                    if(move in occupiedSquares.whiteOccupiedSquares){

                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                        moves.add(move)

                    }
                    else{
                        moves.add(move)
                    }
                }
                if(state.clan == Clan.BLACK){
                    if(move in occupiedSquares.whiteOccupiedSquares){
                        moves.add(move)
                    }
                    else if(move in occupiedSquares.blackOccupiedSquares){
                    }
                    else{
                        moves.add(move)
                    }
                }
            }
        }

        //check Queen moves
        if(state.piece == Piece.Q){
            var curRow = state.posRow
            var curCol = state.posCol

            var i = curCol
            //left move
            while(i > 'a'){
                i--
                move = "${i}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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

            i=curCol

            //right move
            while(i < 'h'){
                i++
                move = "${i}${(state.posRow.toInt())}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            var j=curRow
            while(j < 8){
                j++
                move = "${state.posCol}${(j)}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            j=curRow
            while(j>1){
                j--
                move = "${state.posCol}${(j)}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(i > 'a'){
                i--
                j++
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(i < 'h'){
                i++
                j++
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(j > 1){
                i++
                j--
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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
            i = curCol
            j = curRow
            while(j > 1){
                i--
                j--
                move = "${i}${j}"
                if(state.clan == Clan.WHITE){
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
                if(state.clan == Clan.BLACK){
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


        availableMoves = moves

    }
    */

}