package asteroidgame;

/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Travis Downie
 */

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI {
	public static void main(String[] args) {
		new AsteroidGame(Integer.parseInt(args[0]));
	}
	static int asteroids;
	static SandBox sandbox = new SandBox();
	Random random = new Random();
	public AsteroidGame(int parseInt) {
		asteroids = parseInt;
		sandbox.setSandBoxMode(SandBoxMode.FLOW);
		sandbox.setFrameRate(15);
		sandbox.init(this);
	}
	public void generate() {
		int height = sandbox.getPanelBounds().height;
		int width = sandbox.getPanelBounds().width;
		Rocket rocket = new Rocket(width / 2, height / 2, sandbox);
		sandbox.addBlob(rocket);
		int i;
		for(i = 0; i < asteroids; i++ ) {
		int xvelocity = 0, yvelocity = 0; 
		double rotation = 0;
		while(xvelocity == 0){
			xvelocity = random.nextInt(7) - 3;
		}
		while(yvelocity == 0) {
			yvelocity = random.nextInt(7) - 3;
		}
		while(rotation < 0.1 && rotation > -0.1) {
			rotation = random.nextFloat() * 1.2 - 0.1;
		}
		Asteroid asteroid = new Asteroid(xvelocity, yvelocity, rotation);
		((SandBox) sandbox).addBlob(asteroid);
		}
	}
}
