A* Path Finding
===============

A quick and dirty, A* Implementation in Java.

## Usage

1. Clone the project  
2. Draw up a graph as an `List<Integer>` where each element is the weight of the node, include any unreachable objects as absurd values.  
3. Draw up an adjacency matrix as a `Map<Integer, List<Integer>>` where the
   first Integer represent the index and the `List<Integer>` represents the
   reachable nodes from that node e.g.  
4. Define the starting and ending points  
5. Create the Path, return the path and its values  

``` java
// Define the topology to search
List<Integer> graph = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 5, 100, 100, 1, 1, 0));

// Define the Adj Matrix
Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
adj.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
adj.put(1, new ArrayList<Integer>(Arrays.asList(0, 2)));
adj.put(2, new ArrayList<Integer>(Arrays.asList(1)));
adj.put(3, new ArrayList<Integer>(Arrays.asList(0, 6)));
adj.put(4, new ArrayList<Integer>()); // wall
adj.put(5, new ArrayList<Integer>()); // wall
adj.put(6, new ArrayList<Integer>(Arrays.asList(3, 7)));
adj.put(7, new ArrayList<Integer>(Arrays.asList(6, 8)));
adj.put(8, new ArrayList<Integer>(Arrays.asList(7)));

// Define Start and End Indexes
int start = 8;
int end = 0;

// Create the path, get the path and the cost of that path.
Path path = new Path(graph, adj, start, end);
System.out.println("PATH: " + path.getPath().toString());
System.out.println("VALUE: " + path.getValue());
```
