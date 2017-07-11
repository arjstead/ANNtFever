package ui.graphing;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph 
{
	Vertex root;
	ArrayList<Vertex> verticies = new ArrayList<Vertex>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	ArrayList<Integer>[] layerInfo;
	
	int canvasSize = 500;
	
	public Graph()
	{
		root = new Vertex(0);
		root.minDepth = -1;
		root.maxDepth = -1;
	}
	
	public void addVertex(int id)
	{
		verticies.add(new Vertex(id));
	}
	
	public void addEdge(int v1, int v2)
	{
		Edge newEdge = new Edge(verticies.get(v1), verticies.get(v2));
		verticies.get(v1).oedge.add(newEdge);
		verticies.get(v2).iedge.add(newEdge);
		edges.add(newEdge);
	}
	
	public void connectRoot(int[] inputs)
	{
		for(int i:inputs)
			root.oedge.add(new Edge(root, verticies.get(i)));
	}
	
	public void getObjectCoords()
	{
		// Holds unvisited nodes
		ArrayList<Vertex> queue = new ArrayList<Vertex>();
		// Start at the root
		queue.add(root);
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
		for(Vertex v:verticies)
			if(v.maxDepth+1 > numLayers)
				numLayers = v.maxDepth+1;
		// Get the number of nodes in each layer
		int[] layerFreq = new int[numLayers];
		// Set up a list of node ids for each layer
		layerInfo = new ArrayList[numLayers];
		for(int i = 0; i < numLayers; i++)
			layerInfo[i] = new ArrayList<Integer>();
		
		// Get a list of node ids in each layer
		for(Vertex v:verticies)
			layerInfo[v.maxDepth].add(v.id);
		
		// Workout the x and y for each vertex
		
		// For each layer workout the spacing between each node
		int[] hSpacing = new int[layerInfo.length];
		for(int i = 0; i < layerInfo.length; i++)
			hSpacing[i] = (int) (canvasSize / (double) (layerInfo[i].size() + 2));
		// Workout the spacing between each layer
		int vSpacing = (int) (canvasSize / (double) (layerInfo.length + 2));
		
		// Add a point for each vertex
		int x;
		int y;
		for(int i = 0; i < layerInfo.length; i++)
			for(int j = 0; j < layerInfo[i].size(); j++)
			{
				verticies.get(layerInfo[i].get(j)).x = (j+1)*hSpacing[i];
				verticies.get(layerInfo[i].get(j)).y = canvasSize - (i+1)*vSpacing;
			}
		
		// Add ends for each edge
		for(Edge e:edges)
		{
			e.sx = e.from.x;
			e.sy = e.from.y;
			e.ex = e.to.x;
			e.ey = e.to.y;
		}
	}
	
	
	public void printDepths()
	{
		for(Vertex v:verticies)
			System.out.printf("%d\t%d\t%d\n", v.id, v.minDepth, v.maxDepth);
	}
	
	public void display(JPanel panel)
	{	  
		getObjectCoords();
		panel.add(new GraphDrawing(this, panel.getWidth()));
	}
	
	
}
