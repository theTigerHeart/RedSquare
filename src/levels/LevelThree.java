package levels;

import java.awt.Color;
import java.awt.Graphics;

public class LevelThree extends rSqurGame.MouseButton {
	public LevelThree(double X1, double Y1, double W, double H) {
		x1 = X1;
		y1 = Y1;
		w = W;
		h = H;
	}
	public void draw(Graphics g){
		if( on == true) {
			g.setColor(Color.black);
			g.fillRect((int)x1, (int)y1, (int)w, (int)h);
			g.setColor(Color.gray);
			g.fillRect((int)x1 + 1, (int)y1 + 1, (int)w - 2, (int)h - 2);
			g.setColor(Color.black);
			g.drawString("Level Three", (int)x1 + 6, (int)y1 + 14);
			
	}
}


}
