package myVersion;

import java.util.ArrayList;

public class Genome 
{
	ArrayList<ConnectionAllele> connectionAlleles = new ArrayList<ConnectionAllele>();
	
	ArrayList<NodeAllele> nodeAlleles = new ArrayList<NodeAllele>();
	
	ArrayList<NodeAllele> inputNodes = new ArrayList<NodeAllele>();
	
	ArrayList<NodeAllele> outputNodes = new ArrayList<NodeAllele>();


	public static Genome getInitialisedGnome(int nodesin, int nodesout)
	{
		Genome g = new Genome();
		
		for(int i = 0; i < nodesin; i++)
		{
			NodeAllele newNA = new NodeAllele();
			newNA.func = FuncEnum.Func.input;
			g.inputNodes.add(newNA);
		}
		
		for(int i = 0; i < nodesout; i++)
		{
			NodeAllele newNA = new NodeAllele();
			newNA.func = FuncEnum.Func.output;
			g.outputNodes.add(newNA);
		}		
		
		g.nodeAlleles.addAll(g.inputNodes);
		g.nodeAlleles.addAll(g.outputNodes);
		
		double iweight;
		for(int i = 0; i < nodesin; i++)
			for(int j = 0; j < nodesout; j++)
			{	
				iweight = Math.random()-0.5;
				g.connectionAlleles.add(new ConnectionAllele(g.inputNodes.get(i), g.outputNodes.get(j), iweight, 1, true, 0));
			}
		
		return g;
	}
	
	public static Genome getTestGnome()
	{
		Genome g = new Genome();
		
		// Input nodes
		for(int i = 0; i <= 2; i++)
		{
			NodeAllele newNA = new NodeAllele();
			newNA.func = FuncEnum.Func.input;
			g.inputNodes.add(newNA);
		}
		g.nodeAlleles.addAll(g.inputNodes);
		
		// Hidden layer
		// Input nodes
		for(int i = 0; i < 5; i++)
		{
			NodeAllele newNA = new NodeAllele();
			newNA.func = FuncEnum.Func.sigmoid;
			g.nodeAlleles.add(newNA);
		}
		
		// Output node
		NodeAllele newNA = new NodeAllele();
		newNA.func = FuncEnum.Func.output;
		g.outputNodes.add(newNA);
		g.nodeAlleles.addAll(g.outputNodes);
		
		double iweight;
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(0), g.nodeAlleles.get(6), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(1), g.nodeAlleles.get(3), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(1), g.nodeAlleles.get(4), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(2), g.nodeAlleles.get(4), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(3), g.nodeAlleles.get(5), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(4), g.nodeAlleles.get(7), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(5), g.nodeAlleles.get(6), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(5), g.nodeAlleles.get(7), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(6), g.nodeAlleles.get(8), iweight, 1, true, 0));
		iweight = Math.random()-0.5;
		g.connectionAlleles.add(new ConnectionAllele(g.nodeAlleles.get(7), g.nodeAlleles.get(8), iweight, 1, true, 0));
		
		return g;
	}
}
