/**
 * King piece that is a subclass of a Piece and moves in any direction that
 * are one space
 * @author Saivardhan Mada
 */
public class King extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    */
    public King(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }

    @Override
    public String algebraicName() {
        return "K";
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
                int distance = (i - rankNum)
                    * (i - rankNum)
                    + (j - fileNum) * (j - fileNum);
                if (distance == 1 || ((Math.abs(i - rankNum)
                    == Math.abs(j - fileNum))
                    && distance == 2)) {
                    counter++;
                }
            }
        }
        Square[] moves = new Square[counter];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int distance = (i - rankNum)
                    * (i - rankNum)
                    + (j - fileNum) * (j - fileNum);
                if (distance == 1
                    || ((Math.abs(i - rankNum)
                    == Math.abs(j - fileNum))
                    && distance == 2)) {
                    Square sq = new Square(fileToChar(j - 1), intToChar(i));
                    moves[index] = sq;

                    index++;
                }
            }
        }
        return moves;

    }

}
