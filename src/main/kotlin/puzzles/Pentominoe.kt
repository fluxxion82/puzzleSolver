package puzzles

import model.Cell
import model.PuzzlePiece

/**
 * Standard Pentominoe puzzle pieces
 */

/**
# # # # # #
# # # # # #
# # _ 1 _ _
# # 1 1 _ _
# # _ 1 1 _
# # _ _ _ _
 */
class PentominoePieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 2, originY + 2, true) // 2, 2
    )

    override val printValue = "1 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceOne(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # # #
# # # # # # # #
# # 2 2 2 2 2 _
# # _ _ _ _ _ _
# # _ _ _ _ _ _
# # _ _ _ _ _ _
# # _ _ _ _ _ _
# # _ _ _ _ _ _
 */
class PentominoePieceTwo(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX + 2, originY, true), // 2, 0
        Cell(originX + 3, originY, true), // 3, 0
        Cell(originX + 4, originY, true) // 4, 0
    )

    override val printValue = "2 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceTwo(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # 3 _ _ _ _
# # 3 _ _ _ _
# # 3 _ _ _ _
# # 3 3 _ _ _
# # _ _ _ _ _
 */
class PentominoePieceThree(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX, originY + 3, true), // 0, 3
        Cell(originX + 1, originY + 3, true) // 1, 3
    )

    override val printValue = "3 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceThree(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # _ 4 _ _ _
# # 4 4 _ _ _
# # 4 _ _ _ _
# # 4 _ _ _ _
# # _ _ _ _ _
 */
class PentominoePieceFour(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX, originY + 3, true) // 0,3
    )

    override val printValue = "4 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceFour(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # 5 5 _ _
# # 5 5 _ _
# # 5 _ _ _
# # _ _ _ _
 */
class PentominoePieceFive(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX, originY + 2, true) // 0, 2
    )

    override val printValue = "5 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceFive(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # 6 _ _ _
# # 6 6 6 _
# # 6 _ _ _
# # _ _ _ _
 */
class PentominoePieceSix(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX, originY + 2, true) // 0, 2
    )

    override val printValue = "6 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceSix(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # 7 _ 7 _
# # 7 7 7 _
# # _ _ _ _
# # _ _ _ _
 */
class PentominoePieceSeven(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 2, originY, true), // 2, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true) // 2, 1
    )

    override val printValue = "7 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceSeven(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # 8 _ _ _
# # 8 _ _ _
# # 8 8 8 _
# # _ _ _ _
 */
class PentominoePieceEight(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX + 1, originY + 2, true), // 0, 1
        Cell(originX + 2, originY + 2, true) // 2, 2
    )

    override val printValue = "8 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceEight(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # 9 _ _ _
# # 9 9 _ _
# # _ 9 9 _
# # _ _ _ _
 */
class PentominoePieceNine(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 2, originY + 2, true) // 2, 2
    )

    override val printValue = "9 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceNine(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # _ 0 _ _
# # 0 0 0 _
# # _ 0 _ _
# # _ _ _ _
 */
class PentominoePieceTen(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 2, originY + 1, true), // 2, 1
        Cell(originX + 1, originY + 2, true) // 1, 2
    )

    override val printValue = "0 "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceTen(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # # #
# # # # # # #
# # _ ! _ _ _
# # ! ! _ _ _
# # _ ! _ _ _
# # _ ! _ _ _
# # _ _ _ _ _
 */
class PentominoePieceEleven(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 1, 2
        Cell(originX + 1, originY + 3, true) // 1, 3
    )

    override val printValue = "! "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceEleven(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # # #
# # # # # #
# # + + _ _
# # _ + _ _
# # _ + + _
# # _ _ _ _
 */
class PentominoePieceTwelve(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true), // 2, 1
        Cell(originX + 2, originY + 2, true) // 3, 2
    )

    override val printValue = "+ "

    override fun copy(): PuzzlePiece {
        val newPiece = PentominoePieceTwelve(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}
