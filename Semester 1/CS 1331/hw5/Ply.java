import java.util.Optional;

/**
 * Ply class that holds one players move in chess
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Ply {

    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;
    /**
     * Constructor which sets all the params
     *
     * @param piece the piece being focused on
     * @param from the inital spot
     * @param to the final spot
     * @param comment comment on the movement
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }
    /**
     * returns the piece
     * @return returns the piece
     */
    public Piece getPiece() {
        return piece;
    }
    /**
     * returns the inital start
     * @return returns the start
     */
    public Square getFrom() {
        return from;
    }
    /**
     * returns the final spot
     * @return returns final spot
     */
    public Square getTo() {
        return to;
    }
    /**
     * returns the optional comment
     * @return returns the comment
     */
    public Optional<String> getComment() {
        return comment;
    }
}
