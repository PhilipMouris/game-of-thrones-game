package controller;
import javax.swing.*;

import model.game.Direction;

import java.awt.*;
import java.awt.event.*;

public class DirectionButton extends JButton{
	
	private Direction r;
	private ImageIcon image;
	
	public DirectionButton(Direction r,ImageIcon image) {
		super(image);
		this.r=r;
		
	}

	public Direction getR() {
		return r;
	}
}
