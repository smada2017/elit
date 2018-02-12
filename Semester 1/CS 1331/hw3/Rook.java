/**
 * Rook piece that is a subclass of a Piece and moves in the same file or rank
 *
 * @author Saivardhan Mada
 */
public class Rook extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    */
    public Rook(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "R";
        } else {
            return "r";
        }
    }

    @Override
    public String algebraicName() {
        return "R";
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
                if (((i == rankNum) || (j == fileNum)) && !sameSquare) {
                    counter++;
                }
            }
        }
        Square[] moves = new Square[counter];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Boolean sameSquare = (i == rankNum) && (j == fileNum);
                if (((i == rankNum) || (j == fileNum)) && !sameSquare) {
                    Square sq = new Square(fileToChar(j - 1), intToChar(i));
                    moves[index] = sq;

                    index++;
                }
            }
        }
        return moves;

    }

}
