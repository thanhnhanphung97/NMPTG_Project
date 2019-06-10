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
public class Heuristic {
    private NodeInfo nodeInfo;
    private int endNode;

    public Heuristic() {
    }

    public Heuristic(NodeInfo nodeInfo, int endNode) {
        this.nodeInfo = nodeInfo;
        this.endNode = endNode;
    }
    
    public double estimate(int node){
        return Vector2D.subVector2D(nodeInfo.getPosition(node), nodeInfo.getPosition(endNode)).length();
    }
}
