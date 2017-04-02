package apass.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apass.participates.impl.Athletes;
import apass.participates.impl.Officials;
/**
 * ��Ϸ������  �ṩͨ�õ���Ϊ �Լ�һЩ��Ҫ������ȥ����ʵ�ֵĳ��󷽷�
 * @author Bohang Lin
 *
 */
public abstract class AbstractGame {

	private String gameId;     //��Ϸid
	private String gameName;   //��Ϸ����
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();  //���ÿ���˶�Ա�ĳɼ�map  key���˶�Ա�б�id  value�ųɼ�����
	private Officials offi;				  //����     ÿ����Ϸ��һ������
	private List<Athletes> athlets;       //�μӵ��˶�Ա
	
	public AbstractGame(String gameId, String gameName) {
		super();  
		this.gameId = gameId;
		this.gameName = gameName;
		this.offi = new Officials(gameId+"Off", gameName+"Off", 30, "", gameName);
	}
	
	public Officials getOffi() {
		return offi;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setOffi(Officials offi) {
		this.offi = offi;
	}
	public List<Athletes> getAthlets() {
		return athlets;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public Map<String, Double> getAthletsSecondResult() {
		return athletsSecondResult;
	}
	public void setAthletsSecondResult(Map<String, Double> athletsSecondResult) {
		this.athletsSecondResult = athletsSecondResult;
	}
	public void setAthlets(List<Athletes> athlets) {
		this.athlets = athlets;
	}
	
	/**
	 * ����ɼ��ķ��� ÿ����Ϸ��һ�� ������Ҫ��ʵ����ʵ���������
	 */
	public abstract double compete();   
	
	/**
	 * ��ʼ�����Ϸ  �����ε�������ɼ��������� ����ÿ���˶�Ա�ĳɼ�  
	 * ���浽map�� �������ѯʹ��
	 */
	public void runGame(){
		for(Athletes athlete : athlets){
			double seconds = compete();
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
	}
	
	/**
	 * չʾ�μ��˸���Ϸ�������˶�Ա�ɼ�
	 * ͨ����ѯ�ɼ����map
	 */
	public void displayAthletsResults(){
		System.out.println("game ��ID:"+this.getGameId() + ", name:"+this.gameName+"��");
		for(Athletes ath : athlets){
			double second = athletsSecondResult.get(ath.getAthID());//hashMap
			System.out.println(ath+" "+ second +"s");
		}
	}
	
	
}
