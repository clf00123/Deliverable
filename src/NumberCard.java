public class NumberCard extends Card {

	private int number;
	
	public NumberCard() {
		setNumberRandom();
		setColorRandom();
	}
	
	public NumberCard(Color color, int number) {
		this.number = number;
		this.setColor(color);
	}

	public int getNumber() {
		return this.number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Number Card " + this.getColor() + " " + this.number;
	}
	
	public void setNumberRandom() {
		int num = (int)(Math.random() * 10);
		this.setNumber(num);
	}
	
	public boolean sameNumber(NumberCard other) {
		if (this.getNumber() == other.getNumber()) {
			return true;
		}
		return false;
	}
	
	
	
}