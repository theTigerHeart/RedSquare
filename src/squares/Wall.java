package squares;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends rSqurGame.Object{
	public Wall( double Wx, double Wy, double Ww, double Wh) {
		x = Wx;
		y = Wy;
		with = Ww;
		hite = Wh;
		boolean right = true;
		boolean up = true;
		boolean goal = false;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, (int)with, (int)hite);
	}
}
