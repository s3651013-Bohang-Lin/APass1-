import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	private Random read;
	private int input;
	private Scanner keyboard;
	private ArrayList<Game> game;
	private ArrayList<Athletes> ath;
	private Game list;
	private AthletesList athList;
	public Driver()
	{
		 keyboard = new Scanner(System.in);
		 game = new ArrayList<Game>();
		 ath = new ArrayList<Athletes>();
		 list = new Game();
		 athList = new AthletesList();
	}
	 public void setGame(ArrayList<Game> list)
	    {
	        game = list;
	    }

	    public ArrayList<Game> getGame()
	    {
	        return game;
	    }
	
	/**
     * Search for game name
     * @param the name should not be empty.
     * @return An array of those details that have been found.
     */
	public boolean searchGame(String input)
	{
		//String sportName;
		if (input.trim().isEmpty())
		{
			System.out.println("Game name cannot be blank. Please enter again.");
			return true;
		}
		else if (input.equalsIgnoreCase("swimming") || input.equalsIgnoreCase("running") 
				|| input.equalsIgnoreCase("cycling"))
		{
			//sportName = input.toLowerCase();
			return true;
		}
		else
		{
			//sportName = "Null";
			System.out.println("Please enter again(swimming, cycling or running):");
			return true;
		}
	}

    /**
     * Search for whether a game in text 
     * @return An array of those details that have been found.
     */
	public boolean searchHaveGame(String input)
	{
		for (int index = 0; index < game.size(); index++)
		{
			Game gameList = game.get(index);
            if(input.equals(gameList.getName()))
                return true;
		}
		return false;
	}
    /**
     * Add a new game name.
     * @param details the name of Game.
     */
	public void addType(String type)
	{
        game.add(list);

	}
    /**
     * select a game to run.
     * @param add the details to the Game.
     */

	public void selectGame()
	{
		Athletes list = new Athletes("","",0,"","");
		System.out.println("Please enter a game(swimming, cycling or running): ");
		list.setName(keyboard.nextLine());
		//while(searchGame(list.getName()))
		//{
			//list.setName(keyboard.nextLine());
		//}
		//game.add(list);
		System.out.println("Do you want enrol new Athletes (Yes or No): ");
		String judge = keyboard.nextLine();
		if (judge.equalsIgnoreCase("Yes")){
		System.out.println("Please enter the number of " + list.getName() + " Athletes: ");
		int num = keyboard.nextInt();
		int[] arr = new int[num];
		String[] id = new String[num]; //存放ID
		String[] name = new String[num]; //存放姓名的
		int[] age = new int[num];//存放年龄
		String[] state = new String[num];//存放国家
		String[] type = new String[num];//存放运动员种类 

		for(int i = 0; i < arr.length && i < id.length && i < name.length && i < age.length &&
				i < state.length && i < type.length ; i++)
		{
			arr[i] = i;
			System.out.println("Please enter " + (arr[i]+1) + " athlete unique ID: "); 
			list.setAthID(keyboard.nextLine());
			keyboard.nextLine();
			System.out.println("Please enter " + (arr[i]+1) + " athlete name: ");
			list.setAthName(keyboard.nextLine());
			System.out.println("Please enter " + (arr[i]+1) + " athlete age: ");
			list.setAge(keyboard.nextInt());
			System.out.println("Please enter " + (arr[i]+1) + " athlete state: ");
			list.setAthState(keyboard.nextLine());
			keyboard.nextLine();
			System.out.println("Please enter " + (arr[i]+1) + " athlete type: ");
			list.setAthType(keyboard.nextLine());
			
			id[i] = list.getAthID();
			name[i] = list.getAthName();
			age[i] = list.getAge();
			state[i] = list.getAthState();
			type[i] = list.getAthType();
		}
		ath.add(list);
		}
		else{
			display();
			startSystem();
		}
	}
	
	public void predictGame()
	{
		
	}
	  
	   /**
	* This method will be executed when user needs to start this system.
	* It will read information from a text file called "ozlympic.txt" automatically.
	* Then it will provide a menu so that one can operate the system.
	*/
	public void startSystem()
	{
	
	  boolean exit = false;
	  //readFromFile();
	  while (!exit)
	  {
	      String option = keyboard.nextLine();
	      switch (option)
	      {
	          case "1":
	          	  selectGame();
	              break;
	          case "2":
	             
	              break;    
	          case "3":
	          	  list.playOneRound();
	              break;
	          case "4":
	              
	              break;
	          case "5":
	              athList.listAllAthletes();
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
	public void display()
	{
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
	}
	
}
    /**
     * This method is responsible for read data from "student.txt".
     * It has simple validate function to examine the data coming from the text.
     * If some data cannot be read into database, it will generate a simple report.
     */
    /*
    private void readFromFile()
    {
        String filename = "student.txt";
        int i = 0;
        stuDB.deleteAll();
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            do
            {
                try
                {
                    String line = parser.nextLine();
                    String[] parts = line.split(",");
                    String name = parts[0];
                    int phone = Integer.valueOf(parts[1]);
                    if (check.checkName(name) &&
                        check.checkPhone(phone) &&
                        parts.length <= 5)
                    {
                        SubjectCollection sub = new SubjectCollection();
                        for (int index = 2;index < parts.length;index++)
                        {
                            if (sub.getSize() == 0)
                            {
                                sub.setSub(parts[index]);
                            }
                            else if (sub.checkDuplicate(parts[index]))
                            {
                                System.out.println("Duplicated subject in student information. Delete it automatically.");
                            }
                            else
                                sub.setSub(parts[index]);
                        }
                        Student stud = new Student(name,phone,sub);
                        stuDB.setToStuDB(stud);
                    }
                    else
                    {
                        System.out.println("Invalid data format.");
                        i++;
                    }
                }
                catch (NumberFormatException c)
                {
                    System.out.println("Invalid data format.");
                    i++;
                }
                catch (ArrayIndexOutOfBoundsException d) 
                {
                    System.out.println("Invalid data format.");
                    i++;
                }
            }while (parser.hasNextLine());
            inputFile.close();
        }
        catch (FileNotFoundException a)
        {
            System.out.println(filename + " not found");
        }
        catch (IOException b)
        {
            System.out.println("Fail to read from file.");
        }
        if (i != 0)
        {
            System.out.println("There are " + i + " students cannot enrol, please check student.txt");
        }
    }
    */
	/*
	public void response()
	{
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		switch(choice)
		{
		case 1:
			1: running 
			run = new Game(id,name,Officials,Pop);
		
			2.cycling
			cyc = new Game(id,name,Officials,Pop);
			3.swimming
			swimming = new Game(id,name,Officials,Pop);
			exit;
		case
		}
	}
	*/
    /*
	public void guessWin()
	{
		input = Scanner.nextInt();//随机数
		System.out.println("");
	}
	
	public void startGame()
	{
		for ()
			{
			Athletes.getScore() = Ran.next(num);
			排名次
			}
	    
	}
*/
	

