import java.awt.Color;
import java.awt.Graphics;

/**
 * This class Potion is a subclass of Item.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Potion extends Item
{
	/**
	 * This constructor of Potion initializes the instance variables. Potion has a value of 0.
	 * @param row
	 * @param col
	 */
	public Potion(int row, int col) 
	{
		super(row, col, 0); //potion has no value
	}

	/**
	 * This method draws the Potion object into the Game.
	 */
	public void draw(Graphics g) 
	{
		g.setColor(Color.green);
		g.fillOval(super.getRow() * Tile.WIDTH, super.getColumn() * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
	}
	
}
