
import rtneat.*;
import ui.*;
import ui.graphing.*;


public class ANNtFever 
{
	public static void main(String[] args)
	{
		// Open UI
		UI ui = new UI();
		
		
	    Genome g = Genome.getInitialisedGnome(4, 2);
		Network n = new Network(g);
	}
}
