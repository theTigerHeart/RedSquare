package rSqurGame;

import java.awt.Color;
import java.awt.Graphics;

public class MenuCounter extends Object{
	public MenuCounter( double X, double Y) {
		x = X;
		y = Y;
	}
	public void draw(Graphics g) {
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x, (int)y, 90, 53);
			g.setColor(Color.gray);
			g.fillRect( (int)x + 1, (int)y + 1, 88, 51);
			g.setColor(Color.BLACK);
			g.drawString( "deaths: " + RedSquare.TotalDeaths, (int)x + 3, (int)y + 12);
			g.drawString( "time: " + RedSquare.TimePlayed, (int)x + 3, (int)y + 25);
			g.drawString( "last: " + RedSquare.Last, (int) x +3, (int)y + 38);
			g.drawString( "best: " + RedSquare.HighScore, (int) x +3, (int)y + 51);
		}
	}
}
