
import java.util.ArrayList;
import java.util.Scanner;

public class Athletes extends Participates {
	ArrayList<String> type;// 加在 athletelist
	
	
	public Athletes(String athID,String athName,int athAge,String athState)
	{
		super(athID, athName, athAge, athState);
		type = new ArrayList<String>();
	}
	public Athletes()
	{
		this("","",0,"");
	}

	//增加四种运动员，// 加在 athletelist
	
	public void addType()
	{
		  
        type.add("swimmers");  
        type.add("cyclists");  
        type.add("sprinters");
        type.add("superAthletes"); //get(3) 调用
	}
	//overriding 所有get set 方法
	public String getAthID() {
		return super.getUniqueID();
	}
	public void setAthID(String athID) {
		super.setUniqueID(athID);
	}
	public String getAthName() {
		return super.getName();
	}
	public void setAthName(String name) {
		super.setName(name);
	}
	public int getAthAge() {
		return super.getAge();
	}
	public void setAthAge(int age) {
		super.setAge(age);
	}
	public String getAthState() {
		return super.getState();
	}
	public void setAthState(String state) {
		super.setState(state);
	}
	 /**
     * @return The Id, name, age and state together.
     */
    public String getDetails()
    {
		return "Athletes ID:" + getAthID() + " Name: " + getAthName() + "  age: " + getAge()
		+ " state: " + getAthState();
    }
    
    /**
     * @set The Id, name, age and state together.
     */
    /*
    private void setDetails(int athID,String athName,int athAge,String athState)
    {
        
    }*/
	/*
	public String  getName(int y)
	{
		return super.getName();
	}
	*/
}
