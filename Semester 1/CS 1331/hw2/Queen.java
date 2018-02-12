/**
 * Queen piece that is a subclass of a Piece and moves in a diagnoal and straight pattern
 *
 * @author Saivardhan Mada
 */
public class Queen extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    */
    public Queen(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "Q";
        } else {
            return "q";
        }
    }

    @Override
    public String algebraicName() {
        return "Q";
    }

    @Override
    public Square[] movesFrom(Square square) {
        int counter = 0;
        char file = square.getFile();
        char rank = square.getRank();
        int fileNum = numLetter(file);
        int rankNum = Character.getNumericValue(rank);
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Boolean sameSquare = (i == rankNum) && (j == fileNum);
                if ((((i == rankNum) || (j == fileNum))
                    || (Math.abs(i - rankNum) == Math.abs(j - fileNum)))
                    && !sameSquare) {
                    counter++;
                }
            }
        }
        Square[] moves = new Square[counter];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Boolean sameSquare = (i == rankNum) && (j == fileNum);
                if ((((i == rankNum) || (j == fileNum))
                    || (Math.abs(i - rankNum) == Math.abs(j - fileNum)))
                    && !sameSquare) {
                    Square sq = new Square(fileToChar(j - 1), intToChar(i));
                    moves[index] = sq;

                    index++;
                }
            }
        }
        return moves;

    }
}
