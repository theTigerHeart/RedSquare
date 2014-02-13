package rSqurGame;

import java.awt.Color;
import java.awt.Graphics;

public class Instructions extends MouseButton { 
	public Instructions ( double X1, double Y1, double W, double H) {
		x1 = X1;
		y1 = Y1;
		w = W;
		h = H;
	}
	public void draw(Graphics g) {
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x1, (int)y1, (int)w, (int)h);
			g.setColor(Color.gray);
			g.fillRect( (int)x1 + 1, (int)y1 + 1, (int)w - 2, (int)h - 2);
			g.setColor(Color.BLACK);
			g.drawString( "Welcome" , (int)x1 + 5, (int)y1 + 13);
			g.drawString( "Controls:", (int)x1 + 5, (int)y1 + 28);
			g.drawString( "W = up.", (int)x1 + 6, (int)y1 + 43);
			g.drawString( "A = left.", (int)x1 + 6, (int)y1 + 58);
			g.drawString( "S = down.", (int)x1 + 6, (int)y1 + 73);
			g.drawString( "D = right.", (int)x1 + 6, (int)y1 + 88);
			
		}
	}
}
