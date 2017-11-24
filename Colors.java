import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

public class Colors{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		final int width = 270;
		final int height = 370;
		frame.setSize(width, height);
		frame.setTitle("Colors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent component = new TheseColors();
		frame.add(component);
		frame.setVisible(true);
	}
}