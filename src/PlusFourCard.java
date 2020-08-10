
public class PlusFourCard extends WildCard implements PlusCard {

    public PlusFourCard() {
        this.color = Color.Wild;
    }

    public void plusCard() {
        this.punish = 4;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "Plus Four Card: " + this.getColor();
    }
}
