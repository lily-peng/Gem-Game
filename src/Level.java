import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * This class Level contains the array of tiles and ArrayList of Monsters. It moves and draws monsters, and picks up items.
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Level 
{
	private Tile[][] t;
	private Game game;
	private int gemsLeft; //number of gems left in the game
	private int rows;
	private int columns;
	private Player player;
	private ArrayList<Monster> array;
	private int count; //how many gems collected
	private Random rand;
	
	/**
	 * This is the constructor for Level. It sets up the instance variables.
	 * @param game
	 * @param player
	 */
	public Level(Game game, Player player)
	{
		t = new Tile[10][10];
		this.game = game;
		this.player = player;
		gemsLeft = 0;
		count = 0;
		rows = game.getRows();
		columns = game.getColumns();
		array = new ArrayList<Monster>();
		rand = new Random();
		
		levelConstruct();
	}
	
	/**
	 * This method either takes in a file to read the level or randomly generates one.
	 */
	public void levelConstruct()
	{
		//If there is a file to read the level, reads from that level
		try
		{ 
			Scanner s = new Scanner(new File("Sample Level.txt"));
			
			int row = 0;
			while (s.hasNext())
			{
				String f = s.next();
				
				for (int i =0; i < 10; i++)
				{
					if (f.substring(i, i+1).equals("-"))
					{
						t[row][i] = new Floor(row, i);
					}
					else if (f.substring(i, i+1).equals("x"))
					{
						t[row][i] = new Wall(row, i);
					}
					else if (f.substring(i, i+1).equals("g"))
					{
						t[row][i] = new Floor(row, i, new Gem(row, i));
						gemsLeft = gemsLeft + 1;
					}
					else if (f.substring(i, i+1).equals("p")) //potion
					{
						t[row][i] = new Floor(row, i, new Potion(row, i));
					}
					else if (f.substring(i, i+1).equals("m"))
					{
						t[row][i] = new Floor(row, i);
						array.add(new SimpleMonster(game, row, i, rand.nextInt(3)-1, rand.nextInt(3)-1));
					}
					else if (f.substring(i, i+1).equals("s")) //spikes
					{
						t[row][i] = new Spikes(row, i);
					}
					else if (f.substring(i, i+1).equals("d")) //drug
					{
						t[row][i] = new Floor(row, i, new Drug(row, i));
					}
				}
				
				row++;
			}
		}
		
		
		catch (FileNotFoundException e)
		{
			for (int i = 0; i < t.length; i++)
			{
				for (int j = 0; j < t[i].length; j++)
				{
					double r = rand.nextDouble();
					if (r <= .15)
					{
						t[i][j] = new Wall(i, j); //.15 chance wall tiles
					}
					else if (r > .15 && r <= .25)
					{
						t[i][j] = new Floor(i, j, new Gem(i, j));
						gemsLeft = gemsLeft + 1;
					}
					else if (r > .25 && r <= .30)
					{
						t[i][j] = new Floor(i, j, new Potion(i, j));
					}
					else if (r > .30 && r <= .35)
					{
						t[i][j] = new Floor(i, j, new Drug(i, j));
					}
					else if (r > .35 && r <= .40)
					{
						t[i][j] = new Spikes(i, j);
					}
					else if (r > .40 && r <= .50)
					{
						t[i][j] = new Floor(i, j);
						if (i != 0 && j != 0)
						{
							array.add(new SimpleMonster(game, i, j, new Random().nextInt(3) - 1, new Random().nextInt(3) - 1));
						}
					}
					else
					{
						t[i][j] = new Floor(i, j);
					}	
				}
			}
			
			t[0][0] = new Floor(0, 0);
			
		}	
	}
	
	/** 
	 * This method draws the tiles in the array, the player, performs tile actions, and draws the monsters.
	 * @param g Graphics object being drawn on
	 */
	public void draw(Graphics g)
	{
		for (int i = 0; i < t.length; i++)
		{
			for (int j = 0; j < t[i].length; j++)
			{
				t[i][j].draw(g);
			}
		}
		
		player.draw(g);
		tileAction(player.getRow(), player.getColumn());
		
		for (Monster m : array)
		{
			if (m.getRow() != 0 && m.getColumn() != 0)
			{
				m.draw(g);
			}
		}	
	}
	
	/**
	 * This method moves the Monsters in the ArrayList.
 	*/
	public void move()
	{
		for(Monster m: array)
		{
			m.move();
		}
	}
	
	/**
	 * This method performs actions according to which Tile the Player is standing on. Also hurts Player if attacked.
	 * @param row
	 * @param col
	 */
	public void tileAction(int row, int col)
	{
		if (t[row][col] instanceof Floor && player.getRow() == row && player.getColumn() == col)
		{
			if (((Floor) t[row][col]).hasItem())
			{
				if (((Floor) t[row][col]).collectItem() instanceof Gem)
				{
					t[row][col] = new Floor(row, col);
					count = count + 1;
					gemsLeft = gemsLeft - 1;
					if (gemsLeft == 0)
					{
						game.win();
					}
				}
				
				else if (((Floor) t[row][col]).collectItem() instanceof Potion) //potion heals by 1
				{
					t[row][col] = new Floor(row, col);
					player.attacked(-1);
				}
				
				else if (((Floor) t[row][col]).collectItem() instanceof Drug) //drug hurts by 1
				{
					t[row][col] = new Floor(row, col);
					player.attacked(1);
				}
				
				else
				{
					t[row][col] = new Floor(row, col);
					player.attacked(1);
				}
			}
		}
		
		if (t[row][col] instanceof Spikes && player.getRow() == row && player.getColumn() == col) //if spikes
		{
			player.attacked(1);
		}
		
		for (Monster m: array)
		{
			if (m.getColumn() == player.getColumn() && m.getRow() == player.getRow())
			{
				player.attacked(1);
			}
		}
	}
	
	/**
	 * This method is a getter for the 2D tile array.
	 * @return Tile[][] t
	 */
	public Tile[][] getTiles()
	{
		return t;
	}
	
	/**
	 * This method is a getter for count, how many gems the player has picked up.
	 * @return int count
	 */
	public int getScore()
	{
		return count;
	}
	
	/**
	 * This method is a getter for how many gems are left in the level.
	 * @return int gemsLeft
	 */
	public int getGemsLeft()
	{
		return gemsLeft;
	}
}
