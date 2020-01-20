package asteroidgame;
/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Travis Downie
 */

import java.util.Random;
import java.awt.Point;
import java.lang.Math;
import blobz.BlobUtils;
import blobz.PolyBlob;

public class Asteroid extends PolyBlob {
	public static final Random random = new Random();
	public Asteroid(int x, int y, double r) {
		super(-100, -100, r);
		super.setDelta(x, y);
		int num_Sides = random.nextInt(5) + 5;
		int[] distance = new int[num_Sides];
		double[] angle = new double[num_Sides];
		double regSize = 2 * Math.PI / num_Sides;
		int i;
		for(i = 0; i < num_Sides; i++) {
			distance[i] = random.nextInt(11) + 5;
			angle[i] = (i * regSize) + (Math.random() * regSize);
		}
		Point[] point = new Point[num_Sides];
		for(i = 0; i < num_Sides; i++) {
		point[i] = BlobUtils.rotatePoint(distance[i], angle[i]);
		}
		setPolygon(point);
	}
}
