package View;


import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameView {
	private Stage primaryStage;
	private Group root;
	private Scene scene;
	private BorderPane bp;
	private Button b1= new Button("Level 1");
	private Button b2= new Button("Level 2");
	private Button b3= new Button("Level 3");
	private Button b4= new Button("Reset Game");
	private Button b5= new Button("High Scores");
	private Text score;
	private GridPane drawPane;
	public Color[] colors = {Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED, Color.MEDIUMPURPLE,
			Color.MAGENTA, Color.ORANGE,Color.BLACK,};
	public enum Levels {Level1,Level2,Level3,};
	public Levels currentChoice= Levels.Level1;
	public File highScores;
	/*private HighScoreView theHSView;*/
	
	public GameView(Stage stage) {
		primaryStage = stage;
		root = new Group();
		createBoardPane();
		scene = new Scene(bp,500,500);
		scene.setFill(Color.GRAY);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

    public Text getScore() {
        return score;
    }
    
    public Button getResetGameButton() {
        return b4;
    }
    
    public Button getLevel1Button() {
        return b1;
    }
    
    public Button getLevel2Button() {
        return b2;
    }
    
    public Button getLevel3Button() {
        return b3;
    }
    
    public Button getHighScoresButton() {
        return b5;
    } 
    
    public GridPane getColoredChessBoard() {
        return drawPane;
    }
    
    public File getHighScoresFile() {
        return highScores;
    }
    
    public Levels getCurrentChoice() {
        return currentChoice;
    } 
    
    public void setScore(String s) {
        score.setText(s);
    }
    
    public void setCurrentChoice(Levels l) {
    	currentChoice=l;
    }
    
    private Node createButtons() {
    	VBox vbLeft = new VBox();
		vbLeft.getChildren().addAll(b4,b1,b2,b3);
		vbLeft.setAlignment(Pos.CENTER_LEFT);
		vbLeft.setPadding(new Insets(0,0,0,75));
		return vbLeft;
    }
    
    private Node createTitle() {
		Text title = new Text("Colors Game");
		HBox topBox = new HBox();
		topBox.setPadding(new Insets(15,0,15,0));
		topBox.getChildren().add(title);
		topBox.setAlignment(Pos.CENTER);
		return topBox; 
    }
    
    private Node createScores() {
		Text cureentScore = new Text("Current Score:");
		score = new Text ("0");
		HBox cScore = new HBox();
		cScore.setPadding(new Insets(25,75,0,0));
		cScore.getChildren().addAll(cureentScore, score);
		cScore.setAlignment(Pos.TOP_CENTER);
	
		VBox vbHighScores= new VBox();
		vbHighScores.getChildren().add(b5);
		vbHighScores.setAlignment(Pos.TOP_CENTER);
		vbHighScores.setPadding(new Insets(275,75,0,0));
		
		VBox vbAllScores = new VBox();
		vbAllScores.getChildren().addAll(cScore,vbHighScores);
		return vbAllScores;
    }
    
    public Node createBoardPane() {
		bp = new BorderPane();
		bp.setLeft(createButtons());
		bp.setRight(createScores());
		bp.setTop(createTitle());
		LevelsClicked(currentChoice);
		bp.setCenter(getColoredChessBoard());
		return bp;
    }
    
    public void setCenterOfBoardPane() {
		bp.setCenter(getColoredChessBoard());
    }
	
    public void setGrid(int size,int num_of_col) {
		drawPane = new GridPane();
		double s=100;
		drawPane.getChildren().clear();
		for (int i=0; i<size;i++) {
			for (int j=0; j<size; j++) {
				Rectangle r=new Rectangle(s,s,s,s);
				r.setFill(colors[(int)(Math.random()*num_of_col)]);
				r.setStroke(Color.BLACK);
				drawPane.add(r, j, i);
			}
			
		}
		
		drawPane.setAlignment(Pos.CENTER);
	}
    
		//Set Board By Levels
		public void LevelsClicked(Levels type) {
			switch(type) {
			case Level1:
				setGrid (6, 6);
				break;
			case Level2:
				setGrid (7, 7);
				break;
			case Level3:
				setGrid(8, 8);
				break;
			}
		}
		
		public int newColor(Levels type) {
			switch(type) {
			case Level1:
				return 6;
			case Level2:
				return 7;
			case Level3:
				return 8;
			}
			return 1;
		}
		
		/*public void updateHighScoreParameter(HighScoreFile hs) {
			theHSView.updateHighScoreParameters(hs);
			theHSView.show(drawPane);
		}
		
		public void addScore(int s) {
			score.setText(Integer.toString(s));
		}*/
}

