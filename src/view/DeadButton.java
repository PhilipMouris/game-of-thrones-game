package view;
import javax.swing.*;

import model.pieces.Piece;

import java.awt.*;
import java.awt.event.*;

public class DeadButton extends JButton{
	
	private Piece deadPiece;
	
	public DeadButton(Piece deadPiece) {
		super();
		this.deadPiece=deadPiece;
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		if(deadPiece!=null) {
			if(deadPiece.getName().equals("Arya Stark"))
				setIcon(new ImageIcon("resources/arya.png"));
			if(deadPiece.getName().equals("Ned Stark"))
				setIcon(new ImageIcon("resources/ned.png"));
			if(deadPiece.getName().equals("Hodor"))
				setIcon(new ImageIcon("resources/hodor.png"));
			if(deadPiece.getName().equals("Jon Snow"))
				setIcon(new ImageIcon("resources/jon.png"));
			if(deadPiece.getName().equals("Catelyn Stark"))
				setIcon(new ImageIcon("resources/catelyn.png"));
			if(deadPiece.getName().equals("Brandon Stark"))
				setIcon(new ImageIcon("resources/bran.png"));
			if(deadPiece.getName().equals("Theon Greyjoy"))
				setIcon(new ImageIcon("resources/theon.png"));
			if(deadPiece.getName().equals("The Hound"))
				setIcon(new ImageIcon("resources/hound.png"));
			if(deadPiece.getName().equals("Jamie Lannister"))
				setIcon(new ImageIcon("resources/jamie.png"));
			if(deadPiece.getName().equals("Bronn"))
				setIcon(new ImageIcon("resources/bronn.png"));
			if(deadPiece.getName().equals("Cersei Lannister"))
				setIcon(new ImageIcon("resources/cersei.png"));
			if(deadPiece.getName().equals("Tyrion Lannister"))
				setIcon(new ImageIcon("resources/tyrion.png"));
			if(deadPiece.getName().equals("Tywin Lannister"))
				setIcon(new ImageIcon("resources/tywin.png"));
			if(deadPiece.getName().equals("Joffrey Baratheon"))
				setIcon(new ImageIcon("resources/joffrey.png"));
		}
	}

	public Piece getDeadPiece() {
		return deadPiece;
	}

	public void setDeadPiece(Piece deadPiece) {
		this.deadPiece = deadPiece;
	}
}
