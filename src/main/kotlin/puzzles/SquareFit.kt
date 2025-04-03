package puzzles

import model.Cell
import model.PuzzlePiece

/**
 * Goh Pit Khiam puzzle found here: https://khuong.uk/puzzle_wood_8.html#r
 */

/**
# # # # # # #
# # # # # # #
# # 1 1 _ _ _
# # _ 1 1 _ _
# # _ _ 1 1 _
# # _ _ _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 2, originY + 2, true), // 2, 2
        Cell(originX + 3, originY + 2, true) // 3, 2
    )
    override val printValue = "1 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceOne(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # 2 _ _ _ _
# # 2 2 _ _ _
# # _ 2 2 _ _
# # _ 2 _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceTwo(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 2, originY + 2, true), // 2, 2
        Cell(originX + 1, originY + 3, true) // 1, 3
    )
    override val printValue = "2 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceTwo(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # _ _ _ 3 _
# # 3 3 3 3 _
# # _ 3 _ _ _
# # _ _ _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceThree(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 3, originY, true), // 3, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 3, originY + 1, true), // 3, 1
        Cell(originX + 1, originY + 2, true) // 1, 2
    )
    override val printValue = "3 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceThree(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # 4 _ _ _ _
# # 4 4 4 4 _
# # _ 4 _ _ _
# # _ _ _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceFour(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 3, originY + 1, true), // 3, 1
        Cell(originX + 1, originY + 2, true) // 1, 2
    )
    override val printValue = "4 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceFour(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # _ 5 _ _ _
# # 5 5 5 5 _
# # _ 5 _ _ _
# # _ _ _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceFive(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 3, originY + 1, true), // 3, 1
        Cell(originX + 1, originY + 2, true) // 1, 2
    )
    override val printValue = "5 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceFive(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # 6 _ _ _ _
# # 6 _ _ _ _
# # 6 6 6 _ _
# # _ 6 _ _ _
# # _ _ _ _ _
 */
class SquareFitPieceSix(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 1, originY + 3, true), // 1, 3
        Cell(originX + 2, originY + 2, true) // 2, 2
    )
    override val printValue = "6 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceSix(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # _ 7 _ _
# # 7 7 _ _
# # _ 7 7 _
# # _ _ _ _
 */
class SquareFitPieceSeven(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 2, originY + 2, true) // 2, 2
    )
    override val printValue = "7 "
    
    override fun copy(): PuzzlePiece {
        val newPiece = SquareFitPieceSeven(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}
