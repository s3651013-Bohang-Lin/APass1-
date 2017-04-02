package apass.game.impl;

import apass.game.AbstractGame;
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
