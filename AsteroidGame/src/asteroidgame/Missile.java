package asteroidgame;

/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Travis Downie
 */

import java.awt.Color;

import blobz.Blob;
import blobz.BlobProximity;

public class Missile extends Blob implements BlobProximity {

	public Missile(int x, int y, double a) {
		super(x, y, Color.yellow);
		int speed = 5;
		int dx = (int)Math.round(speed * Math.cos(a));
		int dy = (int)Math.round(speed * Math.sin(a));
		setDelta(dx, dy);
	}
}
