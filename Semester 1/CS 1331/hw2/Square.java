/**
 * Square class basically marks the position on a chessboard with file and rank
 *
 * @author Saivardhan Mada
 */
public class Square {
    private char file;
    private char rank;
    /**
    * Constructor that takes in two chars for file and ranks and sets those
    * values for instance variables
    */
    public Square(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }
    /**
    * Constructor that takes in one string for file and ranks and sets those
    * values for instance variables
    */
    public Square(String name) {
        file = name.charAt(0);
        rank = name.charAt(1);
    }
    /**
    * returns file of the square
    *
    */
    public char getFile() {
        return file;
    }
    /**
    * returns rank of the square
    *
    */
    public char getRank() {
        return rank;
    }
    /**
    * returns location of the square in a string
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
