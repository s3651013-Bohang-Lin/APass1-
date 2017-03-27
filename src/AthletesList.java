import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
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
	public void addAthlete(String athID,String athName,int athAge,String athState,String athType)
	{
		Athletes info = new Athletes(athID, athName, athAge, athState, athType);
		list.add(info);
	}
	

	//增加四种运动员，// 加在 athletelist
	/*
		public void addType()
		{
			  
	        list.add("swimmers");  
	        list.add("cyclists");  
	        list.add("sprinters");
	        list.add("superAthletes"); //get(3) 调用
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
    /**
     * read a file from the local fold..
     */
    
    public ArrayList<Athletes> readFile()
    {
        String fileName = "athletes.txt";
       // ArrayList<Student> files = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader inputFile = new FileReader(file);
            Scanner parser = new Scanner(inputFile);

            while(parser.hasNextLine()) // judge whether the next row is empty
            {
                String line = parser.nextLine();
                String[] lineParts = line.split(",");
                String athID = lineParts[0];
                String athName = lineParts[1];
                int athAge = Integer.parseInt(lineParts[2]);
                String athState = lineParts[3];
                String athType = lineParts[4];
                Athletes athlete = new Athletes(athID, athName, athAge, athState, athType);
                list.add(athlete);
            }
            inputFile.close();
        }
        catch(IOException e) //Capture the IO exception
        {
            System.out.println(fileName + "Can Not be Loaded.");
        }
        return list;
    }

    
    /**
     *write in details in a file from the local fold..
     */
    public void writeFile(ArrayList<Athletes> list)
    {
        String fileName = "athletes.txt";
        try
        {
            PrintWriter outPrinter = new PrintWriter(fileName);
            for(Athletes athlete : list) 
            {
                outPrinter.println(athlete.getAthID() + "," + athlete.getAthName() + "," 
            + athlete.getAthAge() + "," + athlete.getAthState() + "," + athlete.getAthType());
            }
            outPrinter.close();
        }
        catch(IOException e)
        {
            System.out.println(fileName + "Cannot Be Saved. ");
        }
    }

}