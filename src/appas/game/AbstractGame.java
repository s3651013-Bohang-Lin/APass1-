package appas.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apass.participates.impl.Athletes;
import apass.participates.impl.Officials;
/**
 * 游戏抽象类  提供通用的行为 以及一些需要由子类去各自实现的抽象方法
 * @author Bohang Lin
 *
 */
public abstract class AbstractGame {
	private String gameId;//game id
	private String gameName; //game name
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>(); //store the result of each athletes in map,  key store athlete id  value store athlete second 
	private Officials offi; // every game has an official
	private List<Athletes> athletes;   
	
	public AbstractGame(String gameId, String gameName) {
		super(); //默认继承object类 可以不用写
		this.gameId = gameId;
		this.gameName = gameName;
		this.offi = new Officials(gameId+"Off", gameName+"Off", 30, "", gameName);
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
	 * The method of calculating results is different for each game, so it is necessary 
	 * to implement this method by the implementation class 
	 */
	public abstract double compete();  
	/**
	 * To start the game, you will call a random score to generate the results of each player 
	 * Save to map for later query using
	 */
	public void runGame(){
		for(Athletes athlete : athlets){
			double seconds = compete();
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
	 /**
	 * Show all the players participating in the game
	 * Query results by result map 
	 */
	public void displayAthletsResults(){
		System.out.println("game 【ID:"+this.getGameId() + ", name:"+this.gameName+"】");
		for(Athletes ath : athlets){
			double second = athletsSecondResult.get(ath.getAthID());//hashMap
			System.out.println(ath+" "+ second +"s");
		}	
	}
}
