package main;

public class RoundCounter{

	private static int roundCounter = 0;
	private static int maxRoundCount = 0;

	// getter and setters
	public int getRoundCounter(){
		return roundCounter;
	}
	public void setRoundCounter(int roundCounter){
		RoundCounter.roundCounter = roundCounter;
	}
	
	public int getMaxCount(){
		return maxRoundCount;
		}
	
	public void setMaxCount(int maxRoundCount){
		RoundCounter.maxRoundCount = maxRoundCount;
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