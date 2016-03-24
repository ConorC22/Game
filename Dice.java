
import javax.swing.*;
import java.util.*;


     public class Dice extends JButton  {

        private int die=0;   // Number showing on the die.
		private Random generator;
		private ImageIcon[] image = new ImageIcon[7];

        public Dice(){
				super();
				generator = new Random();
				for (int i = 1; i< 7; i++){
				 image[i] = new ImageIcon ("images/dice"+i+".png");
			 }
			}


		// Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.


       public void roll() {
            die = generator.nextInt(6)+1;
            setIcon(image[die]);

        }

		// Return the number showing on the first die.
        public int getDie() {
        return die;
        }





     }  // end class

