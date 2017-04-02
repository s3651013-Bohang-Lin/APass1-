package apass.participates.impl;

import apass.participates.Participates;



public class Athletes extends Participates {
	
	private Integer scores = 0;
	
	public Integer getScores() {
		return scores;
	}

	public void setScores(Integer scores) {
		this.scores = scores;
	}

	public Athletes(String athID,String athName,int athAge,String athState, String athType)
	{
		super(athID, athName, athAge, athState, athType);
		
	}
	
	public Athletes()
	{
		this("","",0,"","");
		
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
	public String getAthType(){
		return super.getType();
	}
	public void setAthType(String athType){
		super.setType(athType);
	}
	 /**
     * @return The Id, name, age and state together.
     */
    public String getDetails()
    {
		return "ID:" + getAthID() + " Name:" + getAthName() + "  age:" + getAge()
		+ " state:" + getAthState() + " type:"+getAthType();
    }
    
    @Override
    public String toString(){
    	return getDetails();
    }
}
