import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is a subclass of Tile. It's a Floor that can be walked on. 
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Floor extends Tile
{

	private Item i;
	
	/**
	 * This is the constructor of Floor if there is an Item on it.
	 * @param row which row the tile is on
	 * @param col which column the tile is on
	 * @param i the item on the floor
	 */
	public Floor(int row, int col, Item i)
	{
		super(row, col);
		this.i = i;
	}
	
	/**
	 * This is the constructor of Floor if there is no Item on it.
	 * @param row which row the tile is on
	 * @param col which column the tile is on
	 */
	public Floor(int row, int col) 
	{
		super(row, col);
		i = null;
	}
	
	/**
	 * This method checks if there's an Item on the tile
	 * @return true if there is an Item on the tile, false otherwise
	 */
	public boolean hasItem()
	{
		if (i != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method collects the Item on the tile
	 * @return the Item on the tile
	 */
	public Item collectItem()
	{
		return i;
	}

	/**
	 * This method draws the Tile on the Graphics object using its location and width/height
	 */
	public void draw(Graphics g)
	{
		if (i != null)
		{
			i.draw(g);
		}
		else
		{
			g.setColor(Color.white);
			g.fillRect(super.getRow() * WIDTH, super.getColumn() * HEIGHT, WIDTH, HEIGHT);
		}
	}

	/**
	 * This method determines if the tile is passable, or able to be moved on. Floors are passable.
	 */
	public boolean isPassable()
	{
		return true;
	}
}
