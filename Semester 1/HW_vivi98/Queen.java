public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "Q";
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
    public Square[] movesFrom(Square square) {
        char file = square.file;
        char rank = square.rank;
        int fi = convFile(file);
        int ri = Character.getNumericValue(rank);
        int count = 0;
        while ((fi < 8) && (ri < 8)) {
            fi++;
            ri++;
            count++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi > 1) && (ri > 1)) {
            fi--;
            ri--;
            count++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi < 8) && (ri > 1)) {
            fi++;
            ri--;
            count++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi > 1) && (ri < 8)) {
            fi--;
            ri++;
            count++;
        }
        Square[] moves = new Square[count + 14];
        int index = 0;
        fi = convFile(file);
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
        ri = Character.getNumericValue(rank);
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
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi < 8) && (ri < 8)) {
            fi++;
            ri++;
            moves[index] = new Square(convToFile(fi), convToRank(ri));
            index++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi > 1) && (ri > 1)) {
            fi--;
            ri--;
            moves[index] = new Square(convToFile(fi), convToRank(ri));
            index++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi < 8) && (ri > 1)) {
            fi++;
            ri--;
            moves[index] = new Square(convToFile(fi), convToRank(ri));
            index++;
        }
        fi = convFile(file);
        ri = Character.getNumericValue(rank);
        while ((fi > 1) && (ri < 8)) {
            fi--;
            ri++;
            moves[index] = new Square(convToFile(fi), convToRank(ri));
            index++;
        }
        return moves;
    }
}