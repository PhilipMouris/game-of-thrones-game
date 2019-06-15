package view;
import javax.swing.*;

import controller.ControlPanel;
import model.game.Game;

import java.awt.*;
import java.awt.event.*;

public class BottomPanel extends JPanel{
	
	private ControlPanel control;
	private JLabel turn;
	private JLabel sigil;
	private Game game;
	
	public 	BottomPanel(ControlPanel control,Game game) {
		this.control=control;
		this.game=game;
		setOpaque(false);
		turn = new JLabel("Your move "+game.getCurrentPlayer().getName());
		setLayout(new GridLayout(1,3));
		sigil = new JLabel("",JLabel.CENTER);
		if(game.getCurrentPlayer()==game.getPlayer1())
			sigil.setIcon(new ImageIcon("resources/pic2.png"));
		else
			sigil.setIcon(new ImageIcon("resources/pic3.png"));
		turn.setFont(new Font("Game of Thrones",Font.PLAIN,20));
		add(control);
		add(sigil);
		add(turn);
	}

	public JLabel getSigil() {
		return sigil;
	}

	public void setSigil(JLabel sigil) {
		this.sigil = sigil;
	}

	public JLabel getTurn() {
		return turn;
	}

	public void setTurn(JLabel turn) {
		this.turn = turn;
	}
}
