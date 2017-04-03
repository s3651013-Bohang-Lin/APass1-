package apass.game.impl;

import apass.game.AbstractGame;

/**
 * Running class
 * @author JinMing Liu s3596621
 *
 */
public class Running extends AbstractGame{

	public Running(String gameId) {
		super(gameId, "running");
	}

	/**
	 * Randomly generated seconds of Running
	 */
	@Override
	public double compete() {
		return (double)Math.round(((Math.random()*11) + 10)*100)/100.0;  //Generating random numbers from 10 to 20 and keep two decimal places 
	}
}
