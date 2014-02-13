package rSqurGame;

import java.awt.Color;
import java.awt.Graphics;

public class DodgeBlock extends Object {
	public DodgeBlock( double Wx, double Wy, double Ww, double Wh, double VX, double VY) {
		x = Wx;
		y = Wy;
		with = Ww;
		hite = Wh;
		Vx = VX;
		Vy = VY;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, (int)with, (int)hite);
	}
}
