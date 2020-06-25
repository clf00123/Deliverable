
public class WildCard extends Card {
	protected Color color = Color.Wild;
	
	public int getNewColor(Color newColor) {
		if(!newColor.equals(Color.Wild)) {
			this.color = newColor;	
			return 1;
		}
		return 0;
	}
	
	public WildCard() {
		this.color = Color.Wild;
	}

	public Color getColor() {
        return this.color;
    }
	
	@Override
	public String toString() {
		return "WildCard, New color:" + getColor();
	}


}