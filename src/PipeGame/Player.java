package PipeGame;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class Player extends JPanel {

	private String nick;

	private ArrayList<GeneratePiece> pieces = new ArrayList<>();

	private final int MAXPIECES = 8 * 8;
	private int id = 0;
	private int d = 0;
	private Game game;

	public Player(String nickname, Game game) {
		this.nick = nickname;
		this.game = game;
		setNewStack();
		refreshDraw();
	}
	
	
	private void setNewStack() {
		for (int i = 0; i < MAXPIECES; i++) {
			int o = ThreadLocalRandom.current().nextInt(3, 5 + 1);
			GeneratePiece p = getPiece(o);
			pieces.add(p);
		}
	}
	
	public void refreshDraw() {
		for (int i = 0; i < pieces.size(); i++) {
			GeneratePiece p = pieces.get(i);
			p.addMouseListener(new MouseAdapter() {
				
				public void mousePressed(MouseEvent e) {
					if(e.getButton() == MouseEvent.BUTTON3) {
						if(p.getID() == d) {
							p.setNewOrientation();
						}
					}
				}
				
			});
			if (i <= 4)
				add(p);
		}
	}

	private GeneratePiece getPiece(int id) {
		GeneratePiece p;
		switch (id) {
		case 3:
			p = new GeneratePiece(PieceType.LINE, 100, 100, game.getBoard(), this.id);

			break;
		case 4:
			p = new GeneratePiece(PieceType.CURVE, 100, 100, game.getBoard(), this.id);

			break;
		case 5:
			p = new GeneratePiece(PieceType.CROSS, 100, 100, game.getBoard(), this.id);

			break;
		default:
			return null;
		}
		this.id++;
		return p;
	}
	
	public void rotatePiece() {
		((GeneratePiece)pieces.get(0)).setNewOrientation();
	}
	
	public GenericPiece getFirstPiece() {
		GenericPiece currentPiece = pieces.get(0);
		pieces.remove(0);
		d++;
		clearAll();
		refreshDraw();
		revalidate();
		repaint();
		currentPiece.removeMouseListener(null);
		return currentPiece;
	}
	
	private void clearAll() {
		removeAll();
	}

}
