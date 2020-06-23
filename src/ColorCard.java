
public class ColorCard extends Card {

    public enum Color {
        Red, Blue, Yellow, Green
    };

    private Color color;
    private boolean clockwise;

    public Color getColor() {
        return this.color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getClockwise() {
        return this.clockwise;
    }

    /**
     *
     * @param clockwise
     */
    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }
}
