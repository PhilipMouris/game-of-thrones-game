package view;
import javax.swing.*;

import model.game.Game;

import java.awt.*;
import java.awt.event.*;

public class DeadPanel2 extends JPanel{
	
	private Game game;
	private GamePanel gamePanel;
	
	public DeadPanel2(Game game,GamePanel gamePanel) {
		this.game=game;
		this.gamePanel=gamePanel;
		setOpaque(false);
		setLayout(new GridLayout(12,1));
		for(int i=0;i<game.getPlayer2().getDeadCharacters().size();i++) {
			DeadButton button = new DeadButton(game.getPlayer2().getDeadCharacters().get(i));
			button.addActionListener(gamePanel);
			add(button);
		}
	}
}
