package myVersion;

import Graphing.Graph;

public class Program 
{
	public static void main(String[] args)
	{
	    Genome g = Genome.getInitialisedGnome(4, 2);
		Network n = new Network(g);
		viewNetwork(n);
	}
	
	public static void viewNetwork(Network nn)
	{
		// Create new graph
		Graph g = new Graph();
		
		// Add the nodes
		for(NNode n:nn.nodes)
			g.addVertex(n.id);
		
		// Add connections
		for(NNode toNode:nn.nodes)
			for(NNode fromNode:toNode.inodes)
				g.addEdge(fromNode.id, toNode.id);
		
		// Connect inputs to root
		// Holds a list of the node ids of the inputs
		int[] inputs = new int[nn.inputs.size()];
		// Populates the list
		for(int i = 0; i < inputs.length; i++)
			inputs[i] = nn.inputs.get(i).id;
		// Connects verticies with the ids to the root.
		g.connectRoot(inputs);
		
		g.display();
	}
}
