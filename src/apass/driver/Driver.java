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
import apass.participates.impl.Officials;
import apass.utils.FileUtils;

public class Driver {
	
	private ArrayList<Athletes> aths = new ArrayList<Athletes>();
	private ArrayList<Athletes> swimmingAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> runningAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> cyclingAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> superAths = new ArrayList<Athletes>();
	private ArrayList<Officials> offics = new ArrayList<Officials>();
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
	 * Show the results of all athletes
	 */
	private void disPlayAllGameResult() {
		for(AbstractGame game : games){
			game.displayAthletsResults();
		  }
	}

	/**
	 * Calculated fraction
	 */
	private void calThePlayerScores() {
		
		for(AbstractGame game : games){//Each game can only be scored by the referee statistics
			  game.getOffi().calScores(game);
		}
		
		for(Athletes ath : aths){
			  System.out.println(ath + " scores:" +ath.getScores());
		}
		
		//Sort by fraction
		Collections.sort(aths, new Comparator<Athletes>() {
			@Override
			public int compare(Athletes o1, Athletes o2) {
				return o2.getScores() - o1.getScores();
			}
		});
		
		Athletes realWinner = aths.get(0);
		System.out.println("the realWinner is "+realWinner);
		
		if(predictWinner == null){// the user does not predict so it do not execute following code 
			return;
		}
		if(predictWinner.getAthID().equals(realWinner.getAthID())){
			System.out.println("Congratulations! your predict is correct");
		}else{
			System.out.println("Sorry! your predict is inCorrect");
		}
	}

	/**
	 * Run all races
	 * Statistical performance of athlete
	 */
	private void runningTheGames() {
		
		System.out.println(" now has "+games.size()+" games");
		for(AbstractGame game : games){
		  List<Athletes> players = new ArrayList<Athletes>();
		  if(game instanceof Swimming){ //if it is swimming
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
	
	//case1£ºselect project and  determine whether to add new players
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

		
		info = "please select a offic for this game:\n";
		int i=1;
		for(Officials offic : offics){
			info += (i++)+ " : " + offic + "\n";
		}
		System.out.println(info);
		int input = getKeyboard().nextInt();
		while(input > offics.size() || input<1){
			System.out.println(info);
			input = getKeyboard().nextInt();
		}
		Officials selOffic = offics.get(input-1);
		System.out.println("you have select the offic: "+selOffic);
		
		AbstractGame game = GameFactory.createAGame(gameType);
		game.setOffi(selOffic);
		System.out.println("you selected the game " +game.getGameName() + ", id:"+game.getGameId());
		games.add(game);
	}
	
	/**
	 * read athlete data from text
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
			 aths.add(ath);		  }
		  
		 System.out.println("there are "+aths.size()+" athletes");
		 for(Athletes a : aths){
			System.out.println(a);
		 }
		 System.out.println("");
	}
	
	
	/**
	 * loading referee
	 */
	public void loadOffics(){
		
		  String content = FileUtils.readFile("offis.txt");
		  String[] lines = content.split(";");	
		  for(String line : lines){
			 String[] values = line.split(" ");
			  
			 Officials offic = new Officials(values[0], values[1], Integer.parseInt(values[2]),
					 values[3], "");
			 
			 offics.add(offic);
		  }
		  
		 System.out.println("there are "+offics.size()+" officials");
		 for(Officials offic : offics){
			System.out.println(offic);
		 }
		 System.out.println("");
	}
	
	
    /**
     * predict winner
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
		System.out.println("you have predict that "+predictWinner.getAthName() + " is the winner");
	}
	  
    private Scanner getKeyboard(){
    	return new Scanner(System.in);
    }
}
