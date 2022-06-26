package controller;

import java.awt.event.KeyEvent;



import model.Direction;
import model.EntityManager;
import view.MainView;

public class GameController {
	EntityManager entityManger;
	MainView view;
	
	//GameController Constructor
	public GameController() {
		entityManger = new EntityManager();
		view = new MainView(entityManger, this);
	}

	//starts movable objects
	public void start() {
		entityManger.startMoveableObject();
	}
	
	//keyboard listening for movement and bomb for player
	public void keyRelease(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			entityManger.move(Direction.N);
			break;
		case KeyEvent.VK_LEFT:
			entityManger.move(Direction.W);
			break;
		case KeyEvent.VK_DOWN:
			entityManger.move(Direction.S);
			break;
		case KeyEvent.VK_RIGHT:
			entityManger.move(Direction.E);
			break;
		case KeyEvent.VK_SPACE:
			entityManger.putBomb();
			break;

		default:
			break;
		}
	}
	

	

}
