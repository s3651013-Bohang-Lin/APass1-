package apass.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import apass.Ozlympic;
import apass.enumeration.GameEnum;
import apass.game.AbstractGame;
import apass.game.factory.GameFactory;
import apass.game.impl.Cycling;
import apass.game.impl.Running;
import apass.game.impl.Swimming;
import apass.participates.impl.Athletes;
import apass.utils.FileUtils;

public class Driver {
	
	private ArrayList<Athletes> aths = new ArrayList<Athletes>();
	private ArrayList<Athletes> swimmingAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> runningAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> cyclingAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> superAths = new ArrayList<Athletes>();
	private Athletes predictWinner;
	private List<AbstractGame> games = new ArrayList<AbstractGame>();
	private	String info = new String("");    
	
	
	/**
	* This method will be executed when user needs to start this system.
	* It will read information from a text file called "ozlympic.txt" automatically.
	* Then it will provide a menu so that one can operate the system.
	*/
	public void startSystem()
	{
	  boolean exit = false;
	  while (!exit)
	  {
	      String option = getKeyboard().nextLine();
	      switch (option)
	      {
	          case "1":
	          	  selectGame();
	          	  Ozlympic.display();
	              break;
	          case "2":
	              predictGame();
	              Ozlympic.display();
	              break;    
	          case "3":
	        	  runningTheGames();
	          	  Ozlympic.display();
	              break;
	          case "4":
	        	  disPlayAllGameResult();
	          	  Ozlympic.display();
	              break;
	          case "5":
	        	  calThePlayerScores();
	              Ozlympic.display();
	              break;  
	          case "6":
	          	 //writeToFile();
	               System.out.println("You have exited.");
	               exit = true;
	              break;  
	          default:
	              System.out.println("Invalid option! Please choose the option from 1 to 6!");
	              break;
	      }
	  }
	}

	/**
	 * 展示所有运动员的成绩结果
	 */
	private void disPlayAllGameResult() {
		for(AbstractGame game : games){
			game.displayAthletsResults();
		  }
	}

	/**
	 * 计算分数
	 */
	private void calThePlayerScores() {
		
		for(AbstractGame game : games){//每个游戏都只能由他的裁判进行分数统计
			  game.getOffi().calScores(game);
		}
		
		for(Athletes ath : aths){
			  System.out.println(ath + " scores:" +ath.getScores());
		}
		
		//按分数排序
		Collections.sort(aths, new Comparator<Athletes>() {
			@Override
			public int compare(Athletes o1, Athletes o2) {
				return o2.getScores() - o1.getScores();
			}
		});
		
		Athletes realWinner = aths.get(0);
		System.out.println("the realWinner is "+realWinner);
		if(predictWinner.getAthID().equals(realWinner.getAthID())){
			System.out.println("Congratulations! your predict is correct");
		}else{
			System.out.println("Sorry! your predict is inCorrect");
		}
	}

	/**
	 * 运行所有比赛 
	 * 统计运动员成绩
	 */
	private void runningTheGames() {
		
		System.out.println(" now has "+games.size()+" games");
		for(AbstractGame game : games){
		  List<Athletes> players = new ArrayList<Athletes>();
		  if(game instanceof Swimming){
			  players.addAll(swimmingAths);
		  }
		  if(game instanceof Running){
			  players.addAll(runningAths);
		  }
		  if(game instanceof Cycling){
			  players.addAll(cyclingAths);
		  }
		  players.addAll(superAths);
		  game.setAthlets(players);
		  game.runGame();
	    }
	}
	
	//case1：选择项目 并 判断是否增加新运动员
	public void selectGame()
	{
		info = "please enter a game you want to run:\n";
		for(GameEnum game : GameEnum.values()){
			info += game.getValue() + " : " + game.getName() + " ";
		}
		info += ":\n";
		
		System.out.println(info);
		int gameIndex = getKeyboard().nextInt();
		GameEnum gameType = GameEnum.getGameByIndex(gameIndex);
		while(gameType == null){
			System.out.println("your input is invalid, please input again");
			gameIndex = getKeyboard().nextInt();
			gameType = GameEnum.getGameByIndex(gameIndex);
		}

		AbstractGame game = GameFactory.createAGame(gameType);
		System.out.println("you selected the game " +game.getGameName() + ", id:"+game.getGameId());
		games.add(game);
	}
	
	/**
	 * jiaziai 运动原
	 */
	public void loadPlayers(){
		
		  String content = FileUtils.readFile("aths.txt");
		  String[] lines = content.split(";");	
		  for(String line : lines){
			 String[] values = line.split(" ");
			  
			 Athletes ath = new Athletes();
			 ath.setAthID(values[0]);
			 ath.setAthName(values[1]);
			 ath.setAge(Integer.parseInt(values[2]));
			 ath.setAthState(values[3]);
			 ath.setAthType(values[4]);
			 
			 if("SWIMMERS".equals(ath.getAthType())){
				 swimmingAths.add(ath);
			 }
			 if("CYCLISTS".equals(ath.getAthType())){
				 cyclingAths.add(ath);
			 }
			 if("SPRINTERS".equals(ath.getAthType())){
				 runningAths.add(ath);
			 }
			 if("SUPERATHLETES".equals(ath.getAthType())){
				 superAths.add(ath);
			 }
			 aths.add(ath);
		  }
		  
		 System.out.println("there are "+aths.size()+" athletes");
		 for(Athletes a : aths){
			System.out.println(a);
		 }
		 System.out.println("");
	}
	
    /**
     * 预测胜利者
     */
	public void predictGame()
	{
		String msg = "";
		int i=0;
		for(Athletes a : aths){
			msg += (++i) + " : " + a + "\n";
		}
		System.out.println("please choose the winner athletes you predict\n"+msg );
		
		int input = getKeyboard().nextInt();
		while(input > aths.size() || input<1){
			System.out.println("please choose the winner athletes you predict\n"+msg );
			input = getKeyboard().nextInt();
		}
		
		predictWinner = aths.get(input-1);
		System.out.println("you have predict that 【"+predictWinner.getAthName() + "】 is the winner");
	}
	  
    private Scanner getKeyboard(){
    	return new Scanner(System.in);
    }
}
