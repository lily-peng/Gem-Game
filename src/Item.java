import java.awt.*;


/**
 * This abstract class Item is a superclass of Gem, Potion, and Drug.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public abstract class Item 
{
	private int value;
	private int row; //location
	private int col; //location
	
	/**
	 * Constructor for Item.
	 * @param row row location
	 * @param col column location
	 * @param value value of the item
	 */
	public Item(int row, int col, int value)
	{
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	/**
	 * This abstract class draws the Item.
	 * @param g Graphics g object being drawn on.
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Getter for instance variable value.
	 * @return int value
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Getter for instance variable column.
	 * @return int col
	 */
	public int getColumn()
	{
		return col;
	}
	
	/**
	 * Getter for instance variable row.
	 * @return int row
	 */
	public int getRow()
	{
		return row;
	}
	
}
