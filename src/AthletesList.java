import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class AthletesList {
	//private String[] subjects;
	private ArrayList<Athletes> list;
	private int Score;
	//private String[] athleteType;
	public AthletesList() {
		
		list = new ArrayList<Athletes>();
		Score = 0;
		//athleteType = new String[4];
	}
	//增加运动员信息
	public void addAthlete(String athID,String athName,int athAge,String athState)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState);
		list.add(info);
	}
	

	

    /**
     * List All athletes from the collection.
     * @param index The index of athletes to be listed.
     */
    public void listAllAthletes()
    {
        System.out.println("Athletes listing: ");
        for (Athletes people : list) {
            System.out.println(people.getDetails());
        }
        System.out.println();
    }
	/*
	public String getScore()
	{
		return 
	}
	*/
	//录入运动员信息
	public void readInput()
	{
		Athletes list = new Athletes("","",0,"");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter athlete unique ID: "); 
		list.setAthID(keyboard.nextLine());
		System.out.println("Enter athlete name: ");
		list.setAthName(keyboard.nextLine());
		System.out.println("Enter athlete age: ");
		list.setAge(keyboard.nextInt());;
		System.out.println("Enter athlete state: ");
		list.setAthState(keyboard.nextLine());;
	}
	
	/*
	public int ddd()
	{
		athleteList.add();
		athleteList.remove();
		athleteList.get(1).getName();//提取排名1号位的运动员的名字
	}*/
}