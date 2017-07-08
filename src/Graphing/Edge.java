package Graphing;

public class Edge 
{
	Vertex from;
	Vertex to;
	
	// starting and ending coords
	int sx, sy, ex, ey;
	
	public Edge(Vertex from, Vertex to)
	{
		this.from = from;
		this.to = to;
	}
}
