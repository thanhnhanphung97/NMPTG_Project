/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DijktrasAlgorithm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Administrator
 */
public class TestDijkstraAlgorithmTest {

    private ArrayList<Node> nodes;
    private ArrayList<Connection> connections;
    
    @Before
    public void setUp() throws Exception {
        nodes = new ArrayList<Node>();
        connections = new ArrayList<Connection>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
	for (int i = 0; i < 11; i++) {
        Node location = new Node("Node_" + i, "Node_" + i);
        nodes.add(location);
        }

        addLane("Node_0", 0, 1, 85);
        addLane("Node_1", 0, 2, 217);
        addLane("Node_2", 0, 4, 173);
        addLane("Node_3", 2, 6, 186);
        addLane("Node_4", 2, 7, 103);
        addLane("Node_5", 3, 7, 183);
        addLane("Node_6", 5, 8, 250);
        addLane("Node_7", 8, 9, 84);
        addLane("Node_8", 7, 9, 167);
        addLane("Node_9", 4, 9, 502);
        addLane("Node_10", 9, 10, 40);
        addLane("Node_11", 1, 10, 600);

        Graph graph = new Graph(nodes, connections);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Node> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Node n : path) {
            System.out.println(n);
        }
    }
	
    private void addLane(String laneId, int sourceLocNo, int destLocNo,int duration) {
        Connection lane = new Connection(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        connections.add(lane);
    }
}
