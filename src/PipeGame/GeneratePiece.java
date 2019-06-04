package PipeGame;

import java.awt.Dimension;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GeneratePiece extends GenericPiece {

	private int size = 105;
	
	private PieceType type;
	private int id;
	
	public GeneratePiece(PieceType type, int xBoard, int yBoard, Board board, int id) {
		super(type.getColor(), type.getAbv(), board);
		this.type = type;
		this.id = id;
		setxBoard(xBoard);
		setyBoard(yBoard);
		setMinimumSize(new Dimension(size , size));
		setMaximumSize(new Dimension(size,size));
		setPreferredSize(new Dimension(size,size));
		if (type.getID() != 0) {
			setText(type.getAbv() + " " +type.getOrientation());
			setHorizontalTextPosition(SwingConstants.CENTER);
		}

	}
	
	public void setNewOrientation() {
		type.setOrientation();
		setText(type.getAbv() + " " +type.getOrientation());
	}
	
	public int getID() {
		return id;
	}

}
