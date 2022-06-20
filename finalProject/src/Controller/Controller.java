package Controller;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Model.Click;
import Model.Clicks;
import Model.HighScores;
import Model.Model;
import View.HighScoreView;
import View.View;
import View.View.Levels;
	
public class Controller {
	private View view;
	private Model model;
	private int numOfClicks=0;
	private Clicks newClicks;
	private HighScores hs= new HighScores();

	public Controller(Model m, View v) {
		model = m;
		view = v;
		setView(view);
	}
		
	private void setView(View view) {
		//link Model with View
		view.setScore(String.valueOf(model.getScore().resetScore()));
    	hs.createFile();
        startGame(view);
		
        //link Controller to View - methods for buttons
		view.getResetGameButton().setOnAction(e->{
			//New Game-Default=Level 1
			endGame(view);
			view.LevelsClicked(view.getCurrentChoice());
			view.setCenterOfBoardPane();
			newClicks.resetClicks();
			numOfClicks=0;
	        startGame(view);
		});
		view.getLevel1Button().setOnAction(e->{
			//Level 1
			endGame(view);
			view.setCurrentChoice(Levels.Level1);
			view.LevelsClicked(view.getCurrentChoice());
			view.setCenterOfBoardPane();
			newClicks.resetClicks();
			numOfClicks=0;
	        startGame(view);
		});
		view.getLevel2Button().setOnAction(e->{
			//Level 2
			endGame(view);
			view.setCurrentChoice(Levels.Level2);
			view.LevelsClicked(view.getCurrentChoice());
			view.setCenterOfBoardPane();
			newClicks.resetClicks();
			numOfClicks=0;
	        startGame(view);
		});
		view.getLevel3Button().setOnAction(e->{
			//Level 3
			endGame(view);
			view.setCurrentChoice(Levels.Level3);
			view.LevelsClicked(view.getCurrentChoice());
			view.setCenterOfBoardPane();
			newClicks.resetClicks();
			numOfClicks=0;
	        startGame(view);
		});
		view.getHighScoresButton().setOnAction(e->{
			//High Score Board
			//choose the file from path D:\eclipse\finalProject\src\Model
			HighScoreView hsv=new HighScoreView();
			hsv.chooseFile();
		});
	}
	
	private void startGame(View view) {
		newClicks= new Clicks();
		for (Node r : view.getColoredChessBoard().getChildren()) {
			r.setOnMouseClicked(e -> {
				numOfClicks++;
				// create new clicks
				// add rectangle to model
				// check number of clicks
				// if under 4 clicks - change color
				// if 4 clicks - check if rectangle
				// if rectangle - calculate surface area (width + height), change all colors of surface area rectangle
				// if not rectangle - change back the colors of the rectangles (selected)
				
				// reset model
				// reset array of clicks + num of clicks
				
				// if high score
				Rectangle rectangle = (Rectangle) r;
				Color color = (Color) rectangle.getFill();
				int row_index = GridPane.getRowIndex(r);
				int col_index = GridPane.getColumnIndex(r);
				Click c=new Click(row_index, col_index,rectangle, color);
				newClicks.setTheClicks(c, numOfClicks-1);
				if (numOfClicks-1<3) {
					rectangle.setFill(color.desaturate());
					rectangle.setStroke(Color.WHITE);
				}
				else {
					if (newClicks.legalPlay()){
						backToNormal(view);
						endTurn(view);
						newClicks.resetClicks();
						numOfClicks=0;
					}
					else {
						backToNormal(view);
						newClicks.resetClicks();
						numOfClicks=0;
					}
				}
			});
		}
    }
        
    private void endGame(View view) {
		HighScoreView hsv=new HighScoreView();
		model.getScore().setName(hsv.enterName());
    	hs.updateScoreFile(model.getScore());
    	hs.updateScoreFile(model.getScore());
        view.setScore(String.valueOf(model.getScore().resetScore())); 
    }
        
    private void endTurn(View view) {
    	int size;
    	model.getScore().updateScore(newClicks.CalcArea());
    	view.setScore(String.valueOf(model.getScore().getScore()));
    	size=view.newColor(view.getCurrentChoice());
    	for (int i=0; i<4; i++) {
    		newClicks.getClick()[i].changeRColor(view.colors[(int)(Math.random()*size)]);
    	}
		view.setCenterOfBoardPane();
    }
    private void backToNormal (View view) {
    	for (int i=0; i<4; i++) {
    		Color c;
    		c=(Color) newClicks.getClick()[i].getR().getFill();
			newClicks.getClick()[i].getR().setFill(c.saturate());
			newClicks.getClick()[i].getR().setStroke(Color.BLACK);
    	}
    }
}