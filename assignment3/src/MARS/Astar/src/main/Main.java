package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import astar.Path;

/**
 * A* Algorithm Implementation in Java using the Manhatten Heuristic of integer
 * index.
 * 
 * @author Skyler Layne © 2016
 *
 */
public class Main {

	public static void main(String[] args) {

		// Define Start and End Indexes
		int start = 8;
		int end = 0;

		// Define the Graph
		List<Integer> graph = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 5, 100, 100, 1, 1, 0));

		// Define the Adj Matrix
		Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		adj.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(1, new ArrayList<Integer>(Arrays.asList(0, 2)));
		adj.put(2, new ArrayList<Integer>(Arrays.asList(1)));
		adj.put(3, new ArrayList<Integer>(Arrays.asList(0, 6)));
		adj.put(4, new ArrayList<Integer>());
		adj.put(5, new ArrayList<Integer>());
		adj.put(6, new ArrayList<Integer>(Arrays.asList(3, 7)));
		adj.put(7, new ArrayList<Integer>(Arrays.asList(6, 8)));
		adj.put(8, new ArrayList<Integer>(Arrays.asList(7)));

		Path path = new Path(graph, adj, start, end);
		System.out.println("PATH: " + path.getPath().toString());
		System.out.println("VALUE: " + path.getValue());

	}
}
