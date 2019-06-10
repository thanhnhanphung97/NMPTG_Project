/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 *
 * @author Administrator
 */
public class pathFindAStar {
    public static Comparator<NodeRecord> compareByEstimatedTotalCost=new Comparator<NodeRecord>(){
        
        @Override
        public int compare(NodeRecord a,NodeRecord b){
            if(a.getEstimatedTotalCost()>b.getEstimatedTotalCost())return 1;
            else if(a.getEstimatedTotalCost()==b.getEstimatedTotalCost())return a.getNode()-b.getNode();
            return -1;
        }
    };
    
    public static List<Connection> pathFindAStar(Graph graph,int start,int end,Heuristic heuristic)
    {
        NodeRecord startRecord=new NodeRecord();
        startRecord.setNode(start);
        startRecord.setCostSoFar(0);
        startRecord.setEstimatedTotalCost(heuristic.estimate(start));
        
        List<NodeRecord> open=new ArrayList<NodeRecord>();
        PriorityQueue<NodeRecord> openSmallest=new PriorityQueue<NodeRecord>(compareByEstimatedTotalCost);
        open.add(startRecord);
        openSmallest.add(startRecord);
        List<NodeRecord> closed=new ArrayList<NodeRecord>();
        
        NodeRecord current=new NodeRecord();
        NodeRecord endNodeRecord;
        int endNode;
        double endNodeCost;
        double endNodeHeuristic;
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
                if(closed.contains(new NodeRecord(endNode))){
                    endNodeRecord=closed.get(closed.indexOf(new NodeRecord(endNode)));
                    if(endNodeRecord.getCostSoFar()<=endNodeCost)continue;
                    closed.remove(endNodeRecord);
                    endNodeHeuristic=endNodeRecord.getEstimatedTotalCost()-endNodeRecord.getCostSoFar();
                }
                else if(open.contains(new NodeRecord(endNode)))
                {
                    endNodeRecord=open.get(open.indexOf(new NodeRecord(endNode)));
                    if(endNodeRecord.getCostSoFar()<=endNodeCost)continue;
                    endNodeHeuristic=endNodeRecord.getEstimatedTotalCost()-endNodeRecord.getCostSoFar();
                }
                else
                {
                    endNodeRecord=new NodeRecord();
                    endNodeRecord.setNode(endNode);
                    endNodeHeuristic=heuristic.estimate(endNode);
                }
                
                endNodeRecord.setCostSoFar(endNodeCost);
                endNodeRecord.setConnection(connection);
                endNodeRecord.setEstimatedTotalCost(endNodeCost+endNodeHeuristic);
                
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
    
    public static void main(String[] args) {
        //Test
        NodeInfo nodeInfo=new NodeInfo();
        nodeInfo.setPosition(1, new Vector2D(0,0));
        nodeInfo.setPosition(2, new Vector2D(2,0));
        nodeInfo.setPosition(3, new Vector2D(3,0));
        nodeInfo.setPosition(4, new Vector2D(3,-2));
        nodeInfo.setPosition(5, new Vector2D(4,-1));
        
        Heuristic heuristic=new Heuristic(nodeInfo,4);
        
        Graph graph = new Graph();
        Connection con=new Connection(2,1,2);
        graph.addConnection(con);
        con=new Connection(1,3,2);
        graph.addConnection(con);
        con=new Connection(7,1,4);
        graph.addConnection(con);
        con=new Connection(3,3,4);
        graph.addConnection(con);
        con=new Connection(1,3,5);
        graph.addConnection(con);
        con=new Connection(1,4,5);
        graph.addConnection(con);
        
        List<Connection> list=pathFindAStar(graph,1,4,heuristic);
        for(Connection i:list)System.out.println(i);
    }
}
