import model.Cell
import model.PuzzlePiece
import puzzles.*

/**
# # # # #
# # # # #
# # 1 _ _
# # 1 _ _
# # 1 1 _
 */
class TestPieceOne(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX, originY, true), // 0, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX, originY + 2, true), // 0, 2
        Cell(originX + 1, originY + 2, true) // 1, 2
    )
    override val printValue = "1 "

    override fun copy(): PuzzlePiece {
        val newPiece = TestPieceOne(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

/**
# # # # #
# # # # #
# # _ 2 _
# # 2 2 _
# # _ 2 _
 */
class TestPieceTwo(xOrigin: Int, yOrigin: Int) : PuzzlePiece(xOrigin, yOrigin) {
    override var cells = listOf(
        Cell(originX + 1, originY, true), // 1, 0
        Cell(originX, originY + 1, true), // 0, 1
        Cell(originX + 1, originY + 1, true), // 1, 1
        Cell(originX + 1, originY + 2, true) // 1, 2
    )
    override val printValue = "2 "

    override fun copy(): PuzzlePiece {
        val newPiece = TestPieceTwo(0, 0)
        copyTo(newPiece)
        return newPiece
    }
}

fun main(args: Array<String>) {
    //testBoard()
    wikiPuzzle()
    pentominoes()

    // squareFitPuzzle()
    trivialPuzzle()
    almostThere()
}

fun testBoard() {
    println("test board")
    val testBoard = PuzzleBoard(3, 3)
    val pieceOne = TestPieceOne(0,0)
    val pieceTwo = TestPieceTwo(0,0)

//    pieceOne.print()
//    pieceTwo.print()

    testBoard.addPlayablePuzzlePiece(pieceOne)
    testBoard.addPlayablePuzzlePiece(pieceTwo)
    testBoard.solvePuzzle()
}

fun wikiPuzzle() {
    println("wiki")
    val wikiBoard = PuzzleBoard(6, 5)
    val pieceOne = WikiPieceOne(0,0)
    val pieceTwo = WikiPieceTwo(0,0)
    val pieceThree = WikiPieceThree(0,0)
    val pieceFour = WikiPieceFour(0,0)
    val pieceFive = WikiPieceFive(0,0)
    val pieceSix= WikiPieceSix(0,0)
    val pieceSeven = WikiPieceSeven(0,0)

//    pieceOne.print()
//    pieceTwo.print()
//    pieceThree.print()
//    pieceFour.print()
//    pieceFive.print()
//    pieceSix.print()
//    pieceSeven.print()

    wikiBoard.addPlayablePuzzlePiece(pieceOne)
    wikiBoard.addPlayablePuzzlePiece(pieceTwo)
    wikiBoard.addPlayablePuzzlePiece(pieceThree)
    wikiBoard.addPlayablePuzzlePiece(pieceFour)
    wikiBoard.addPlayablePuzzlePiece(pieceFive)
    wikiBoard.addPlayablePuzzlePiece(pieceSix)
    wikiBoard.addPlayablePuzzlePiece(pieceSeven)
    wikiBoard.solvePuzzle()
}

fun pentominoes() {
    val pieceOne = PentominoePieceOne(0,0)
    val pieceTwo = PentominoePieceTwo(0,0)
    val pieceThree = PentominoePieceThree(0,0)
    val pieceFour = PentominoePieceFour(0,0)
    val pieceFive = PentominoePieceFive(0,0)
    val pieceSix = PentominoePieceSix(0,0)
    val pieceSeven = PentominoePieceSeven(0,0)
    val pieceEight = PentominoePieceEight(0,0)
    val pieceNine = PentominoePieceNine(0,0)
    val pieceTen = PentominoePieceTen(0,0)
    val pieceEleven = PentominoePieceEleven(0,0)
    val pieceTwelve = PentominoePieceTwelve(0,0)

//    pieceOne.print()
//    pieceTwo.print()
//    pieceThree.print()
//    pieceFour.print()
//    pieceFive.print()
//    pieceSix.print()
//    pieceSeven.print()
//    pieceEight.print()
//    pieceNine.print()
//    pieceTen.print()
//    pieceEleven.print()
//    pieceTwelve.print()

    println("pentominoes board 1:")
    val pentBoard = PuzzleBoard(10, 6)
    pentBoard.addPlayablePuzzlePiece(pieceOne)
    pentBoard.addPlayablePuzzlePiece(pieceTwo)
    pentBoard.addPlayablePuzzlePiece(pieceThree)
    pentBoard.addPlayablePuzzlePiece(pieceFour)
    pentBoard.addPlayablePuzzlePiece(pieceFive)
    pentBoard.addPlayablePuzzlePiece(pieceSix)
    pentBoard.addPlayablePuzzlePiece(pieceSeven)
    pentBoard.addPlayablePuzzlePiece(pieceEight)
    pentBoard.addPlayablePuzzlePiece(pieceNine)
    pentBoard.addPlayablePuzzlePiece(pieceTen)
    pentBoard.addPlayablePuzzlePiece(pieceEleven)
    pentBoard.addPlayablePuzzlePiece(pieceTwelve)
    pentBoard.solvePuzzle()

    println("pentominoes board 2:")
    val pentBoard2 = PuzzleBoard(8, 8)
    pentBoard2.addPlayablePuzzlePiece(pieceOne)
    pentBoard2.addPlayablePuzzlePiece(pieceTwo)
    pentBoard2.addPlayablePuzzlePiece(pieceThree)
    pentBoard2.addPlayablePuzzlePiece(pieceFour)
    pentBoard2.addPlayablePuzzlePiece(pieceFive)
    pentBoard2.addPlayablePuzzlePiece(pieceSix)
    pentBoard2.addPlayablePuzzlePiece(pieceSeven)
    pentBoard2.addPlayablePuzzlePiece(pieceEight)
    pentBoard2.addPlayablePuzzlePiece(pieceNine)
    pentBoard2.addPlayablePuzzlePiece(pieceTen)
    pentBoard2.addPlayablePuzzlePiece(pieceEleven)
    pentBoard2.addPlayablePuzzlePiece(pieceTwelve)
    pentBoard2.solvePuzzle()
}

// Goh Pit Khiam puzzles \\
fun squareFitPuzzle() {
    println("square fit")
    val squareFitBoard = PuzzleBoard(7, 7)
    val pieceOne = SquareFitPieceOne(0,0)
    val pieceTwo = SquareFitPieceTwo(0,0)
    val pieceThree = SquareFitPieceThree(0,0)
    val pieceFour = SquareFitPieceFour(0,0)
    val pieceFive = SquareFitPieceFive(0,0)
    val pieceSix= SquareFitPieceSix(0,0)
    val pieceSeven = SquareFitPieceSeven(0,0)

//    pieceOne.print()
//    pieceTwo.print()
//    pieceThree.print()
//    pieceFour.print()
//    pieceFive.print()
//    pieceSix.print()
//    pieceSeven.print()

    squareFitBoard.addPlayablePuzzlePiece(pieceOne)
    squareFitBoard.addPlayablePuzzlePiece(pieceTwo)
    squareFitBoard.addPlayablePuzzlePiece(pieceThree)
    squareFitBoard.addPlayablePuzzlePiece(pieceFour)
    squareFitBoard.addPlayablePuzzlePiece(pieceFive)
    squareFitBoard.addPlayablePuzzlePiece(pieceSeven)
    squareFitBoard.addPlayablePuzzlePiece(pieceSix)
    squareFitBoard.solvePuzzle()
}

fun almostThere() {
    println("almost there")
    val almostThereBoard = PuzzleBoard(7, 7)
    val pieceOne = PieceOne(0,0)
    val pieceTwo = PieceTwo(0,0)
    val pieceThree = PieceThree(0,0)
    val pieceFour = PieceFour(0,0)
    val pieceFive = PieceFive(0,0)

//    pieceOne.print()
//    pieceTwo.print()
//    pieceThree.print()
//    pieceFour.print()
//    pieceFive.print()

    almostThereBoard.addPlayablePuzzlePiece(pieceOne)
    almostThereBoard.addPlayablePuzzlePiece(pieceTwo)
    almostThereBoard.addPlayablePuzzlePiece(pieceThree)
    almostThereBoard.addPlayablePuzzlePiece(pieceFour)
    almostThereBoard.addPlayablePuzzlePiece(pieceFive)
    almostThereBoard.solvePuzzle()
}

fun trivialPuzzle() {
    println("trivial puzzle")
    val trivialBoard = PuzzleBoard(6, 6)
    val pieceOne = TrivalPieceOne(0,0)
    val pieceTwo = TrivalPieceTwo(0,0)
    val pieceThree = TrivalPieceThree(0, 0)

//    pieceOne.print()
//    pieceTwo.print()
//    pieceThree.print()

    trivialBoard.addPlayablePuzzlePiece(pieceOne)
    trivialBoard.addPlayablePuzzlePiece(pieceTwo)
    trivialBoard.addPlayablePuzzlePiece(pieceThree)
    trivialBoard.solvePuzzle()
}
