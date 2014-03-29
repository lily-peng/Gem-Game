import java.awt.*;

/**
 * This abstract class Monster represents the Monsters of the game.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public abstract class Monster 
{
	private Game game;
	protected int row; //location
	protected int col; //location
	
	/**
	 * Constructor for Monster, initializes intance variables.
	 * @param game Gem Game
	 * @param row the row location
	 * @param col the column location
	 */
	public Monster(Game game, int row, int col)
	{
		this.game = game;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Abstract method to attack the Player.
	 * @param p
	 */
	public abstract void attackPlayer(Player p);
	
	/**
	 * Abstract method to draw the Monster object.
	 * @param g
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Abstract method to move the Monster.
	 */
	public abstract void move();
	
	/**
	 * Getter for instance variable row.
	 * @return int row
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Getter for instance variable col
	 * @return int col
	 */
	public int getColumn()
	{
		return col;
	}
	
	/**
	 * Getter for instance variable game
	 * @return Game game
	 */
	public Game getGame()
	{
		return game;
	}
}
