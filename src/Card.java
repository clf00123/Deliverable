
/**
 * This class +++Insert Description Here+++
 *
 * @author Ningfan Chen
 */
public abstract class Card {
    protected boolean clockwise;
    public enum Color {
        Red, Blue, Yellow, Green, Wild
    };

    private Color color;
    protected int punish = 1;


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

	public abstract String toString();
	
	public void setColorRandom() {
		int num = (int)(Math.random() * 4);
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
		if (this instanceof NumberCard && this instanceof NumberCard) {
			NumberCard newthis = (NumberCard)this;
			NumberCard newother = (NumberCard)other;
			return newthis.getNumber() == newother.getNumber();
		}
		return false;
	}
	
	public boolean sametype(Card other) {
		return this.getClass().equals(other.getClass());
	}
}
