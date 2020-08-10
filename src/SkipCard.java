
/**
 * Next player in sequence misses a turn
 *
 * @author Ningfan Chen
 */
public class SkipCard extends Card {

    public SkipCard() {
        this.setColorRandom();
    }

    @Override
    public String toString() {
        return "SkipCard: " + this.getColor();
    }
}
