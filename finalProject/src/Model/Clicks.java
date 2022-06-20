package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Clicks {
	private Click[] theClicks=new Click [4];
	private int numOfSelected=0;
	
	public Clicks (int x, int y,Rectangle r, Color c, int l) {
		theClicks[l]= new Click(x, y, r, c);
	}
	
	public Clicks () {
		for (int i=0; i<4;i++)
		theClicks[i]= new Click();
	}
	
	public Clicks (int n) {
		numOfSelected= n;
	}
	
	public Click[] getClick() {
		return theClicks;
	}
	
	public void setTheClicks(Click c,int l) {
	 theClicks[l]=c;
}
	
//	public void setNumOfSelected(int n) {
//		 numOfSelected=n;
//	}
    
    public boolean sameColor(int i, int j) {
        if (theClicks[i].getC().equals(theClicks[3-i].getC())){
        	return true;
        }
        else
        	return false;
    }
    
    public boolean sameX (int i, int j) {
    	if (theClicks[i].getX()==theClicks[j].getX()){
        	return true;
        }
        else
        	return false;
    }
    
    public boolean sameY (int i, int j) {
    	if (theClicks[i].getY()==theClicks[j].getY()){
        	return true;
        }
        else
        	return false;
    }
    
    public boolean legalPlay (){
    	int countX=1;
    	int countY=1;
    	int countColor=1;
    	int firstX=theClicks[0].getX();
    	int firstY=theClicks[0].getY();
    	Color firstColor=theClicks[0].getC();
    	for (int i=1; i<4;i++) {
            	if (firstX==theClicks[i].getX()){
            		countX++;
            	}
            	
            	if (firstY==theClicks[i].getY()){
            		countY++;
            	}
            	
            	if (firstColor==theClicks[i].getC()){
            		countColor++;
            	}
            }
        if (((countX==4)&&(countY==1))&&(countColor==4)) {
        	for (int i=1; i<4; i++) {
        		if ((firstY+i!=theClicks[i].getY())&&(firstY-i!=theClicks[i].getY()))
        			return false;
        	}
            return true;	
        }
        if (((countY==4)&&(countX==1))&&(countColor==4)) {
        	for (int i=1; i<4; i++) {
        		if ((firstX+i!=theClicks[i].getX())&&(firstX-i!=theClicks[i].getX()))
        			return false;
        	}
            return true;
        }
        if (((countY==2)&&(countX==2))&&(countColor==4)) {
            return true;
        }
        return false;
    }
    
    public int CalcArea() {
    	int area;
    	int length=0;
    	int height=0;
    	int maxL=0;
    	int maxH=0;
    	int firstX=theClicks[0].getX();
    	int firstY=theClicks[0].getY();
    	if ((theClicks[0].getX()==theClicks[1].getX())&&(theClicks[0].getX()==theClicks[2].getX())){
    		return 4;
    	}
    	if ((theClicks[0].getY()==theClicks[1].getY())&&(theClicks[0].getY()==theClicks[2].getY())){
    		return 4;
    	}
    	for (int i=1; i<4;i++) {
        	if ((firstX==theClicks[i].getX())&&(Math.abs(firstY-theClicks[i].getY())+1)>maxH){
        		height=Math.abs(firstY-theClicks[i].getY())+1;
        		maxH=height;
        	}
        	if ((firstY==theClicks[i].getY())&&(Math.abs(firstX-theClicks[i].getX())+1)>maxL){
        		length=Math.abs(firstX-theClicks[i].getX())+1;
        		maxL=length;
        	}
    	}
     	area=length*height;
        return area;
    }
    
    public void resetClicks () {
    	theClicks= new Click[4];
    }
}
