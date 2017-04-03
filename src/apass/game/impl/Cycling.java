package apass.game.impl;

import apass.game.AbstractGame;

/**
 * Cyclng class
 * @author JinMing Liu s3596621
 *
 */
public class Cycling extends AbstractGame{

	public Cycling(String gameId) {
		super(gameId, "cycling");
	}

	/**
	 * Randomly generated seconds of cycling
	 */
	@Override
	public double compete() {
		return (double)(Math.random()*301) + 500;  //Generating random numbers from 500 to 800 
	}
}
