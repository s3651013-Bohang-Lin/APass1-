package apass.game.factory;

import java.util.HashMap;
import java.util.Map;

import apass.enumeration.GameEnum;
import apass.game.AbstractGame;
import apass.game.impl.Cycling;
import apass.game.impl.Running;
import apass.game.impl.Swimming;

/**
 * 游戏工厂 因为游戏可以选择多个 每次选则同一种游戏则id需要变化 如游泳S01 S02
 * 所以通过工厂类进行游戏创建
 * @author lkr
 *
 */
public class GameFactory {

	//保存各种游戏的当前数量 用于生成游戏id
	private  static Map<GameEnum, Integer> gameMap = new HashMap<GameEnum, Integer>(); 
	
	static{//初始化为0
		for(GameEnum gameEnum : GameEnum.values()){
			gameMap.put(gameEnum, 0);
		}
	}
	
	/**
	 * 根据选择的游戏类型创建游戏
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
