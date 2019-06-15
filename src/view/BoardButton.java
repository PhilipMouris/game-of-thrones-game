package view;
import javax.swing.*;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

import java.awt.*;
import java.awt.event.*;

public class BoardButton extends JButton {
	
	private Cell gameCell;
	private int i;
	private int j;
	
	public BoardButton(Cell gameCell,int i,int j) {
		super(new ImageIcon("resources/tile.jpg"));
		this.gameCell=gameCell;
		this.i=i;
		this.j=j;
		if(gameCell.getPiece()!=null) {
			String name = gameCell.getPiece().getName();
			String hero = "";
			String player = "";
			String power = "";
			if(gameCell.getPiece() instanceof Armored)
				hero="Armored";
			if(gameCell.getPiece() instanceof Medic)
				hero="Medic";
			if(gameCell.getPiece() instanceof Ranged)
				hero="Ranged";
			if(gameCell.getPiece() instanceof Speedster)
				hero="Speedster";
			if(gameCell.getPiece() instanceof Super)
				hero="Super";
			if(gameCell.getPiece() instanceof Tech)
				hero="Tech";
			if(gameCell.getPiece() instanceof SideKick)
				hero="SideKick";
			player = gameCell.getPiece().getOwner().getName();
			if(gameCell.getPiece() instanceof Armored)
				if(((Armored)gameCell.getPiece()).isArmorUp())
					power = "Armor: Up";
				else
					power = "Armor: Down";
			else
				if(gameCell.getPiece() instanceof ActivatablePowerHero)
					if(((ActivatablePowerHero) gameCell.getPiece()).isPowerUsed())
						power = "Power: OFF";
					else
						power = "Power: ON";
				else
					power = "Power is always ON";
			setToolTipText("<html>"+name+"<br>"+hero+"<br>"+player+"<br>"+power+"</html>");
			if(gameCell.getPiece().getName().equals("Arya Stark"))
				setIcon(new ImageIcon("resources/arya2.png"));
			if(gameCell.getPiece().getName().equals("Ned Stark"))
				setIcon(new ImageIcon("resources/ned2.png"));
			if(gameCell.getPiece().getName().equals("Hodor"))
				setIcon(new ImageIcon("resources/hodor2.png"));
			if(gameCell.getPiece().getName().equals("Jon Snow"))
				setIcon(new ImageIcon("resources/jon2.png"));
			if(gameCell.getPiece().getName().equals("Catelyn Stark"))
				setIcon(new ImageIcon("resources/catelyn2.png"));
			if(gameCell.getPiece().getName().equals("Brandon Stark"))
				setIcon(new ImageIcon("resources/bran2.png"));
			if(gameCell.getPiece().getName().equals("Theon Greyjoy"))
				setIcon(new ImageIcon("resources/theon2.png"));
			if(gameCell.getPiece().getName().equals("The Hound"))
				setIcon(new ImageIcon("resources/hound2.png"));
			if(gameCell.getPiece().getName().equals("Jamie Lannister"))
				setIcon(new ImageIcon("resources/jamie2.png"));
			if(gameCell.getPiece().getName().equals("Bronn"))
				setIcon(new ImageIcon("resources/bronn2.png"));
			if(gameCell.getPiece().getName().equals("Cersei Lannister"))
				setIcon(new ImageIcon("resources/cersei2.png"));
			if(gameCell.getPiece().getName().equals("Tyrion Lannister"))
				setIcon(new ImageIcon("resources/tyrion2.png"));
			if(gameCell.getPiece().getName().equals("Tywin Lannister"))
				setIcon(new ImageIcon("resources/tywin2.png"));
			if(gameCell.getPiece().getName().equals("Joffrey Baratheon"))
				setIcon(new ImageIcon("resources/joffrey2.png"));
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public Cell getGameCell() {
		return gameCell;
	}

	public void setGameCell(Cell gameCell) {
		this.gameCell = gameCell;
	}
}
