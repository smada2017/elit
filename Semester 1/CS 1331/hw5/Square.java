/**
 * Square class basically marks the position on a chessboard with file and rank
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Square {
    private char file;
    private char rank;
    /**
     * Creates an HourlyEmployee with all required parameters.
     *
     * @param file the file of the Square
     * @param rank the rank of the Square
     */
    public Square(char file, char rank) {
        String files = "abcdefgh";
        String ranks = "12345678";
        if ((files.indexOf(file) >= 0) && (ranks.indexOf(rank) >= 0)) {
            this.file = file;
            this.rank = rank;
        } else {
            String name = "" + file + rank;
            throw new InvalidSquareException(name);
        }
    }
    /**
     * Constructor that takes in one string for file and ranks and sets those
     * values for instance variables and checks if it is a valid Square
     * and throws an error if it is not
     * @param name given string containing file and rank
     */
    public Square(String name) {
        char fileCheck = name.charAt(0);
        char rankCheck = name.charAt(1);
        String files = "abcdefgh";
        String ranks = "12345678";
        if (name.length() >= 3) {
            throw new InvalidSquareException(name);
        } else if ((files.indexOf(fileCheck) >= 0)
            && (ranks.indexOf(rankCheck) >= 0)) {
            file = name.charAt(0);
            rank = name.charAt(1);
        } else {
            throw new InvalidSquareException(name);
        }
    }
    /**
     * @return file of the square
     *
     */
    public char getFile() {
        return file;
    }
    /**
     * @return rank of the square
     *
     */
    public char getRank() {
        return rank;
    }
    /**
     * concates file and rank
     * @return location of the square in a string
     *
     */
    public String toString() {
        String concateAll = "" + file + rank;
        return concateAll;
    }


    @Override
    public boolean equals(Object item) {
        if (item == null) {
            return false;
        } else if (item == this) {
            return true;
        } else if (!(item instanceof Square)) {
            return false;
        } else {
            Square check = (Square) item;
            return file == check.file && rank == check.rank;
        }
    }
}
