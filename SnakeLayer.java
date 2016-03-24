import javax.swing.JLabel;

import javax.swing.ImageIcon;

	public class SnakeLayer extends JLabel{
				
		public SnakeLayer(String file){
			ImageIcon myIcon = new ImageIcon(file);
			setIcon(myIcon);
		
		}//end of constructor
		
	}//end of class


