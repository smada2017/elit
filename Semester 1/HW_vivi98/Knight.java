public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "N";
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
    public Square[] movesFrom(Square square) {
        char file = square.file;
        char rank = square.rank;
        //System.out.println("Reached method");
        int count = 0;
        for (int row = 1; row <= 8; row++) {
            //System.out.println("reached loop 1");
            for (int col = 1; col <= 8; col++) {
                //System.out.println("reached loop 2");
                if ((Character.getNumericValue(rank) - col)
                    * (Character.getNumericValue(rank) - col)
                    + (convFile(file) - row)
                    * (convFile(file) - row) == 5) {
                    count++;
                    //System.out.print("I am hereeee");
                }
            }
        }
        int index = 0;
        //System.out.print(count + "possible moves");
        Square[] moves = new Square[count];
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                if ((Character.getNumericValue(rank) - c)
                    * (Character.getNumericValue(rank) - c)
                    + (convFile(file) - r)
                    * (convFile(file) - r) == 5) {
                    moves[index] = new Square(convToFile(r), convToRank(c));
                    index++;
                }
            }
        }
        return moves;
    }
}