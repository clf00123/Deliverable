
import java.util.ArrayList;
import java.util.Scanner;

public class UnoController {

    Scanner sc = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<Player>();
    boolean clockwise = true;

    Card prevCard = new EmptyCard();
    Card curCard;
    int curPlayerind = 0;
    int prevPlayerind = 0;

    public boolean isSkipped(Card curr) {
        return curr instanceof SkipCard;
    }
    
    public int isInteger(String s) {
    	try {
    		int i = Integer.parseInt(s);
    		return i;
    	}
    	catch (Exception e) {
    		return -1;
    	}
    }

    public int getInput() {
        String input = sc.next();
        int result = isInteger(input);
        while (result < 0) {
        	System.out.println("Enter a valid integer");
        	input = sc.next();
        	result = isInteger(input);
        }
        return result;
    }
    
    public int getValidIndex(Player player) {
    	int index = getInput();
    	while (index > player.countHand()) {
    		System.out.println("Enter a valid integer");
    		index = getInput();
    	}
    	return index;
    }

    public void getNewColor(WildCard card) {
        System.out.println("Choose a color to input: Yellow, Blue, Red, Green");

        //String c = sc.nextLine();
        Color nc = getColor();
        //int correct = 0;

        while (nc.equals(Color.Wild)) {
            System.out.println("Invalid Input Color");
            System.out.println("Choose a color to input: "
                    + "Yellow, Blue, Red, Green");
            nc = getColor();
        }
        card.getNewColor(nc);
    }

    public Color getColor() {
        
        String c = sc.nextLine();
        while (c.equals("")) {
            c = sc.nextLine();
        }
        if (c.equals("Red")) {
            return Color.Red;
        }
        if (c.equals("Blue")) {
            return Color.Blue;
        }
        if (c.equals("Green")) {
            return Color.Green;
        }
        if (c.equals("Yellow")) {
            return Color.Yellow;
        }
        return Color.Wild;
    }

    public void getPunished(Card prevCard, Player cur, Player prev) {
        int many = prev.getPunishment() + prevCard.getPunish();
        cur.addCardRandom(many);

    }

    public void punishPass(Player cur, Player prev, Card curCard) {
        int total = prev.getPunishment() + curCard.getPunish();
        cur.setPunishment(total);
    }

    public void setClockwise() {
        if (this.clockwise = true) {
            this.clockwise = false;
        } else {
            this.clockwise = true;
        }
    }

    public int nextPlayer(int curr, int move) {

        if (clockwise == true) {
            for (int i = 0; i < move; i++) {
                curr++;
                if (curr == players.size()) {
                    curr = 0;
                }
            }

        }
        if (clockwise == false) {

            for (int i = 0; i < move; i++) {
                curr--;
                if (curr <= 0) {
                    curr = players.size() - 1;
                }
            }

        }
        return curr;
    }

    /*
	 * return index of player + 1 in player list if the player has empty hand. Return 0 
	 * if no one has empty hand. Return -1 if no player in player list.
     */
    public int someoneEmpty() {
        if (players.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).emptyHand()) {
                return i + 1;
            }
        }
        return 0;
    }

    public void setupGame(int people) {
        for (int i = 0; i < people; i++) {
            Player player = new Player();
            player.initialHand();
            players.add(player);
        }
    }

    public int operate(Card validCard, Card prevCard) {
        Player curPlayer = players.get(curPlayerind);
        Player prevPlayer = players.get(prevPlayerind);
        if (validCard.isEmpty()) {
            System.out.println("Invalid card, choose another card");
            return curPlayerind;
        }
        if (validCard.isPass()) {
            getPunished(prevCard, curPlayer, prevPlayer);

        }

        if (validCard instanceof ReverseCard) {
            setClockwise();
        }
        if (validCard instanceof SkipCard) {
            curPlayerind = nextPlayer(curPlayerind, 1);

        }
        if (validCard instanceof WildCard || validCard instanceof PlusFourCard) {
            this.getNewColor((WildCard) validCard);
        }
        if (validCard instanceof PlusFourCard || validCard instanceof PlusTwoCard) {
            this.punishPass(curPlayer, prevPlayer, validCard);

        }
        int nextPlayer = nextPlayer(curPlayerind, 1);

        return nextPlayer;
    }

    public void run() {
        System.out.println("Enter an integer to set player number:");
        int people = getInput();
        setupGame(people);

        while (someoneEmpty() == 0) {

            Player curPlayer = players.get(curPlayerind);

            int playeri = curPlayerind + 1;
            System.out.println("Player" + (playeri) + " play card");
            System.out.print(curPlayer.showHand());

            System.out.println("input an index of Card to play. "
                    + "Input 0 to skip and draw card.");
            int nextCardind = getValidIndex(curPlayer);

            Card curCard = curPlayer.canPlayCard(prevCard, nextCardind);

            int agent = operate(curCard, prevCard);
            if (!(curCard instanceof EmptyCard)) {

                if (!(curCard instanceof PassCard)) {
                    prevCard = curCard;
                    System.out.println("\nPlayer" + (playeri) + " play " + curCard);
                }
                prevPlayerind = curPlayerind;
                curPlayerind = agent;
            }
        }
    }

    public static void main(String[] args) {
        UnoController newgame = new UnoController();
        newgame.run();
    }
}
