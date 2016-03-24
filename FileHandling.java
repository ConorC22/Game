//Written by Conor Currran and Deeshan Dabycharun
import java.io.*;
import java.util.*;


class FileHandling{
	private String str;
	private String text;
	private User u;
	private User users[];
	private ArrayList <User> players[];


	public FileHandling(){
		str = new String();
		text = new String();
		u = new User();
		users = new User[10];
		players = new ArrayList <User>();
	}

	public void setUser(User u){
		this.u = u;
	}

	public void setUsers(User[] u){
			this.users = u;
	}

	public User getUser(){
		return u;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getStr(){
		return str;
	}
	public void readFromFile(){
		try{
			File inFile;
			FileReader fReader;
			BufferedReader bReader;

			inFile = new File("input.txt");
			fReader = new FileReader(inFile);
			bReader = new BufferedReader(fReader);

			str = bReader.readLine();
			bReader.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	public void writeToFile(){
		try{
			File outFile;
			FileWriter fWriter;
			BufferedWriter bWriter;

			outFile = new File("output.txt");
			fWriter = new FileWriter(outFile);
			bWriter = new BufferedWriter(fWriter);

			bWriter.write(text);

			bWriter.close();
	 	}
		catch(IOException e){
			 System.out.println(e);
		}
	}


	public void writeObjectToFile(){

		try{
			File outFile;
			FileOutputStream fStream;
			ObjectOutputStream oStream;

			outFile = new File("objects.txt");
			fStream = new FileOutputStream(outFile);
			oStream = new ObjectOutputStream(fStream);

			oStream.writeObject(u);
			oStream.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

	public void writeArrayObjectToFile(){

			try{
				File outFile;
				FileOutputStream fStream;
				ObjectOutputStream oStream;

				outFile = new File("users.txt");
				fStream = new FileOutputStream(outFile);
				oStream = new ObjectOutputStream(fStream);

				oStream.writeObject(users);
				oStream.close();
			}
			catch(IOException e){
				System.out.println(e);
			}
	}

	public void readObjectFromFile(){
		try{
			File inFile;
			FileInputStream fStream;
			ObjectInputStream oStream;

			inFile = new File("objects.txt");
			fStream = new FileInputStream(inFile);
			oStream = new ObjectInputStream(fStream);

			User u;
			u = (User)oStream.readObject();
			oStream.close();
		}
		catch(ClassNotFoundException e){
			System.out.println("Class Not Found");
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	public void writeArrayListToFile(){
		try{
			File inFile;
			FileOutputStream fStream;
			ObjectOutputStream oStream;

			inFile = new File("objects.txt");
			fStream = new FileOutputStream(inFile);
			oStream = new ObjectOutputStream(fStream);
			oStream.writeObject(players);
			oStream.close();

		}
		catch(IOExceeption e){
			System.out.println(e);

		}

	}


}
