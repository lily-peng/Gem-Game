import java.awt.Color;
import java.awt.Graphics;

/**
 * This class Wall is a subclass of Tile.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Wall extends Tile
{

	/**
	 * This is the constructor of Wall. 
	 * @param row the row the tile is at
	 * @param col the column the tile is at
	 */
	public Wall(int row, int col) 
	{
		super(row, col);
	}
	
	/**
	 * This method draws the wall using its location and height/width.
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(super.getRow() * WIDTH, super.getColumn() * HEIGHT, WIDTH, HEIGHT);
	}
	
	/**
	 * This method returns false because walls are not passable.
	 */
	public boolean isPassable()
	{
		return false;
	}
	
	
}
