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

	public Square(int x, int y, int width, int height, double vx, double vy, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
	}

	public Color getColor() {
		return color;
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

	public void onHit(Player p) {
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);
	}
}
