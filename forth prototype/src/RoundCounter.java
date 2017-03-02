
public class RoundCounter{

	private static int roundCounter = 0;

	public int getRoundCounter(){
		return roundCounter;
	}

	public void setRoundCounter(int roundCounter){
		this.roundCounter = roundCounter;
	}

	public void incRoundCounter(){
		roundCounter++;
	}
	private static RoundCounter instance = null;
	protected RoundCounter() {}
	   
	public static RoundCounter getInstance() {
		if(instance == null) {
			instance = new RoundCounter();
	    }
		return instance;
	}
}