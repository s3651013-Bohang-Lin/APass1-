import java.util.*;

public class Game {
	private static final String Sring = null;
	private static int ID; //ֻ��constructor ����
	private Officials offi;//����
	private int popu;  //�˶�Ա����
	private String name; //��Ŀ��
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
	//����swimming
	public void swimList()
	{
		type.add("swimming");
	}
	//����cycling��Ŀ
	public void cycList()
	{
		type.add("cycling");
	} 
	//����running��Ŀ
	public void runList()
	{
		type.add("running");
	}
	*/
	//����������Ŀ
	
	public void addType()
	{
		  
        type.add("swimming");  
        type.add("cycling");  
        type.add("sprinters");
        //get(0)����
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
