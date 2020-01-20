package asteroidgame;
/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Travis Downie
 */

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.BlobUtils;
import blobz.PolyBlob;
import blobz.SandBox;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {

	private double angle = 0.0; 
	private final double delta = 0.15; 
	private final double speed = 5.0;
	static SandBox sandbox;
	public Rocket(int x, int y, SandBox sb) {
		super(x, y, 0);
		Point[] point = {
				new Point(9, 0),
				new Point(-9, -1),
				new Point(-9, 1),
				new Point(-4, -9),
				new Point(-4, 9),
				new Point(-7, -2),
				new Point(-7, 2),
				new Point(-1, -2),
				new Point(-1, 2)
		};
		setPolygon(point);
		setColor(Color.blue);
		sandbox = sb;
	}
	public void keyAction(KeyEvent e) {
		if(e.getKeyCode() == 39) {
			angle = angle + delta;
			if(angle > 2 * Math.PI) {
				angle = angle - 2 * Math.PI;
			}
			setAngle(angle);
		}
		if(e.getKeyCode() == 37) {
			angle = angle - delta;
			if(angle < 0) {
				angle = angle + 2 * Math.PI;
			}
			setAngle(angle);
		}
		if(e.getKeyCode() == 38) {
			int xloc = getLoc().x;
			int yloc = getLoc().y;
			xloc = xloc + (int) Math.round(speed * Math.cos(angle));
			yloc = yloc + (int) Math.round(speed * Math.sin(angle));
			setLoc(xloc, yloc);
		}
		if(e.getKeyCode() == 32) {
			Launch(sandbox);
			BlobUtils.playSound();
		}
	}
	public void Launch(SandBox sb) {
		int br = (getSize())/2;
		int distance = br + 5;
		Point np = BlobUtils.rotatePoint(distance, angle);
		Point Lp = new Point(getLoc().x + np.x, getLoc().y + np.y);
		Missile missile = new Missile(Lp.x, Lp.y, angle);
		sb.addBlob(missile);
	}
}
