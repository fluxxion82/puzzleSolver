import model.Board
import model.Cell
import model.PuzzlePiece
import java.util.*

class PuzzleBoard(private val width: Int = 7, private val height: Int = 7) : Board {
    private val cellMap = mutableMapOf<Pair<Int, Int>, Cell>()
    private val usedPieces = mutableListOf<PuzzlePiece>()
    private val puzzlePieces = mutableListOf<PuzzlePiece>()

    private var nodesExplored = 0
    private var prunedStates = 0

    init {
        for (x in 0 until width) {
            for (y in 0 until height) {
                cellMap[Pair(x, y)] = Cell(x, y, false)
            }
        }
    }

    override fun addPlayablePuzzlePiece(puzzlePiece: PuzzlePiece): Boolean {
        puzzlePiece.initOriginalCells()
        return puzzlePieces.add(puzzlePiece)
    }

    override fun solvePuzzle() {
        val visited = mutableSetOf<String>()
        val startTime = System.currentTimeMillis()
        println("Starting puzzle solution...")
        println("Board dimensions: ${width}x${height}")
        println("Number of pieces: ${puzzlePieces.size}")

        // Pre-sort pieces by the number of cells to place larger, more constraining pieces first
        val sortedPieces = puzzlePieces.sortedByDescending { it.cells.size }
        
        val result = solve(sortedPieces, visited)
        
        val endTime = System.currentTimeMillis()
        println("Puzzle solving completed in ${endTime - startTime}ms")
        println("Explored $nodesExplored nodes")
        println("Pruned $prunedStates states")
        println("Visited ${visited.size} unique board states")
        println("Solution found: $result")
        println()
    }

    private fun solve(
        sortedPieces: List<PuzzlePiece>,
        visited: MutableSet<String> = mutableSetOf()
    ): Boolean {
        nodesExplored++
        
        if (usedPieces.size == puzzlePieces.size) {
            println("Solution found!")
            printBoard()
            return true
        }

        if (hasUnfillableRegions()) {
            prunedStates++
            return false
        }

        var bestPiece: PuzzlePiece? = null
        var minPossiblePlacements = Int.MAX_VALUE
        
        for (piece in sortedPieces) {
            if (usedPieces.contains(piece)) continue
            
            val possiblePlacements = countPossiblePlacements(piece)
            if (possiblePlacements == 0) {
                return false
            }
            
            if (possiblePlacements < minPossiblePlacements) {
                minPossiblePlacements = possiblePlacements
                bestPiece = piece
            }
        }
        
        bestPiece ?: return false
        
        val orientations = bestPiece.getUniqueOrientations()
        for (orientation in orientations) {
            bestPiece.applyOrientation(orientation)
            
            val positions = getMostConstrainedPositions()
            
            for ((x, y) in positions) {
                bestPiece.updateOrigin(x, y)
                
                if (putPieceOnBoard(bestPiece)) {
                    usedPieces.add(bestPiece)
                    
                    val boardState = getBoardStateString()
                    if (!visited.contains(boardState)) {
                        visited.add(boardState)
                        
                        if (solve(sortedPieces, visited)) {
                            return true
                        }
                    }
                    removePieceFromBoard(bestPiece)
                    usedPieces.remove(bestPiece)
                }
            }
        }
        
        return false
    }

    private fun countPossiblePlacements(piece: PuzzlePiece): Int {
        var count = 0
        val originalX = piece.originX
        val originalY = piece.originY
        
        val orientations = piece.getUniqueOrientations()
        for (orientation in orientations) {
            piece.applyOrientation(orientation)
            
            for (x in 0 until width) {
                for (y in 0 until height) {
                    piece.updateOrigin(x, y)
                    if (canPlacePiece(piece)) {
                        count++
                    }
                }
            }
        }
        
        // Restore original position
        piece.updateOrigin(originalX, originalY)
        return count
    }

    private fun canPlacePiece(piece: PuzzlePiece): Boolean {
        return !piece.cells.any { cell ->
            cell.xCoord < 0 || cell.xCoord >= width || 
            cell.yCoord < 0 || cell.yCoord >= height || 
            cellMap[Pair(cell.xCoord, cell.yCoord)]?.filled == true
        }
    }

    private fun hasUnfillableRegions(): Boolean {
        val emptyCells = mutableSetOf<Pair<Int, Int>>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                if (!isCellFilled(x, y)) {
                    emptyCells.add(Pair(x, y))
                }
            }
        }
        
        if (emptyCells.isEmpty()) return false
        
        val regions = findConnectedRegions(emptyCells)
        for (region in regions) {
            if (!canRegionFitAnyPiece(region)) {
                return true
            }
        }
        
        return false
    }

    private fun findConnectedRegions(emptyCells: Set<Pair<Int, Int>>): List<Set<Pair<Int, Int>>> {
        val regions = mutableListOf<Set<Pair<Int, Int>>>()
        val remaining = emptyCells.toMutableSet()
        
        while (remaining.isNotEmpty()) {
            val region = findConnectedRegion(remaining.first(), remaining)
            regions.add(region)
            remaining.removeAll(region)
        }
        
        return regions
    }

    private fun findConnectedRegion(seed: Pair<Int, Int>, emptyCells: MutableSet<Pair<Int, Int>>): Set<Pair<Int, Int>> {
        val region = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()
        
        queue.add(seed)
        region.add(seed)
        
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            
            val neighbors = listOf(
                Pair(x-1, y), Pair(x+1, y), 
                Pair(x, y-1), Pair(x, y+1)
            )
            
            for (neighbor in neighbors) {
                if (neighbor in emptyCells && neighbor !in region) {
                    region.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }
        
        return region
    }

    private fun canRegionFitAnyPiece(region: Set<Pair<Int, Int>>): Boolean {
        val remainingPieces = puzzlePieces.filter { !usedPieces.contains(it) }
        
        for (piece in remainingPieces) {
            val orientations = piece.getUniqueOrientations()
            for (orientation in orientations) {
                piece.applyOrientation(orientation)
                
                for ((x, y) in region) {
                    piece.updateOrigin(x, y)
                    
                    val fits = piece.cells.all { cell ->
                        val cellPos = Pair(cell.xCoord, cell.yCoord)
                        cellPos in region
                    }
                    
                    if (fits) {
                        return true
                    }
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

    private fun getBoardStateString(): String {
        val sb = StringBuilder()
        sb.append("$width,$height;")
        
        for (piece in usedPieces) {
            val pieceId = puzzlePieces.indexOf(piece)
            sb.append("$pieceId(")
            
            piece.cells.forEach { cell ->
                sb.append("${cell.xCoord},${cell.yCoord};")
            }
            
            sb.append(")")
        }
        
        return sb.toString()
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
