package model;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Wall extends Entity {

	//Wall Constructor
	public Wall(Position p,EntityManager en) {
		super(p,en);
		 image = new ImageIcon("image/wall2.png").getImage();
		
	}

	//draws the wall
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);
	
	}
}