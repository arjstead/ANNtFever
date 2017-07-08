package myVersion;

public class ConnectionAllele 
{
	// Innovation number tracks gene history to find matching genes
	int innovationNumber;
	
	// The link that the gene codes for
	NodeAllele inode;
	NodeAllele onode;
	double weight;
	int delay;
	boolean expression;
	
	public ConnectionAllele(NodeAllele from, NodeAllele to, double weight, int delay, boolean expression, int innNo)
	{
		inode = to;
		onode = from;
		this.weight = weight;
		this.delay = delay;
		this.expression = expression;
		innovationNumber = innNo;
	}
	
}
