package model

import java.util.concurrent.ConcurrentHashMap

abstract class PuzzlePiece(var originX: Int = 0, var originY: Int = 0) {
    abstract var cells: List<Cell>
    abstract val printValue: String

    private var originalCells: List<Cell> = listOf()

    fun initOriginalCells() {
        if (originalCells.isEmpty()) {
            originalCells = cells.map { it.copy() }
        }
    }

    fun getUniqueOrientations(): List<Orientation> {
        val cacheKey = this.javaClass.name
        
        return orientationCache.computeIfAbsent(cacheKey) { _ ->
            if (originalCells.isEmpty()) {
                initOriginalCells()
            }

            val uniqueOrientations = mutableSetOf<Int>()
            val result = mutableListOf<Orientation>()

            // Check all 8 possible orientations (4 rotations × 2 flips)
            for (flip in 0..1) {
                for (rotation in 0..3) {
                    val tempPiece = this.copy() // Create a temporary copy to manipulate
                    if (flip == 1) tempPiece.flipVertical()
                    repeat(rotation) { tempPiece.rotate() }

                    val normalized = tempPiece.cells
                        .map { Pair(it.xCoord - tempPiece.originX, it.yCoord - tempPiece.originY) }
                        .sortedWith(compareBy({ it.first }, { it.second }))
                    val orientationHash = normalized.hashCode()

                    if (uniqueOrientations.add(orientationHash)) {
                        result.add(Orientation(rotation, flip == 1))
                    }
                }
            }

            result
        }
    }

    fun applyOrientation(orientation: Orientation) {
        resetOrientation()

        if (orientation.flipped) {
            flipVertical()
        }

        repeat(orientation.rotations) {
            rotate()
        }
    }

    private fun resetOrientation() {
        if (originalCells.isEmpty()) {
            initOriginalCells()
            return
        }
        cells = originalCells.map { it.copy() }
        originX = 0
        originY = 0
    }

    fun updateOrigin(newX: Int, newY: Int) {
        val dx = newX - originX
        val dy = newY - originY

        cells.forEach { cell ->
            cell.xCoord += dx
            cell.yCoord += dy
        }

        originX = newX
        originY = newY
    }

    fun rotate(rotateDegree: RotateDegree = RotateDegree.NINETY) {
        val rotations = when (rotateDegree) {
            RotateDegree.NINETY -> 1
            RotateDegree.ONE_EIGHTY -> 2
            RotateDegree.TWO_SEVENTY -> 3
        }
        
        if (rotations == 1) {
            rotateSingle()
        } else {
            repeat(rotations) {
                rotateSingle()
            }
        }
    }
    
    private fun rotateSingle() {
        val yBound = cells.maxOf { it.yCoord } + 1
        cells.forEach { cell ->
            val temp = cell.xCoord
            cell.xCoord = yBound - 1 - cell.yCoord
            cell.yCoord = temp
        }
        val tempOrigin = originX
        originX = yBound - 1 - originY
        originY = tempOrigin
    }

    fun flipVertical() {
        val bound = cells.maxOf { it.yCoord }
        cells.forEach { cell ->
            cell.yCoord = bound - cell.yCoord
        }
        originY = bound - originY
    }

    abstract fun copy(): PuzzlePiece
    
    protected fun copyTo(target: PuzzlePiece) {
        target.originX = this.originX
        target.originY = this.originY
        target.cells = this.cells.map { it.copy() }
        if (this.originalCells.isNotEmpty()) {
            target.originalCells = this.originalCells.map { it.copy() }
        }
    }

    fun print() {
        val pieces = cells.sortedBy { it.xCoord }.sortedBy { it.yCoord }
        val xBound = cells.sortedBy { it.xCoord }.last().xCoord
        val yBound = cells.sortedBy { it.yCoord }.last().yCoord
        val max = maxOf(xBound, yBound) + 1
        val cellIterator = pieces.listIterator()
        var nextCell: Cell = cellIterator.next()
        // negative lower bound gives better visuals, especially if piece
        // position goes out of board bounds
        for (i in -2..max) {
            for (j in -2..max) {
                if (nextCell.xCoord == j && nextCell.yCoord == i) {
                    print(printValue)
                    if (cellIterator.hasNext()) {
                        nextCell = cellIterator.next()
                    }
                } else {
                    if (j < 0) {
                        print("# ")
                    } else if (i < 0) {
                        print("# ")
                    } else {
                        print("_ ")
                    }
                }
            }

            println("")
        }

        println("")
    }

    enum class RotateDegree {
        NINETY,
        ONE_EIGHTY,
        TWO_SEVENTY
    }

    data class Orientation(val rotations: Int, val flipped: Boolean)

    companion object {
        private val orientationCache = ConcurrentHashMap<String, List<Orientation>>()
    }
}
