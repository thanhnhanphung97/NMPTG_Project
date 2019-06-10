package DijktrasAlgorithm;


public class Connection {
	private String id;
	private int cost;
	private Node formNode;
	private Node toNode;
	
	public Connection() {
		super();
	}

	public Connection(String id, Node formNode, Node toNode, int cost) {
		super();
		this.id = id;
		this.cost = cost;
		this.formNode = formNode;
		this.toNode = toNode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Node getFormNode() {
		return formNode;
	}

	public void setFormNode(Node formNode) {
		this.formNode = formNode;
	}

	public Node getToNode() {
		return toNode;
	}

	public void setToNode(Node toNode) {
		this.toNode = toNode;
	}

	@Override
	public String toString() {
		return formNode+" "+toNode;
	}
	
	
}
