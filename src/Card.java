
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
		if (this instanceof NumberCard && other instanceof NumberCard) {
			NumberCard newthis = (NumberCard)this;
			NumberCard newother = (NumberCard)other;
			return newthis.getNumber() == newother.getNumber();
		}
		return false;
	}
	
	public boolean sameType(Card other) {
		return this.getClass().equals(other.getClass());
	}

	public boolean isValid(Card prev) {
		if (prev.isEmpty()) {
			return true;
		}
		if (this instanceof PlusFourCard) {
			return true;
		} else if(this instanceof NumberCard && prev instanceof NumberCard) {
			if(this.sameNumber(prev)) {
				return true;
			}	
				return this.sameColor(prev);
		} else if(this.sameType(prev)) {
			return true;
		}
		return this.sameColor(prev) || this.getColor() == Color.Wild;
	
	}
	
	public static void main(String[] args) {
		Card c1 = new NumberCard();
		Card c2 = new NumberCard();
		System.out.println(c1);
		System.out.println(c2);
		NumberCard newc1 = (NumberCard)c1;
		NumberCard newc2 = (NumberCard)c2;
		System.out.println(newc1);
		System.out.println(newc2);
		
	}

}
