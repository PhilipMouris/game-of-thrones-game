package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class MainFrame extends JFrame {
	
	private MenuPanel menu;
	private FormPanel form;
	private GamePanel game;
	private WinningPanel win;
	private BackgroundPanel back;
	
	public MainFrame() {
		super();
		setSize(1000,800);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setTitle("SuperHeros Chess (GOT Edition)");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menu = new MenuPanel(this);
		form = new FormPanel(this);
		back = new BackgroundPanel(new ImageIcon("resources/pic1.png").getImage());
		setContentPane(back);
		getContentPane().setLayout(new CardLayout());	
		getContentPane().add(menu);
		getContentPane().add(form);
	}
	
	public FormPanel getForm() {
		return form;
	}

	public void setForm(FormPanel form) {
		this.form = form;
	}

	public BackgroundPanel getBack() {
		return back;
	}

	public void setBack(BackgroundPanel back) {
		this.back = back;
	}

	public WinningPanel getWin() {
		return win;
	}

	public void setWin(WinningPanel win) {
		this.win = win;
	}


	public void setGame(GamePanel game) {
		this.game = game;
	}

	public GamePanel getGame() {
		return game;
	}
	
	private void startMusic() {
	
		try {	File file = new File("GoT.wav");
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(file));
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		return;
		} catch(Exception e) {
		System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws FontFormatException, IOException {
		MainFrame test = new MainFrame();
		test.setVisible(true);
		test.startMusic();
	}
}
