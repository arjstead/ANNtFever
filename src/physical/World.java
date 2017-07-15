package physical;
import java.util.ArrayList;

import physical.annts.ANNt;
import physical.objects.BasicFoodBlock;
import physical.objects.WorldObject;
import rtneat.Genome;
import ui.UI;


public class World 
{
	// World drawing
	public UI ui;
	
	// List of World Objects
	public ArrayList<WorldObject> worldObjects = new ArrayList<WorldObject>();
	
	// List of organisms
	public ArrayList<ANNt> organisms = new ArrayList<ANNt>();
	
	// Dimensions
	int width, height = 1000;
	
	// Set up
	public void start()
	{
		// populate the world with some food
		for(int i = 0; i < 50; i++)
			worldObjects.add(new BasicFoodBlock((int) (Math.random()*1000), (int) (Math.random()*1000)));
		
		// populate the world with some ants
		for(int i = 0; i < 20; i++)
		{
			organisms.add(new ANNt(Genome.getInitialisedGnome(5, 5), (int) (Math.random()*1000), (int) (Math.random()*1000)));
		}
		
		// Finally run the simulation
		run();
	}
	
	// Execution loop
	public void run()
	{
		boolean loop = true;
		while(loop)
		{			
			update();
		}
	}
	
	// Update all aspects of the world
	public void update()
	{
		for(ANNt a:organisms)
			a.update();
		for(WorldObject o:worldObjects)
			o.update();
		updateUI();
	}
	
	public void updateUI()
	{
		// Remove all components
		ui.worldPanel.removeAll();
		
		// Paint components
		ui.worldPanel.repaint();
		
		// Revalidate JPanel
		ui.worldPanel.revalidate();
	}
}
