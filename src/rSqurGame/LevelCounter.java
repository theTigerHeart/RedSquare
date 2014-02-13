package rSqurGame;

import java.awt.Color;
import java.awt.Graphics;

public class LevelCounter extends Object{
	public LevelCounter( double X, double Y) {
		x = X;
		y = Y;
	}
	public void draw(Graphics g) {
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x, (int)y, 80, 40);
			g.setColor(Color.gray);
			g.fillRect( (int)x + 1, (int)y + 1, 78, 38);
			g.setColor(Color.BLACK);
			g.drawString( "deaths: " + RedSquare.Deaths, (int)x + 3, (int)y + 12);
			g.drawString( "time: " + RedSquare.Time, (int)x + 3, (int)y + 25);
			g.drawString( "total: " + RedSquare.TotalDeaths, (int) x +3, (int)y + 38);
		}
	}
}
