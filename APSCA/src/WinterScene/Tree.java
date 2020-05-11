package WinterScene;

import java.awt.Color;
import java.awt.Graphics;

public class Tree extends AbstractShape{

	public Tree(int x, int y, int wid, int ht, Color col) {
		super(x, y, wid, ht, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics window) {
		// TODO Auto-generated method stub
		 int[] x = {super.getXPos(),(int)(super.getXPos()*2.5),(int)(super.getXPos()/5)};
		   int[] y = {super.getXPos(),super.getXPos()*5,super.getXPos()*5};
		   int z = x.length;
		   window.setColor(Color.green);
		   window.fillPolygon(x,y,z);
	}

	@Override
	public void moveAndDraw(Graphics window) {
		// TODO Auto-generated method stub
		draw(window);
	}

}

