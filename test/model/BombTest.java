package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;

import view.MainView;
import controller.GameController;

public class BombTest {
	
	private GameController gc;
	private EntityManager manager;
	private Position position = new Position(200,300);

	@Before
	public void  setup() {
		gc = new GameController(); 
		manager = new EntityManager();
		
		
	}
	
	@Test
	 public void BombCreation() {
		MainView view = new MainView(manager,gc);
		Bomb bombtest =	new Bomb(position,manager);
		assertEquals(bombtest.getPosition(), new Position(200,300));
		
		
	}

}
