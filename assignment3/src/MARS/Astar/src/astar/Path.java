package astar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Definition of a path.
 * 
 * @author Skyler Layne © 2016
 *
 */
public class Path {

	private int start;
	private int end;
	private int value;
	private List<Integer> graph;
	private Map<Integer, List<Integer>> adj;

	// Weights stores the wait which is meant to reach that index. [g(n)]
	private List<Integer> weights;

	// Indexes in arrows refers to the node which lead to the visit
	private List<Integer> arrows;

	private List<Integer> path;

	/**
	 * Create a path object.
	 * 
	 * @param graph
	 * @param adj
	 * @param start
	 * @param end
	 */
	public Path(List<Integer> graph, Map<Integer, List<Integer>> adj, int start, int end) {
		this.graph = graph;
		this.adj = adj;
		this.start = start;
		this.end = end;
		this.weights = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1));
		this.arrows = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1));
		this.path = this.createPath();
		this.value = 0;
		for (Integer i : path) {
			this.value += graph.get(i);
		}
	}

	/**
	 * Gets a list of indexes which represent the path. Uses the manhatten
	 * distance.
	 * 
	 * @return
	 */
	private List<Integer> createPath() {
		List<Integer> solution = new ArrayList<Integer>();

		weights.set(start, 0);

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Node n = new Node(start, 0);
		pq.add(n);

		Integer finalIndex = 0;
		while (pq.size() > 0) {
			Node current = pq.poll();
			Integer currentIndex = current.getIndex();

			// If we've reached the end we're done.
			if (currentIndex.equals(end)) {
				break;
			}

			// get a list of the adj nodes.
			List<Integer> adjNodes = adj.get(currentIndex);

			// Loop over all the adj nodes
			for (Integer index : adjNodes) {
				if (index != 100) {

					// Calculate the cost of that node.
					Integer cost = weights.get(currentIndex) + graph.get(index);
					float calc = 0;

					boolean process = cost < weights.get(index) || weights.get(index) == -1;
					if (process) {
						// drop an arrow
						arrows.set(index, currentIndex);

						weights.set(index, cost);
						calc = cost + (float) (Math.abs(end - index) * 1.001);
						Node other = new Node(index, calc);
						pq.add(other);
						finalIndex = index;
					}

				}
			}

		} // end loops

		// Create the path:
		do {
			finalIndex = arrows.get(finalIndex);
			solution.add(finalIndex);
		} while (finalIndex != start);

		return solution;
	}

	/**
	 * Get the array of paths from leading from end to start.
	 * 
	 * @return - the path.
	 */
	public List<Integer> getPath() {
		return this.path;
	}

	/**
	 * Get the value of the path.
	 * 
	 * @return - the path value.
	 */
	public int getValue() {
		return this.value;
	}

}
