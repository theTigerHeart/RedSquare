package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Activated {
	private int x;
	private int y;
	private int width;
	private int height;
	private double vx;
	private double vy;
	private int borderWidth;
	private Color borderColor;
	private Color color;

	public Activated(int x, int y, int width, int height, double vx, double vy, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
		borderWidth = 0;
		borderColor = Color.BLACK;
	}

	public Activated(int x, int y, int width, int height, int borderWidth, double vx, double vy, Color color, Color borderColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
		this.borderWidth = borderWidth;
		this.borderColor = borderColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void progress(double dt) {
		x += (int)(vx * dt + 0.5);
		y += (int)(vy * dt + 0.5);
	}

	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	public void onHit(Player playerContext, RedSquare gameContext) {
	}

	public void draw(Graphics g) {
		g.setColor(getBorderColor());
		g.fillRect(x, y, width, height);
		g.setColor(getColor());
		g.fillRect(x + borderWidth, y + borderWidth, width - 2 * borderWidth, height - 2 * borderWidth);
	}
}
