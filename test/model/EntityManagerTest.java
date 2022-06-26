package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Observable;

import org.junit.jupiter.api.Test;

import controller.GameController;
import view.MainView;

import org.junit.Before;


class EntityManagerTest extends Observable{

	private List<Entity> list;
	private Player player1;
	private MainView view;
	
	@Before
	public void  setup() {
		
	}
	
	@Test
	void CreatingANewPlayer() {
	//	player1 = new Player(new Position(50, 100), this, Direction.N, 50, 5, 0);
	}

}
