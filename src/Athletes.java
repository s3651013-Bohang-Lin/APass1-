
import java.util.ArrayList;
import java.util.Scanner;

public class Athletes extends Participates {
	ArrayList<String> type;
	
	
	public Athletes(int athID,String athName,int athAge,String athState)
	{
		super(athID, athName, athAge, athState);
		type = new ArrayList<String>();
	}
	public Athletes()
	{
		this(0,"",0,"");
	}

	//增加四种运动员
	
	public void addType()
	{
		  
        type.add("swimmers");  
        type.add("cyclists");  
        type.add("sprinters");
        type.add("superAthletes"); //get(3) 调用
	}
	//overriding 所有get set 方法
	public int getAthID() {
		return super.getUniqueID();
	}
	public void setAthID(int athID) {
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
		super.setAge(age);;
	}
	public String getAthState() {
		return super.getState();
	}
	public void setAthState(String state) {
		super.setState(state);
	}
	
	/*
	public String  getName(int y)
	{
		return super.getName();
	}
	*/
}
