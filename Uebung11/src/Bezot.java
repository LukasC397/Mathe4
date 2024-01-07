public class Bezot {
	int x;
	int y;
	int g;

	public Bezot(int x, int y, int g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	@Override
	public String toString() {
		return "Bezot{" + "x=" + x + ", y=" + y + ", g=" + g + '}';
	}
}