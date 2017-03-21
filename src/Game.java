import java.util.*;

public class Game {
	private static int ID; //只在constructor 调用
	private Officials offi;//裁判
	private int popu;  //运动员人数
	private String name; //项目名
	private ArrayList<String> type;
	
	public Game()
	{
		ID += 1;
		name = "";
		//offi = Officials.getOff();
		popu = 1;
		type = new ArrayList<String>();
	}
	//增加swimming
	public void swimList()
	{
		type.add("swimming");
	}
	//增加cycling项目
	public void cycList()
	{
		type.add("cycling");
	} 
	//增加running项目
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
