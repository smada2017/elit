import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

/**
 * records lists of moves
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class ChessGame {

    private List<Move> moves;
    /**
    * Constructor that creates class with given list of moves
    * @param moves takes in a list of moves
    */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }
    /**
    * getter method that gets move at specified point
    * @param n indicates which moves is required
    * @return the move that was asked for
    */
    public Move getMove(int n) {
        return moves.get(n);
    }
    /**
    * getter method that gets move at specified point
    * @return returns the list of moves
    */
    public List<Move> getMoves() {
        return moves;
    }
    /**
    * filter method that tests moves
    * @param filter takes in predicate filter
    * @return returns the list of moves
    */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> passTest = new ArrayList<Move>();
        for (Move testMove: moves) {
            if (filter.test(testMove)) {
                passTest.add(testMove);
            }
        }

        return passTest;

    }
    /**
    * methods that gets all moves with comments using lambda expression
    * @return returns the list of moves with comments
    */
    public List<Move> getMovesWithComment() {
        return filter((Move check) -> {
                return check.getblackPly().getComment().isPresent()
                    || check.getwhitePly().getComment().isPresent();
            });

    }
    /**
    * methods that gets all moves with comments using anonymous inner class
    * @return returns the list of moves without comments
    */
    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move check) {
                    return !(check.getblackPly().getComment().isPresent()
                        || check.getwhitePly().getComment().isPresent());
            }
        });
    }

    /**
     * predicate class for this program
     *
     * @author Saivardhan Mada
     * @version 1.1
     */
    public class MovePredicate implements Predicate<Move> {
        private Piece poy;

        /**
         *Constructor that takes in a piece
         *
         *@param poy a Piece
         */
        public MovePredicate(Piece poy) {
            this.poy = poy;
        }

        /**
         *tests if the piece is the same type in each ply
         *
         *@param mov is a Move
         *@return boolean
         */
        public boolean test(Move mov) {
            return (mov.getblackPly().getPiece().
                algebraicName().equals(poy.algebraicName()))
                || mov.getwhitePly().getPiece().
                algebraicName().equals(poy.algebraicName());
        }
    }

    /**
     *Returns whether white and black moves are same class
     *
     *@param poy Piece
     *@return List of moves
     */
    public List<Move> getMovesWithPiece(Piece poy) {
        return filter(new MovePredicate(poy));
    }


}
