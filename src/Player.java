import java.awt.*;

/**
 * This class Player represents the Player the user will control.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Player 
{
	private int row; //location
	private int col; //location
	
	private int health;
	private boolean hit; //one hit at a time
	
	private Game game;
	
	/**
	 * This is the constructor for Player. It sets the Player's health to 5.
	 * @param game the Gem Game
	 * @param row the row the player is located on
	 * @param col the column the player is located on
	 */
	public Player(Game game, int row, int col)
	{
		this.game = game;
		this.row = row;
		this.col = col;
		health = 5;
		hit = false;
	}
	
	/**
	 * This method moves the player to a new row and/or column.
	 * @param aRow the increment you're moving by rows (-1, 0, 1)
	 * @param aCol the increment you're moving by columns (-1, 0, 1)
	 */
	public void move(int aRow, int aCol) //how much you're moving
	{	
		if (game.getFreeze() == true)
		{
			//Player doesn't move if he/she has won the game.
		}
		else
		{
			if (aRow + row >= 0 && col + aCol >= 0 && row + aRow < 10 && col + aCol < 10 && game.getLevel().getTiles()[row + aRow][col + aCol].isPassable())
			{
				row = row + aRow;
				col = col + aCol;
			}
		}
	}
	
	/**
	 * This method draws the Player in the game using its location and height/width.
	 * @param g The Graphics object being drawn on
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval(row * Tile.WIDTH, col * Tile.WIDTH, Tile.WIDTH, Tile.HEIGHT);
	}
	
	/**
	 * This is a getter for the instance variable row.
	 * @return int row
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * This is a getter for the instance variable col.
	 * @return int col
	 */
	public int getColumn()
	{
		return col;
	}
	
	/**
	 * This method alters the Player's health if he/she has been attacked or healed.
	 * @param damage how much damage the Player has taken (negative if healed)
	 */
	public void attacked(int damage)
	{
		if (hit == false)
		{
			health = health - damage;
			hit = true;
			if (health <= 0)
			{
				game.lose();
			}
		}
	}
	
	/**
	 * This method controls the Player getting hit only one at a time.
	 */
	public void nextTurn()
	{
		hit = false;
	}
	
	/**
	 * This is a getter for the Player's HP.
	 * @return int health
	 */
	public int getHP()
	{
		return health;
	}
}
