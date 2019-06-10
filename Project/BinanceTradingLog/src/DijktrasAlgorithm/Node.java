package DijktrasAlgorithm;

public class Node {
    private String id;
    private String name;
    public Node(String id, String name) {
    	super();
	this.id = id;
	this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public boolean equals(Object arg0) {
	if (this == arg0)
            return true;
        if (arg0 == null)
            return false;
        if (getClass() != arg0.getClass())
            return false;
        Node other = (Node) arg0;
        if (id == null) {
            if (other.id != null)
                return false;
        } 
        else if (!id.equals(other.id))
            return false;
        return true;
    }
	
    @Override
    public int hashCode() {
	int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
	return name;
    }

}
