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
public class NodeInfo {
    private Vector2D[] position = new Vector2D[1000];
    
    public NodeInfo() {
    }
    
    public void setPosition(int node,Vector2D position){
        this.position[node]=position;
    }
    
    public Vector2D getPosition(int node){
        return this.position[node];
    }
}
