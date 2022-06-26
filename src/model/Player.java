package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

//Class For Player
public  class Player extends MovealeObject implements Observer {

	private int maxBomb =2;
	private int numberOfBombWasCreated=0;

	//Constructor
	public Player(Position position, EntityManager manager, Direction direction, int speed, int maxBomb,
			int numberOfBombWasCreated) {
		super(position, manager, direction, speed);
		this.maxBomb = 2;
		this.numberOfBombWasCreated = numberOfBombWasCreated;
		this.image = new ImageIcon("image/player.png").getImage();
	}

	//Chooses image of the Player by moving
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		switch (this.direction) {
		case N:
			g2.drawImage(new ImageIcon("image/playerUp.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
			break;
		case S:
			g2.drawImage(image, position.getX(), position.getY(), WIDTH, HEIGHT, null);
			break;
		case E:
			g2.drawImage(new ImageIcon("image/playerRight.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
			break;
		case W:
			g2.drawImage(new ImageIcon("image/playerLeft.png").getImage(), position.getX(), position.getY(), WIDTH,
					HEIGHT, null);
			break;
		default:
			break;
		}
	}

	//Changes the actual Position of player
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
			if (e instanceof Wall || e instanceof Brick || e instanceof Bomb || e instanceof Monster) {
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

	//Puts a bomb on the map
	public void putBomb() {
		if (numberOfBombWasCreated < maxBomb) {
			Bomb bomb = new Bomb(new Position(this.position.getX(), this.position.getY()), manager);
			manager.addEntity(bomb); 
			((Observable) bomb).addObserver(this);
			numberOfBombWasCreated++; 
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		numberOfBombWasCreated=1;
	}

	public void die(Player player) {
		manager.removeEntity(player);
		
	}

	//Bomb collision manager
	public List<Entity> getCollision() {
		List<Entity> listCollision = new ArrayList<>();

		Iterator<Entity> it = manager.getBoundsList(this).iterator();
		while (it.hasNext()) {
			Entity en = it.next();
			if (en instanceof Wall) {
				if (this.getBounds().intersects(en.getBounds())) {
				}
				
			}
		
		}
		return listCollision;
	}

	@Override
	public void startMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMove() {
		// TODO Auto-generated method stub
		
	}

}
