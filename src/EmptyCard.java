
public class EmptyCard extends Card {

    protected int punish = 1;
    
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean isEmpty() {
    	return true;
    }


}
