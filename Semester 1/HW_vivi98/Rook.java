public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "R";
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
    public Square[] movesFrom(Square square) {
        char file = square.file;
        char rank = square.rank;
        Square[] moves = new Square[14];
        int fi = convFile(file);
        int ri = Character.getNumericValue(rank);
        int index = 0;
        while (fi < 8) {
            fi++;
            moves[index] = new Square(convToFile(fi), rank);
            index++;
        }
        fi = convFile(file);
        while (fi > 1) {
            fi--;
            moves[index] = new Square(convToFile(fi), rank);
            index++;
        }
        while (ri < 8) {
            ri++;
            moves[index] = new Square(file, convToRank(ri));
            index++;
        }
        ri = Character.getNumericValue(rank);
        while (ri > 1) {
            ri--;
            moves[index] = new Square(file, convToRank(ri));
            index++;
        }
        return moves;
    }
}