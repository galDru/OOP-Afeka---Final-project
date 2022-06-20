package Model;

import java.io.PrintWriter;

import javafx.scene.paint.Color;

public class Score {
	private int score;
	private String name;
	
	
	public Score(int s, String str) {
		score = s;
		name = str;
		
	}
	
	public Score (String s) {
		name = s;
	}
	
	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String str) {
		 name=str;
	}
	
	public void setScore(Score s) {
		 score=s.score;
		 name=s.name;
	}
	
	public void updateScore (int newScore) {
        score=getScore() + newScore;
    }
	
	public int resetScore () {
		score=0;
        return score;
    }
	
	public String toString(int i) {
		return "place : "+i+", name: "+name+", score: "+score;
	}
}
