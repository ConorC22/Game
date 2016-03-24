
/*
 * Score2.java
 *
 * Written by Conor Curran
 *
 */

import javax.swing.*;
import java.io.*;

class HighscoreReader{


	private String Score;
	private String text;
	private String output;
	private Player[] scores;
	public static final int COUNT = 10;





	public HighscoreReader(){
		Score = new String();

	}

	//read
	public void read() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("newscore.txt"));
		for(int i=0; i<COUNT; i++) {
			scores[i].setName(in.readLine());
			scores[i].setScore(Integer.decode(in.readLine()).intValue());

		}
	  }


	public void input(){
	Score = JOptionPane.showInputDialog(null, "Please enter score");

		}

	public void writeToFile(){
		try{
					File outFile;
					FileWriter fWriter;
					BufferedWriter bWriter;

					outFile = new File("score.txt");
					fWriter = new FileWriter(outFile);
					bWriter = new BufferedWriter(fWriter);
					bWriter.write("1 " + Score + "\n");
					bWriter.write("2 " + Score + "\n");
			        bWriter.write("3 " + Score + "\n");
					bWriter.write("4 " + Score + "\n");
					bWriter.write("5 " + Score + "\n");
					bWriter.write("6 " + Score + "\n");
					bWriter.write("7 " + Score + "\n");
					bWriter.write("8 " + Score + "\n");
					bWriter.write("9 " + Score + "\n");
					bWriter.write("10 " + Score + "\n");

					bWriter.close();
					//JOptionPane.showMessageDialog(null, "Successfully written to file");
			 }
			 catch(IOException e){
				 System.out.println(e);
		}
	}



	// code to read txt from a txt file

	public String readFromFile(){
		try{

			File inFile;
			FileReader fReader;
			BufferedReader bReader;

			inFile = new File("score.txt");
			fReader = new FileReader(inFile);
			bReader = new BufferedReader(fReader);


			//declaring a string array
			String arr[];
			arr= new String[10];
			int i = 0;

			output = "<html>";

			while(true){

			text = bReader.readLine();
			if(text == null){
				break;
			}
			output = output + text + "<br>";

			arr[i] = text;











		}



			bReader.close();
		}

		catch(IOException e){
			System.out.println(e);
		}
		output = output + "</html>";
		return output;
}

}