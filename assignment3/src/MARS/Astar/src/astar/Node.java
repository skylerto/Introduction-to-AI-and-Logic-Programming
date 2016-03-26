package astar;

/**
 * Definition of a Single Node in a graph.
 * 
 * @author Skyler Layne, 2016
 *
 */
public class Node implements Comparable<Object> {
	private Integer index;
	private float weight;

	public Node(Integer index, float weight) {
		this.setIndex(index);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "[NODE] -- " + "INDEX: " + index + " WEIGHT: " + weight;
	}

	@Override
	public int compareTo(Object o) {
		Node other = (Node) o;

		float a = this.weight;
		float b = other.weight;

		if (a > b)
			return 1;
		if (a < b)
			return -1;
		return 0;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
