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
	//�����˶�Ա��Ϣ
	public void addAthlete(String athID,String athName,int athAge,String athState,String athType)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState, athType);
		list.add(info);
	}
	

	//���������˶�Ա��// ���� athletelist
	/*
		public void addType()
		{
			  
	        list.add("swimmers");  
	        list.add("cyclists");  
	        list.add("sprinters");
	        list.add("superAthletes"); //get(3) ����
		}
*/
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
	//¼���˶�Ա��Ϣ
	public void readInput()
	{
		Athletes list = new Athletes("","",0,"","");
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
		athleteList.get(1).getName();//��ȡ����1��λ���˶�Ա������
	}*/
}