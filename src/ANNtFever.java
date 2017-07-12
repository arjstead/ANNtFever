
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
		// Open UI t interact with the world
		UI ui = new UI();
		
		// Create a world for everything to exist in. Give it the panel to draw the world on.
		World world = new World(ui.worldPanel);
		

		
		
		
	    Genome g = Genome.getInitialisedGnome(4, 2);
		Network n = new Network(g);

	}
}
