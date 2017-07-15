package ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import physical.World;
import physical.annts.ANNt;
import physical.objects.WorldObject;
import ui.graphing.Edge;
import ui.graphing.Vertex;

public class WorldPanel extends JPanel
{
	World world;
	
	public WorldPanel(World w)
	{
		world = w;
	}
	
    public Dimension getPreferredSize() 
    {
        return new Dimension(1000,1000);
    }
    
	public void paintComponent(Graphics graphics) 
    {
        super.paintComponent(graphics);     
        
		for(WorldObject wo:world.worldObjects)
		{
			graphics.drawRect(wo.getX(),wo.getY(), 5,  5);
		}
		
		for(ANNt ant:world.organisms)
		{
			graphics.drawArc(ant.getX(), ant.getY(), 5, 5, 0, 360);
		}
    }
}
