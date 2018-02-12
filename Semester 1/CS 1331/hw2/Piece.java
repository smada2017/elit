/**
 * Piece class basically has the basic aspects of all pieces
 *
 * @author Saivardhan Mada
 */
public abstract class Piece {

    private String name;
    private Color color;
    /**
    * returns the algebraic name of the piece
    *
    */
    abstract String algebraicName();
    /**
    * returns the fen notation name of the piece
    *
    */
    abstract String fenName();
    /**
    * returns all the possible moves from a given square
    *
    */
    abstract Square[] movesFrom(Square square);
    /**
    * Constructor creates a piece with provided color
    *
    */
    public Piece(Color color) {
        this.color = color;
    }
    /**
    * returns the color of the piece
    *
    */
    public Color getColor() {
        return color;
    }
    /**
    * method that converts char to int position on the board
    *
    */
    public static int numLetter(char letter) {
        return (int) letter - (int) 'a' + 1;
    }
    /**
    * method that converts int to char
    *
    */
    public char intToChar(int rank) {
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
    /**
    * method that converts file int to char
    *
    */
    public char fileToChar(int num) {
        num++;
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

}
