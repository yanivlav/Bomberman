package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
//Class for monster objects
public class Monster extends MovealeObject implements Runnable {
	private Thread thread;

	//Monster Constructor
	public Monster(Position position, EntityManager manager, Direction direction, int speed) {
		super(position, manager, direction, speed);
		image = new ImageIcon("image/monster.png").getImage();
	}

	//Draws Monster
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);
	}

	//Moves The monster and checks for collisions  
	@Override
	public void move() {

		Rectangle rect = null;
		switch (this.direction) {
		case N:
			rect = new Rectangle(this.position.getX(), this.position.getY() - this.speed, WIDTH, HEIGHT);

			break;
		case S:
			rect = new Rectangle(this.position.getX(), this.position.getY() +this.speed, WIDTH, HEIGHT);

			break;
		case E:
			rect = new Rectangle(this.position.getX() +  this.speed, this.position.getY(), WIDTH, HEIGHT);

			break;
		case W:
			rect = new Rectangle(this.position.getX() -  this.speed, this.position.getY(), WIDTH, HEIGHT);

			break;

		default:
			break;
		}
		List<Entity> list = manager.getEntityFromBound(rect);
		System.out.println(list.toString());
		
		Iterator<Entity> listInRectangle = manager.getEntityFromBound(rect).iterator();
		while (listInRectangle.hasNext()) {
			Entity e = listInRectangle.next();
			if (e instanceof Wall || e instanceof Brick || e instanceof Bomb || e instanceof Monster || e instanceof Player) {
					return;
			}
		
		}
		switch (this.direction) {
		case N:
			this.position.decreateY(this.speed);
			break;
		case S:
			this.position.increateY(this.speed);
			break;
		case E:
			this.position.increateX(this.speed);
			break;
		case W:
			this.position.decreateX(this.speed);
			break;
		default:
			break;
		}
	}

	//auto moving as a new thread 
	@Override
	public void startMove() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	//stop moving as a new thread
	@SuppressWarnings("deprecation")
	@Override
	public void stopMove() {
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}

	
	//auto direction generator
	@Override
	public void run() {
		Random r = new Random();
		int times = 0;
		while (true) {
			
			setDirection(Direction.values()[r.nextInt(4)]);
			
			move();
			
			manager.notifyChanged();
			times++;
			if (times == 10) {
				this.setSpeed(this.speed * 1);
				times = 0;
			}
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
