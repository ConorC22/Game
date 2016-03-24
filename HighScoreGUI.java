 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 class HighScoreGUI extends JFrame implements ActionListener{

	//declare objects

    private Container contentPane;
	private SnakeLayer instruct;
	private JLayeredPane lp;
	private JButton Jback;
	private HighscoreReader score;
	private JLabel scoreLabel;

	//private MainMenuGUI myApp;

	//constructor

    public HighScoreGUI(){

	super("SnakeAndLadders");
	setSize(600,500);
	setLocation(200, 50);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container contentPane = getContentPane();
	score = new HighscoreReader();

	//create and set bounds

    instruct = new SnakeLayer("images/high.png");
	instruct.setBounds(0, 0, 600, 500);

	Jback = new JButton(new ImageIcon("images/mainmenu.png"));
	Jback.setBounds(480,400,100,45);
	lp = new JLayeredPane();


	lp.add(instruct, new Integer(1));
	lp.add(Jback, new Integer(2));
	Jback.addActionListener(this);

	lp.setBounds(0, 0, 600, 500);
	lp.setVisible(true);
	contentPane.add(lp);

	scoreLabel = new JLabel(score.readFromFile());
	scoreLabel.setBounds(275, 20, 800, 400);
	lp.add(scoreLabel, new Integer(2));
	//score = new Score2("score.txt");
	//score.setBounds (0, 50, 600, 400);


	 }




	public void actionPerformed(ActionEvent event){ //action performed
		if(Jback == event.getSource()){  //if back button

		 MainMenuGUI myApp;
		 myApp = new MainMenuGUI();
		 myApp.setVisible(true);
		 this.setVisible(false);

				}
		}
 }
