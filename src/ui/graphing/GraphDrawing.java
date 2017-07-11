package ui.graphing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphDrawing extends JPanel
{
	int canvasSize;
	Graph g;
	
	public GraphDrawing(Graph g, int size)
	{
		this.g = g;
		this.canvasSize = size;
		calcObjectCoords(g);
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(canvasSize,canvasSize);
    }
    
    public void paintComponent(Graphics graphics) 
    {
        super.paintComponent(graphics);     
        
		for(Vertex v:g.verticies)
		{
			graphics.drawString(""+v.id, v.x, v.y);
			graphics.drawArc(v.x-7, v.y-15, 20, 20, 0, 360);
		}
		
		for(Edge e:g.edges)
			graphics.drawLine(e.sx, e.sy, e.ex, e.ey);
    } 
    
    public void calcObjectCoords(Graph g)
	{
		// Holds unvisited nodes
		ArrayList<Vertex> queue = new ArrayList<Vertex>();
		// Start at the root
		queue.add(g.root);
		// While there are unvisited nodes
		while(queue.size() > 0)
		{
			// Get the next unvisited node
			Vertex current = queue.get(0);
			// Add its children to the stack, give them the depth of the node + 1, if it is larger than their current depth
			for(Edge oedge:current.oedge)
			{
				if(oedge.to.minDepth > current.minDepth + 1)
					oedge.to.minDepth = current.minDepth + 1;
				if(oedge.to.maxDepth <= current.maxDepth)
					oedge.to.maxDepth = current.maxDepth + 1;
				queue.add(oedge.to);
			}
			// Remove the node from the queue, if it is visited later on it will be added again and the change propageted.
			queue.remove(0);
		}
		
		// Get the max overall depth
		int numLayers = 0;
		for(Vertex v:g.verticies)
			if(v.maxDepth+1 > numLayers)
				numLayers = v.maxDepth+1;
		// Get the number of nodes in each layer
		int[] layerFreq = new int[numLayers];
		// Set up a list of node ids for each layer
		g.layerInfo = new ArrayList[numLayers];
		for(int i = 0; i < numLayers; i++)
			g.layerInfo[i] = new ArrayList<Integer>();
		
		// Get a list of node ids in each layer
		for(Vertex v:g.verticies)
			g.layerInfo[v.maxDepth].add(v.id);
		
		// Workout the x and y for each vertex
		
		// For each layer workout the spacing between each node
		int[] hSpacing = new int[g.layerInfo.length];
		for(int i = 0; i < g.layerInfo.length; i++)
			hSpacing[i] = (int) (g.canvasSize / (double) (g.layerInfo[i].size() + 2));
		// Workout the spacing between each layer
		int vSpacing = (int) (g.canvasSize / (double) (g.layerInfo.length + 2));
		
		// Add a point for each vertex
		int x;
		int y;
		for(int i = 0; i < g.layerInfo.length; i++)
			for(int j = 0; j < g.layerInfo[i].size(); j++)
			{
				g.verticies.get(g.layerInfo[i].get(j)).x = (j+1)*hSpacing[i];
				g.verticies.get(g.layerInfo[i].get(j)).y = g.canvasSize - (i+1)*vSpacing;
			}
		
		// Add ends for each edge
		for(Edge e:g.edges)
		{
			e.sx = e.from.x;
			e.sy = e.from.y;
			e.ex = e.to.x;
			e.ey = e.to.y;
		}
		
	}
}
