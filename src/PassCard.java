
/**
 * When player does not has card to play or player does not want to play,
 * this class is used to pass.
 *
 * @author Ningfan Chen
 */
public class PassCard extends Card {

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isPass() {
        return true;
    }

}
