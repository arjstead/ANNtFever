package myVersion;

import java.util.ArrayList;


public class NNode
{
	int id;
	double threshold;
	double bias;
	FuncEnum.Func func;
	ArrayList<NNode> inodes = new ArrayList<NNode>(); // Nodes connecting into it
	ArrayList<NNode> onodes = new ArrayList<NNode>(); // Nodes connecting out of it
	double excitement;
	
	public NNode(double threshold, double bias, FuncEnum.Func func, int id)
	{
		this.threshold = threshold;
		this.bias = bias;
		this.func = func;
		this.id = id;
	}
}
