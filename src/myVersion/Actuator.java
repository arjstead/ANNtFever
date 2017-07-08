package myVersion;

public class Actuator 
{
	double response;
	Network network;
	int outputNeuron;
	
	public Actuator(int id, Network nn)
	{
		outputNeuron = id;
		network = nn;
	}
	
	public World apply(World w)
	{
		return w;
	}
	
	public double getResponse()
	{
		return network.nodes.get(outputNeuron).excitement;
	}
	
	
}
