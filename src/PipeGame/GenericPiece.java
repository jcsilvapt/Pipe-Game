package PipeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class GenericPiece extends JLabel{

	
	private Board board;
	
	private int xBoard, yBoard;
	private int size = 1;
	private String abv;
	
	public GenericPiece(Color color, String abv, Board board) {
		this.board = board;
		this.abv = abv;
		setMinimumSize(new Dimension(size , size));
		setMaximumSize(new Dimension(size,size));
		setPreferredSize(new Dimension(size,size));
		setOpaque(true);
		setBackground(color);
		setForeground(Color.white);
		setVisible(true);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(e.getComponent() instanceof GenericPiece) {
						GenericPiece p = ((GenericPiece) e.getComponent());
						if(p.getAbv().equals("empty")) {
							board.setPlaceAt(p.getxBoard(), p.getyBoard());
						}
					}
				}
			}
		});
	}

	public int getxBoard() {
		return xBoard;
	}

	public void setxBoard(int xBoard) {
		this.xBoard = xBoard;
	}

	public int getyBoard() {
		return yBoard;
	}

	public void setyBoard(int yBoard) {
		this.yBoard = yBoard;
	}
	
	public String getAbv() {
		return abv;
	}
	
}
