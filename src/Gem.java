import java.awt.Color;
import java.awt.Graphics;

/**
 * This class Gem is a subclass of Item.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Gem extends Item
{

	/**
	 * Constructor for Gem. Sets Gem's value to 1.
	 * @param row row location
	 * @param col column location
	 */
	public Gem(int row, int col) 
	{
		super(row, col, 1); //gem has value of 1
	}

	/**
	 * Draws the Gem object.
	 */
	public void draw(Graphics g) 
	{
		g.setColor(Color.cyan);
		g.fillOval(super.getRow() * Tile.WIDTH, super.getColumn() * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
	}
}
