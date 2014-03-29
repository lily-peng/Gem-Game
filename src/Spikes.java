import java.awt.Color;
import java.awt.Graphics;

/**
 * This class Spikes is a subclass of Tile. It hurts the Player as long as he/she stands on it.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Spikes extends Tile
{
	/**
	 * This is the constructor for Spikes
	 * @param row the row the spikes are located on
	 * @param col the col the spikes are located on
	 */
	public Spikes(int row, int col) 
	{
		super(row, col);
	}
	
	/**
	 * This method draws the Spikes using its location and height/width
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRect(super.getRow() * WIDTH, super.getColumn() * HEIGHT, WIDTH, HEIGHT);
	}
	
	/**
	 * This method returns true because the Spikes are passable.
	 */
	public boolean isPassable()
	{
		return true;
	}
	
	
}
