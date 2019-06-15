package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.game.Game;

public class WinningPanel extends JPanel implements ActionListener{
	
	private JButton playAgain;
	private JButton exit;
	private JLabel winner1;
	private JLabel winner2;
	private JLabel winner3;
	private JLabel throne;
	private Game game;
	private MainFrame frame;
	
	public WinningPanel(MainFrame frame,Game game) {
		super();
		this.frame=frame;
		setOpaque(false);
		setLayout(null);
		playAgain = new JButton("Play Again");
		exit = new JButton("Exit");
		playAgain.addActionListener(this);
		exit.addActionListener(this);
		this.game=game;
		if(game.getPlayer1().getPayloadPos()==6)
			winner1 = new JLabel("Congratulations   "+game.getPlayer1().getName());
		else
			winner1 = new JLabel("Congratulations   "+game.getPlayer2().getName());
		winner2 = new JLabel("You   are   the   rightful   heir");
		winner3 = new JLabel("to   the   iron   throne");
		winner1.setFont(new Font("Game of Thrones",Font.PLAIN,25));
		winner2.setFont(new Font("Game of Thrones",Font.PLAIN,25));
		winner3.setFont(new Font("Game of Thrones",Font.PLAIN,25));
		throne = new JLabel();
		throne.setIcon(new ImageIcon("resources/throne.png"));
		throne.setBounds(313,0,374,314);
		winner1.setBounds(270,400,600,40);
		winner2.setBounds(250,450,1000,40);
		winner3.setBounds(300,500,1000,40);
		playAgain.setFont(new Font("Game of Thrones",Font.PLAIN,30));
		playAgain.setBounds(300,585,400,70);
		playAgain.setOpaque(false);
		playAgain.setContentAreaFilled(false);
		playAgain.setBorderPainted(false);
		playAgain.setFocusPainted(false);
		exit.setFont(new Font("Game of Thrones",Font.PLAIN,30));
		exit.setBounds(300,640,400,70);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		add(throne);
		add(winner1);
		add(winner2);
		add(winner3);
		add(playAgain);
		add(exit);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play Again")) {
			frame.dispose();
			MainFrame test = new MainFrame();
			test.setVisible(true);
		}
		else
			System.exit(0);
	}
}