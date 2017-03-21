import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class AthletesList {
	private String[] subjects;
	private ArrayList<Athletes> list;
	//private String[] athleteType;
	public AthletesList() {
		
		list = new ArrayList<Athletes>();
		//athleteType = new String[4];
	}
	//增加运动员信息
	public void addAthlete(int athID,String athName,int athAge,String athState)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState);
		list.add(info);
	}
	
	//产生随机秒数
	public int compete(String gameType)
	{
		if (gameType.equalsIgnoreCase("running"))
		{
			int seconds = (int)(Math.random()*11) + 10;  //产生从10到20的随机数
			return seconds;
		}
		else if (gameType.equalsIgnoreCase("swimming"))
		{
			int seconds = (int)(Math.random()*101) + 100;  //产生从100到200的随机数
			return seconds;
		}
		else if (gameType.equalsIgnoreCase("cycling"))
		{
			int seconds = (int)(Math.random()*301) + 500;  //产生从500到800的随机数
			return seconds;
		}
		else {
			return 0;
		}
	}
	//录入运动员信息
	public void readInput()
	{
		Athletes list = new Athletes(0,"",0,"");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter athlete unique ID: "); 
		list.setAthID(keyboard.nextInt());
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
