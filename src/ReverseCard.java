public class ReverseCard extends Card {
	
	public ReverseCard() {
		this.setColorRandom();
	}

	/**
	 * 
	 * @param clockwise
	 */
	public void setClockwise(boolean clockwise) {
		// TODO - implement ReverseCard.setClockwise
		if(this.clockwise = true) {
			this.clockwise = false;
		}else {
		this.clockwise = true;
		}
	}
	
	@Override
	public String toString() {
		return "Reverse card: " + this.getColor() + ", Clockwise: " + this.getClockwise();
	}
	
}