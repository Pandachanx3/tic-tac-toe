import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];	
	Border thickBorder = new LineBorder(Color.WHITE,10);
	boolean player1_turn;

	//Konstruktor
	TicTacToe(){	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(255, 235, 204));
		frame.setLayout(new BorderLayout());
	
		frame.setVisible(true);		
		
		textfield.setText("Tic-Tac-Toe");
		textfield.setBorder(thickBorder);
		textfield.setBackground(new Color (255, 235, 204));
		textfield.setForeground(new Color (255, 153, 153));
		textfield.setFont(new Font("Times",Font.CENTER_BASELINE,30));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,600,200);

		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color (255, 235, 204));
		button_panel.setBorder(thickBorder);
		

		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Times" , Font.BOLD,30));
			buttons[i].setBackground(new Color(255, 235, 204));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<9; i++) {

			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255, 235, 204));
						buttons[i].setBackground(new Color(182, 113, 98));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("Your turn Player 2");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255, 235, 204));
						buttons[i].setBackground(new Color(158, 157, 137));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("Your turn Player 1");
						check();
					}

				}
			}
		}				
	}

	public void firstTurn() {

		try {
			Thread.sleep(2300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("Player 1 begins");
		}
		else {
			player1_turn=false;
			textfield.setText("Player 2 begins");
		}

	}

	public void check() {
		if(
				(buttons[0].getText()=="X") &&  
				(buttons[1].getText()=="X") && 
				(buttons[2].getText()=="X") 
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&  
				(buttons[4].getText()=="X") && 
				(buttons[5].getText()=="X") 
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&  
				(buttons[7].getText()=="X") && 
				(buttons[8].getText()=="X") 
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&  
				(buttons[3].getText()=="X") && 
				(buttons[6].getText()=="X") 
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&  
				(buttons[4].getText()=="X") && 
				(buttons[7].getText()=="X") 
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&  
				(buttons[5].getText()=="X") && 
				(buttons[8].getText()=="X") 
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[0].getText()=="X") &&  
				(buttons[4].getText()=="X") && 
				(buttons[8].getText()=="X") 
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[2].getText()=="X") &&  
				(buttons[4].getText()=="X") && 
				(buttons[6].getText()=="X") 
				) {
			xWins(2,4,6);
		}

		if(
				(buttons[0].getText()=="O") &&  
				(buttons[1].getText()=="O") && 
				(buttons[2].getText()=="O") 
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&  
				(buttons[4].getText()=="O") && 
				(buttons[5].getText()=="O") 
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&  
				(buttons[7].getText()=="O") && 
				(buttons[8].getText()=="O") 
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&  
				(buttons[3].getText()=="O") && 
				(buttons[6].getText()=="O") 
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&  
				(buttons[4].getText()=="O") && 
				(buttons[7].getText()=="O") 
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&  
				(buttons[5].getText()=="O") && 
				(buttons[8].getText()=="O") 
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[0].getText()=="O") &&  
				(buttons[4].getText()=="O") && 
				(buttons[8].getText()=="O") 
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[2].getText()=="O") &&  
				(buttons[4].getText()=="O") && 
				(buttons[6].getText()=="O") 
				) {
			oWins(2,4,6);
		}

	}

	public void xWins(int a,int b,int c) {

		buttons[a].setBackground(new Color (182, 113, 98));
		buttons[b].setBackground(new Color (182, 113, 98));
		buttons[c].setBackground(new Color (182, 113, 98));

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X hat gewonnen");		

	}

	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(new Color (158, 157, 137));
		buttons[b].setBackground(new Color (158, 157, 137));
		buttons[c].setBackground(new Color (158, 157, 137));

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O hat gewonnen");
		
	}
	
}
