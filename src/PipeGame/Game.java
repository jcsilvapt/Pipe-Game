package PipeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;

public class Game {

	private JFrame frame;
	
	private Board board;
	private Player player;
	
	private MouseListener mouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		board = new Board(this);
		player = new Player("Teste", this);
		initialize();
	}
	
	public MouseListener getMouse() {
		return mouse;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 607, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Content = new JPanel();
		Content.setBounds(10, 5, 581, 534);
		frame.getContentPane().add(Content);
		Content.setLayout(null);
		
		JPanel PlayerHolder = new JPanel();
		PlayerHolder.setBounds(0, 402, 581, 132);
		Content.add(PlayerHolder);
		PlayerHolder.setBorder(new TitledBorder(null, "Next Piece", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PlayerHolder.setLayout(null);
		player.setBounds(6, 18, 569, 103);
		PlayerHolder.add(player);
		board.setBounds(0, 0, 581, 391);
		Content.add(board);
		board.setMinimumSize(new Dimension(10, 1));
		board.setMaximumSize(new Dimension(10, 1));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnHome.add(mntmNewGame);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnHome.add(mntmQuit);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getPlayer() {
		return player;
	}
}
