package physical;
import rtneat.*;
import ui.WorldPanel;


public class World 
{
	// World drawing
	WorldPanel worldPanel;
	
	public World(WorldPanel worldPanel)
	{
		this.worldPanel = worldPanel;
	}
	
	public void updateDrawing()
	{
		// Remove all components
		worldPanel.removeAll();
		
		// Paint components
		
		
		// Revalidate JPanel
		worldPanel.revalidate();
	}
}
