/**
 * Pawn piece that is a subclass of a Piece and moves either one or two spaces
 * foward
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Pawn extends Piece {
    /**
    * Constructor that references super class and creates a piece with
    * provided color
    * @param color in color of piece
    */
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return "P";
        } else {
            return "p";
        }
    }

    @Override
    public String algebraicName() {
        return "";
    }

    @Override
    public Square[] movesFrom(Square square) {
        char file = square.getFile();
        char rank = square.getRank();
        int fileNum = numLetter(file);
        Square[] moves;
        int rankNum = Character.getNumericValue(rank);
        if (rankNum == 2) {
            moves = new Square[2];
            Square sq = new Square(file, '3');
            moves[0] = sq;
            Square sq1 = new Square(file, '4');
            moves[1] = sq1;
        } else if (rankNum == 7) {
            moves = new Square[2];
            Square sq1 = new Square(file, '6');
            moves[0] = sq1;
            Square sq = new Square(file, '5');
            moves[1] = sq;
        } else if ((getColor() == Color.WHITE) && !(rankNum == 8)) {
            moves = new Square[1];
            Square sq = new Square(file, intToChar(rankNum + 1));
            moves[0] = sq;
        } else if ((getColor() == Color.BLACK) && !(rankNum == 1)) {
            moves = new Square[1];
            Square sq = new Square(file, intToChar(rankNum - 1));
            moves[0] = sq;
        } else {
            moves = new Square[0];
        }
        return moves;
    }


}
