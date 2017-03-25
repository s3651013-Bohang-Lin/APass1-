import java.util.*;

public class Game {
	private static final String Sring = null;
	private static int ID; //只在constructor 调用
	private Officials offi;//裁判
	private int popu;  //运动员人数
	private String name; //项目名
	private ArrayList<String> type;
	private AthletesList list; 
    //Arrays.list.randomNo; 
    
	public Game()
	{
		ID += 1;
		setName("");
		//offi = Officials.getOff();
		popu = 1;
		type = new ArrayList<String>();
		list = new AthletesList();
	}
	/*
	//增加swimming
	public void swimList()
	{
		type.add("swimming");
	}
	//增加cycling项目
	public void cycList()
	{
		type.add("cycling");
	} 
	//增加running项目
	public void runList()
	{
		type.add("running");
	}
	*/
	//增加三个项目
	
	public void addType()
	{
		  
        type.add("swimming");  
        type.add("cycling");  
        type.add("sprinters");
        //get(0)调用
	}
	
	 /**
     * return the input sports in the main .
     * @param ignore the Case of sport's input.
	 * @return 
     */
	public String setSport(String input)
	{
		String sportName;
		if (input.equalsIgnoreCase("swimming") || input.equalsIgnoreCase("running") 
				|| input.equalsIgnoreCase("cycling"))
		{
			sportName = input.toLowerCase();
			return sportName;
		}
		else
		{
			sportName = "Null";
			System.out.println("Please enter again(swimming, cycling or running):");
			return sportName;
		}
	}
	
/*	public void points()
	{
		if 
	}
	*/
	public void playOneRound()
	{
		System.out.println("");
		System.out.println("Please choose a game(swimming, cycling or running): ");
		Scanner keyboard = new Scanner(System.in);
		String sport = keyboard.nextLine();
		while(sport.trim().isEmpty())
	       {
	           sport = setSport(keyboard.nextLine());
	       }
	       // sport.setSport(getSport(sport));
		list.compete(sport);
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public void record()
	{
		offi.getArray().add(mess)
	}
	*/
}
