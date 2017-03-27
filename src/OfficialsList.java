import java.util.*;
import java.io.*;
public class OfficialsList {
	private ArrayList<Officials> officiallist;
	
	public OfficialsList()
	{
		officiallist = new ArrayList<Officials>();
	}
	
	   /**
     * read a file from the local fold..
     */
    
    public ArrayList<Officials> readFile()
    {
        String fileName = "officials.txt";
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
                String offiID = lineParts[0];
                String offiName = lineParts[1];
                int offiAge = Integer.parseInt(lineParts[2]);
                String offiState = lineParts[3];
                String gameType = lineParts[4];
                Officials official = new Officials(offiID, offiName, offiAge, offiState, gameType);
                officiallist.add(official);
            }
            inputFile.close();
        }
        catch(IOException e) //Capture the IO exception
        {
            System.out.println(fileName + "Can Not be Loaded.");
        }
        return officiallist;
    }

    
    /**
     *write in details in a file from the local fold..
     */
    public void writeFile(ArrayList<Officials> files)
    {
        String fileName = "students.txt";
        try
        {
            PrintWriter outPrinter = new PrintWriter(fileName);
            for(Officials official : officiallist) 
        
            {
                outPrinter.println(official.getOffiID() + "," + official.getOffiName() + "," 
            + official.getOffiAge() + "," + official.getOffiState() + "," + official.getGameType());
            }
            outPrinter.close();
        }
        catch(IOException e)
        {
            System.out.println(fileName + "Cannot Be Saved. ");
        }
    }

}
