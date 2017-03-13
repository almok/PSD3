package main;

public class RoundCounter{

	private static int roundCounter = 0;
	private static int maxRoundCount = 0;

	public int getRoundCounter(){
		return roundCounter;
	}

	public void setRoundCounter(int roundCounter){
		System.out.println("setting round counter");
		this.roundCounter = roundCounter;
	}

	public void incRoundCounter(){
		roundCounter++;
	}

	public int getMaxCount(){
		return maxRoundCount;
	}

	public void setMaxCount(int maxRoundCount){
		this.maxRoundCount = maxRoundCount;
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