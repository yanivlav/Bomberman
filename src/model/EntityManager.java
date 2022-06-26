package model;

import view.MainView;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

public class EntityManager extends Observable {
	private List<Entity> list;
	private Player player1;
	private MainView view;
	

	//EntityManager Constructor - manage and adds all objects to list to be drawn on map
	public EntityManager() {

		
		player1 = new Player(new Position(50, 100), this, Direction.N, 50, 5, 0);

		this.list = new Vector<>();
		
		//left wall
		list.add(new Wall(new Position(0, 0), this));
		list.add(new Wall(new Position(0, 50), this));
		list.add(new Wall(new Position(0, 100), this));
		list.add(new Wall(new Position(0, 150), this));
		list.add(new Wall(new Position(0, 200), this));
		list.add(new Wall(new Position(0, 250), this));
		list.add(new Wall(new Position(0, 300), this));
		list.add(new Wall(new Position(0, 350), this));
		list.add(new Wall(new Position(0, 400), this));
		list.add(new Wall(new Position(0, 450), this));
		list.add(new Wall(new Position(0, 500), this));
		list.add(new Wall(new Position(0, 550), this));
		list.add(new Wall(new Position(0, 600), this));
		
		//right wall
		list.add(new Wall(new Position(700, 0), this));
		list.add(new Wall(new Position(700, 50), this));
		list.add(new Wall(new Position(700, 100), this));
		list.add(new Wall(new Position(700, 150), this));
		list.add(new Wall(new Position(700, 200), this));
		list.add(new Wall(new Position(700, 250), this));
		list.add(new Wall(new Position(700, 300), this));
		list.add(new Wall(new Position(700, 350), this));
		list.add(new Wall(new Position(700, 400), this));
		list.add(new Wall(new Position(700, 450), this));
		list.add(new Wall(new Position(700, 500), this));
		list.add(new Wall(new Position(700, 550), this));
		list.add(new Wall(new Position(700, 600), this));

		//up wall
		list.add(new Wall(new Position(600, 0), this));
		list.add(new Wall(new Position(550, 0), this));
		list.add(new Wall(new Position(650, 0), this));
		list.add(new Wall(new Position(450, 0), this));
		list.add(new Wall(new Position(500, 0), this));
		list.add(new Wall(new Position(400, 0), this));
		list.add(new Wall(new Position(350, 0), this));
		list.add(new Wall(new Position(300, 0), this));
		list.add(new Wall(new Position(250, 0), this));
		list.add(new Wall(new Position(200,0), this));
		list.add(new Wall(new Position(150, 0), this));
		list.add(new Wall(new Position(100, 0), this));
		list.add(new Wall(new Position(50, 0), this));
		list.add(new Wall(new Position(700, 0), this));
		
		//down wall
		list.add(new Wall(new Position(600, 600), this));
		list.add(new Wall(new Position(550, 600), this));
		list.add(new Wall(new Position(650, 600), this));
		list.add(new Wall(new Position(450, 600), this));
		list.add(new Wall(new Position(500, 600), this));
		list.add(new Wall(new Position(400, 600), this));
		list.add(new Wall(new Position(350, 600), this));
		list.add(new Wall(new Position(300, 600), this));
		list.add(new Wall(new Position(250, 600), this));
		list.add(new Wall(new Position(200,600), this));
		list.add(new Wall(new Position(150, 600), this));
		list.add(new Wall(new Position(100, 600), this));
		list.add(new Wall(new Position(50, 600), this));
		list.add(new Wall(new Position(700, 600), this));
		
		//brick line #1
		list.add(new Brick(new Position(100, 100), this));
		list.add(new Brick(new Position(100, 200), this));
		list.add(new Brick(new Position(100, 300), this));
		list.add(new Brick(new Position(100, 400), this));
		list.add(new Brick(new Position(100, 500), this));
		
		//brick line #2
		list.add(new Brick(new Position(200, 100), this));
		list.add(new Brick(new Position(200, 200), this));
		list.add(new Brick(new Position(200, 300), this));
		list.add(new Brick(new Position(200, 400), this));
		list.add(new Brick(new Position(200, 500), this));
	
		//brick line #3
		list.add(new Brick(new Position(300, 100), this));
		list.add(new Brick(new Position(300, 200), this));
		list.add(new Brick(new Position(300, 300), this));
		list.add(new Brick(new Position(300, 400), this));
		list.add(new Brick(new Position(300, 500), this));
		
		//brick line #4
		list.add(new Brick(new Position(400, 100), this));
		list.add(new Brick(new Position(400, 200), this));
		list.add(new Brick(new Position(400, 300), this));
		list.add(new Brick(new Position(400, 400), this));
		list.add(new Brick(new Position(400, 500), this));
		
		//brick line #5
		list.add(new Brick(new Position(500, 100), this));
		list.add(new Brick(new Position(500, 200), this));
		list.add(new Brick(new Position(500, 300), this));
		list.add(new Brick(new Position(500, 400), this));
		list.add(new Brick(new Position(500, 500), this));
		
		//brick line #6
		list.add(new Brick(new Position(600, 100), this));
		list.add(new Brick(new Position(600, 200), this));
		list.add(new Brick(new Position(600, 300), this));
		list.add(new Brick(new Position(600, 400), this));
		list.add(new Brick(new Position(600, 500), this));

		//monsters
		list.add(new Monster(new Position(600, 550), this, Direction.N, 50));
		list.add(new Monster(new Position(500, 50), this, Direction.N, 50));
		list.add(new Monster(new Position(300, 150), this, Direction.N, 50));
		list.add(new Monster(new Position(100, 250), this, Direction.N, 50));
		

	}

