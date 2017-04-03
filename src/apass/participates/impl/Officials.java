package apass.participates.impl;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import apass.game.AbstractGame;
import apass.participates.Participates;
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
		
		
		public void calScores(AbstractGame game){
			
			List<Athletes> athletes = game.getAthlets();
			Map<String, Double> athletsSecondResult = game.getAthletsSecondResult();
			for(Athletes ath : athletes){
			    Double seconds = athletsSecondResult.get(ath.getAthID());
			    if(seconds == null){//�������˶�Աû�гɼ� ���������Ϸδ���л�����ԭ�� �ó�������ͳ�Ʒ���
			    	continue;
			    }
			    int ranking = 1; //���� Ĭ�ϵ�һ��
			    for(Entry<String, Double> entry : athletsSecondResult.entrySet()){
			    	if(entry.getKey() == ath.getAthID()){
			    		continue;  //�����Լ�
			    	}
			    	
			    	if(entry.getValue() < seconds){ //�������˱��Լ���
			    		ranking ++;
			    	}
			    }
			    
			    if(ranking == 1){
			    	ath.setScores(ath.getScores() + 5);
			    }
			    if(ranking == 2){
			    	ath.setScores(ath.getScores() + 2);
			    }
			    if(ranking == 3){
			    	ath.setScores(ath.getScores() + 1);
			    }
			}
			
		}
		
	    public String getDetails()
	    {
			return "ID:" + this.getOffiID() + " Name:" + this.getOffiName() + "  age:" + this.getAge()
			+ " state:" + this.getOffiState();
	    }
	    
	    @Override
	    public String toString(){
	    	return getDetails();
	    }
}
