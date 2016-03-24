
//written by Conor Curran
import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.text.*;

public class Player implements Serializable {

	public String name;
    public int score;
    private String date;
    private int playerNumber;
    private Player next;
    private JLabel token;
    private int field, start;
    private ArrayList <Player> players;
	private int index;
	private int id;


    public Player(int id){
        score = 0;
        field = 0;
        this.id = id;
        name = " ";
        players = new ArrayList<Player>();
        }

	public void setName(String name) {
        this.name = name;
    }


	 public String getName() {
	         return name;
	     }


	 public void addPlayer(Player player)
	 {
     players.add(player);
	 }


      public void start()
	 	{
	      int index = 0;
	      while (true)
	      {
	      Player current = players.get(index);
	      //current.makeMove();
	      index = (index + 1) % players.size();
	      }
		 }


	public int getStart()    {
        return start;
    }

	public int getID()    {
        return id;
    }

    public void setScore(int i){
        score = i;
    }





    public void addScore(){

	do{
		score += field ;

		}while (score <0);



	        /*else if (field ==4){
	   		score = score + field;

	   			}
	   		else if (field ==9){
	   		score = score + field;
	   			}
	   		else if (field ==21){
	   		score = score + field;
	   			}
	   		else if (field ==28){
	   			score = score + field;
	   			}
	   		else if (field ==51){
	   			score = score + field;
	   			}
	   		else if (field ==71){
	   			score = score + field;
	   			}
	   		else if (field ==80){
	   			score = score + field;
	   			}



	   		/Snake movements
	   			if (field ==17){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 7");
	   				field = 7;
	   			}
	   			else if (field ==54){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 34");
	   				field = 34;
	   			}
	   			else if (field ==62){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 62");
	   				field = 19;
	   			}
	   			else if (field ==64){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 60");
	   				field = 60;
	   			}
	   			else if (field ==87){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 24");
	   				field = 24;
	   			}
	   			else if (field ==93){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 73");
	   				field = 73;
	   			}
	   			else if (field ==96){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 75");
	   				field = 75;
	   			}
	   			else if (field ==98){
	   				JOptionPane.showMessageDialog(null, "Oops Snake bite, back to Square 79");
	   				field = 79;
	   			}

	           	if (field >= 100) {
	   		               field = 100;
           }


		//else
		//score += score + 1;

		*/
    }

    public int getScore()    {
        return score;
    }

    public void setField(int f){
        field = f;

   }

    public int getField()    {
        return field;
    }

    public void setPlayerNumber(int i){
        playerNumber = i;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void setNext(Player player){
        next = player;
    }

    public Player getNext(){
        return next;
    }


	public void setToken(JLabel t){
		token = t;
	}

	public JLabel getToken(){
		return token;
	}

	 public void copyScore(Player p) {
			this.name = p.getName();

		}





}
