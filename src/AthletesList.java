import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class AthletesList {
	//private String[] subjects;
	private ArrayList<Athletes> list;
	private int num;
	private double[] randomNo = new double[num];
	private int Score;
	//private String[] athleteType;
	public AthletesList() {
		
		list = new ArrayList<Athletes>();
		Score = 0;
		num = 8;
		//athleteType = new String[4];
	}
	//�����˶�Ա��Ϣ
	public void addAthlete(int athID,String athName,int athAge,String athState)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState);
		list.add(info);
	}
	
	//�������������
	public void compete(String gameType)
	{
		double temp = 0;
		if (gameType.equalsIgnoreCase("running"))
		{
			for (int i = 0; i <= num; i++) //Ϊ�˺�������������������
			{
				double seconds = (double)(Math.random()*11) + 10;  //������10��20�������
				randomNo[i] = seconds;
				if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
			}
			
		}
		else if (gameType.equalsIgnoreCase("swimming"))
		{
			for (int i = 0; i <= num; i++)
			{
				double seconds = (double)(Math.random()*101) + 100;  //������100��200�������
				randomNo[i] = seconds;
				if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
			}
		}
		else if (gameType.equalsIgnoreCase("cycling"))
		{
			for (int i = 0; i <= num; i++)
			{
				double seconds = (double)(Math.random()*301) + 500;  //������500��800�������
				randomNo[i] = seconds;
				if (randomNo[i] < randomNo[i+1])// ð������
				{
					temp = randomNo[i];
			        randomNo[i] = randomNo[i+1];
			        randomNo[i+1] = temp;
				}
			}
		}
		else {
			System.out.println("no game");
		}
	}
	/*
	public String getScore()
	{
		return 
	}
	*/
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