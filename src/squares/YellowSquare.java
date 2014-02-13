package squares;

import java.awt.Color;
import java.awt.Graphics;

public class YellowSquare extends rSqurGame.Object {
	public YellowSquare( double Wx, double Wy, double Ww, double Wh, double VX, double VY, double drx1, double dry1, double drx2, double dry2) {
		x = Wx;
		y = Wy;
		with = Ww;
		hite = Wh;
		Vx = VX;
		Vy = VY;
		dx1 = drx1;
		dy1 = dry1;
		dx2 = drx2;
		dy2 = dry2;
		boolean right = true;
		boolean up = true;
	}
	public void draw(Graphics g){
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, (int)with, (int)hite);
		g.setColor(Color.yellow);
		g.fillRect((int)x + 1, (int)y + 1, (int)with - 2, (int)hite - 2);
	}
}
