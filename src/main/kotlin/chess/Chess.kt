package chess

import chess.helper.Clan
import chess.helper.Piece
import chess.helper.Player
import chess.helper.Square

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
                                sqr.clan = Clan.BLACK
                                when(col){
                                    'a','h' -> {sqr.piece = Piece.R}
                                    'b','g' -> {sqr.piece = Piece.N}
                                    'c','f' -> {sqr.piece = Piece.B}
                                    'd' -> {sqr.piece = Piece.Q}
                                    'e' -> {sqr.piece = Piece.K}
                                }

                            }
                            7 -> {
                                sqr.clan = Clan.BLACK
                                sqr.piece = Piece.P
                            }
                            2 -> {
                                sqr.clan = Clan.WHITE
                                sqr.piece = Piece.P
                            }
                            1 -> {
                                sqr.clan = Clan.WHITE
                                when(col){
                                    'a','h' -> {sqr.piece = Piece.R}
                                    'b','g' -> {sqr.piece = Piece.N}
                                    'c','f' -> {sqr.piece = Piece.B}
                                    'd' -> {sqr.piece = Piece.Q}
                                    'e' -> {sqr.piece = Piece.K}
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
                    if(sqr.clan == Clan.WHITE){
                        if(i==1){
                            print(j.toString() + " " +sqr.piece.toString().toLowerCase() + " ")
                        }else{
                            print(sqr.piece.toString().toLowerCase() + " ")
                        }

                    }
                    else{
                        if(i==1){
                            print(j.toString() + " " +sqr.piece.toString() + " ")
                        }else{
                            print(sqr.piece.toString() + " ")
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
                    if(sqr.clan == Clan.WHITE){
                        if(i==1){
                            print(j.toString() + " " +sqr.piece.toString().toLowerCase() + " ")
                        }else{
                            print(sqr.piece.toString().toLowerCase() + " ")
                        }

                    }
                    else{
                        if(i==1){
                            print(j.toString() + " " +sqr.piece.toString() + " ")
                        }else{
                            print(sqr.piece.toString() + " ")
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
    

}