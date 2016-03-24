 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 class InstructGUI extends JFrame implements ActionListener{

	//declare objects

    private Container contentPane;
	private SnakeLayer instruct;
	private JLayeredPane lp;
	private JButton Jback;
	//private MainMenuGUI myApp;

	//constructor

    public InstructGUI(){

	super("SnakeAndLadders");
	setSize(600,559);
	setLocation(200, 50);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container contentPane = getContentPane();

	//create and set bounds

    instruct = new SnakeLayer("images/instruct.png");
	instruct.setBounds(0, 0, 600, 550);

	Jback = new JButton(new ImageIcon("images/mainmenu.png"));
	Jback.setBounds(480,450,100,45);

	lp = new JLayeredPane();


	lp.add(instruct, new Integer(1));
	lp.add(Jback, new Integer(2));
	Jback.addActionListener(this);

	lp.setBounds(0, 0, 600, 550);
	lp.setVisible(true);
	contentPane.add(lp);

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
