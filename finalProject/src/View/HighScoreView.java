package View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HighScoreView {
    private Stage window;
    private Group root;
    private Scene scene;
    private GridPane highScores= new GridPane();

    public HighScoreView() {
        window = new Stage();
        root = new Group();
    }
    
    public void chooseFile () {
    window = new Stage();
    FileChooser fileChooser= new FileChooser();
    fileChooser.getExtensionFilters().addAll
    (new FileChooser.ExtensionFilter("TXT files (*.TXT)","*TXT"),
    		new FileChooser.ExtensionFilter("txt files (*.txt)","*txt"));
    File file=fileChooser.showOpenDialog(null);
    if (file!=null) {
    	try {
    		List<String> data=Files.readAllLines(file.toPath());
    		for (int i=0; (i<data.size()&&i<10); i++) {
    		    Text t= new Text(); 
    			t.setText(data.get(i));
    			highScores.addRow(i, t);
    		}
    	}
    		catch (IOException e) {
    			Logger.getLogger(HighScoreView.class.getName()).log(Level.SEVERE,null, e);
    		}
    	}
    
    highScores.setAlignment(Pos.CENTER);
    scene = new Scene(highScores,100,100);
	scene.setFill(Color.GRAY);
	window.setScene(scene);
	window.show();
    }
    
    public String enterName() {
    	String s="default name";
        TextInputDialog td = new TextInputDialog("enter any text");
        td.setHeaderText("enter your name");
        td.setTitle("High Score");
        Optional<String> result =td.showAndWait();;
        if (result.isPresent()){
        	s=result.get();
        }
        return s;
    }
}