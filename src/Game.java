import java.util.*;

public class Game {
	private static final String Sring = null;
	private static int ID; //ֻ��constructor ����
	private Officials offi;//����
	private int popu;  //�˶�Ա����
	private String name; //��Ŀ��
	private ArrayList<String> type;
	private AthletesList list; 
	private int num;
	private double[] randomNo = new double[num];
    //Arrays.list.randomNo; 
    
	public Game()
	{
		setID(getID() + 1);
		setName("");
		//offi = Officials.getOff();
		popu = 1;
		type = new ArrayList<String>();
		list = new AthletesList();
		num = 8;
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
	//�������������
	public double compete(String gameType)
	{
		double temp = 0;
		if (gameType.equalsIgnoreCase("running"))
		{
		//	for (int i = 0; i <= num; i++) //Ϊ�˺�������������������
			//{
				double seconds = (double)(Math.random()*11) + 10;  //������10��20�������
				//randomNo[i] = seconds;
				return seconds;
				/*if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
				System.out.println("randomNo[i]");*/
			//}
			
		}
		else if (gameType.equalsIgnoreCase("swimming"))
		{
			//for (int i = 0; i <= num; i++)
			//{
				double seconds = (double)(Math.random()*101) + 100;  //������100��200�������
				//randomNo[i] = seconds;
				return seconds;
				/*if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
				System.out.println("randomNo[i]");*/
			//}
		}
		else if (gameType.equalsIgnoreCase("cycling"))
		{
			//for (int i = 0; i <= num; i++)
			//{
				double seconds = (double)(Math.random()*301) + 500;  //������500��800�������
				//randomNo[i] = seconds;
				return seconds;
				/*if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
				System.out.println("randomNo[i]");*/
			//}
		}
		else {
			System.out.println("no game");
		}
		return 0;
		
	}
	
	public String setSport(String input)
	{
		String sportName;
		if (input.equalsIgnoreCase("swimming") || input.equalsIgnoreCase("running") 
				|| input.equalsIgnoreCase("cycling"))
		{n
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
		compete(sport);
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}
	
	/*
	public void record()
	{
		offi.getArray().add(mess)
	}
	*/
}
