import processing.core.PApplet;

public class Main extends PApplet {
		
	public int spessore;
	private int gamemode;
	private int highscore;

	public int getSpessore() {
		return this.spessore;
	}

	Snake s;
	Food f;
	Point up = new Point(0, -1);
	Point down = new Point(0, 1);
	Point right = new Point(1, 0);
	Point left = new Point(-1, 0);

	public void settings() {
		size(400, 400);		
		this.spessore = 20;
		this.gamemode = 1;
		s = new Snake(this);
		f = new Food(this, s);
	}

	public void draw() {
		switch(gamemode) {
			case 0:
				background(64);
				grid();
				s.step();
				f.step();
				// interaction between snake and food
				if (s.getAct().equals(f.getAct())) {
					s.add();
					f.setEaten(true);
				}
				s.render();
				f.render();
				if (s.getGameOver()) {
					this.gamemode = 1;
					//s.restart();
					break;
				}
				delay(150);
				break;
			case 1:
				// Entry window
				rect(100, 100, 100, 100, 7);	
				if (mousePressed) {
					this.gamemode = 0;
				}
				break;
		}
	}

	public void grid() {
		stroke(0);
		for (int i=1; i<20; i++) {
			line(i*this.getSpessore(), 0, i*this.getSpessore(), height);
			line(0, i*this.getSpessore(), width, i*this.getSpessore());
		}
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				if (s.getVel().equals(right) || s.getVel().equals(left)) {
					s.setVel(0, -1);	
				}					
			}
			if (keyCode == DOWN) {
				if (s.getVel().equals(right) || s.getVel().equals(left)) {
					s.setVel(0, 1);	
				}					
			}
			if (keyCode == RIGHT) {
				if (s.getVel().equals(up) || s.getVel().equals(down)) {
					s.setVel(1, 0);	
				}
			}
			if (keyCode == LEFT) {
				if (s.getVel().equals(up) || s.getVel().equals(down)) {
					s.setVel(-1, 0);
				}					
			}
		}
	}

	public static void main(String args[]) {
		PApplet.main("Main");		
	}
}
