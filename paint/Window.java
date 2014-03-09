package paint;

import javax.swing.*; // Bibliothèque graphique
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.util.*;

public class Window extends JFrame implements MouseListener, MouseMotionListener
{
	/*
	 * Attributes
	 */

	public TopPanel topPanel;
	public BotPanel botPanel;
	public BorderLayout borderLayout;
	public Sheet sheet;
//	public SheetListener sheetListener;
	
	public ArrayList<Shape> shapeList;
	
	public int xs,ys,xf,yf;
	
	/*
	 * Constructors
	 */
	 
	public Window()
	{
		borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setSize(640,480);
		this.setTitle("YoloPaint");
		this.setLocation(0,0);
		shapeList = new ArrayList<Shape>();
		
		topPanel = new TopPanel(this);
		this.add(topPanel, BorderLayout.NORTH);

		botPanel = new BotPanel();
		this.add(botPanel, BorderLayout.SOUTH);

		sheet = new Sheet();
//		sheetListener = new SheetListener(this);
//		sheet.addMouseListener(sheetListener);
//		sheet.addMouseMotionListener(sheetListener);
		
		sheet.addMouseListener(this);
		sheet.addMouseMotionListener(this);
		
		this.add(sheet, BorderLayout.CENTER);
	}
	
	
	/*
	 * Overrides
	 */
	
//	@Override
	public void mouseClicked(MouseEvent me)
	{
		
	}
	
//	@Override
	public void mousePressed(MouseEvent me)
	{
		xs = me.getX();
		ys = me.getY();
	}
	
//	@Override
	public void mouseReleased(MouseEvent me)
	{
		xf = me.getX();
		yf = me.getY();
		
		Graphics toDraw = sheet.getGraphics();
		Color lineColor;

		// Sélection de la couleur
		switch(topPanel.colors.getSelectedIndex())
		{
			case 0:
				lineColor = Color.blue;
				break;
			case 1:
				lineColor = Color.red;
				break;
			case 2:
				lineColor = Color.green;
				break;
			default:
				lineColor = Color.black;
		}
		toDraw.setColor(lineColor);
		
		// Sélection de la forme
		switch(topPanel.shapes.getSelectedIndex())
		{
			case 0: // Rectangle
				shapeList.add(new Rectangle(xs,ys,xf,yf,lineColor));
				
				toDraw.drawLine(xs,ys,xs,yf);
				toDraw.drawLine(xs,yf,xf,yf);
				toDraw.drawLine(xf,yf,xf,ys);
				toDraw.drawLine(xf,ys,xs,ys);
				botPanel.message.setText("Rectangle drawn.");
				break;
			case 1: // Cercle
				shapeList.add(new Circle(xs,ys,xf,yf,lineColor));
				
				toDraw.drawOval(Math.min(xs,xf), Math.min(ys,yf), Math.abs(xs-xf), Math.abs(ys-yf));
				botPanel.message.setText("Circle drawn.");
				break;
			case 2: // Ligne
				shapeList.add(new Line(xs,ys,xf,yf,lineColor));
				
				toDraw.drawLine(xs,ys,xf,yf);
				botPanel.message.setText("Line drawn.");
				break;
		}
	}
	
//	@Override
	public void mouseEntered(MouseEvent me)
	{
		
	}

//	@Override
	public void mouseExited(MouseEvent me)
	{
		
	}
//	@Override
	public void mouseDragged(MouseEvent me)
	{
		// Effacer la forme et la redessiner avec les nouvelles coord. TO_DO
	}
	
//	@Override
	public void mouseMoved(MouseEvent me)
	{
		botPanel.x.setText("x="+me.getX());
		botPanel.y.setText("y="+me.getY());
	}
}
