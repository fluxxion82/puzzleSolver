import model.Board
import model.Cell
import model.PuzzlePiece

class PuzzleBoard(private val width: Int = 7, private val height: Int = 7) : Board {
    private val cells = initBoard(width, height)
    private val usedPieces = mutableListOf<PuzzlePiece>()
    private val puzzlePieces = mutableListOf<PuzzlePiece>()

    private fun initBoard(width: Int, height: Int): List<Cell> = mutableListOf<Cell>().apply {
        for (x in 0 until width) {
            for (y in 0 until height) {
                add(Cell(x, y, false))
            }
        }
    }

    override fun addPlayablePuzzlePiece(puzzlePiece: PuzzlePiece) =
        puzzlePieces.add(puzzlePiece)

    override fun solvePuzzle() {
        puzzlePieces.onEachIndexed { index, _ ->
            solve(index)
        }
    }

    private fun solve(piece: Int) {
        if (piece < 0 || piece >= puzzlePieces.size) {
            return
        }
        val puzzlePiece = puzzlePieces[piece]
        var index = piece

        if (!usedPieces.contains(puzzlePiece)) {
            // todo: get orientations from piece, excluding symmetrical positions
            for (orientation in 0 until 8) {
                for (xAxis in 0 until width) {
                    for (yAxis in 0 until height) {
                        puzzlePiece.updateOrigin(xAxis, yAxis)

                        if (putPieceOnBoard(puzzlePiece)) {
                            usedPieces.add(puzzlePiece)
                            index++

                            if (usedPieces.size == puzzlePieces.size) {
                                println("solution:")

                                printBoard()

                                index--
                                removePieceFromBoard(puzzlePiece)
                                usedPieces.remove(puzzlePiece)
                            } else {
                                solve(
                                    if (index >= puzzlePieces.size) {
                                        -1
                                    } else {
                                        index
                                    }
                                )
                            }
                        }

                        if (index > piece) {
                            index--
                            removePieceFromBoard(puzzlePiece)
                            usedPieces.remove(puzzlePiece)
                        }
                    }
                }

                if (!usedPieces.contains(puzzlePiece)) {
                    puzzlePiece.rotate()
                    if (orientation == 3 || orientation == 7) {
                        puzzlePiece.rotate()
                        puzzlePiece.flipVertical()
                    }
                }
            }
        }
    }

    private fun putPieceOnBoard(piece: PuzzlePiece): Boolean {
        if (piece.cells.any { it.xCoord >= width || it.yCoord >= height || it.xCoord < 0 || it.yCoord < 0 }
            || piece.originX >= width || piece.originY >= height || piece.originX < 0 || piece.originY < 0
            || cells.any { cell ->
                piece.cells.any { piece ->
                    piece.xCoord == cell.xCoord && piece.yCoord == cell.yCoord && cell.filled
                }
            }
        ) {
            return false
        }

        piece.cells.forEach { pieceCell ->
            cells.find {
                it.xCoord == pieceCell.xCoord && it.yCoord == pieceCell.yCoord
            }?.filled = true
        }

        return true
    }

    private fun removePieceFromBoard(piece: PuzzlePiece) {
        if (usedPieces.contains(piece)) {
            piece.cells.forEach { pieceCell ->
                cells.find {
                    it.xCoord == pieceCell.xCoord && it.yCoord == pieceCell.yCoord
                }?.filled = false
            }
        }
    }

    override fun printBoard() {
        val xBound = cells.maxByOrNull { it.xCoord }!!.xCoord
        val yBound = cells.maxByOrNull { it.yCoord }!!.yCoord

        val sortedCells = cells.sortedBy { it.xCoord }.sortedBy { it.yCoord }
        val cellIter = sortedCells.listIterator()
        var nextCell: Cell = cellIter.next()
        for (i in 0..yBound) {
            for (j in 0..xBound) {
                if (nextCell.xCoord == j && nextCell.yCoord == i && nextCell.filled) {
                    usedPieces.forEach { pp ->
                        pp.cells.forEach {
                            if (it.xCoord == j && it.yCoord == i) {
                                print(pp.printValue)
                            }
                        }
                    }
                } else {
                    print("_ ")
                }

                if (cellIter.hasNext()) {
                    nextCell = cellIter.next()
                }
            }

            println("")
        }

        println("")
    }
}
