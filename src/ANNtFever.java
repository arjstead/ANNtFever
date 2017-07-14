
import javax.swing.JFrame;
import javax.swing.JPanel;

import physical.World;
import rtneat.*;
import ui.*;
import ui.graphing.*;


public class ANNtFever 
{
	public static void main(String[] args)
	{		
		// Create a world for everything to exist in. Give it the panel to draw the world on.
		World world = new World();
		
		// Open UI t interact with the world
		UI ui = new UI(world);
		
		// Start simulation
		world.start();
	}
}
