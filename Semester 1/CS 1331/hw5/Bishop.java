/**
 * Bishop piece that is a subclass of a Piece and moves in a diagnoal pattern
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Bishop extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    * @param color takes in the color of the piece
    */
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "B";
        } else {
            return "b";
        }
    }

    @Override
    public String algebraicName() {
        return "B";
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
                if ((Math.abs(i - rankNum) == Math.abs(j - fileNum))
                    && !(i == rankNum) && !(j == fileNum)) {
                    counter++;
                }
            }
        }
        Square[] moves = new Square[counter];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if ((Math.abs(i - rankNum) == Math.abs(j - fileNum))
                    && !(i == rankNum)
                    && !(j == fileNum)) {
                    Square sq = new Square(fileToChar(j - 1), intToChar(i));
                    moves[index] = sq;

                    index++;
                }
            }
        }
        return moves;

    }

}
