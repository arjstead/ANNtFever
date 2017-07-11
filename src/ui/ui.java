package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.border.Border;

import rtneat.Genome;
import rtneat.NNode;
import rtneat.Network;
import ui.graphing.Graph;
import ui.graphing.GraphDrawing;

import java.awt.Canvas;
import java.awt.Color;

public class UI extends JFrame implements ActionListener
{
	// UI elements
	Canvas worldCanvas;
	JPanel infoPanel;
	JButton viewFittestButton;
	
	// Construct a new UI
	public UI()
	{
		// Pre amble
		setTitle("ANNtFever - (C) A Stead, 2017.");
		Container container = getContentPane();
		
		// Layout set up
		container.setLayout(new FlowLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// world view canvas
		JPanel worldPanel = new JPanel();
		worldPanel.setBorder(BorderFactory.createLineBorder(Color.black));		
		worldCanvas = new Canvas();
		worldCanvas.setSize(750, 750);
		worldPanel.add(worldCanvas);
		container.add(worldPanel);
		
		// data viewer
		infoPanel = new JPanel();
		container.add(infoPanel);
		infoPanel.setLayout(new FlowLayout());
		viewFittestButton = new JButton("View Leader");
		viewFittestButton.addActionListener(this);
		infoPanel.add(viewFittestButton);
		
		// Post amble	
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	// Called by parent on action performed eg. button click.
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == viewFittestButton)
			viewNetwork(new Network(Genome.getInitialisedGnome(4, 2)));
	}

	// Display the given network in a window.
	public void viewNetwork(Network nn)
	{
		JFrame frame = new JFrame("ANNtFever - (C) A Stead, 2017.");
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout());
		frame.add(new Label("Fittest Network:"));
		Graph gr = new Graph(nn);
		JPanel netdrawing = new GraphDrawing(gr, 500);
		netdrawing.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.add(netdrawing);
		frame.setVisible(true);
	}
}
