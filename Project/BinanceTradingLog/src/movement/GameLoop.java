/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.PriorityQueue;

/**
 *
 * @author Administrator
 */
public class GameLoop implements Runnable{
    
    private boolean isRunning;
    private Demo demo;

    public GameLoop() {
    }

    public GameLoop(boolean isRunning, Demo demo) {
        this.isRunning = isRunning;
        this.demo = demo;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }
    
    public static List<Connection> pathFindDijkstra(Graph graph,int start,int end)
    {
         NodeRecord startRecord=new NodeRecord();
        startRecord.setNode(start);
        startRecord.setCostSoFar(0);
        
        List<NodeRecord> open=new ArrayList<NodeRecord>();
        PriorityQueue<NodeRecord> openSmallest=new PriorityQueue<NodeRecord>();
        open.add(startRecord);
        openSmallest.add(startRecord);
        List<NodeRecord> closed=new ArrayList<NodeRecord>();
        
        NodeRecord current=new NodeRecord();
        NodeRecord endNodeRecord;
        int endNode;
        double endNodeCost;
        List<Connection> connections=new ArrayList<Connection>();
        
        while(open.size()>0)
        {
            current=openSmallest.poll();
            
            if(current.getNode()==end)break;
            
            connections=graph.getConnections(current.getNode());
            
            
            for(Connection connection:connections)
            {
                endNode=connection.getToNode();
                endNodeCost=current.getCostSoFar()+connection.getCost();
                if(closed.contains(new NodeRecord(endNode)))continue;
                else if(open.contains(new NodeRecord(endNode)))
                {
                    endNodeRecord=open.get(open.indexOf(new NodeRecord(endNode)));
                    if(endNodeRecord.getCostSoFar()<=endNodeCost)continue;
                }
                else
                {
                    endNodeRecord=new NodeRecord();
                    endNodeRecord.setNode(endNode);
                }
                
                endNodeRecord.setCostSoFar(endNodeCost);
                endNodeRecord.setConnection(connection);
                
                if(!open.contains(new NodeRecord(endNode)))
                {
                    open.add(endNodeRecord);
                    openSmallest.add(endNodeRecord);
                }
            }
            
            open.remove(current);
            closed.add(current);
        }
        
        if(current.getNode()!=end)return new ArrayList<Connection>();
        else
        {
            List<Connection> path=new ArrayList<Connection>();
            while(current.getNode()!=start)
            {
                path.add(current.getConnection());
                current=closed.get(closed.indexOf(new NodeRecord(current.getConnection().getFromNode())));
            }
            return path;
        }
    }
    
    
    @Override
    public void run(){
        
            Character character1 = new Character(0,new Vector2D(50,50),0,new Vector2D(200,200));
            Character character2 = new Character(0,new Vector2D(300,300),0,new Vector2D(400,400));
            character1.initRender(Color.red,40);
            character2.initRender(Color.blue, 60);
            Wandering wander1 = new Wandering(character1,3, (float) Math.PI/10);
            Wandering wander2 = new Wandering(character2,3, (float) (Math.PI/12));
            
            while(isRunning){
                demo.getGraphics().clearRect(0, 0, demo.getWidth(), demo.getHeight());
                character1.update(wander1.generateKinematicSteeringOutput(), 1);
                character2.update(wander2.generateKinematicSteeringOutput(), 1);
                character1.render(demo.getGraphics());
                character2.render(demo.getGraphics());
                character1.reloadCharacter(character1);
                character2.reloadCharacter(character2);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
}
