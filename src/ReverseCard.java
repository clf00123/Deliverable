
/**
 * Order of play switches directions
 *
 * @author Ningfan Chen
 */
public class ReverseCard extends Card {

    public ReverseCard() {
        this.setColorRandom();
    }

    /**
     *
     * @param clockwise
     */
    @Override
    public String toString() {
        return "Reverse card: " + this.getColor();
    }

}
