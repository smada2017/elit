public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "";
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
    public Square[] movesFrom(Square square) {
        char file = square.file;
        char rank = square.rank;
        int ri = Character.getNumericValue(rank);
        if (fenName().equals("P")
            && ri == 2) {
            Square[] moves = new Square[2];
            moves[0] = new Square(file, convToRank(ri + 1));
            moves[1] = new Square(file, convToRank(ri + 2));
            return moves;
        } else if (fenName().equals("P")
            && ri != 2) {
            Square[] moves;
            if (ri < 8) {
                moves = new Square[1];
                moves[0] = new Square(file, convToRank(ri + 1));
            } else {
                moves = new Square[0];
            }
            return moves;
        } else if (fenName().equals("p")
                && ri == 7) {
            Square[] moves = new Square[2];
            moves[0] = new Square(file, convToRank(ri - 1));
            moves[1] = new Square(file, convToRank(ri - 2));
            return moves;
        } else {
            Square[] moves;
            if (ri > 1) {
                moves = new Square[1];
                moves[0] = new Square(file, convToRank(ri - 1));
            } else {
                moves = new Square[0];
            }
            return moves;
        }
    }
}