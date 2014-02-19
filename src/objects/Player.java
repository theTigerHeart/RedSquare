package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x;
	private int y;
	private int width;
	private int height;
	private double vx;
	private double vy;

	public Player(int x, int y, int width, int height, double vx, double vy) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
	}

	public Color getColor() {
		return Color.RED;//This will be changed to produce blueshift once I work out the relativity.
	}

	public void progress(double dt) {
		x += (int)(vx * dt + 0.5);
		y += (int)(vy * dt + 0.5);
	}

	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(getColor());
		g.fillRect(x + 1, y + 1, width - 2, height - 2);
	}
}
