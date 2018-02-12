public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "K";
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
    public Square[] movesFrom(Square square) {
        char file = square.file;
        char rank = square.rank;
        int fi = convFile(file);
        int ri = Character.getNumericValue(rank);
        int count = 0;
        if ((fi + 1) <= 8) {
            count++;
        }
        if ((fi - 1) >= 1) {
            count++;
        }
        if ((ri + 1) <= 8) {
            count++;
        }
        if ((ri - 1) >= 1) {
            count++;
        }
        if ((fi + 1) <= 8 && (ri + 1) <= 8) {
            count++;
        }
        if ((fi - 1) >= 1 && (ri - 1) >= 1) {
            count++;
        }
        if ((fi - 1) >= 1 && (ri + 1) <= 8) {
            count++;
        }
        if ((fi + 1) <= 8 && (ri - 1) >= 1) {
            count++;
        }
        Square[] moves = new Square[count];
        int index = 0;
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        if ((fi + 1) <= 8) {
            moves[index] = new Square(convToFile(fi + 1), rank);
            index++;
        }
        if ((fi - 1) >= 1) {
            moves[index] = new Square(convToFile(fi - 1), rank);
            index++;
        }
        //ri = Character.getNumericValue(rank);
        if ((ri + 1) <= 8) {
            //ri = ri + 1;
            moves[index] = new Square(file, convToRank(ri + 1));
            index++;
        }
       // ri = Character.getNumericValue(rank);
        if ((ri - 1) >= 1) {
            //ri = ri - 1;
            moves[index] = new Square(file, convToRank(ri - 1));
            index++;
        }
        //ri = Character.getNumericValue(rank);
        if ((fi + 1) <= 8 && (ri + 1) <= 8) {
            //ri = ri + 1;
            moves[index] = new Square(convToFile(fi + 1), convToRank(ri + 1));
            index++;
        }
        //ri = Character.getNumericValue(rank);
        if ((fi - 1) >= 1 && (ri - 1) >= 1) {
            moves[index] = new Square(convToFile(fi - 1), convToRank(ri - 1));
            index++;
        }
        ri = Character.getNumericValue(rank);
        if ((fi - 1) >= 1 && (ri + 1) <= 8) {
            moves[index] = new Square(convToFile(fi - 1), convToRank(ri + 1));
            index++;
        }
        ri = Character.getNumericValue(rank);
        if ((fi + 1) <= 8 && (ri - 1) >= 1) {
            moves[index] = new Square(convToFile(fi + 1), convToRank(ri - 1));
            index++;
        }
        return moves;
    }
}