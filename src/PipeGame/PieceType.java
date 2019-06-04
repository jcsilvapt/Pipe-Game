package PipeGame;

import java.awt.Color;

public enum PieceType {

	EMPTY(0, "empty", "NORTH", Color.GRAY),
	START(1, "start", "NORTH", Color.BLUE),
	END(2, "end", "NORTH", Color.RED),
	LINE(3, "line", "NORTH", Color.GREEN),
	CURVE(4, "curve", "NORTH", Color.ORANGE),
	CROSS(5, "cross", "NORTH", Color.BLACK);
	
	private int ID, curOrientation;
	private String abv, orientation;
	private String Ori[] = {"NORTH", "SOUTH", "EAST" , "WEST" };
	private int OriID[] = {0, 1, 2, 3};
	private Color color;
	
	PieceType(int id, String abv, String orientation, Color color) {
		this.ID = id;
		this.abv = abv;
		this.orientation = Ori[OriID[0]];
		this.curOrientation = OriID[0];
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getAbv() {
		return abv;
	}
	
	public String getOrientation() {
		return orientation;
	}
	
	public void setOrientation(int ori) {
		orientation = Ori[ori];
	}
	
	public void setOrientation() {
		switch (curOrientation) {
		case 0:
			this.orientation = Ori[1];
			this.curOrientation = 1;
			break;
		case 1:
			this.orientation = Ori[2];
			this.curOrientation = 2;
			break;
		case 2:
			this.orientation = Ori[3];
			this.curOrientation = 3;
			break;
		case 3:
			this.orientation = Ori[0];
			this.curOrientation = 0;
		default:
			break;
		}
	}
	
}
