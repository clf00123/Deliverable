
/**
 * When player choose a card that is invalid, 
 * this class is used to replace that card,
 * so player can not play this card
 *
 * @author Ningfan Chen
 */
public class EmptyCard extends Card {

    protected int punish = 1;

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

}
