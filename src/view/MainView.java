package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import controller.GameController;
import model.EntityManager;

public class MainView extends JFrame implements Observer {

	private static final long serialVersionUID = -5739494728315815061L;
	EntityManager entityManger;
	GameController gameController;
	JPanel mainContent;
	

	public MainView(EntityManager entityManager, GameController gameController) {
		super();
		
		this.entityManger = entityManager;
		this.gameController = gameController;
		((Observable) entityManager).addObserver(this);
		mainContent = new JPanel() {

			private static final long serialVersionUID = 579656472431881086L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				entityManager.collisionable();

				entityManger.draw(g);//Draws the map objects
			}
		};
		mainContent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				gameController.keyRelease(e.getKeyCode());
			}
		});
		mainContent.setFocusable(true);
		getContentPane().add(mainContent, BorderLayout.CENTER);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		menuBar.add(menu);


		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem scoreTable = new JMenuItem("Score Table");
		JMenuItem exit = new JMenuItem("Exit");
		
		menu.add(newGame);
		menu.add(scoreTable);
		menu.add(exit);
		
		exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	                System.exit(0);
	        }
	    });
		

		getContentPane().add(menuBar, BorderLayout.NORTH);



		//window application properties 
		this.setSize(770, 690);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Bombameer");
		
		//if start game was chosen
		gameController.start();

	}

	public void initView() {

	}

	@Override
	public void update(Observable o, Object arg) {
		mainContent.repaint();
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		
		
	}
}
