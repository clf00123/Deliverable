
public class WildCard extends Card {
	protected Color color = Color.Wild;
	
	public void getNewColor(Color newColor) {
		this.color = newColor;
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