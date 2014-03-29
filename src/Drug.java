import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is a subclass of Item. It harms the Player by 1 HP.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Drug extends Item
{

	/**
	 * Constructor for Drug. Drug has a value of 0.
	 * @param row row location of Drug
	 * @param col column location of Drug
	 */
	public Drug(int row, int col) 
	{
		super(row, col, 0); //drug has no value
	}

	/**
	 * Draws the Drug Item onto the Game. 
	 */
	public void draw(Graphics g) 
	{
		g.setColor(Color.pink);
		g.fillOval(super.getRow() * Tile.WIDTH, super.getColumn() * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
	}
	
}
