import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class contains the main method to run Gem Game. It contains Player, Level, and LevelPanel references. 
 * I did not collaborate with other students on this assignment.
 * @author Lily Peng
 * @version 1.0
 * @date 11/29/11
 */
public class LevelPanel extends JPanel
{
	private Player player;
	private Level level;
	
	private JLabel status, score, gemsLeft;
	
	/**
	 * This is the constructor for LevelPanel. It initializes the JLabels and adds them as well as the KeyListener.
	 * @param game the Gem Game this panel is running on
	 */
	public LevelPanel(Game game)
	{
		setPreferredSize(new Dimension(game.getRows() * Tile.HEIGHT, game.getColumns() * Tile.WIDTH));
		player = game.getPlayer();
		level = game.getLevel();
		
		status = new JLabel("HP: " + player.getHP());
		score = new JLabel("Score: " + level.getScore());
		gemsLeft = new JLabel("Gems Left: " + level.getGemsLeft());
		
		MoveListener m = new MoveListener();
		addKeyListener(m);
		
		add(status);
		add(score);
		add(gemsLeft);
		setFocusable(true);
	}
	
	/**
	 * This method draws the level and sets the text for the JLabels.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.white);
		level.draw(g);
		score.setText("Score: " + level.getScore());
		status.setText("HP: " + player.getHP());
		gemsLeft.setText("Gems Left: " + level.getGemsLeft());;
	}
	
	/**
	 * This class is a KeyListener that moves the Player in accordance to the arrow keys.
	 * I did not collaborate with other students on this assignment.
	 * @author Lily Peng
	 * @version 1.0
	 * @date 11/29/11
	 */
	private class MoveListener implements KeyListener
	{
		/**
		 * This method in MoveListener moves the Player when the arrow keys are pressed.
		 */
		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT )
			{
				player.move(1, 0);
		    } 
			else if (e.getKeyCode() == KeyEvent.VK_LEFT ) 
		    {
				player.move(-1, 0);
		    } 
			else if (e.getKeyCode() == KeyEvent.VK_UP ) 
			{
				player.move(0, -1);
		    } 
			else if (e.getKeyCode() == KeyEvent.VK_DOWN ) 
			{
				player.move(0, 1);
		    }
			
			repaint();
		}
		
		/**
		 * This method shows that nothing special happens when a key is released.
		 */
		public void keyReleased(KeyEvent e) 
		{
			
		}

		/**
		 * This method shows that nothing special happens when a key is typed.
		 */
		public void keyTyped(KeyEvent e) 
		{
			
		}
	}
	
	
	
	
}
