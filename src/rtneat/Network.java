package rtneat;

import java.util.ArrayList;

public class Network 
{
	public ArrayList<NNode> nodes = new ArrayList<NNode>();
	public ArrayList<NNode> inputs = new ArrayList<NNode>();
	ArrayList<NNode> outputs = new ArrayList<NNode>();
	
	public Network(Genome g)
	{
		// Create network
		// Create nodes
		for(int i = 0; i < g.nodeAlleles.size(); i++)
		{
			NNode newNode = new NNode(g.nodeAlleles.get(i).threshold, g.nodeAlleles.get(i).bias, g.nodeAlleles.get(i).func, i);
			nodes.add(newNode);
			if(g.nodeAlleles.get(i).func == FuncEnum.Func.input)
				inputs.add(newNode);
			else if(g.nodeAlleles.get(i).func == FuncEnum.Func.output)
				outputs.add(newNode);
		}
		// Connect nodes
		for(ConnectionAllele ca:g.connectionAlleles)
			nodes.get(g.nodeAlleles.indexOf(ca.inode)).inodes.add(nodes.get(g.nodeAlleles.indexOf(ca.onode)));
	}
	
	public void update()
	{
		// Holds unvisited nodes
		ArrayList<NNode> queue = new ArrayList<NNode>();
		// Start at the root
		queue.addAll(inputs);
		// While there are unvisited nodes
		while(queue.size() > 0)
		{
			// Get the next unvisited node
			NNode current = queue.get(0);
			// Add its children to the stack, give them the depth of the node + 1, if it is larger than their current depth
			for(NNode onode:current.onodes)
			{
				// update excitement of connecting node
			}
			// Remove the node from the queue, if it is visited later on it will be added again and the change propageted.
			queue.remove(0);
		}
	}
	
}
