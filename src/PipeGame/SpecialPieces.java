package PipeGame;

import java.awt.Window.Type;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class SpecialPieces extends GenericPiece {

	private int xBoard, yBoard;
	private Board board;
	private PieceType type;

	public SpecialPieces(PieceType type, int xBoard, int yBoard, Board board) {
		super(type.getColor(), type.getAbv(), board);
		this.board = board;
		this.type = type;
		setxBoard(xBoard);
		setyBoard(yBoard);
		this.xBoard = xBoard;
		this.yBoard = yBoard;
		setOrientation();
		setText(type.getAbv() + " " + type.getOrientation());
	}

	private void setOrientation() {
		int index = board.getIndex(xBoard, yBoard);
		boolean run = true;
		Random rnd = new Random();
		int o = rnd.nextInt(3);
		type.setOrientation(o);
	}

}
