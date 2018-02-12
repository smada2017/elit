public class Bishop extends Piece {

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
        char file = square.file;
        char rank = square.rank;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

    }
}
