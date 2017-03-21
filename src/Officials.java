import java.util.Scanner;
public class Officials extends Participates {
	
	public Officials(int offiID,String offiName,int offiAge,String offiState)
	{
		super(offiID, offiName, offiAge, offiState);
	}
	//overriding 所有get set 方法
		public int getOffiID() {
			return super.getUniqueID();
		}
		public void setOffiID(int athID) {
			super.setUniqueID(athID);
		}
		public String getOffiName() {
			return super.getName();
		}
		public void setOffiName(String name) {
			super.setName(name);
		}
		public int getOffiAge() {
			return super.getAge();
		}
		public void setOffiAge(int age) {
			super.setAge(age);;
		}
		public String getOffiState() {
			return super.getState();
		}
		public void setOffiState(String state) {
			super.setState(state);
		}
		
	
}
