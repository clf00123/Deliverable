import java.util.ArrayList;
import java.util.Scanner;

public class UnoController {

	Scanner sc = new Scanner(System.in);
	ArrayList<Player> players = new ArrayList<Player>();
	
	public boolean isValid(Card prev, Card curr) {
		if (prev == null) {
			return true;
		}
		if (curr instanceof PlusFourCard) {
			return true;
		} else if(curr.sameColor(prev)) {
			return true;
		} else if(curr.sameNumber(prev)) {
			return true;
		}
		return curr.sametype(prev);
	
	}

	public boolean isSkipped(Card curr) {
		return curr instanceof SkipCard;
	}

	public int getInput() {
	    int i = sc.nextInt();
	    return i;
	}
	
	
	public boolean someoneEmpty() {
		if(players.isEmpty()) {
			return true;
		}
		for (Player player: players) {
			if (player.emptyHand()){
				return true;
			}
		}
		return false;
	}
	
	public void setupGame(int people) {
		for (int i = 0; i < people; i++) {
			Player player = new Player();
			player.initialHand();
			players.add(player);
		}
	}
	
	public void run() {
		int people = getInput();
		setupGame(people);
		Card prevCard;
		int playerind = 0;
		while(!someoneEmpty()) {
			Player curPlayer = players.get(playerind);
			int nextCardind = getInput();
			Card curCard = curPlayer.playCard(nextCardind);
			
		}
	}
}
