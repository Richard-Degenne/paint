package paint;

import java.awt.*;

public class Shape
{
	/*
	 * Attributes
	 */
	
	public int xs,ys,xf,yf;
	public Color color;
	
	
	/*
	 * Construcotrs
	 */
	
	public Shape(int newxs, int newys, int newxf, int newyf, Color c)
	{
		xs = newxs;
		xf = newxf;
		ys = newys;
		yf = newyf;
	}
}
