public abstract class Piece {

    private String name;
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }

    abstract String algebraicName();
    abstract String fenName();
    abstract Square[] movesFrom(Square square);

    public int convFile(char file) {
        if (file == 'a') {
            return 1;
        } else if (file == 'b') {
            return 2;
        } else if (file == 'c') {
            return 3;
        } else if (file == 'd') {
            return 4;
        } else if (file == 'e') {
            return 5;
        } else if (file == 'f') {
            return 6;
        } else if (file == 'g') {
            return 7;
        } else if (file == 'h') {
            return 8;
        } else {
            return 0;
        }
    }
    public char convToFile(int num) {
        if (num == 1) {
            return 'a';
        } else if (num == 2) {
            return 'b';
        } else if (num == 3) {
            return 'c';
        } else if (num == 4) {
            return 'd';
        } else if (num == 5) {
            return 'e';
        } else if (num == 6) {
            return 'f';
        } else if (num == 7) {
            return 'g';
        } else if (num == 8) {
            return 'h';
        } else {
            return 0;
        }
    }

    public char convToRank(int rank) {
        if (rank == 1) {
            return '1';
        } else if (rank == 2) {
            return '2';
        } else if (rank == 3) {
            return '3';
        } else if (rank == 4) {
            return '4';
        } else if (rank == 5) {
            return '5';
        } else if (rank == 6) {
            return '6';
        } else if (rank == 7) {
            return '7';
        } else if (rank == 8) {
            return '8';
        } else {
            return '0';
        }
    }
}