package Q1_Route_Between_Nodes;

import java.util.LinkedList;

public class Question {
	/*
		Chapter 4 Problem 1
		Given a directed graph, design an algorithm to find out whether there
		is a route between two nodes.


		Time Complexity: O(b^d)
	*/


	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static boolean search(Graph g, Node start, Node end){
		//create a Queue
		LinkedList<Node> q = new LinkedList<Node>();
		//mark all nodes as unvisited
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        //mark the first node as visited and add it to the queue
        start.state = State.Visiting;
        q.add(start);
        //perform a breadth first search using the queue
        Node u;
        while(!q.isEmpty()) {
        	//remove node from the queue
            u = q.removeFirst();
            if (u != null) {
            	//get all of its adjacent nodes
	            for (Node v : u.getAdjacent()) {
	            	//if they have been visited already, ignore, otherwise
	                if (v.state == State.Unvisited) {
	                	//check if it is the destination
	                    if (v == end) {
	                        return true;
	                    } else { 
	                    	//if not, mark the node as visited and add it to the queue
	                        v.state = State.Visiting;
	                        q.add(v);
	                    }
	                }
	            }
	            //mark the original node as visited
	            u.state = State.Visited;
            }
        }
        return false;
	}


    
}