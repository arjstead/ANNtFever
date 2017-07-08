package myVersion;

import java.util.ArrayList;

public class ANNt 
{
	Genome g;
	Network nn;
	World w;
	
	// Inputs
	ArrayList<Sensor> sensors = new ArrayList<Sensor>();
	
	// Outputs
	ArrayList<Actuator> actuators = new ArrayList<Actuator>(); 
	
	public ANNt(Genome xg)
	{
		g = xg;
		nn = new Network(g);
		sensors.add(new FoodProximitySensor(0, nn, 0, 10));
		sensors.add(new FoodProximitySensor(1, nn, 0, -10));
		sensors.add(new FoodProximitySensor(2, nn, 10, 0));
		sensors.add(new FoodProximitySensor(3, nn, -10, 0));
		actuators.add(new CatTrack(4, nn));
		actuators.add(new CatTrack(5, nn));
	}
	
	public void update()
	{
		for(Sensor s:sensors)
			s.update(w);
		
		nn.update();
		
		for(Actuator a:actuators)
			w = a.apply(w);
	}
	
	
}
