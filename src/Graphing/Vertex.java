package Graphing;

import java.util.ArrayList;

public class Vertex 
{
	int id;
	int minDepth;
	int maxDepth;
	ArrayList<Edge> oedge = new ArrayList<Edge>();
	ArrayList<Edge> iedge = new ArrayList<Edge>();
	
	// coordinates on the graph
	int x;
	int y;
	
	public Vertex(int id)
	{
		this.id = id;
		maxDepth = 0;
		minDepth = 1000000;
	}
}
