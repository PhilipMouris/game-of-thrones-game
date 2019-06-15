package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BackgroundPanel extends JPanel{
	
	private Image image;
	   
	 public BackgroundPanel(Image image) {
	        this.image = image;
   }
     @Override
	 protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
	 }
     
     public Image getImage() {
 		return image;
 	}
 	public void setImage(Image image) {
 		this.image = image;
 	}
}
