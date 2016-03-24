/*
 * Score2.java
 *
 * Writen by Conor Curran
 *
 */

import javax.swing.*;
import java.io.*;

class Score2{


	private String Score;


	public Score2(){
		Score = new String();

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
					JOptionPane.showMessageDialog(null, "Successfully written to file");
			 }
			 catch(IOException e){
				 System.out.println(e);
		}
	}



	// code to read txt from a txt file

	public void readFromFile(){
		try{

			File inFile;
			FileReader fReader;
			BufferedReader bReader;

			inFile = new File("score.txt");
			fReader = new FileReader(inFile);
			bReader = new BufferedReader(fReader);

			String text;

			//declaring a string array
			String arr[];
			arr= new String[4];
			int i = 0;



			while(true){

			text = bReader.readLine();
			if(text == null){
				break;
			}

			arr[i] = text;


		    //start of conversion class
		    //Conversion myConvert();
		    //myConvert = new Conversion();
		    //myConvert.setWord(arr[i]);
		    //myConvert.compute();
		    //arr[i] = myConvert.getWord[];







			JOptionPane.showMessageDialog(null, text);

			// or use i = i+1;
			i++;

		}



			bReader.close();
		}

		catch(IOException e){
			System.out.println(e);
		}
}

}