package controller;
import javax.swing.*;

import model.game.Direction;
import view.GamePanel;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel{
	
	private GamePanel gamePanel;
	
	public ControlPanel(GamePanel gamePanel) {
		this.gamePanel=gamePanel;
		setLayout(new GridLayout(3,3));
		setOpaque(false);
		DirectionButton upLeft = new DirectionButton(Direction.UPLEFT,new ImageIcon("resources/upleft.png"));
		upLeft.addActionListener(gamePanel);
		upLeft.setOpaque(false);
		upLeft.setContentAreaFilled(false);
		upLeft.setBorderPainted(false);
		add(upLeft);
		DirectionButton up = new DirectionButton(Direction.UP,new ImageIcon("resources/up.png"));
		up.addActionListener(gamePanel);
		up.setOpaque(false);
		up.setContentAreaFilled(false);
		up.setBorderPainted(false);
		add(up);
		DirectionButton upRight = new DirectionButton(Direction.UPRIGHT,new ImageIcon("resources/upright.png"));
		upRight.addActionListener(gamePanel);
		upRight.setOpaque(false);
		upRight.setContentAreaFilled(false);
		upRight.setBorderPainted(false);
		add(upRight);
		DirectionButton left = new DirectionButton(Direction.LEFT,new ImageIcon("resources/left.png"));
		left.addActionListener(gamePanel);
		left.setOpaque(false);
		left.setContentAreaFilled(false);
		left.setBorderPainted(false);
		add(left);
		JButton power = new JButton(new ImageIcon("resources/power.png"));
		power.setActionCommand("Power");
		power.addActionListener(gamePanel);
		power.setOpaque(false);
		power.setContentAreaFilled(false);
		power.setBorderPainted(false);
		add(power);
		DirectionButton right = new DirectionButton(Direction.RIGHT,new ImageIcon("resources/right.png"));
		right.addActionListener(gamePanel);
		right.setOpaque(false);
		right.setContentAreaFilled(false);
		right.setBorderPainted(false);
		add(right);
		DirectionButton downLeft = new DirectionButton(Direction.DOWNLEFT,new ImageIcon("resources/downleft.png"));
		downLeft.addActionListener(gamePanel);
		downLeft.setOpaque(false);
		downLeft.setContentAreaFilled(false);
		downLeft.setBorderPainted(false);
		add(downLeft);
		DirectionButton down = new DirectionButton(Direction.DOWN,new ImageIcon("resources/down.png"));
		down.addActionListener(gamePanel);
		down.setOpaque(false);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		add(down);
		DirectionButton downRight = new DirectionButton(Direction.DOWNRIGHT,new ImageIcon("resources/downright.png"));
		downRight.addActionListener(gamePanel);
		downRight.setOpaque(false);
		downRight.setContentAreaFilled(false);
		downRight.setBorderPainted(false);
		add(downRight);
	}
}
