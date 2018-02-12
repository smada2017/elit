/**
 * Knight piece that is a subclass of a Piece and moves in a L pattern
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Knight extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    * @param color in color of piece
    */
    public Knight(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "N";
        } else {
            return "n";
        }
    }

    @Override
    public String algebraicName() {
        return "N";
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
                int distance = (i - rankNum) * (i - rankNum)
                    + (j - fileNum) * (j - fileNum);
                if (distance == 5) {
                    counter++;
                }
            }
        }
        Square[] moves = new Square[counter];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int distance = (i - rankNum)
                    * (i - rankNum) + (j - fileNum) * (j - fileNum);
                if (distance == 5) {
                    Square sq = new Square(fileToChar(j - 1), intToChar(i));
                    moves[index] = sq;

                    index++;
                }
            }
        }
        return moves;

    }

}
