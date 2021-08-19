package puzzles

import model.Cell
import model.PuzzlePiece

/**
 * Goh Pit Khiam puzzle found here: https://khuong.uk/puzzle_wood_8.html#r
 */

/**
# # # # # # #
# # # # # # #
# # 1 1 1 _ _
# # 1 1 1 _ _
# # _ 1 _ _ _
# # _ 1 _ _ _
# # _ _ _ _ _
 */
open class PieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX + 2, originY, true), // 2, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 1, originY + 3, true) // 1, 3
    )
    override val printValue = "1 "
}

/**
# # # # # # #
# # # # # # #
# # 2 2 2 _ _
# # 2 2 2 _ _
# # _ 2 _ _ _
# # _ 2 _ _ _
# # _ _ _ _ _
 */
class PieceTwo(xOrigin: Int, yOrigin: Int) : PieceOne(xOrigin, yOrigin) {
    override val printValue = "2 "
}

/**
# # # # # # #
# # # # # # #
# # 3 3 3 _ _
# # 3 3 3 _ _
# # _ 3 _ _ _
# # _ 3 _ _ _
# # _ _ _ _ _
 */
class PieceThree(xOrigin: Int, yOrigin: Int) : PieceOne(xOrigin, yOrigin) {
    override val printValue = "3 "
}

/**
# # # # # # #
# # # # # # #
# # _ _ 4 _ _
# # 4 4 4 _ _
# # _ _ 4 4 _
# # _ _ 4 4 _
# # _ _ _ _ _
 */
class PieceFour(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 2, originY, true), // 2, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 2, originY + 2, true), // 2, 2
        Cell(originX + 3, originY + 2, true), // 3, 2
        Cell(originX + 2, originY + 3, true), // 2, 3
        Cell(originX + 3, originY + 3, true) // 3, 3
    )
    override val printValue = "4 "
}

/**
# # # # # # #
# # # # # # #
# # 5 5 _ _ _
# # 5 5 5 5 _
# # _ _ 5 _ _
# # _ _ 5 _ _
# # _ _ _ _ _
 */
class PieceFive(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 3, originY + 1, true), // 3, 1
        Cell(originX + 2, originY + 2, true), // 2, 2
        Cell(originX + 2, originY + 3, true) // 2, 3
    )
    override val printValue = "5 "
}
