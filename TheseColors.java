import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TheseColors extends JComponent{
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g.fillRect(0, 0, 270, 370);
		
	// Shape I
		Color Pink = new Color(255, 102, 255);
		// Light
		g.setColor(Pink);
		g.fillRect(0, 0, 30, 30);
		// Main
		g.setColor(Pink.darker());
		g.fillRect(40, 0, 30, 30);
		// Darker
		g.setColor(Pink.darker().darker());
		g.fillRect(80, 0, 30, 30);
		
	// Shape L
		Color lightBlue = new Color(0, 255, 255);
		// Light
		g.setColor(lightBlue);
		g.fillRect(0, 40, 30, 30);
		// Main
		g.setColor(lightBlue.darker());
		g.fillRect(40, 40, 30, 30);
		// Darker
		g.setColor(lightBlue.darker().darker());
		g.fillRect(80, 40, 30, 30);
		
	// Shape J(Mirrored L)
		// Light
		g.setColor(Color.BLUE);
		g.fillRect(0, 80, 30, 30);
		// Main
		g.setColor(Color.BLUE.darker());
		g.fillRect(40, 80, 30, 30);
		// Darker
		g.setColor(Color.BLUE.darker().darker());
		g.fillRect(80, 80, 30, 30);
		
	// Shape N
		Color myOrange = new Color(255, 79, 0);
		// Light
		g.setColor(myOrange);
		g.fillRect(0, 120, 30, 30);
		// Main
		g.setColor(myOrange.darker());
		g.fillRect(40, 120, 30, 30);
		// Darker
		g.setColor(myOrange.darker().darker());
		g.fillRect(80, 120, 30, 30);
		
	// Shape M(Mirrored N)
		Color lightOrange = new Color(255, 178, 102);
		// Light
		g.setColor(lightOrange);
		g.fillRect(0, 160, 30, 30);
		// Main
		g.setColor(lightOrange.darker());
		g.fillRect(40, 160, 30, 30);
		// Darker
		g.setColor(lightOrange.darker().darker());
		g.fillRect(80, 160, 30, 30);
		
	// Shape F
		Color Green = new Color(0, 204, 0);
		// Light
		g.setColor(Green);
		g.fillRect(0, 200, 30, 30);
		// Main
		g.setColor(Green.darker());
		g.fillRect(40, 200, 30, 30);
		// Darker
		g.setColor(Green.darker().darker());
		g.fillRect(80, 200, 30, 30);
		
	// Shape E(Mirrored F)
		Color lightGreen = new Color(102, 255, 102);
		// Light
		g.setColor(lightGreen);
		g.fillRect(0, 240, 30, 30);
		// Main
		g.setColor(lightGreen.darker());
		g.fillRect(40, 240, 30, 30);
		// Darker
		g.setColor(lightGreen.darker().darker());
		g.fillRect(80, 240, 30, 30);
		
	// Shape P
		// Light
		g.setColor(Color.RED);
		g.fillRect(0, 280, 30, 30);
		// Main
		g.setColor(Color.RED.darker());
		g.fillRect(40, 280, 30, 30);
		// Darker
		g.setColor(Color.RED.darker().darker());
		g.fillRect(80, 280, 30, 30);
		
	// Shape Q(Mirrored P)
		Color lightRed = new Color(255, 102, 102);
		// Light
		g.setColor(lightRed);
		g.fillRect(0, 320, 30, 30);
		// Main
		g.setColor(lightRed.darker());
		g.fillRect(40, 320, 30, 30);
		// Darker
		g.setColor(lightRed.darker().darker());
		g.fillRect(80, 320, 30, 30);
		
	// Shape T
		Color someBlue = new Color(137, 107, 255);
		// Light
		g.setColor(someBlue);
		g.fillRect(160, 0, 30, 30);
		// Main
		g.setColor(someBlue.darker());
		g.fillRect(200, 0, 30, 30);
		// Darker
		g.setColor(someBlue.darker().darker());
		g.fillRect(240, 0, 30, 30);
		
	// Shape U
		Color Gold = new Color(218, 165, 32);
		// Light
		g.setColor(Gold);
		g.fillRect(160, 40, 30, 30);
		// Main
		g.setColor(Gold.darker());
		g.fillRect(200, 40, 30, 30);
		// Darker
		g.setColor(Gold.darker().darker());
		g.fillRect(240, 40, 30, 30);
		
	// Shape V
		Color Army = new Color(0, 102, 0);
		// Light
		g.setColor(Army);
		g.fillRect(160, 80, 30, 30);
		// Main
		g.setColor(Army.darker());
		g.fillRect(200, 80, 30, 30);
		// Darker
		g.setColor(Army.darker().darker());
		g.fillRect(240, 80, 30, 30);
		
	// Shape W
		Color Purple = new Color(153, 0, 153);
		// Light
		g.setColor(Purple);
		g.fillRect(160, 120, 30, 30);
		// Main
		g.setColor(Purple.darker());
		g.fillRect(200, 120, 30, 30);
		// Darker
		g.setColor(Purple.darker().darker());
		g.fillRect(240, 120, 30, 30);
		
	// Shape X
		Color Brown = new Color(127, 35, 17);
		// Light
		g.setColor(Brown);
		g.fillRect(160, 160, 30, 30);
		// Main
		g.setColor(Brown.darker());
		g.fillRect(200, 160, 30, 30);
		// Darker
		g.setColor(Brown.darker().darker());
		g.fillRect(240, 160, 30, 30);
		
	// Shape Y
		// Light
		g.setColor(Color.YELLOW);
		g.fillRect(160, 200, 30, 30);
		// Main
		g.setColor(Color.YELLOW.darker());
		g.fillRect(200, 200, 30, 30);
		// Darker
		g.setColor(Color.YELLOW.darker().darker());
		g.fillRect(240, 200, 30, 30);
		
	// Shape H(Mirrored Y)
		Color lightYellow = new Color(255, 255, 153);
		// Light
		g.setColor(lightYellow);
		g.fillRect(160, 240, 30, 30);
		// Main
		g.setColor(lightYellow.darker());
		g.fillRect(200, 240, 30, 30);
		// Darker
		g.setColor(lightYellow.darker().darker());
		g.fillRect(240, 240, 30, 30);
		
	// Shape Z
		// Light
		g.setColor(Color.WHITE);
		g.fillRect(160, 280, 30, 30);
		// Main
		g.setColor(Color.WHITE.darker());
		g.fillRect(200, 280, 30, 30);
		// Darker
		g.setColor(Color.WHITE.darker().darker());
		g.fillRect(240, 280, 30, 30);
		
	// Shape S(Mirrored Z)
		Color Grey = new Color(128, 128, 128);
		// Light
		g.setColor(Grey);
		g.fillRect(160, 320, 30, 30);
		// Main
		g.setColor(Grey.darker());
		g.fillRect(200, 320, 30, 30);
		// Darker
		g.setColor(Grey.darker().darker());
		g.fillRect(240, 320, 30, 30);
	}
}