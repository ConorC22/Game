/*
 * Score.java
 *
 *
 *
 */


class Score{
	public static void main(String args[]){
		HighscoreReader myScore;
		myScore = new HighscoreReader();

		myScore.input();
		myScore.writeToFile();
		myScore.readFromFile();
	}
}
