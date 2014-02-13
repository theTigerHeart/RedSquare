package squares;

import java.awt.Color;
import java.awt.Graphics;

public class PurpleSquare extends rSqurGame.Object {
	public PurpleSquare( double Wx, double Wy, double Ww, double Wh, double VX, double VY, double drx1, double dry1, double drx2, double dry2, int USE) {
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
		Color grape = new Color(130, 50, 180);
		Color darkGrape = new Color(60, 0, 100);
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x, (int)y, (int)with, (int)hite);
			if( time >= timeLag + 2) {
				g.setColor(grape);
			}else{
				g.setColor(darkGrape);	
			}
			g.fillRect((int)x + 1, (int)y + 1, (int)with - 2, (int)hite - 2);
		}
	}
}