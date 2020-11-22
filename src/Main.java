import processing.core.PApplet;

public class Main extends PApplet {
		
	public int nRow;
	public int nCol;
	public int spessore;

	public int getNRow() {
		return this.nRow;
	}

	public int getNCol() {
		return this.nCol;
	}

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
		this.nRow = height/this.getSpessore();
		this.nCol = width/this.getSpessore();
		s = new Snake(this);
		f = new Food(this);
	}

	public void draw() {
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
		delay(200);
	}

	public void grid() {
		stroke(0);
		for (int i=1; i<20; i++) {
			line(i*this.getSpessore(), 0, i*this.getSpessore(), height);
			line(0, i*this.getSpessore(), width, i*this.getSpessore());
		}
	}

	public void mouseClicked() {
		s.add();
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
