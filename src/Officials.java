import java.util.Scanner;
public class Officials extends Participates {
	
	public Officials(String offiID,String offiName,int offiAge,String offiState, String gameType)
	{
		super(offiID, offiName, offiAge, offiState, gameType);
	}
	//overriding ����get set ����
		public String getOffiID() {
			return super.getUniqueID();
		}
		public void setOffiID(String athID) {
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
		public String getGameType(){ //¼����������������
			return super.getType();
		}
		public void setGameType(String gameType){
			super.setType(gameType);
		}
		
	
}
