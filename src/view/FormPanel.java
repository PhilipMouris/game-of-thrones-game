package view;
import javax.swing.*;

import model.game.Game;
import model.game.Player;

import java.awt.*;
import java.awt.event.*;
public class FormPanel extends JPanel implements ActionListener{
	
	private JLabel player1Label;
	private JTextField player1Field;
	private JLabel player2Label;
	private JTextField player2Field;
	private JButton okButton;
	private MainFrame frame;
	
	public FormPanel(MainFrame frame) {
		super();
		setLayout(null);
		this.frame=frame;
		player1Label = new JLabel("STARKS");
		player1Field = new JTextField();
		player2Label = new JLabel("Lannisters");
		player2Field = new JTextField();
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		player1Label.setFont(new Font("Game of Thrones",Font.PLAIN,40));
		player2Label.setFont(new Font("Game of Thrones",Font.PLAIN,40));
		player1Label.setBounds(80,80,200,200);
		player1Field.setBounds(80,220,800,40);
		player1Field.setFont(new Font("SansSerif",Font.BOLD,20));
		player2Label.setBounds(80,260,400,200);
		player2Field.setBounds(80,400,800,40);
		player2Field.setFont(new Font("SansSerif",Font.BOLD,20));
		player1Field.setOpaque(false);
		player2Field.setOpaque(false);
		okButton.setFont(new Font("Game of Thrones",Font.PLAIN,40));
		okButton.setBounds(420,500,150,70);
		okButton.setOpaque(false);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		add(player1Label);
		add(player1Field);
		add(player2Label);
		add(player2Field);
		add(okButton);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			Player player1 = new Player(player1Field.getText());
			Player player2 = new Player(player2Field.getText());
			Game newGame = new Game(player1,player2);
			frame.setGame(new GamePanel(newGame,frame));
			frame.getContentPane().add(frame.getGame());
			((CardLayout) frame.getContentPane().getLayout()).next(frame.getContentPane());
		}
	}
}
