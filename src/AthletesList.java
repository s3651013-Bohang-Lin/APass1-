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
	//�����˶�Ա��Ϣ
	public void addAthlete(int athID,String athName,int athAge,String athState)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState);
		list.add(info);
	}
	
	//�����������
	public int compete(String gameType)
	{
		if (gameType.equalsIgnoreCase("running"))
		{
			int seconds = (int)(Math.random()*11) + 10;  //������10��20�������
			return seconds;
		}
		else if (gameType.equalsIgnoreCase("swimming"))
		{
			int seconds = (int)(Math.random()*101) + 100;  //������100��200�������
			return seconds;
		}
		else if (gameType.equalsIgnoreCase("cycling"))
		{
			int seconds = (int)(Math.random()*301) + 500;  //������500��800�������
			return seconds;
		}
		else {
			return 0;
		}
	}
	//¼���˶�Ա��Ϣ
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
		athleteList.get(1).getName();//��ȡ����1��λ���˶�Ա������
	}*/
}
