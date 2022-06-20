package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighScores {
	private static final String FilePath = "D:\\eclipse\\finalProject\\src\\Model\\high scores.txt";
	private File file;
	private ArrayList<Score> scores= new ArrayList <Score>();
	
	public HighScores() {
		file= new File(FilePath);
		scores= new ArrayList<>();
	}
	
	public HighScores (File f, ArrayList<Score> s) {
		scores=s;
		file=f;
	}
	
	public void createFile() {
		//create file for score
		try {
			file = new File(FilePath);
			if (file.createNewFile()==false) {
				file.delete();
				file = new File(FilePath);			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateScoreFile(Score s) {
		try {
			FileWriter writer = new FileWriter(file, false);
			List<String> lines = Files.readAllLines(file.toPath());
			scores.add(s);
			sortArray();
			if (lines.size() >= 10) {
				removeMin();
			}
			writeToFile(writer);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToFile(FileWriter writer) throws IOException {
		for (int i = 0; i < scores.size(); i++) {
			writer.write(scores.get(i).toString(i+1) + "\n");
		}
	}
	
	private void sortArray() {
		Score[] newScoreArr = new Score[scores.size()]; 
		Score temp;
		Score min;
		//list to array
		for(int i = 0 ; i < scores.size() ; i++) {
			newScoreArr[i] = scores.get(i);
		}
		//sort the array
		for(int i = 0 ; i < newScoreArr.length ; i++) {
			min = newScoreArr[i];
			for(int j = i + 1; j < newScoreArr.length ; j++) {
				if(min.getScore() > newScoreArr[j].getScore()) {
					temp = newScoreArr[j];
					newScoreArr[j].setScore(min);
					min = temp;
					newScoreArr[i].setScore(min);
				}
			}
		}
		//array to list
		scores.clear();
		for(int i = 0 ; i < newScoreArr.length ; i++) {
			scores.add(i, newScoreArr[i]);
		}
	}
	
	private void removeMin() {
		//remove the min number in the array  
		Integer minToRemove = scores.get(0).getScore();
		int index = 0;
		for(int i = 1 ; i < scores.size() ; i++) {
			if(scores.get(i).getScore() < minToRemove) {
				minToRemove = scores.get(i).getScore();
				index = i;
			};
		}
		scores.remove(index);
	}
}