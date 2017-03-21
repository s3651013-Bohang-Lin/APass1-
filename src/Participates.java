
public abstract class Participates {
	private int uniqueID;
	private String name;
	private int age;
	private String state;
	
	public Participates(int ID, String Name, int Age, String State)
	{
		setUniqueID(ID);
		setName(Name);
		setAge(Age);
		setState(State);
	}
	public int getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
