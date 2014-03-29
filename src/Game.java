import javax.swing.*;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.*;

/**
 * This class contains the main method to run Gem Game. It contains Player, Level, and LevelPanel references. 
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class Game 
{
	private Level level;
	private Player player;
	private static LevelPanel panel;
	private Timer time;
	private int rows; //how many rows in the level
	private int columns; //how many columns in the level
	private boolean freeze;
	
	/**
	 * Constructor for Game. It initializes the instance variables for Game and starts the Timer.
	 */
	public Game()
	{
		player = new Player(this, 0, 0); //starting location of player
		level = new Level(this, player);
		panel = new LevelPanel(this);
		time = new Timer(400, new LevelListener());
		rows = 10;
		columns = 10;
		freeze = false;
		time.start();
	}
	
	/**
	 * This method is run when the Player collects all the Gems and beats the game.
	 * It prints a victory message, stops time, and stops the Player from moving.
	 */
	public void win()
	{
		time.stop();
		System.out.println("You win!");
		freeze = true;
	}
	
	/**
	 * This method is run when the Player loses the Game by running out of health.
	 * It prints a defeat message, stops time, and stops the Player from moving.
	 */
	public void lose()
	{
		time.stop();
		System.out.println("You lose!");
		freeze = true;
	}
	
	/**
	 * This is a getter method for the instance variable rows.
	 * @return int rows
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * This is a getter method for the instance variable columns.
	 * @return int columns
	 */
	public int getColumns()
	{
		return columns;
	}
	
	/**
	 * This is a getter method for the instance variable level.
	 * @return Level level
	 */
	public Level getLevel()
	{
		return level;
	}
	
	/**
	 * This is a getter method for the instance variable player.
	 * @return Player player
	 */
	public Player getPlayer()
	{
		return player;
	}
	
	/**
	 * This is a getter method for the instance variable freeze. This freezes the Player
	 * once the game is won or lost.
	 * @return boolean freeze
	 */
	public boolean getFreeze()
	{
		return freeze;
	}
	
	/**
	 * This is the main method. It sets up a JFrame for the game to run in.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		JFrame frame = new JFrame("Gem Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		frame.setPreferredSize(new Dimension(440, 440));
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * This class contains an ActionListener to run with Game. It moves the player, monsters, and performs tile actions. 
	 * I did not collaborate with other students on this assignment.
	 * @author Lily Peng
	 * @version 1.0
	 * @date 11/29/11
	 */
	private class LevelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player.nextTurn();
			level.move();
			for (int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					level.tileAction(i,j);
				}
			}
			
			panel.repaint();
			
		}
	}
	
}
