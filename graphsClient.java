package GRAPHS;

import java.util.HashMap;

public class graphsClient {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graphs gp = new graphs();
		gp.addVertex("A");
		gp.addVertex("B");
		gp.addVertex("C");
		gp.addVertex("D");
		gp.addVertex("E");
		gp.addVertex("F");
		gp.addVertex("G");
		gp.addEdge("A", "B", 3);
		gp.addEdge("A", "D", 2);
		gp.addEdge("B", "C", 4);
		gp.addEdge("C", "D", 7);
		gp.addEdge("D", "E", 10);
		gp.addEdge("E", "F", 4);
		gp.addEdge("F", "G", 6);
		gp.addEdge("E", "G", 8);
		gp.display();
//		System.out.println(gp.numVErtex());
//		System.out.println(gp.numEdges());
//		System.out.println(gp.containsVertex("Z"));
//		System.out.println(gp.containEdge("A", "Z"));
//		System.out.println(gp.containEdge("A", "B"));
//		gp.addVertex("X");
//		gp.display();
//		gp.addEdge("A", "X", 11);
//		gp.display();
//		gp.removeEdge("D", "E");
//		gp.display();
//		gp.removeVertex("X");
//		gp.display();
//		System.out.println(gp.hasPath("A", "F",new HashMap<>()));
//		System.out.println(gp.BFS("A", "F"));
//		System.out.println(gp.dfs("A", "F"));
//		gp.bft();
//		gp.dft();
//		System.out.println(gp.isCyclic());
		//check component by taking count we are considering components in our graph
//		System.out.println(gp.isConnected());
//		System.out.println(gp.getConnectedComponents());
		gp.BFS("A", "G");
	}

}
