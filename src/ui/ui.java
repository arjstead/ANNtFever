package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.border.Border;

import rtneat.NNode;
import rtneat.Network;
import ui.graphing.Graph;

import java.awt.Canvas;
import java.awt.Color;

public class UI extends JFrame
{
	// UI elements
	Canvas worldCanvas;
	Canvas networkCanvas;
	Label genNo;
	
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
		JPanel infoSidePanel = new JPanel();
		container.add(infoSidePanel);
		infoSidePanel.setLayout(new GridLayout(0, 1));
		// NN viewer
		JPanel nnPanel = new JPanel();
		nnPanel.setBorder(BorderFactory.createLineBorder(Color.black));		

		nnPanel.add(networkCanvas);
		infoSidePanel.add(nnPanel);
		// Population info
		JPanel popInfo = new JPanel();
		popInfo.setLayout( new GridLayout(0,4));
		Label genLabel = new Label();
		genLabel.setText("Generation: ");
		popInfo.add(genLabel);
		genNo = new Label();
		genNo.setText("0");
		popInfo.add(genNo);
		infoSidePanel.add(popInfo);
		
		
		// Post amble	
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void viewNetwork(Network nn)
	{
		// Create new graph
		Graph g = new Graph();
		
		// Add the nodes
		for(NNode n:nn.nodes)
			g.addVertex(n.id);
		
		// Add connections
		for(NNode toNode:nn.nodes)
			for(NNode fromNode:toNode.inodes)
				g.addEdge(fromNode.id, toNode.id);
		
		// Connect inputs to root
		// Holds a list of the node ids of the inputs
		int[] inputs = new int[nn.inputs.size()];
		// Populates the list
		for(int i = 0; i < inputs.length; i++)
			inputs[i] = nn.inputs.get(i).id;
		// Connects verticies with the ids to the root.
		g.connectRoot(inputs);
		
		g.display(nnPanel);
	}
}
