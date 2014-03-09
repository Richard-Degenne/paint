package paint;

import javax.swing.*; // Bibliothèque graphique
import javax.swing.JPanel.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.util.*;

public class BotPanel extends JPanel
{
	/*
	 * Attributes
	 */
	
	public JLabel message;
	public JPanel coord;
	public JLabel x,y;
	public JButton clear, clearAll;
	public BorderLayout coordLayout;
	
	/*
	 * Constructor
	 */
	
	public BotPanel()
	{
		message = new JLabel("Hello World.");

		coordLayout = new BorderLayout();
		coord = new JPanel(coordLayout);
		coordLayout.setHgap(5);
		x = new JLabel("x=0");
		y = new JLabel("y=0");
		
		this.setLayout(new BorderLayout());
		
		this.add(message, BorderLayout.WEST);
		coord.add(x, BorderLayout.WEST);
		coord.add(y, BorderLayout.EAST);
		this.add(coord, BorderLayout.EAST);
	}
}
