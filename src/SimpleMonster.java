import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

/**
 * This class SimpleMonster is a subclass of Monster.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class SimpleMonster extends Monster
{
	private int aRow;
	private int aCol;
	private Random rand;
	
	/**
	 * Constructor for SimpleMonster. Initilizes all instance variables.
	 * @param game Gem Game
	 * @param row row location of SimpleMonster
	 * @param col col location
	 * @param aRow increment of row to move
	 * @param aCol increment of col to move
	 */
	public SimpleMonster(Game game, int row, int col, int aRow, int aCol) 
	{
		super(game, row, col);
		this.aRow = aRow;
		this.aCol = aCol;
		rand = new Random();
	}
	/**
	 * Draws the monster onto the Gem Game
	 */
	public void draw(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRoundRect(row * Tile.WIDTH, col * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT, 15, 15);
	}

	/**
	 * Moves the Monster in a random fashion. Checks that monster is moving into a passable tile, and 
	 * that the mosnter is not moving off the level first.
	 */
	public void move() 
	{
		aRow = rand.nextInt(3) - 1;
		aCol = rand.nextInt(3) - 1;
		
			if ((row + aRow < 10) && (row + aRow >= 0) && (col + aCol < 10) && (col + aCol >= 0))
			{
				if (super.getGame().getLevel().getTiles()[row + aRow][aCol + col].isPassable())
				{
					row = row + aRow;
					col = col + aCol;
				}
			}
			
			else
			{
				aRow = -1 * aRow;
				aCol = -1 * aCol;
				if ((row + aRow < 10) && (row + aRow >= 0) && (col + aCol < 10) && (col + aCol >= 0))
				{
					if (super.getGame().getLevel().getTiles()[row + aRow][aCol + col].isPassable())
					{
						row = row + aRow;
						col = col + aCol;
					}
				}	
			}
		}
	
	/**
	 * This method attacks the player for 1 HP.
	 */
	public void attackPlayer(Player p)
	{
		p.attacked(1);
	}
	
	/**
	 * This method is a getter for aRow.
	 * @return int aRow
	 */
	public int getARow()
	{
		return aRow;
	}
	
	/**
	 * This method is a getter for aCol.
	 * @return int aCol
	 */
	public int getACol()
	{
		return aCol;
	}
	
}
