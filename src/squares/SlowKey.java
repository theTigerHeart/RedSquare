package squares;

import java.awt.Color;
import java.awt.Graphics;

public class SlowKey extends rSqurGame.Object{
	public SlowKey( double Wx, double Wy, double Ww, double Wh, int SX, int SY, 
					double drx1, double dry1, double drx2, double dry2, int USE, int SD) {
		x = Wx;
		y = Wy;
		with = Ww;
		hite = Wh;
		sX = SX;
		sY = SY;
		dx1 = drx1;
		dy1 = dry1;
		dx2 = drx2;
		dy2 = dry2;
		timeLag = -2;
		use = USE;
		sD = SD;
		boolean right = true;
		boolean up = true;
		boolean on = true;
	}
	public void draw(Graphics g){
		Color grape = new Color(130, 50, 180);
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x, (int)y, (int)with, (int)hite);
			g.setColor(Color.yellow);
			g.fillRect((int)x + 1, (int)y + 1, (int)with - 2, (int)hite - 2);
			if(time >= timeLag + 2 ){
				g.setColor(grape);
			}else{
				g.setColor(Color.black);
			}
			g.fillRect((int)x + 4, (int)y + 4, (int)with - 8, (int)hite - 8);
		}
	}
}
