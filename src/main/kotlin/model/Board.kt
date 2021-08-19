package model

interface Board {
    fun addPlayablePuzzlePiece(puzzlePiece: PuzzlePiece): Boolean
    fun solvePuzzle()
    fun printBoard()
}
