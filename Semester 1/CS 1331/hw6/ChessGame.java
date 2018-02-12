import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Class ChessGame.
 * @version 1.1
 * @author Sai Mada
 */
public class ChessGame {

    /** The event. */
    private StringProperty event = new SimpleStringProperty(this, "NA");

    /** The site. */
    private StringProperty site = new SimpleStringProperty(this, "NA");

    /** The date. */
    private StringProperty date = new SimpleStringProperty(this, "NA");

    /** The white. */
    private StringProperty white = new SimpleStringProperty(this, "NA");

    /** The black. */
    private StringProperty black = new SimpleStringProperty(this, "NA");

    /** The result. */
    private StringProperty result = new SimpleStringProperty(this, "NA");

    /** The moves. */
    private List<String> moves;

    /**
     * Instantiates a new chess game.
     *
     * @param event the event
     * @param site the site
     * @param date the date
     * @param white the white
     * @param black the black
     * @param result the result
     */
    public ChessGame(String event, String site, String date,
                     String white, String black, String result) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        moves = new ArrayList<>();
    }

    /**
     * Adds the move.
     *
     * @param move the move
     */
    public void addMove(String move) {
        moves.add(move);
    }

    /**
     * Gets the move.
     *
     * @param n the n
     * @return the move
     */
    public String getMove(int n) {
        return moves.get(n - 1);
    }

    /**
     * Gets the event.
     *
     * @return the event
     */
    public String getEvent() {
        return event.get();
    }

    /**
     * Gets the site.
     *
     * @return the site
     */
    public String getSite() {
        return site.get();
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date.get();
    }

    /**
     * Gets the white.
     *
     * @return the white
     */
    public String getWhite() {
        return white.get();
    }

    /**
     * Gets the black.
     *
     * @return the black
     */
    public String getBlack() {
        return black.get();
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    public String getResult() {
        return result.get();
    }
}