	public synchronized void addEntity(List<Entity> list) {
		this.list.addAll(list);
		notifyChanged();
	}

	public synchronized void addEntity(Entity e) {
		this.list.add(e);
		notifyChanged();
	}

	public void removeEntity(Entity e) {
		this.list.remove(e);
		notifyChanged();
	}

	public void removeEntity(List<Entity> list) {
		this.list.removeAll(list);
		notifyChanged();
	}

	public void removePlayer(Player player) {
		this.deleteObserver(player);
		notifyChanged();
	}

	//bounds manager for entities
	public List<Entity> getEntityFromBound(Rectangle getbound) {
		List<Entity> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBounds().equals(getbound)) {
				res.add(list.get(i));
			}
		}
		if (player1.getBounds().equals(getbound)) {
			res.add(player1);
		}
		return res;
	}
	
	//draws each entity on the list + player
	public void draw(Graphics g) {
		player1.draw(g);
		//player2.draw(g);

		Iterator<Entity> itr = list.iterator();
		while (itr.hasNext()) {
			Entity e = itr.next();
			e.draw(g);
		}
	}

	public int size() {
		return list.size();
	}

	//checks collision for all entities
	public synchronized void collisionable() {
		List<Entity> listCollision = new Vector<>();
		for (Entity entity : list) {
			listCollision.addAll(entity.getCollision());
		}
		listCollision.addAll(player1.getCollision());
		list.removeAll(listCollision);

	}

	//player set direction and initiate movement 
	public void move(Direction direction) {
		player1.setDirection(direction);
		player1.move();
		notifyChanged();
		System.out.println(player1.position.getX() + "  " + player1.position.getY());
	}

	public void putBomb() {
		player1.putBomb();
	}

	// start movement of monsters
	public void startMoveableObject() {
		Iterator<Entity> itr = list.iterator();
		while (itr.hasNext()) {
			Entity entity = itr.next();
			if (entity instanceof MovealeObject)
				((MovealeObject) entity).startMove();
		}
	}

	

	public void notifyChanged() {
		setChanged();
		notifyObservers();
	}

	public List<Entity> getList() {
		return list;
	}

	//Bounds manager
	public List<Entity> getBoundsList(Entity entity) {
		List<Entity> list = new Vector<>();
		Iterator<Entity> itr = this.list.iterator();
		while (itr.hasNext()) {
			Entity e = itr.next();
			if (e.getBounds().intersects(entity.getBounds())) {
				list.add(e);
			}
		}
		if (this.player1.getBounds().intersects(entity.getBounds()))
			list.add(player1);
	
		return list;

	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player) {
		this.player1 = player;
	}
	 public void gameOverSystem(){
		 view.gameOver();
	
	 }
}
