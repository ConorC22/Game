//Written by Conor Currran and Deeshan Dabycharun
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class MainMenuGUI extends JFrame implements ActionListener {

	//Declare objects

	private Container contentPane;
	private SnakeLayer background;
	private JLayeredPane lp;
	private JButton Jstart, Jhigh, Jinstruct, Jexit;


	//Constructor
	public MainMenuGUI(){
		contentPane=getContentPane();
		contentPane.setLayout(null);
		setSize(600,530);
		setLocation(200,50);
		setTitle ("Snake And Ladders");


	//Create Background image
		background = new SnakeLayer ("images/cover.png");

		background.setBounds(0,0,600,500);

		lp=new JLayeredPane();
		lp.add(background, new Integer(1));

	//Create Buttons and bounds

		Jstart = new JButton(new ImageIcon("images/start.png"));
		Jhigh = new JButton(new ImageIcon("images/highbutton.png"));
		Jinstruct = new JButton(new ImageIcon("images/instructions.png"));
		Jexit = new JButton(new ImageIcon("images/exit.png"));

		Jstart.setBounds(220,250,160,40);
		Jhigh.setBounds(220,300,160,40);
		Jinstruct.setBounds(220,350,160,40);
		Jexit.setBounds(220,400,160,40);

	//ActionListener

		contentPane.add(Jstart);
		Jstart.addActionListener(this);

		contentPane.add(Jhigh);
		Jhigh.addActionListener(this);

		contentPane.add(Jinstruct);
		Jinstruct.addActionListener(this);

		contentPane.add(Jexit);
		Jexit.addActionListener(this);

		lp.setBounds(0,0,600,500);
		lp.setVisible(true);
		contentPane.add(lp);

	}

	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==Jstart){

			BoardScreenGUI myApp;
			myApp = new BoardScreenGUI();
			myApp.setVisible(true);
			this.setVisible(false);
			}

		if(ev.getSource()==Jhigh){
			HighScoreGUI myApp;
			myApp = new HighScoreGUI();
			myApp.setVisible(true);
			this.setVisible(false);
			}

		if(ev.getSource()==Jinstruct){
			InstructGUI myApp;
			myApp = new InstructGUI();
			myApp.setVisible(true);
			this.setVisible(false);
			}

		else if(ev.getSource()==Jexit){
		Toolkit.getDefaultToolkit().beep();


		// use of Jotion to display message

		JDialog.setDefaultLookAndFeelDecorated(true);
		    int s = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    if (s == JOptionPane.NO_OPTION) {
		    }

		    else if (s == JOptionPane.YES_OPTION) {
		      System.exit(0);
		    }
		    else if (s == JOptionPane.CLOSED_OPTION) {

    }

		//System.exit(0);
			}
		}


	}




