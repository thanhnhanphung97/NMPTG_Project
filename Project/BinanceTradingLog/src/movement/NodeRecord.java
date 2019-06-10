/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class NodeRecord implements Comparable<NodeRecord>{
    private int node;
    private Connection connection;
    private double costSoFar;
    private double estimatedTotalCost;

    public NodeRecord() {
    }
    
    public NodeRecord(int node) {
        this.node = node;
    }

    public NodeRecord(int node, Connection connection, double costSoFar) {
        this.node = node;
        this.connection = connection;
        this.costSoFar = costSoFar;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public double getCostSoFar() {
        return costSoFar;
    }

    public void setCostSoFar(double costSoFar) {
        this.costSoFar = costSoFar;
    }

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public void setEstimatedTotalCost(double estimatedTotalCost) {
        this.estimatedTotalCost = estimatedTotalCost;
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
        final NodeRecord other = (NodeRecord) obj;
        if (this.node != other.node) {
            return false;
        }
        if (Double.doubleToLongBits(this.costSoFar) != Double.doubleToLongBits(other.costSoFar)) {
            return false;
        }
        if (Double.doubleToLongBits(this.estimatedTotalCost) != Double.doubleToLongBits(other.estimatedTotalCost)) {
            return false;
        }
        if (!Objects.equals(this.connection, other.connection)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "NodeRecord{" + "node=" + node + ", connection=" + connection + ", costSoFar=" + costSoFar + '}';
    }
    
    public int compareTo(NodeRecord nodeRecord){
        //if(this.costSoFar>nodeRecord.costSoFar)return 1;
        //else if(this.costSoFar==nodeRecord.costSoFar)return this.node-nodeRecord.node;
        return -1;
    }
}
