package ui.graphing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphDrawing extends JPanel
{
	int size;
	Graph g;
	
	public GraphDrawing(Graph g, int size)
	{
		this.g = g;
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(size,size);
    }
    
    public void paintComponent(Graphics graphics) 
    {
        super.paintComponent(graphics);     
        
		for(Vertex v:g.verticies)
		{
			graphics.drawString(""+v.id, v.x, v.y);
			graphics.drawArc(v.x-7, v.y-15, 20, 20, 0, 360);
		}
		
		for(Edge e:g.edges)
			graphics.drawLine(e.sx, e.sy, e.ex, e.ey);
    }  
}
