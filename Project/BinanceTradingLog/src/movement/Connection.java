/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

/**
 *
 * @author Administrator
 */
public class Connection {
    private float cost;
    private int fromNode;
    private int toNode;

    public Connection() {
    }

    public Connection(float cost, int fromNode, int toNode) {
        this.cost = cost;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getFromNode() {
        return fromNode;
    }

    public void setFromNode(int fromNode) {
        this.fromNode = fromNode;
    }

    public int getToNode() {
        return toNode;
    }

    public void setToNode(int toNode) {
        this.toNode = toNode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Connection other = (Connection) obj;
        if (Float.floatToIntBits(this.cost) != Float.floatToIntBits(other.cost)) {
            return false;
        }
        if (this.fromNode != other.fromNode) {
            return false;
        }
        if (this.toNode != other.toNode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Connection{" + "cost=" + cost + ", fromNode=" + fromNode + ", toNode=" + toNode + '}';
    }

    
    
    
}
