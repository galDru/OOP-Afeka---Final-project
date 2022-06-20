package Model;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Click {
	private int oldX;
	private int oldY;
	private Color oldC;
	private Rectangle r;
	
	public Click(int x,int y, Rectangle r, Color c) {
		oldX = x;
		oldY = y;
		oldC=c;
		this.r=r;
	}
	
	public Click() {
		oldX=0;
		oldY=0;
		oldC=Color.BLACK;
	}

	public int getX() {
		return oldX;
	}
	
	public int getY() {
		return oldY;
	}
	
	public Color getC() {
		return oldC;
	}
	
	public Rectangle getR() {
		return r;
	}
	
	
	public void setX(int x) {
		 oldX=x;
	}
	
	public void setY(int y) {
		 oldY=y;
	}
	
	public void setC(Color c) {
		 oldC=c;
	}
	
	public void setR(Rectangle r) {
		 this.r= r;
	}
	
	public void changeRColor(Color c) {
		 this.r.setFill(c);
	}
	
}
