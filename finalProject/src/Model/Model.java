package Model;

public class Model {
	
	private Score theScore;
	private Clicks theClicks;
	private HighScores theHighScores;
	
	public Model() {
		theScore = new Score("player1");
	}
	
	public Model(Clicks c, Score s, HighScores hs) {
		theClicks=c;
		theScore=s;
		theHighScores=hs;
	}
	
	public Clicks getClicks() {
		return theClicks;
	}
	
	public Score getScore() {
		return theScore;
	}
	
	public HighScores getHighScores() {
		return theHighScores;
	}	
	
	/*public void buildHighScoreFile () throws FileNotFoundException {
		File highScores = new File("highScores.txt");
		Scanner s  = new Scanner(highScores);
		ArrayList<HighScoreFile> highScoresArray = new ArrayList<HighScoreFile>();
		while(s.hasNext()) {
			highScoresArray.add(new HighScoreFile(s));
		}*/
	}
