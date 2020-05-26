package StarFighter;
//(c) A+ Computer Science


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for(Ammo a: ammo) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for(Ammo a: ammo) {
			a.move("UP");
		}
	}

	public void cleanEmUp()
	{
		
		List<Ammo> ammoRemove = new ArrayList<Ammo>();
		for(Ammo am : ammo) {
			if(am.getY() + am.getHeight() <= 0) {
				ammoRemove.add(am);
			}
		}
		ammo.removeAll(ammoRemove);
	}

	public List<Ammo> getList()
	{
		return ammo;
	}
	public void removeAll(List<Ammo> bullets){
		ammo.removeAll(bullets);
	}
	
	public String toString()
	{
		return "";
	}
}