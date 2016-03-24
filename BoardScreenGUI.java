 //Written by Conor Curran

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;
 import java.awt.Toolkit;



 class BoardScreenGUI extends JFrame implements ActionListener{

	//declare objects

    private Container contentPane;
	private SnakeLayer board, board1, board2;
	private JLayeredPane lp;
	private JButton myJnew, myJreset, myJreturn;
	private JRadioButton Jradio1, Jradio2, Jradio3,Jradio4;
	private JLabel PTurn, myJselect, myTurn;
	private JLabel JLabelplayer1, JLabelplayer2, JLabelplayer3, JLabelplayer4;
	private JLabel JLabelplayer1name, JLabelplayer2name, JLabelplayer3name, JLabelplayer4name;
	private String player1name, player2name, player3name, player4name;
	private JLabel token1, token2, token3, token4;
	private Field[][] boardfield;
	private Dice myDice;
	private JFrame frame;
	private Dice myJdice;
	private JLabel dice1, currentToken;
	private Player player1, player2, player3, player4, currentPlayer;
	private Player[] players = new Player[5];
	private Player p;
	private MainMenuGUI myApp;
	private int numberOfPlayers;
	private JLabel PSquare, P2score,P3score, P4score;
	private int[] fromField = {1, 4};
	private int[] toField = {1, 38, 2, 3, 14, 5, 6, 7, 8, 31, 10, 11, 12, 13, 14, 15, 16, 7, 18 , 19, 20, 42, 22, 23, 24, 25, 26, 27, 84, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 67, 52, 53, 34, 55, 56, 57, 58, 59, 60, 61, 19, 63, 60, 65, 66, 67, 68, 69, 70, 91, 72, 73, 74, 75, 76, 77, 78, 79, 100, 81,82, 83, 84, 85, 86, 24, 88, 89, 90, 91, 92, 73, 94, 95, 75, 97, 79, 99, 100};





	//constructor

    public BoardScreenGUI(){

	super("SnakeAndLadders");
	setSize(1024, 768);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	Container contentPane = getContentPane();

	//create and set bounds


    board = new SnakeLayer("images/platform.png");
    board.setVisible(true);
	board.setBounds(0, 0, 1024, 768);

	board1 = new SnakeLayer("images/board.png");
	board1.setVisible(false);
	board1.setBounds(0, 0, 800, 700);


	board2 = new SnakeLayer("images/board.png");
	board2.setVisible(true);
	board2.setBounds(0, 0, 800, 700);

	myJnew = new JButton(new ImageIcon("images/newgame.png"));
	myJnew.setBounds(837,6,147,40);
	myJselect = new JLabel (new ImageIcon("images/selectplayers.png"));
	myJselect.setBounds(837,50,150,40);
	myJselect.setEnabled(false);

	PTurn = new JLabel(new ImageIcon("images/rolldice.png"));
	PTurn.setBounds(837, 200, 150, 30);
	PTurn.setEnabled(false);

	myJdice = new Dice();
	myJdice.setBounds(860, 250, 75, 75);
	ImageIcon ico = new ImageIcon("images/dice.png"); //add dice image
	myJdice.setIcon(ico);
	myJdice.setEnabled(false);



	//Creating Token and its bounds
	token1=new JLabel (new ImageIcon("images/red.png"));
	token1.setBounds(960,400,40,40);
	token1.setVisible(false);
	token2=new JLabel (new ImageIcon("images/blue.png"));
	token2.setBounds(960,440,40,40);
	token2.setVisible(false);
	token3=new JLabel (new ImageIcon("images/yellow.png"));
	token3.setBounds(960,480,40,40);
	token3.setVisible(false);
	token4=new JLabel (new ImageIcon("images/green.png"));
	token4.setBounds(960,520,40,40);
	token4.setVisible(false);

	player1 = new Player(1);
	player2 = new Player(2);
	player3 = new Player(3);
	player4 = new Player(4);
	currentPlayer = player1;

	players[1] = player1;
	players[2] = player2;
	players[3] = player3;
	players[4] = player4;

	player1.setToken(token1);
	player2.setToken(token2);
	player3.setToken(token3);
	player4.setToken(token4);



	JLabelplayer1= new JLabel("Player 1");
	JLabelplayer1.setFont(new Font("sansserif",1, 15));
	JLabelplayer1.setBounds(837, 400, 80, 30);
	JLabelplayer1.setVisible(false);
	JLabelplayer2= new JLabel("Player 2");
	JLabelplayer2.setFont(new Font("sansserif",1, 15));
	JLabelplayer2.setBounds(837, 440, 80, 30);
	JLabelplayer2.setVisible(false);
	JLabelplayer3= new JLabel("Player 3");
	JLabelplayer3.setFont(new Font("sansserif",1, 15));
	JLabelplayer3.setBounds(837, 480, 80, 30);
	JLabelplayer3.setVisible(false);
	JLabelplayer4= new JLabel("Player 4");
	JLabelplayer4.setFont(new Font("sansserif",1, 15));
	JLabelplayer4.setBounds(837, 520, 80, 30);
	JLabelplayer4.setVisible(false);
	JLabelplayer1name=new JLabel();
	JLabelplayer1name.setBounds(900, 400, 80, 30);
	JLabelplayer1name.setFont(new Font("sansserif",1, 15));
    JLabelplayer1name.setForeground(Color.red);
	JLabelplayer2name=new JLabel();
	JLabelplayer2name.setBounds(900, 440, 80, 30);
	JLabelplayer2name.setFont(new Font("sansserif",1, 15));
    JLabelplayer2name.setForeground(Color.blue);
	JLabelplayer3name=new JLabel();
	JLabelplayer3name.setBounds(900, 480, 80, 30);
	JLabelplayer3name.setFont(new Font("sansserif",1, 15));
    JLabelplayer3name.setForeground(Color.yellow);
	JLabelplayer4name=new JLabel();
	JLabelplayer4name.setBounds(900, 520, 80, 30);
	JLabelplayer4name.setFont(new Font("sansserif",1, 15));
    JLabelplayer4name.setForeground(Color.green);


	//Score

	PSquare = new JLabel();
	PSquare.setText("Player");
	PSquare.setFont(new Font ("Serif", Font.BOLD, 20));
	PSquare.setForeground(Color.black);
	PSquare.setBounds(820, 330, 120, 60);


	//myRollDice label parameters
    myTurn = new JLabel();
    myTurn.setText("0");
    myTurn.setBounds(950, 330, 40, 60);
	myTurn.setFont(new Font("Serif", Font.BOLD, 25));  //font parameters
    myTurn.setForeground(Color.red); //font foreground color

	myJreset = new JButton(new ImageIcon("images/resetgame.png"));
	myJreset.setBounds(837, 600, 150, 40);
 	myJreturn = new JButton(new ImageIcon("images/mainmenu.png"));
 	myJreturn.setBounds(837, 650, 150, 40);

	//JRadioButton
	ButtonGroup group = new ButtonGroup();
	Jradio1 = new JRadioButton("V/S Computer", false);
	Jradio1.setEnabled(false);
	Jradio1.setBounds (837,100,150,20);
	Jradio2 = new JRadioButton("2 Players", false);
	Jradio2.setBounds (837,120,150,20);
	Jradio2.setEnabled(false);
	Jradio3 = new JRadioButton("3 Players", false);
	Jradio3.setBounds (837,140,150,20);
	Jradio3.setEnabled(false);
	Jradio4 = new JRadioButton("4 Players", false);
	Jradio4.setBounds (837,160,150,20);
	Jradio4.setEnabled(false);


	group.add(Jradio1);
	group.add(Jradio2);
	group.add(Jradio3);
	group.add(Jradio4);
p = new Player();

	//Layering
	lp = new JLayeredPane();
	lp.add(board, new Integer(1));
	lp.add(board1, new Integer(2));
	lp.add(board2, new Integer(2));
	lp.add(myJnew, new Integer(2));
	lp.add(myJselect, new Integer(2));
	lp.add(PTurn, new Integer(2));
	lp.add(myJdice, new Integer(2));
	lp.add(myTurn, new Integer(2));
	lp.add(myJreset, new Integer(2));
	lp.add(myJreturn, new Integer(2));
	lp.add(JLabelplayer1, new Integer(2));
	lp.add(JLabelplayer2, new Integer(2));
	lp.add(JLabelplayer3, new Integer(2));
	lp.add(JLabelplayer4, new Integer(2));
	lp.add(JLabelplayer1name, new Integer(2));
	lp.add(JLabelplayer2name, new Integer(2));
	lp.add(JLabelplayer3name, new Integer(2));
	lp.add(JLabelplayer4name, new Integer(2));

	//lp.add(currentToken, new Integer(3));
	lp.add(player1.getToken(), new Integer(3));
	lp.add(player2.getToken(), new Integer(3));
	lp.add(player3.getToken(), new Integer(3));
	lp.add(player4.getToken(), new Integer(3));


	//lp.add score on board
	lp.add(PSquare, new Integer(2));


	lp.add(Jradio1, new Integer(2));
	lp.add(Jradio2, new Integer(2));
	lp.add(Jradio3, new Integer(2));
	lp.add(Jradio4, new Integer(2));


	//Adding action listener
	myJnew.addActionListener(this);
	myJdice.addActionListener(this);
	myJreset.addActionListener(this);
	myJreturn.addActionListener(this);
	Jradio1.addActionListener(this);
	Jradio2.addActionListener(this);
	Jradio3.addActionListener(this);
	Jradio4.addActionListener(this);


	lp.setBounds(0, 0, 1024, 768);
	lp.setVisible(true);
	contentPane.add(lp);



	boardfield = new Field[10][10];
	for (int i = 0; i<10; i++){
		for (int j = 0; j<10; j++){
			boardfield[i][j] = new Field();
		}
	 }





	boardfield[0][9].setNext(boardfield[1][9]);
	boardfield[1][9].setNext(boardfield[2][9]);
	boardfield[2][9].setNext(boardfield[3][9]);
	boardfield[3][9].setNext(boardfield[4][9]);
	boardfield[4][9].setNext(boardfield[5][9]);
	boardfield[5][9].setNext(boardfield[6][9]);
	boardfield[6][9].setNext(boardfield[7][9]);
	boardfield[6][9].setNext(boardfield[8][9]);
	boardfield[7][9].setNext(boardfield[8][9]);
	boardfield[8][9].setNext(boardfield[9][9]);


	boardfield[9][9].setNext(boardfield[9][8]);
	boardfield[9][8].setNext(boardfield[8][8]);
	boardfield[8][8].setNext(boardfield[7][8]);
	boardfield[7][8].setNext(boardfield[6][8]);
	boardfield[4][8].setNext(boardfield[5][8]);
	boardfield[3][8].setNext(boardfield[4][8]);
	boardfield[2][8].setNext(boardfield[3][8]);
	boardfield[1][8].setNext(boardfield[2][8]);
	boardfield[0][8].setNext(boardfield[1][8]);
	boardfield[0][8].setNext(boardfield[0][0]);

	int[] coor;
	coor = calculateCoordinates(1);
	System.out.println("cellnumber 1: " + coor[0] + ", " + coor[1]);
	coor = calculateCoordinates(10);
	System.out.println("cellnumber 10: " + coor[0] + ", " + coor[1]);
	coor = calculateCoordinates(11);
	System.out.println("cellnumber 11: " + coor[0] + ", " + coor[1]);
	coor = calculateCoordinates(20);
	System.out.println("cellnumber 20: " + coor[0] + ", " + coor[1]);
	coor = calculateCoordinates(21);
	System.out.println("cellnumber 21: " + coor[0] + ", " + coor[1]);

	}



	public void actionPerformed(ActionEvent event){ //action performed


		if(myJnew == event.getSource()){
			board2.setVisible(false);
			board1.setVisible(true);
			JOptionPane.showMessageDialog(null,
			"·      This is a 2 player game\n"
  		    + "·      Click ‘Select Player’ if you wish to start a new game at any point during your game.\n"
			+ "·      A single dice is used. In each play the dice is only thrown once\n"
			+ "·      Each player will go forward the number of squares that is displayed on the dice that was rolled\n"
			+ "·      Should either player land on the furthest point forward of a snake, they will be moved back to the square at the furthest point back of that snake\n"
			+ "·      Should either player land on the base of a ladder,they will be moved forward to the square at the head of that ladder\n"
			+ "·      The Winner will be the first Player who arrives at square 100\n"
			+ "·      If however one of the players rolls a greater number on the dice than necessary to reach the final square they will automatically become the winner\n"
			+ "·      If you wish to try various related games click on one of the links, which will take you to an alternative site\n", "Instructions", JOptionPane.PLAIN_MESSAGE );




			PTurn.setEnabled(true);
			myJselect.setEnabled(true);
			Jradio1.setEnabled(true);
			Jradio2.setEnabled(true);
			Jradio3.setEnabled(true);
			Jradio4.setEnabled(true);
			repaint();

		}

		if(Jradio1 == event.getSource()){
			player1name=JOptionPane.showInputDialog(null, "Player 1: Please enter your name ");
			p.setName(player1name);
			JLabelplayer1.setVisible(true);
			JLabelplayer1name.setText(player1name);
			token1.setVisible(true);
			numberOfPlayers =1;
		}

		if(Jradio2 == event.getSource()){
			player1name=JOptionPane.showInputDialog(null, "Player 1: Please enter your name ");
			p.setName(player1name);
			JLabelplayer1.setVisible(true);
			JLabelplayer1name.setText(player1name);
			token1.setVisible(true);
			player2name=JOptionPane.showInputDialog(null, "Player 2: Please enter your name ");
			p.setName2(player2name);
			JLabelplayer2.setVisible(true);
			JLabelplayer2name.setText(player2name);
			token2.setVisible(true);
			numberOfPlayers =2;
		}

		if(Jradio3 == event.getSource()){
			player1name=JOptionPane.showInputDialog(null, "Player 1: Please enter your name ");
			p.setName(player1name);
			JLabelplayer1.setVisible(true);
			JLabelplayer1name.setText(player1name);
			token1.setVisible(true);
			player2name=JOptionPane.showInputDialog(null, "Player 2: Please enter your name ");
			p.setName2(player2name);
			JLabelplayer2.setVisible(true);
			JLabelplayer2name.setText(player2name);
			token2.setVisible(true);
			player3name=JOptionPane.showInputDialog(null, "Player 3: Please enter your name ");
			p.setName(player3name);
			JLabelplayer3.setVisible(true);
			JLabelplayer3name.setText(player3name);
			token3.setVisible(true);
			numberOfPlayers =3;
		}

		if(Jradio4 == event.getSource()){
			player1name=JOptionPane.showInputDialog(null, "Player 1: Please enter your name ");
			p.setName(player1name);
			JLabelplayer1.setVisible(true);
			JLabelplayer1name.setText(player1name);
			token1.setVisible(true);
			player2name=JOptionPane.showInputDialog(null, "Player 2: Please enter your name ");
			p.setName2(player2name);
			JLabelplayer2.setVisible(true);
			JLabelplayer2name.setText(player2name);
			token2.setVisible(true);
			player3name=JOptionPane.showInputDialog(null, "Player 3: Please enter your name ");
			p.setName3(player3name);
			JLabelplayer3.setVisible(true);
			JLabelplayer3name.setText(player3name);
			token3.setVisible(true);
			player4name=JOptionPane.showInputDialog(null, "Player 4: Please enter your name ");
			p.setName4(player4name);
			JLabelplayer4.setVisible(true);
			JLabelplayer4name.setText(player4name);
			token4.setVisible(true);
			numberOfPlayers =4;
		}



			myJdice.setEnabled(true);
			if (myJdice == event.getSource())

			{

			myJdice.roll();


		int currentField = currentPlayer.getField();
		int diceField = currentField + myJdice.getDie();
		int targetField;

		if (diceField > 100){
			diceField = 100;

		}


		targetField = toField[diceField];


        //Ladder movements
		int middleField = currentField;
		for (int i = currentField; i<=diceField; i++){
			move(currentPlayer, middleField, i);
			middleField = i;
		}
		if (diceField != targetField){
        	move(currentPlayer, diceField, targetField);
		}


 /**       int field = targetField;


            if (field ==1){
						JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 38");
				field = 38;
			}

        	else if (field ==4){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 14");
				field = 14;

			}
			else if (field ==9){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 31");
				field = 31;
			}
			else if (field ==21){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 42");
				field = 42;
			}
			else if (field ==28){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 84");
				field = 84;
			}
			else if (field ==51){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 67");
				field = 67;
			}
			else if (field ==71){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 71");
				field = 91;
			}
			else if (field ==80){
				JOptionPane.showMessageDialog(null, "hehe ladder, jump to Square 100");
				field = 100;
			}

		//Snake movements
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
*/

			currentPlayer.setField(targetField);
			currentToken = currentPlayer.getToken();
			currentPlayer.addScore();

			Jradio1.setEnabled(false);
			Jradio2.setEnabled(false);
			Jradio3.setEnabled(false);
			Jradio4.setEnabled(false);

				if (currentPlayer == player1) {
					myTurn.setText(" "+currentPlayer.getField());
					PSquare.setText(player1name +"  Square");
					}
				else if (currentPlayer == player2){
					myTurn.setText(" "+currentPlayer.getField());
					PSquare.setText(player2name +"  Square");
					}

				else if (currentPlayer == player3){
					myTurn.setText(" "+currentPlayer.getField());
					PSquare.setText(player3name +" Square");
					}
				else if (currentPlayer == player4){
					myTurn.setText(" "+currentPlayer.getField());
					PSquare.setText(player4name +" Square");
					}


				int[] coor = calculateCoordinates(currentPlayer.getField());
				currentToken.setBounds(coor[0], coor[1], 40, 40);
				changePlayer();

				currentPlayer.getScore();
				System.out.println("player1Score =  " +player1.getName());
				System.out.println("player2Score =  " +player2.getScore());
				System.out.println("player1 =  " +player1.getField());
				System.out.println("player2 =  " +player2.getField());

				//testing

				HighscoreReader myScore;
				myScore = new HighscoreReader();


				if (currentPlayer.getField() >= 99) {
				JOptionPane.showMessageDialog(null, "Player has won");
				myScore.input();
				myScore.writeToFile();
				currentToken.setVisible(false);
				PTurn.setEnabled(false);

				repaint();

				 }

			currentToken.setVisible(true);
			repaint();




		}

		//reset the game
		if(myJreset == event.getSource())

		{
			Toolkit.getDefaultToolkit().beep();

		int k = JOptionPane.showConfirmDialog(null, "Are you sure to reset game?", "Reset Game", 0);
		if(k == 0)
		{
		setVisible(false);
		MainMenuGUI myApp;
		myApp = new MainMenuGUI();
		myApp.setVisible(true);
		 this.setVisible(false);
            }
        }

		if(myJreturn == event.getSource())
		{  //if back button
			Toolkit.getDefaultToolkit().beep();
		 MainMenuGUI myApp;
		 myApp = new MainMenuGUI();
		 myApp.setVisible(true);
		 this.setVisible(false);
		}

	}

	private int[] calculateCoordinates(int cellnumber){
		int x,y;
		int[] point;
		int originX = 0;
		int originY = 630;
		int width = 80;
		int height = 70;
		int row = (cellnumber-1) / 20; // 5 rows of 20 cells each
		int direction = ((cellnumber - 1) / 10) % 2; // 0 = left to right; 1 = right to left
		int column;
		if (direction == 0){
			column = (cellnumber-1) % 10;
		}else{
			column = 9 - ((cellnumber-1) % 10);
		}

		x = originX + (column * width) + 15;
		if(direction == 0){
			y = originY - (2 * height * row) + 15;
		}else{
			y = originY - (2 * height * row)- height + 15;
	}
	point = new int[2];
	point[0] = x;
	point[1] = y;
	return point;

		}

	private void move(Player p, int from, int to){
//System.out.println("moving from " + from + " to " + to);
		JLabel token = p.getToken();

		int[] coor = calculateCoordinates(from);
		int fromX = coor[0];
		int fromY = coor[1];
		coor = calculateCoordinates(to);
		int toX = coor[0];
		int toY = coor[1];
		int distanceX = fromX - toX;
		int distanceY = fromY - toY;

		double distance = Math.pow(Math.pow(distanceX, 2) + Math.pow(distanceY, 2), 0.5);
	//System.out.println("distance: " + distance);
		for (int i = 0; i < distance; i++){
			token.setLocation(fromX + (int) (distanceX * (i/distance)) , fromY + (int) (distanceY * (i/distance)));
			repaint();
			try {
			     Thread.sleep(0);
			    } catch (Exception excep) {}

		}

	}



	public void changePlayer () {

		 //loop for currentPlayer
			int i;
			i = currentPlayer.getID();

			if (i == numberOfPlayers){
				i = 1;
			}else{
				i++;
			}
			currentPlayer = players[i];

		}







}
