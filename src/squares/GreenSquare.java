package squares;

import java.awt.Color;
import java.awt.Graphics;

public class GreenSquare extends rSqurGame.Object{
	public GreenSquare( double Wx, double Wy, double Ww, double Wh, double VX, double VY, double drx1, double dry1, double drx2, double dry2, int USE) {
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
		use = USE;
		timeLag = -2;
		boolean right = true;
		boolean up = true;
	}
	public void draw(Graphics g) {
		Color Oj = new Color( 255, 100, 50);
		Color darkOj = new Color( 150, 30, 0);
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x, (int)y, (int)with, (int)hite);
			if( time >= timeLag + 2) {
				g.setColor(Oj);
			}else{
				g.setColor(darkOj);
			}
			g.fillRect((int)x + 1, (int)y + 1, (int)with - 2, (int)hite - 2);
		}
	}
}
