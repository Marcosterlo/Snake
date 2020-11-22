public class Point {
	
	private int x;
	private int y; 

	public Point() {
		this.setX(0);
		this.setY(0);
	}

	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Point somma(Point altro) {
		return new Point(this.getX() + altro.getX(), this.getY() + altro.getY());
	}

	public boolean equals(Point altro) {
		return this.getX() == altro.getX() && this.getY() == altro.getY();
	}
}
