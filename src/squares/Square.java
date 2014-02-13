package squares;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends rSqurGame.Object { 
	public Square( double X, double Y, double WITH, double HITE, double VX, double VY) {
		x = X;
		y = Y;
	    with = WITH;
	    hite = HITE;
	    Vx = VX;
	    Vy = VY;
	}
	public void draw(Graphics g){
		Color blueShift = new Color(red, green, blue);
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, (int)with, (int)hite);
		g.setColor(blueShift);
		g.fillRect((int)x + 1, (int)y + 1, (int)with - 2, (int)hite - 2);
	}
}
