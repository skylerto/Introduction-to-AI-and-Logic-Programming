package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import astar.Path;

/**
 * Notebook test case.
 * 
 * @author Skyler Layne © 2016
 *
 */
public class Test {

	public static void main(String[] args) {
		// Define Start and End Indexes
		int start = 8;
		int end = 0;

		// Define the Graph
		List<Integer> graph = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 5, 100, 100, 1, 1, 0));

		// Define the adjacent Matrix
		Map<Integer, List<Integer>> adjacent = new HashMap<Integer, List<Integer>>();
		adjacent.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adjacent.put(1, new ArrayList<Integer>(Arrays.asList(0, 2)));
		adjacent.put(2, new ArrayList<Integer>(Arrays.asList(1)));
		adjacent.put(3, new ArrayList<Integer>(Arrays.asList(0, 6)));
		adjacent.put(4, new ArrayList<Integer>());
		adjacent.put(5, new ArrayList<Integer>());
		adjacent.put(6, new ArrayList<Integer>(Arrays.asList(3, 7)));
		adjacent.put(7, new ArrayList<Integer>(Arrays.asList(6, 8)));
		adjacent.put(8, new ArrayList<Integer>(Arrays.asList(7)));

		Path path = new Path(graph, adjacent, start, end);
		System.out.println("Start to Finish -- PATH: " + path.getPath().toString());
		System.out.println("Start to Finish -- VALUE: " + path.getValue());

	}

}
