package PipeGame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Board extends JPanel {

	private Game game;
	private final int nCols = 8, nRows = 8;
	private int size = 1;
	ArrayList<GenericPiece> pieces = new ArrayList<>();

	public Board(Game game) {
		this.game = game;
		setBeginning();		
		refreshDraw();
		setStart();
		setEnd();

	}
	
	public void refreshDraw() {
		setLayout(new GridLayout(nRows, nCols, 1, 1));
		setMinimumSize(new Dimension(size , size));
		setMaximumSize(new Dimension(size,size));
		setPreferredSize(new Dimension(size,size));
		for (int cols = 0; cols < nCols; cols++) {
			for (int rows = 0; rows < nRows; rows++) {
				add(pieces.get(getIndex(rows, cols)));
			}
		}
	}
	
	private void setBeginning() {
		for (int cols = 0; cols < nCols; cols++) {
			for (int rows = 0; rows < nRows; rows++) {
				pieces.add(new GeneratePiece(PieceType.EMPTY, rows, cols, this, 0));
			}
		}
	}

	private void setStart() {
		Random rnd = new Random();
		int x = rnd.nextInt((6 - 1) + 1) + 1;
		int y = rnd.nextInt((6 - 1) + 1) + 1;
		int index = getIndex(x, y);
		pieces.remove(index);
		remove(index);
		pieces.add(index, new SpecialPieces(PieceType.START, x, y, this));
		add(new SpecialPieces(PieceType.START, x, y, this), index);
	}

	private void setEnd() {
		Random rnd = new Random();
		boolean run = true;
		while (run) {
			int x = rnd.nextInt((6 - 1) + 1) + 1;
			int y = rnd.nextInt((6 - 1) + 1) + 1;
			int index = getIndex(x, y);
			GenericPiece v = pieces.get(index);
			if (v.getAbv().equals("empty") && !v.getAbv().equals("start")) {
				pieces.remove(index);
				remove(index);
				pieces.add(index, new SpecialPieces(PieceType.END, x, y, this));
				add(new SpecialPieces(PieceType.END, x, y, this), index);
				run = false;
			}
		}
	}

	public int getIndex(int x, int y) {
		return y * nCols + x;
	}

	public Component getPlaceAt(int xBoard, int yBoard) {
		int index = getIndex(xBoard, yBoard);
		return getComponent(index);
	}
	
	public void setPlaceAt(int xBoard, int yBoard) {
		int index = getIndex(xBoard, yBoard);
		Player pla = game.getPlayer();
		pieces.set(index, pla.getFirstPiece());
		clearDraw();
		refreshDraw();
		revalidate();
		repaint();
	}
	
	private void clearDraw() {
		removeAll();
	}
}
