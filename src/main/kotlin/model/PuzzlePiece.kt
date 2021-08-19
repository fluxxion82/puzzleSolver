package model

abstract class PuzzlePiece(var originX: Int = 0, var originY: Int = 0) {
    abstract var cells: List<Cell>
    abstract val printValue: String

    enum class RotateDegree {
        NINETY,
        ONE_EIGHTY,
        TWO_SEVENTY
    }

    fun updateOrigin(newX: Int, newY: Int) {
        mutableListOf<Cell>().apply {
            cells.forEach { cell ->
                cell.xCoord = cell.xCoord - originX
                cell.yCoord = cell.yCoord - originY
            }
        }
        originX = newX
        originY = newY
        mutableListOf<Cell>().apply {
            cells.forEach { cell ->
                cell.xCoord = cell.xCoord + newX
                cell.yCoord = cell.yCoord + newY
            }
        }
    }

    fun rotate(rotateDegree: RotateDegree = RotateDegree.NINETY): List<Cell> {
        fun rotate90(param: List<Cell>) = mutableListOf<Cell>().apply {
            val yBound = cells.maxByOrNull { it.yCoord }!!.yCoord + 1
            param.forEach { cell ->
                val temp = cell.xCoord
                cell.xCoord = yBound - 1 - cell.yCoord
                cell.yCoord = temp
            }
        }

        val yBound = cells.maxByOrNull { it.yCoord }!!.yCoord + 1
        val temp = originX
        originX = yBound - 1 - originY
        originY = temp

        return when (rotateDegree) {
            RotateDegree.NINETY -> rotate90(cells)
            RotateDegree.ONE_EIGHTY -> rotate90(rotate90(cells))
            RotateDegree.TWO_SEVENTY -> rotate90(rotate90(rotate90(cells)))
        }
    }

    fun flipVertical() = mutableListOf<Cell>().apply {
        val bound = cells.maxByOrNull { it.yCoord }!!.yCoord
        cells.forEach { cell ->
            cell.yCoord = bound - cell.yCoord
        }

        originY = bound - originY
    }

    fun flipHorizontal() = mutableListOf<Cell>().apply {
        val bound = cells.maxByOrNull { it.xCoord }!!.xCoord
        cells.forEach { cell ->
            add(cell.copy(xCoord = bound - cell.xCoord, yCoord = cell.yCoord, filled = true))
        }
        val temp = originX
        originX = bound - originY
        originY = temp
        cells = this
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
}
