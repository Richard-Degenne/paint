package paint;

import javax.swing.*; // Bibliothèque graphique
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.util.*;

public class TopPanel extends JPanel implements ActionListener
{
	/*
	 * Attributes
	 */
	
	public JComboBox shapes;
	public JComboBox colors;
	public JButton clear, clearAll;
	public Window window;
	
	/*
	 * Constructors
	 */
	 
	public TopPanel(Window window)
	{
		this.window = window;
		shapes = new JComboBox();
			shapes.addItem("Rectangle");
			shapes.addItem("Circle");
			shapes.addItem("Line");
		colors = new JComboBox();
			colors.addItem("Blue");
			colors.addItem("Red");
			colors.addItem("Green");
		clear = new JButton("Clear");
		clearAll = new JButton("Clear all");

		this.add(shapes);
		this.add(colors);
		this.add(clear);
		clear.addActionListener(this);
		this.add(clearAll);
		clearAll.addActionListener(this);
	}
	
	
	/*
	 * Overrides
	 */
	
//	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// Clic sur clear
		if(ae.getSource() == clear)
		{
			try
			{
				Shape toErase = window.shapeList.get(window.shapeList.size()-1);
				clear(toErase);
			}
			catch(Exception e)
			{
				window.botPanel.message.setText("Nothing to clear.");
			}
		}
		
		// Clic sur ClearAll
		else if(ae.getSource() == clearAll)
		{
			if(window.shapeList.size() != 0)
			{
				for(int i=0 ; i < window.shapeList.size() ; )
				{
					Shape toErase = window.shapeList.get(i);
					clear(toErase);
				}
				window.botPanel.message.setText("All cleared.");
			}
			else
			{
				window.botPanel.message.setText("Nothing to clear.");
			}
		}
	}

	/*
	 * Methods
	 */

	public void clear(Shape toErase)
	{
		Graphics toDraw = window.sheet.getGraphics();
		toDraw.setColor(window.sheet.background);
		
		// Sélection de la forme
		if(toErase instanceof Rectangle)
		{
			toDraw.drawLine(toErase.xs,toErase.ys,toErase.xs,toErase.yf);
			toDraw.drawLine(toErase.xs,toErase.yf,toErase.xf,toErase.yf);
			toDraw.drawLine(toErase.xf,toErase.yf,toErase.xf,toErase.ys);
			toDraw.drawLine(toErase.xf,toErase.ys,toErase.xs,toErase.ys);
			window.botPanel.message.setText("Rectangle cleared.");
		}
		else if(toErase instanceof Circle)
		{
			toDraw.drawOval(Math.min(toErase.xs,toErase.xf), Math.min(toErase.ys,toErase.yf), Math.abs(toErase.xs-toErase.xf), Math.abs(toErase.ys-toErase.yf));
			window.botPanel.message.setText("Circle cleared.");
		}
		else if (toErase instanceof Line)
		{
			toDraw.drawLine(toErase.xs,toErase.ys,toErase.xf,toErase.yf);
			window.botPanel.message.setText("Line cleared.");
		}
		
		window.shapeList.remove(toErase);
	}
}
