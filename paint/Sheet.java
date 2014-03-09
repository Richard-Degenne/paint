package paint;

import javax.swing.*;
import java.awt.*;

public class Sheet extends Canvas
{
	/*
	 * Attributes
	 */

	public Color background;
	/*
	 * Constructors
	 */
	 
	public Sheet()
	{
		background = Color.white;
		this.setBackground(background);
	}
}
