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

	public void step() {
		if (this.getEaten()) {
			this.act.setX((int) sketch.random(0, 20)); 			
			this.act.setY((int) sketch.random(0, 20)); 			
			this.setEaten(false);
		}
	}

	public void render() {
		this.sketch.fill(255, 0, 0);
		this.sketch.rect(this.act.getX() * 20, this.act.getY() * 20, 20, 20, 7);
	}
}
