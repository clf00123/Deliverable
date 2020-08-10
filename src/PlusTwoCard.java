
public class PlusTwoCard extends Card implements PlusCard {

    public PlusTwoCard() {
        this.setColorRandom();
    }

    public void plusCard() {
        this.punish = 2;
    }

    @Override
    public String toString() {
        return "Plus Two Card: " + this.getColor();
    }

}
