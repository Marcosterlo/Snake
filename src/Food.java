import processing.core.PApplet;

public class Food {

	private	PApplet sketch;
	private Point act;
	private Snake s;
	private boolean eaten;

	public Food(PApplet sketch, Snake s) {
		this.sketch = sketch;
		this.s = s;
		this.act = new Point((int) sketch.random(0, 20), (int) sketch.random(0, 20));
		this.eaten = false;
	}

	public Point getAct() {
		return this.act;
	}

	public boolean getEaten() {
		return this.eaten;
	}

	public void setEaten(boolean val) {
		this.eaten = val;			
	}

	public void reassign() {
		this.act.setX((int) sketch.random(0, 20)); 			
		this.act.setY((int) sketch.random(0, 20)); 			
	}

	public void step() {
		if (this.getEaten()) {
			int coex = 1;
			while (coex == 1) {
				this.reassign();
				int check = 0;
				for (Point p : s.getBody()) {
					if (!this.act.equals(p)) {
						check++;
					}
				}
				if (check == s.getBody().size() && !(this.act.equals(s.getHead()[0]))) {
					coex = 0;
				}
			}
			this.setEaten(false);
		}
	}

	public void render() {
		this.sketch.fill(255, 0, 0);
		this.sketch.rect(this.act.getX() * 20, this.act.getY() * 20, 20, 20, 7);
	}
}
