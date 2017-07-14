package physical;
import java.util.ArrayList;

import physical.annts.ANNt;
import physical.objects.WorldObject;
import ui.UI;


public class World 
{
	// World drawing
	public UI ui;
	
	// List of World Objects
	ArrayList<WorldObject> worldObjects = new ArrayList<WorldObject>();
	
	// List of organisms
	ArrayList<ANNt> organisms = new ArrayList<ANNt>();
	
	// Set up
	public void start()
	{
		
		
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
		
		
		// Revalidate JPanel
		ui.worldPanel.revalidate();
	}
}
