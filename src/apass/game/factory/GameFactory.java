package apass.game.factory;

import java.util.HashMap;
import java.util.Map;

import apass.enumeration.GameEnum;
import apass.game.AbstractGame;
import apass.game.impl.Cycling;
import apass.game.impl.Running;
import apass.game.impl.Swimming;

/**
 * ��Ϸ���� ��Ϊ��Ϸ����ѡ���� ÿ��ѡ��ͬһ����Ϸ��id��Ҫ�仯 ����ӾS01 S02
 * ����ͨ�������������Ϸ����
 * @author lkr
 *
 */
public class GameFactory {

	//���������Ϸ�ĵ�ǰ���� ����������Ϸid
	private  static Map<GameEnum, Integer> gameMap = new HashMap<GameEnum, Integer>(); 
	
	static{//��ʼ��Ϊ0
		for(GameEnum gameEnum : GameEnum.values()){
			gameMap.put(gameEnum, 0);
		}
	}
	
	/**
	 * ����ѡ�����Ϸ���ʹ�����Ϸ
	 * @param gameType
	 * @return
	 */
	public static AbstractGame createAGame(GameEnum gameType){
		
		int nowNum = 0;
		switch(gameType){
		  case SWIMMING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Swimming(gameType.getGameIdPre() + nowNum);
		  case RUNNIING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Running(gameType.getGameIdPre() + nowNum);
		  case CYCLING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Cycling(gameType.getGameIdPre() + nowNum);
		  default:
			  return null;
		}
	}
}
