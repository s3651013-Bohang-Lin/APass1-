package apass.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apass.participates.impl.Athletes;
import apass.participates.impl.Officials;
/**
 *Game abstract class provides general behavior and some subclasses to achieve their abstract method
 * @author Bohang Lin
 *
 */
public abstract class AbstractGame {

	private String gameId;     //game ID
	private String gameName;   //game name
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();  // map-saving the results of each player  key放运动员列表id  value放成绩秒数
	private Officials offi;				  //裁判     每个游戏有一个裁判
	private List<Athletes> athlets = new ArrayList<Athletes>();       //参加的运动员
	private boolean isRun = false;   //是否运行过的标志  展示结果时如果还没运行过则不展示 需要先选择运行
	
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
	 * 开始这个游戏  会依次调用随机成绩产生方法 生成每个运动员的成绩  
	 * 保存到map中 供后面查询使用
	 */
	public void runGame(){
		isRun = true;   //修改运行标志位true   表示执行过runGame步骤

		if(athlets.size() < 4){//如果运动员小于4个 则不能运行比赛 所以提示信息
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
	 * 展示参加了该游戏的所有运动员成绩
	 * 通过查询成绩结果map
	 */
	public void displayAthletsResults(){
		
		if(!isRun){//如果没有选中3运行游戏 则还不能展示结果
			System.out.println("==========================================================");
			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			System.out.println("the game is not run please select the menu Start the games to run ");
			return;
		}
		
		if(athlets.size() < 4){//如果运动员小于4个 则不能运行比赛 所以提示信息
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
