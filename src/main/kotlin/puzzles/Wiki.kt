package puzzles

import model.Cell
import model.PuzzlePiece

/**
 * Small Pentominoe puzzle I found on the pentominoe wiki page
 */

/**
# # # # #
# # # # #
# # 1 1 _
# # _ _ _
# # _ _ _
 */
class WikiPieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true) // 1, 0
    )
    override val printValue = "1 "
}

/**
# # # # # #
# # # # # #
# # _ 2 _ _
# # 2 2 _ _
# # _ 2 2 _
# # _ _ _ _
 */
class WikiPieceTwo(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 2, originY + 2, true) // 2, 2
    )
    override val printValue = "2 "
}

/**
# # # # # #
# # # # # #
# # 3 _ _ _
# # 3 _ _ _
# # 3 3 3 _
# # _ _ _ _
 */
class WikiPieceThree(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX + 1, originY + 2, true), // 0, 1
        Cell(originX + 2, originY + 2, true) // 2, 2
    )
    override val printValue = "3 "
}

/**
# # # # # # #
# # # # # # #
# # 4 _ _ _ _
# # 4 _ _ _ _
# # 4 _ _ _ _
# # 4 4 _ _ _
# # _ _ _ _ _
 */
class WikiPieceFour(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX, originY + 3, true), // 0, 3
        Cell(originX + 1, originY + 3, true) // 1, 3
    )
    override val printValue = "4 "
}

/**
# # # # # #
# # # # # #
# # 5 5 _ _
# # _ 5 _ _
# # _ 5 5 _
# # _ _ _ _
 */
class WikiPieceFive(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 2, 1
        Cell(originX + 2, originY + 2, true) // 3, 2
    )
    override val printValue = "5 "
}

/**
# # # # # #
# # # # # #
# # 6 _ _ _
# # 6 6 6 _
# # 6 _ _ _
# # _ _ _ _
 */
class WikiPieceSix(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX, originY + 2, true) // 0, 2
    )
    override val printValue = "6 "
}

/**
# # # # # #
# # # # # #
# # 7 _ _ _
# # 7 _ _ _
# # 7 _ _ _
# # _ _ _ _
 */
class WikiPieceSeven(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true) // 1, 1
    )
    override val printValue = "7 "
}
