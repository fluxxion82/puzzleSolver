package puzzles

import model.Cell
import model.PuzzlePiece

/**
 * Goh Pit Khiam puzzle found here: https://khuong.uk/puzzle_wood_8.html#r
 */

/**
# # # # # # # #
# # # # # # # #
# # 1 _ _ _ _ _
# # 1 1 1 _ _ _
# # _ 1 _ _ _ _
# # _ 1 _ _ _ _
# # _ 1 _ _ _ _
# # _ _ _ _ _ _
 */
open class TrivalPieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 1, originY + 3, true), // 1, 3
        Cell(originX + 1, originY + 4, true) // 1, 4
    )
    override val printValue = "1 "
}

/**
# # # # # # # #
# # # # # # # #
# # 2 _ _ _ _ _
# # 2 2 2 _ _ _
# # _ 2 _ _ _ _
# # _ 2 _ _ _ _
# # _ 2 _ _ _ _
# # _ _ _ _ _ _
 */
class TrivalPieceTwo(xOrigin: Int, yOrigin: Int) : TrivalPieceOne(xOrigin, yOrigin) {
    override val printValue = "2 "
}

/**
# # # # # # # #
# # # # # # # #
# # 3 _ _ _ _ _
# # 3 3 3 _ _ _
# # _ 3 _ _ _ _
# # _ 3 _ _ _ _
# # _ 3 _ _ _ _
# # _ _ _ _ _ _
 */
class TrivalPieceThree(xOrigin: Int, yOrigin: Int) : TrivalPieceOne(xOrigin, yOrigin) {
    override val printValue = "3 "
}
