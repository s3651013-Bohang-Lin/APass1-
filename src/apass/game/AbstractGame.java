package apass.game;

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

	private String gameId;     //游戏id
	private String gameName;   //游戏名称
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();  //存放每个运动员的成绩map  key放运动员列表id  value放成绩秒数
	private Officials offi;				  //裁判     每个游戏有一个裁判
	private List<Athletes> athlets;       //参加的运动员
	
	public AbstractGame(String gameId, String gameName) {
		super();  
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
	 * 计算成绩的方法 每个游戏不一样 所以需要由实现类实现这个方法
	 */
	public abstract double compete();   
	
	/**
	 * 开始这个游戏  会依次调用随机成绩产生方法 生成每个运动员的成绩  
	 * 保存到map中 供后面查询使用
	 */
	public void runGame(){
		for(Athletes athlete : athlets){
			double seconds = compete();
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
	}
	
	/**
	 * 展示参加了该游戏的所有运动员成绩
	 * 通过查询成绩结果map
	 */
	public void displayAthletsResults(){
		System.out.println("game 【ID:"+this.getGameId() + ", name:"+this.gameName+"】");
		for(Athletes ath : athlets){
			double second = athletsSecondResult.get(ath.getAthID());//hashMap
			System.out.println(ath+" "+ second +"s");
		}
	}
	
	
}
