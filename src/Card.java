
/**
 * This class +++Insert Description Here+++
 *
 * @author Ningfan Chen
 */
public abstract class Card {

    private Color color;
    protected int punish = 1;

    public boolean isEmpty() {
        return false;
    }

    public boolean isPass() {
        return false;
    }

    public int getPunish() {
        return this.punish;
    }

    public void setPunish(int punish) {
        this.punish = punish;
    }

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

    @Override
    public abstract String toString();

    public void setColorRandom() {
        int num = (int) (Math.random() * 4);
        switch (num) {
            case 0:
                setColor(Color.Red);
                break;
            case 1:
                setColor(Color.Green);
                break;
            case 2:
                setColor(Color.Blue);
                break;
            case 3:
                setColor(Color.Yellow);
                break;
        }
    }

    public boolean sameColor(Card other) {
        return this.getColor() == other.getColor();
    }

    public boolean sameNumber(Card other) {
        if (this instanceof NumberCard && other instanceof NumberCard) {
            NumberCard newthis = (NumberCard) this;
            NumberCard newother = (NumberCard) other;
            return newthis.getNumber() == newother.getNumber();
        }
        return false;
    }

    public boolean sameType(Card other) {
        if (this instanceof NumberCard && other instanceof NumberCard) {
            return true;
        }
        if (this instanceof SkipCard && other instanceof SkipCard) {
            return true;
        }
        if (this instanceof ReverseCard && other instanceof ReverseCard) {
            return true;
        }
        if (this instanceof PlusTwoCard && other instanceof PlusTwoCard) {
            return true;
        }
        return this instanceof WildCard && other instanceof WildCard;
    }

    public boolean isValid(Card prev) {
        if (prev.isEmpty()) {
            return true;
        }
        if (this instanceof PlusFourCard) {
            return true;
        } else if (prev instanceof PlusFourCard) {
            return false;
        } else if (prev instanceof PlusTwoCard) {
            return this instanceof PlusTwoCard;
        } else if (this instanceof NumberCard && prev instanceof NumberCard) {
            if (this.sameNumber(prev)) {
                return true;
            }
            return this.sameColor(prev);
        } else if (this.sameType(prev)) {
            return true;
        }
        return this.sameColor(prev) || this.getColor() == Color.Wild;

    }
}
