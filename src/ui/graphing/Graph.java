package ui.graphing;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rtneat.NNode;
import rtneat.Network;

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
	
	public Graph(Network nn)
	{
		// Add the nodes
		for(NNode n:nn.nodes)
			addVertex(n.id);
		
		// Add connections
		for(NNode toNode:nn.nodes)
			for(NNode fromNode:toNode.inodes)
				addEdge(fromNode.id, toNode.id);
		
		// Connect inputs to root
		// Holds a list of the node ids of the inputs
		int[] inputs = new int[nn.inputs.size()];
		// Populates the list
		for(int i = 0; i < inputs.length; i++)
			inputs[i] = nn.inputs.get(i).id;
		// Connects verticies with the ids to the root.
		root = new Vertex(0);
		root.minDepth = -1;
		root.maxDepth = -1;
		connectRoot(inputs);
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
	
	
	
}
