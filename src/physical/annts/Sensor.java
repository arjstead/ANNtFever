package physical.annts;
import physical.World;
import rtneat.*;


public class Sensor 
{
	double response;
	Network network;
	int inputNeuron;
	
	public Sensor(int id, Network nn)
	{
		inputNeuron = id;
		network = nn;
	}
	
	public void update(World w)
	{
		network.nodes.get(inputNeuron).excitement = getExcitation(w); 
	}
	
	public double getExcitation(World w)
	{
		return 0.0;
	}

}
