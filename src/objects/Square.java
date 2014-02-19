package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int x;
	private int y;
	private int width;
	private int height;
	private double vx;
	private double vy;
	private Color color;
	private boolean collidable;

	public Square(int x, int y, int width, int height, double vx, double vy, Color color, boolean collidable) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
		this.collidable;
	}

	public Color getColor() {
		return color;//This will changed to produce blueshift once I work out the relativity.
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void progress(double dt) {
		x += (int)(vx * dt + 0.5);
		y += (int)(vy * dt + 0.5);
	}

	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	public void onHit() {
	}

	public boolean collides() {
		return collidable;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);
	}
}
