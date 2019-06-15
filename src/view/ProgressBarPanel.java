package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressBarPanel extends JPanel{
	
	private JProgressBar bar1;
	private JProgressBar bar2;
	private JLabel starks;
	private JLabel lannisters;
	
	public ProgressBarPanel() {
		setOpaque(false);
		bar1 = new JProgressBar(0,6);
		bar2 = new JProgressBar(0,6);
		bar1.setValue(0);
		bar2.setValue(0);
		bar1.setString("Starks");
		bar2.setString("Lannisters");
		starks = new JLabel("Starks");
		lannisters = new JLabel("Lannisters");
		starks.setFont(new Font("Game of Thrones",Font.PLAIN,17));
		lannisters.setFont(new Font("Game of Thrones",Font.PLAIN,17));
		bar1.setOpaque(false);
		bar2.setOpaque(false);
		setLayout(new GridLayout(2,2));
		add(starks);
		add(lannisters);
		add(bar1);
		add(bar2);
	}

	public JLabel getStarks() {
		return starks;
	}

	public JLabel getLannisters() {
		return lannisters;
	}

	public JProgressBar getBar1() {
		return bar1;
	}

	public JProgressBar getBar2() {
		return bar2;
	}

	public void setBar1(JProgressBar bar1) {
		this.bar1 = bar1;
	}

	public void setBar2(JProgressBar bar2) {
		this.bar2 = bar2;
	}
	
	
}
