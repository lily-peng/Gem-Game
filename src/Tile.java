import java.awt.*;

/**
 * This abstract class Tile is the superclass of Floor, Wall, and Spikes.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public abstract class Tile 
{

	public static final int WIDTH = 40; 
	public static final int HEIGHT = 40;
	
	private int row; //which row the tile is on
	private int col; //which column the tile is on
	
	/**
	 * This is the constructor of Tile.
	 * @param row which row the tile is on
	 * @param col while column the tile is on
	 */
	public Tile(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	/**
	 * This abstract method draw is used in the subclasses of Tile. Draws the Tile.
	 * @param g Graphics object drawn on
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * This abstract method isPassable is used in the subclasses of Tile.
	 * @return
	 */
	public abstract boolean isPassable(); 
	
	/**
	 * This is a getter for the instance variable row.
	 * @return int row
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * This is a getter for the instance variable column.
	 * @return int col
	 */
	public int getColumn()
	{
		return col;
	}
	
}
