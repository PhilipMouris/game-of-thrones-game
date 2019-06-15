package view;
import javax.swing.*;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel {
	
	private Game game;
	private GamePanel gamePanel;
	
	public BoardPanel(Game game,GamePanel gamePanel) {
		this.game=game;
		this.gamePanel=gamePanel;
		setOpaque(false);
		setLayout(new GridLayout(7,6));
		for(int i=0;i<7;i++)
			for(int j=0;j<6;j++) {
				BoardButton button = new BoardButton(game.getCellAt(i,j),i,j);
				button.addActionListener(gamePanel);
				add(button);
			}
	}
}
