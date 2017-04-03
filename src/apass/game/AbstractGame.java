package apass.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apass.participates.impl.Athletes;
import apass.participates.impl.Officials;
/**
 *Game abstract class provides general behavior and some subclasses to achieve their abstract method
 * @author Bohang Lin s3651013
 *
 */
public abstract class AbstractGame {

	private String gameId;     //game ID
	private String gameName;   //game name
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();  // map-saving the results of each player  key放运动员列表id  value放成绩秒数
	private Officials offi;				 
	private List<Athletes> athlets = new ArrayList<Athletes>();       
	private boolean isRun = false;   
	
	public AbstractGame(String gameId, String gameName) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
	}
	
	public Officials getOffi() {
		return offi;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setOffi(Officials offi) {
		this.offi = offi;
	}
	public List<Athletes> getAthlets() {
		return athlets;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public Map<String, Double> getAthletsSecondResult() {
		return athletsSecondResult;
	}
	public void setAthletsSecondResult(Map<String, Double> athletsSecondResult) {
		this.athletsSecondResult = athletsSecondResult;
	}
	public void setAthlets(List<Athletes> athlets) {
		this.athlets = athlets;
	}
	
	/**
	 *the method of calculating result cause it is different, need the concrete class to  achieve that method 
	 */
	public abstract double compete();   
	
	/**
	 * To start the game, you will call a random score to generate the results of each player 
	 * Save to map for later query use 
	 */
	public void runGame(){
		isRun = true;   //Modify the operation flag bit true, said the implementation of the rungame steps

		if(athlets.size() < 4){
			System.out.println("==========================================================");
			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			System.out.println("the game is not run because athletes is less than 4");
			return;
		}
		
		for(Athletes athlete : athlets){
			double seconds = compete();
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
	}
	
	/**
	 * Show all the players participating in the game 
	 * Query results by query map 
	 */
	public void displayAthletsResults(){
		
		if(!isRun){//If you do not select the 3 run the game can not show results 
			System.out.println("==========================================================");
			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			System.out.println("the game is not run please select the menu Start the games to run ");
			return;
		}
		
		if(athlets.size() < 4){//If the player is less than 4, you can't run the game 
			System.out.println("==========================================================");
			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			System.out.println("the game is not run because athletes is less than 4");
			return;
		}
		
		System.out.println("==========================================================");
		System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
		Officials offi = this.getOffi();
		System.out.println("officials: "+offi);
		for(Athletes ath : athlets){
			double second = athletsSecondResult.get(ath.getAthID());
			System.out.println(ath+" "+ second +"s");
		}
	}

	
	
}
