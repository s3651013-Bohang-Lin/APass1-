import java.util.*;

public class Game {
	private static int ID; //ֻ��constructor ����
	private Officials offi;//����
	private int popu;  //�˶�Ա����
	private String name; //��Ŀ��
	private ArrayList<String> type;
	
	public Game()
	{
		ID += 1;
		name = "";
		//offi = Officials.getOff();
		popu = 1;
		type = new ArrayList<String>();
	}
	//����swimming
	public void swimList()
	{
		type.add("swimming");
	}
	//����cycling��Ŀ
	public void cycList()
	{
		type.add("cycling");
	} 
	//����running��Ŀ
	public void runList()
	{
		type.add("running");
	}
	
	/*
	public void record()
	{
		offi.getArray().add(mess)
	}
	*/
}
