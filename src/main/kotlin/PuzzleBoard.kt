import model.Board
import model.Cell
import model.PuzzlePiece

class PuzzleBoard(private val width: Int = 7, private val height: Int = 7) : Board {
    private val cellMap = mutableMapOf<Pair<Int, Int>, Cell>()
    private val usedPieces = mutableListOf<PuzzlePiece>()
    private val puzzlePieces = mutableListOf<PuzzlePiece>()

    override fun addPlayablePuzzlePiece(puzzlePiece: PuzzlePiece): Boolean {
        puzzlePiece.initOriginalCells()
        return puzzlePieces.add(puzzlePiece)
    }

    override fun solvePuzzle() {
        val visited = mutableSetOf<Int>()
        val startTime = System.currentTimeMillis()
        println("Starting puzzle solution...")
        println("Board dimensions: ${width}x${height}")
        println("Number of pieces: ${puzzlePieces.size}")
        
        val result = solve(0, visited)
        
        val endTime = System.currentTimeMillis()
        println("Puzzle solving completed in ${endTime - startTime}ms")
        println("Visited ${visited.size} unique board states")
        println("Solution found: $result")
    }

    private fun solve(pieceIndex: Int, visited: MutableSet<Int> = mutableSetOf()): Boolean {
        if (usedPieces.size == puzzlePieces.size) {
            println("Solution found!")
            printBoard()
            return true
        }
        
        if (pieceIndex >= puzzlePieces.size) return false
        
        val piece = puzzlePieces[pieceIndex]
        if (usedPieces.contains(piece)) {
            return solve(pieceIndex + 1, visited)
        }

        val orientations = piece.getUniqueOrientations()
        for (orientation in orientations) {
            piece.applyOrientation(orientation)
            val positions = getMostConstrainedPositions()
            
            for ((x, y) in positions) {
                piece.updateOrigin(x, y)
                
                if (putPieceOnBoard(piece)) {
                    usedPieces.add(piece)

                    val boardState = getBoardStateHash()
                    if (!visited.contains(boardState)) {
                        visited.add(boardState)
                        
                        if (solve(pieceIndex + 1, visited)) {
                            return true
                        }
                    }

                    removePieceFromBoard(piece)
                    usedPieces.remove(piece)
                }
            }
        }
        
        return false
    }

    private fun getMostConstrainedPositions(): List<Pair<Int, Int>> {
        val emptyPositions = mutableListOf<Triple<Int, Int, Int>>()

        for (x in 0 until width) {
            for (y in 0 until height) {
                if (!isCellFilled(x, y)) {
                    val constraintValue = countFilledNeighbors(x, y)
                    emptyPositions.add(Triple(x, y, constraintValue))
                }
            }
        }

        return emptyPositions.sortedByDescending { it.third }
            .map { Pair(it.first, it.second) }
    }

    private fun isCellFilled(x: Int, y: Int): Boolean {
        return cellMap[Pair(x, y)]?.filled == true
    }

    private fun countFilledNeighbors(x: Int, y: Int): Int {
        var count = 0
        val neighbors = listOf(
            Pair(x-1, y), Pair(x+1, y), 
            Pair(x, y-1), Pair(x, y+1)
        )
        
        for ((nx, ny) in neighbors) {
            if (nx < 0 || nx >= width || ny < 0 || ny >= height || 
                cellMap[Pair(nx, ny)]?.filled == true) {
                count++
            }
        }
        return count
    }

    private fun getBoardStateHash(): Int {
        var hash = 17

        for (piece in usedPieces) {
            val pieceId = puzzlePieces.indexOf(piece)
            hash = 31 * hash + pieceId
            hash = 31 * hash + piece.originX
            hash = 31 * hash + piece.originY
        }

        return hash
    }

    private fun putPieceOnBoard(piece: PuzzlePiece): Boolean {
        if (piece.cells.any { cell ->
            cell.xCoord < 0 || cell.xCoord >= width || 
            cell.yCoord < 0 || cell.yCoord >= height || 
            cellMap[Pair(cell.xCoord, cell.yCoord)]?.filled == true
        }) {
            return false
        }

        piece.cells.forEach { cell ->
            cellMap[Pair(cell.xCoord, cell.yCoord)]?.filled = true
        }

        return true
    }

    private fun removePieceFromBoard(piece: PuzzlePiece) {
        piece.cells.forEach { cell ->
            val coords = Pair(cell.xCoord, cell.yCoord)
            if (coords.first in 0 until width && coords.second in 0 until height) {
                cellMap[coords]?.filled = false
            }
        }
    }

    override fun printBoard() {
        println("Board state:")
        for (y in 0 until height) {
            for (x in 0 until width) {
                val cell = cellMap[Pair(x, y)]
                if (cell?.filled == true) {
                    var found = false
                    for (piece in usedPieces) {
                        if (piece.cells.any { it.xCoord == x && it.yCoord == y }) {
                            print(piece.printValue)
                            found = true
                            break
                        }
                    }
                    if (!found) print("X ")
                } else {
                    print("_ ")
                }
            }
            println("")
        }
        println("")
    }
}
