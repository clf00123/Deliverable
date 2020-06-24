import java.util.ArrayList;

public class Player {
	boolean skip = false;
	int punishment = 0;
	ArrayList<Card> hand = new ArrayList<Card>();

	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void addCard(Card newCard) {
		this.hand.add(newCard);
	}
	
	public void addCardRandom() {
		int num = (int)(Math.random() * (108));
		if(num < 76) {
			hand.add(new NumberCard());
		}else if(num < 84){
			hand.add(new SkipCard());
		}else if(num < 92){
			hand.add(new ReverseCard());
		}else if(num < 100) {
			hand.add(new PlusTwoCard());
		}else if(num < 104) {
			hand.add(new WildCard());
		}else if(num < 108) {
			hand.add(new PlusFourCard());
		}
	}
	
	public void initialHand() {
		for(int i = 0; i < 7; i++) {
			addCardRandom();
		}
	}
	
	public String showHand() {
		String answer = "";
		for(int i = 0; i < hand.size(); i++) {
			answer += (i + 1);
			answer += ". " + hand.get(i).toString() + "\n";
		}
		return answer;
	}
	
	public Card playCard(int i) {
		Card toPlay = hand.remove(i - 1);
		return toPlay;
	}
	
	public boolean emptyHand() {
		return hand.isEmpty();
	}
	
	public static void main(String[] args) {
		Player p1 = new Player();
		p1.initialHand();
		System.out.print(p1.showHand());
		System.out.print(p1.playCard(4));
		System.out.print(p1.showHand());
	}
	
}
