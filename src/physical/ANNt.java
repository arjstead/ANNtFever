package physical;
import rtneat.*;

import java.util.ArrayList;

public class ANNt 
{
	Genome g;
	Network nn;
	int numInputs;
	int numOutputs;
	World w;
	
	int lifeRemaining;
	
	// Inputs
	ArrayList<Sensor> sensors = new ArrayList<Sensor>();
	
	// Outputs
	ArrayList<Actuator> actuators = new ArrayList<Actuator>(); 
	
	public ANNt(Genome xg)
	{
		g = xg;
		nn = new Network(g);
		
		lifeRemaining = 1000000;
		numInputs = 3;
		numOutputs = 2;
		sensors.add(new ChemoReceptor(0, nn, 0, 10));
		sensors.add(new ChemoReceptor(1, nn, 0, -10));
		sensors.add(new ChemoReceptor(2, nn, 10, 0));
		actuators.add(new CatTrack(3, nn));
		actuators.add(new CatTrack(4, nn));
	}
	
	public void update()
	{
		for(Sensor s:sensors)
			s.update(w);
		
		nn.update();
		
		for(Actuator a:actuators)
			w = a.apply(w);
		
		lifeRemaining--;
		
		if(lifeRemaining <= 0)
			kill();
	}
	
	public void kill()
	{
		
	}
	
	
}
