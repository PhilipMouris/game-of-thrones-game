package view;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener{
	
	private JButton startButton;
	private MainFrame frame;
	
	public MenuPanel(MainFrame frame) {
		super();
		this.frame=frame;
		setLayout(null);
		startButton = new JButton("START");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new FileInputStream("resources/Game of Thrones.ttf")));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startButton.setFont(new Font("Game of Thrones",Font.PLAIN,40));
		startButton.setBounds(400,610,200,70);
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		startButton.addActionListener(this);
		add(startButton);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("START")) {
			frame.dispose();
			frame.setBack(new BackgroundPanel(new ImageIcon("resources/pic4.png").getImage()));
			frame.setContentPane(frame.getBack());
			frame.getContentPane().setLayout(new CardLayout());
			frame.getContentPane().add(frame.getForm());
			frame.setVisible(true);
		}
	}
}
