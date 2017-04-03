package apass.game.impl;

import apass.game.AbstractGame;

/**
 * Swimming class
 * @author JinMing Liu s3596621
 *
 */
public class Swimming extends AbstractGame{

	public Swimming(String gameId) {
		super(gameId, "swimming");
	}

	/**
	 * Randomly generated seconds of Swimming
	 */
	@Override
	public double compete() {
		return (double)(Math.random()*101) + 100;  //Generating random numbers from 100 to 200 
	}


}
