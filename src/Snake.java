import processing.core.PApplet;
import java.util.ArrayList;

public class Snake {
	
	private PApplet sketch;
	private Point act;
	private Point head[];
	private ArrayList<Point> body;
	private Point vel;
	private boolean gameOver = false;

	// 2 ArrayLists for the coordinates:
	// the head list will contain the 2 coordinates of the actual head in the first 2 indexes
	// and the 2 previous coordinates in the indexes 2 and 3
	//
	// The  body ArrayList will contain the body coordinates
	// I will have to make the first piece have the previous coordinates of the head
	// I have to implement a shift mechanism in order to make the snake move

	public Snake() {}

	public Snake(PApplet sketch) {
		this.sketch = sketch;
		this.head = new Point[2];
		this.body = new ArrayList<>();
		this.act = new Point(20/2, 20/2);
		this.head[0] = this.act;
		this.vel = new Point(1, 0);
	}

	public Point getAct() {
		return this.act;
	}

	public int getSize() {
		return this.body.size();
	}

	public Point getVel() {
		return this.vel;
	}

	public void setVel(int xv, int yv) {
		if (xv == 0 || xv == 1 || xv == -1) {
			this.vel.setX(xv);
		}
		if (yv == 0 || yv == 1 || yv == -1) {
			this.vel.setY(yv);
		}
	}

	public void add() {
		Point n = this.head[1];
		this.body.add(0, n);
	}

	public void step() {
		if (!this.gameOver) {
			this.head[1] = this.head[0];
			this.act = this.act.somma(this.vel);
			this.head[0] = this.act;
			for (Point p : this.body) {
				if (p.equals(this.head[0])) {
					this.gameOver = true;
				}
			}
			if (this.act.getX() < 0 || this.act.getX() >= 20 || this.act.getY() < 0 || this.act.getY() >= 20) {
				this.gameOver = true;
			}
			// body part
			if (this.body.size() == 1) {
				this.body.set(0, this.head[1]);
			}
			else if (this.body.size() > 1) {
				for (int i=this.body.size()-1; i>0; i--) {
					this.body.set(i, this.body.get(i-1));	
				}	
				this.body.set(0, this.head[1]);
			}
		}	
	}

	public void render() {
		if (this.gameOver) {
			sketch.noLoop();
			System.out.println("Game over");
		}
		sketch.fill(0, 0, 255);
		this.sketch.rect(this.act.getX() * 20, this.act.getY() * 20, 20, 20, 7);
		// body part
		for (Point p : this.body) {
			this.sketch.rect(p.getX() * 20, p.getY() * 20, 20, 20, 7);
		}
	}
}
