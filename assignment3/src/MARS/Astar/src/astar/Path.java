package astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Definition of a path, the path is calculated with a heuristic function.
 * 
 * @author Skyler Layne, 2016
 *
 */
public class Path {

	// The index to start.
	private int start;

	// The index to end.
	private int end;

	// The cost of taking the path.
	private int value;

	// The graph to be traversed.
	private List<Integer> graph;

	// adjacent matrix, for determining reachable nodes.
	private Map<Integer, List<Integer>> adjacent;

	// Weights stores the wait which is meant to reach that index. [g(n)]
	private List<Integer> weights;

	// Indexes in arrows refers to the node which lead to the visit/
	private List<Integer> arrows;

	// The path to be taken.
	private List<Integer> path;

	private Boolean admissible;

	/**
	 * Create a path object.
	 * 
	 * @param graph
	 * @param adjacent
	 * @param start
	 * @param end
	 */
	public Path(Boolean admissible, List<Integer> graph, Map<Integer, List<Integer>> adjacent, int start, int end) {
		this.admissible = admissible;
		this.graph = graph;
		this.adjacent = adjacent;
		this.start = start;
		this.end = end;
		this.weights = new ArrayList<Integer>(Collections.nCopies(graph.size(), -1));
		this.arrows = new ArrayList<Integer>(Collections.nCopies(graph.size(), -1));
		this.path = this.createPath();
		this.value = 0;
		for (Integer i : path) {
			this.value += graph.get(i);
		}
	}

	/**
	 * Gets a list of indexes which represent the path. Uses the Manhattan
	 * distance.
	 * 
	 * @return
	 */
	private List<Integer> createPath() {

		// The solution path to be constructed.
		List<Integer> solution = new ArrayList<Integer>();

		// PriorityQueue keeps track of the most optimal choice.
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		// No cost associated with the start node.
		weights.set(start, 0);

		// Create a node on the start node and add it to the PriorityQueue.
		Node n = new Node(start, 0);
		pq.add(n);

		// Index of the last node to be processed
		Integer finalIndex = 0;

		// Loop through the PriorityQueue.
		while (pq.size() > 0) {

			// The the first node off the PriorityQueue
			Node current = pq.poll();
			if (current == null) {
				current = pq.poll();
			}

			// Update the index of the current node.
			Integer currentIndex = current.getIndex();

			// Check if we've reached the end.
			if (currentIndex.equals(end)) {
				break;
			}

			// Get a list of the adjacent nodes, loop over all the adjacent
			// nodes
			List<Integer> adjacentNodes = adjacent.get(currentIndex);
			for (Integer index : adjacentNodes) {

				// Calculate the cost of that node.
				Integer cost = weights.get(currentIndex) + graph.get(index);
				float calc = 0;

				// Check if we should process the node.
				boolean process = cost < weights.get(index) || weights.get(index) == -1;
				if (process) {
					// drop an arrow
					arrows.set(index, currentIndex);

					// Update the weight associated with this choice, calculate
					// the cost of that decision, add it to the PriorityQueue.
					weights.set(index, cost);

					// Use admissible Heuristic if desired.
					if (admissible) {
						calc = cost + admissibleHeuristic(index, end);
					} else {
						calc = cost * Math.abs(end - index);
					}

					Node other = new Node(index, calc);
					pq.add(other);
					finalIndex = index;
				}

			} // end adjacent loop

		} // end loops

		// Create the path:
		do

		{
			finalIndex = arrows.get(finalIndex);
			solution.add(finalIndex);
		} while (finalIndex != start);

		Collections.reverse(solution);
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

	private float admissibleHeuristic(double index, double end) {
		return (float) Math.sqrt(Math.abs(end - index));
	}

}
