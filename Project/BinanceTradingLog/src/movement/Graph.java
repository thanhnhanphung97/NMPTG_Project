/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Graph {
    List<List<Connection>> node=new ArrayList<List<Connection>>();
    
    public Graph() {
    for(int i=0;i<1000;i++)node.add( new ArrayList<Connection>());
        
    }
    
    void addConnection(Connection node){
        this.node.get(node.getFromNode()).add(node);
        this.node.get(node.getToNode()).add(new Connection(node.getCost(),node.getToNode(),node.getFromNode()));
    }
    
    List<Connection> getConnections(int fromNode){
        return this.node.get(fromNode);
    }
}
