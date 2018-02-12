/**
 * Move one turn that includes both white and black move
 *
 * @author Saivardhan Mada
 * @version 1.1
 */
public class Move {

    private Ply whitePly;
    private Ply blackPly;

    /**
     * Constructor which sets all the params
     *
     * @param whitePly white move
     * @param blackPly black move
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }
    /**
     * returns the white move
     * @return returns white move
     */
    public Ply getwhitePly() {
        return whitePly;
    }
    /**
     * returns the black move
     * @return returns black move
     */
    public Ply getblackPly() {
        return blackPly;
    }

}
