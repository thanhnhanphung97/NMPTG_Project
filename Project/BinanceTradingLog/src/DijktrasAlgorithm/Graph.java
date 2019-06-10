package DijktrasAlgorithm;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Node> nodes;
	private ArrayList<Connection> connections;

	public Graph() {
		super();
	}

	public Graph(ArrayList<Node> nodes, ArrayList<Connection> connections) {
		super();
		this.nodes = nodes;
		this.connections = connections;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
	
	
}
