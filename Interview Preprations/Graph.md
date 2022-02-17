## GRAPH
1. Implementation
2. Depth First Search Recursive
3. Depth First Search Iterative
4. Breadth First Search
5. Detect Cycle in undirected graph
6. Total number of path from source to destination having exactly m edges
7. check if undirected graph is strongly connected or not 
8. Check if graph is strongly connected or not

## Solution
1. Implementation
class Edge {
		int source, dest;

		public Edge(int source, int dest) {
			this.source = source;
			this.dest = dest;
		}
}

class Graph {
	List<List<Integer>> adjList = null;

	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		for (Edge edge: edges) {
			int src = edge.source;
			int dest = edge.dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src); // not required for directed graph
		}
	}
}

2. DFS Recursive
public static void DFS(int src, boolean[] discovered) {
	discovered[src] = true; 	// mark current node as discovered
	System.out.print(src + " "); 	// print current node

	for (int dest : adjList.get(src)) {
		if (!discovered[dest]) {	// u is not discovered
			DFS(dest, discovered);
		}
	}
}

// Recursive Java implementation of Depth first search
public static void main(String[] args) {
	List<Edge> edges = Arrays.asList(
			// Notice that node 0 is unconnected node
			new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
			new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
			new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
			new Edge(9, 10), new Edge(9, 11)
	);

	final int N = 13;
	Graph graph = new Graph(edges, N);
	boolean[] discovered = new boolean[N];
	for (int i = 0; i < N; i++) {
		if (!discovered[i]) {
			DFS(graph, i, discovered);
		}
	}
}

3. DFS Iterative
public static void iterativeDFS(int src, boolean[] discovered) {
	Stack<Integer> stack = new Stack<>();
	stack.push(src);
	while (!stack.empty()) {
		int current = stack.pop();
		if (discovered[current])
			continue;

		discovered[current] = true;
		System.out.print(current + " ");

		List<Integer> adj = graph.adjList.get(current);
		for (int i = adj.size() - 1; i >= 0; i--) {
			int dest = adj.get(i);
			if (!discovered[dest]) {
				stack.push(dest);
			}
		}
	}
}

4. BFS iterative
public static void BFS(int src, boolean[] discovered) {
	Queue<Integer> q = new ArrayDeque<>();
	q.add(src);

	// run till queue is not empty
	while (!q.isEmpty()) {
		src = q.poll();
		if (discovered[src])
			continue;

		discovered[src] = true;
		System.out.print(src + " ");

		for (int dest : graph.adjList.get(src)) {
			if (!discovered[dest]) {
				q.add(u);
			}
		}
	}
}

5. detect cycle in undirected graph
public static boolean dfs(int src, boolean[] discovered, int parent){
	discovered[src] = true;
	for(int dest : adj.get(src)){
		if(!discovered[dest]){
			if(dfs(dest, discovered), src)
				return true;
		} else if( dest != parent) {
			return true;
		}
	}
	return false;
}

public static boolean bfs(int src, boolean[] discovered)	{
	Queue<Node> queue = new LinkedList<>();
	queue.add(new Node<>(src, -1));
	while(!queue.isEmpty()) {
		Node node = queue.poll();
		int src = node.src;
		int parent = node .src;
		if(discovered[src]) continue;
		
		for(int dest: adj.get(src)){
			if(!discovered[dest]){
				queue.add(new Node(dest, src));
			} else if(dest != parent){
				return true;
			}
		}
	}
	return false;
}

6. Total number of path from source to destination having exactly m edges
public static  int modifiedBFS(int src, int dest, int m) {
	Queue<Node> q = new ArrayDeque<>();
	q.add(new Node(src, 0));
	int count = 0;
	while (!q.isEmpty()) {
		src = q.poll();
		Node vertex = node.vertex;
		int depth = node.depth;

		// if destination is reached and BFS depth is equal to m update count
		if (vertex == dest && depth == m)
			count++;

		// don't consider nodes having BFS depth more than m.
		// This check will result in optimized code and also
		// handle cycles in the graph (else loop will never break)
		if (depth > m)
			break;

		// do for every adjacent vertex u of v
		for (int dest : g.adjList.get(src)) {
			// push every vertex (discovered or undiscovered) into the queue
			q.add(new Node(dest, depth + 1));
		}
	}
	return count;
}

7. check if undirected graph is strongly connected or not
public static boolean check(int N) {
	boolean[] visited = new boolean[N];
	// choose random starting point
	int v = 0;
	// run a DFS starting at v
	DFS(v, visited);
	// If DFS traversal doesn’t visit all vertices,
	// then graph is not strongly connected
	for (boolean b: visited)
		if (!b)
			return false;
}				

8. Check if graph is strongly connected or not
public static boolean check(Graph graph, int N) {
	// do for every vertex	
	for (int i = 0; i < N; i++) {
		// stores vertex is visited or not
		boolean[] visited = new boolean[N];

		// start DFS from first vertex
		DFS(graph, i, visited);

		// If DFS traversal doesn’t visit all vertices,
		// then graph is not strongly connected
		for (boolean b: visited)
			if (!b)
			return false;
	}
	return true;
}
time compexity is N^3,
check other solution

9. check if directed graph has cycle
boolean isCyclic(int source, boolean[] visited, boolean[] recursionStack){
	if(recursionStack[source])
		return true;
	
	if(visited[source])
		return false;
	
	visited[i] = true;
	recursionStack[i] = true;
	
	for(Integer dest: adjList.get(source)) {
		if(!visited[dest]) {
			isCyclic(dest, visited, recursionStack);
		}
	}
	recursionStack[i] = false;
	return false;
}

10. count number of islands
class Islands { 
    // No of rows and columns 
    int final ROW, COL; 
	Islands(row, col){
	}
	
    // A function to check if a given cell (row, col) can 
    // be included in DFS 
    boolean isSafe(int M[][], int row, int col, 
                   boolean visited[][]) 
    { 
        // row number is in range, column number is in range 
        // and value is 1 and not yet visited 
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]); 
    } 
  
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    void DFS(int M[][], int row, int col, boolean visited[][]) 
    { 
        // These arrays are used to get row and column numbers 
        // of 8 neighbors of a given cell 
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
  
        // Mark this cell as visited 
        visited[row][col] = true; 
  
        // Recur for all connected neighbours 
        for (int k = 0; k < 8; ++k) 
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) 
                DFS(M, row + rowNbr[k], col + colNbr[k], visited); 
    } 
  
    // The main function that returns count of islands in a given 
    // boolean 2D matrix 
    int countIslands(int M[][]) 
    { 
        // Make a bool array to mark visited cells. 
        // Initially all cells are unvisited 
        boolean visited[][] = new boolean[ROW][COL]; 
  
        // Initialize count as 0 and travese through the all cells 
        // of given matrix 
        int count = 0; 
        for (int i = 0; i < ROW; ++i) 
            for (int j = 0; j < COL; ++j) 
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with 
                { // value 1 is not 
                    // visited yet, then new island found, Visit all 
                    // cells in this island and increment island count 
                    DFS(M, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    } 
  
    // Driver method 
    public static void main(String[] args) throws java.lang.Exception 
    { 
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
                                  { 0, 1, 0, 0, 1 }, 
                                  { 1, 0, 0, 1, 1 }, 
                                  { 0, 0, 0, 0, 0 }, 
                                  { 1, 0, 1, 0, 1 } }; 
        Islands I = new Islands(); 
        System.out.println("Number of islands is: " + I.countIslands(M)); 
    } 
}

11. dijkstra's alogorithm
class Edge {
	int source, dest, weight;
	public Edge(int source, int dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
};


class Node {
	int vertex, weight;
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
};

class Graph {
	// A List of Lists to represent an adjacency list
	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge);
		}
	}
}

class Dijkstra {
	public static void main(String[] args) 	{
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1, 10), new Edge(0, 4, 3),
				new Edge(1, 2, 2), new Edge(1, 4, 4),
				new Edge(2, 3, 9), new Edge(3, 2, 7),
				new Edge(4, 1, 1), new Edge(4, 2, 8),
				new Edge(4, 3, 2)
		);
		final int N = 5;
		Graph graph = new Graph(edges, N);
		shortestPath(graph, 0, N);
	}
	
	public static void shortestPath(Graph graph, int source, int N) {
		PriorityQueue queue = new PriorityQueue<>(N, (lhs, rhs) -> lhs.weight - rhs.weight);
		queue.add(new Node(source, 0));

		boolean visited = new boolean[N];
		int distances = new int[N];

		for(i=0;i<vertices;i++){
			distances[i]=Integer.MAX_VALUE;
		}	
		distances[source] = 0;
		visited[source] = true;
		
		// stores predecessor of a vertex (to print path)
		int prev[] = new int[N];
		prev[source] = -1;
		
		while(!queue.isEmpty()){
			// Remove and return best vertex
			Node node = queue.poll();
			int u = node.vertex;
			visited[u] = true;
			
			for(Edge edge: graph.adjList.get(u)){
				int v = edge.dest;
				int weight = edge.weight;
				
				// Relaxation step
				if (!visited[v] && (distances[u] + weight) < distances[v]) {
					distances[v] = distances[u] + weight;
					prev[v] = u;
					queue.add(new Node(v, dist.get(v)));
				}
			}
		}
		
		
		for (int i = 1; i < N; ++i) {
			System.out.print("Path from vertex 0 to vertex " + i +
							" has minimum cost of " + dist.get(i) +
							" and the route is [ ");
			printRoute(prev, i);
			System.out.println("]");
		}
	}
	
	private static void printRoute(int prev[], int i) {
		if (i < 0)
			return;

		printRoute(prev, prev[i]);
		System.out.print(i + " ");
	}

}


12. snake and ladder
class Edge {
	int src, dest;

	public Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
};

// A queue node
class Node {
	// stores number associated with graph node
	int ver;

	// minDist stores minimum distance of node from starting vertex
	int minDist;

	public Node(int ver, int minDist) {
		this.ver = ver;
		this.minDist = minDist;
	}
};

class Graph {
	// A List of Lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the graph
		for (int i = 0; i < edges.size(); i++)
		{
			int src = edges.get(i).src;
			int dest = edges.get(i).dest;

			// Please note that directed is directed
			adjList.get(src).add(dest);
		}
	}
}


class SnakeLadder {

		public static void findSolution(Map<Integer, Integer> ladder,
								   Map<Integer, Integer> snake)
	{
		// Number of vertices in the graph
		int N = 100;
		
		// find all edges involved and store them in a vector
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < N; i++)
		{
			for (int j = 1; j <= 6 && i + j <= N; j++)
			{
				int src = i;

				// update destination if there is any ladder
				// or snake from current position.
				int dest;

				int _ladder = (ladder.get(i + j) != null) ?
								ladder.get(i + j): 0;

				int _snake = (snake.get(i + j) != null) ?
								snake.get(i + j): 0;

				if (_ladder != 0 || _snake != 0)
					dest = _ladder + _snake;
				else
					dest = i + j;

				// add edge from src to dest
				edges.add(new Edge(src, dest));
			}
		}

		// construct directed graph
		Graph g = new Graph(edges, N);

		// Find Shortest path between 1 and 100 using BFS
		BFS(g, 0, N);
	}

	// Perform DFS on graph g starting from given source vertex
	public static void BFS(Graph g, int source, int N) {
		// create a queue used to do BFS
		Queue<Node> q = new ArrayDeque<>();

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N + 1];

		// mark source vertex as discovered
		discovered[source] = true;

		// assign minimum distance of source vertex as 0 and
		// push it into the queue
		Node node = new Node( source, 0 );
		q.add(node);

		// run till queue is not empty
		while (!q.isEmpty()) {
			// pop front node from queue
			node = q.poll();

			// Stop BFS if we have reached last node
			if (node.ver == N) {
				System.out.println(node.minDist);
				break;
			}

			// do for every adjacent node of current node
			for (int u : g.adjList.get(node.ver)) {
				if (!discovered[u]) {
					// mark it discovered & push it into queue
					discovered[u] = true;

					// assign minimum distance of current node
					// as minimum distance of parent node + 1
					Node n = new Node(u, node.minDist + 1);
					q.add(n);
				}
			}
		}
	}
}

13. shortest path chess knight
class Node
{
	// (x, y) represents chess board coordinates
	// dist represent its minimum distance from the source
	int x, y, dist;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	// As we are using class object as a key in a HashMap
	// we need to implement hashCode() and equals()

	// -- below methods are generated by IntelliJ IDEA (Alt + Insert) --
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Node node = (Node) o;

		if (x != node.x) return false;
		if (y != node.y) return false;
		return dist == node.dist;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + dist;
		return result;
	}
};

class Main {
	private static int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	private static int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };
	
	public static void main(String[] args) 	{
		int N = 8;

		// source coordinates
		Node src = new Node(0, 7);

		// destination coordinates
		Node dest = new Node(7, 0);

		System.out.println("Minimum number of steps required is " + BFS(src, dest, N));
	}
	
	public static int BFS(Node src, Node dest, int N)
	{
		// set to check if matrix cell is visited before or not
		Set<Node> visited = new HashSet<>();

		// create a queue and enqueue first node
		Queue<Node> q = new ArrayDeque<>();
		q.add(src);

		// run till queue is not empty
		while (!q.isEmpty()) {
			// pop front node from queue and process it
			Node node = q.poll();

			int x = node.x;
			int y = node.y;
			int dist = node.dist;

			// if destination is reached, return distance
			if (x == dest.x && y == dest.y)
				return dist;

			// Skip if location is visited before
			if (!visited.contains(node)) {
				// mark current node as visited
				visited.add(node);

				// check for all 8 possible movements for a knight
				// and enqueue each valid movement into the queue
				for (int i = 0; i < 8; ++i) {
					// Get the new valid position of Knight from current
					// position on chessboard and enqueue it in the
					// queue with +1 distance
					int x1 = x + row[i];
					int y1 = y + col[i];

					if (valid(x1, y1, N))
						q.add(new Node(x1, y1, dist + 1));
				}
			}
		}

		// return INFINITY if path is not possible
		return Integer.MAX_VALUE;
	}

	// Check if (x, y) is valid chess board coordinates
	// Note that a knight cannot go out of the chessboard
	private static boolean valid(int x, int y, int N) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
	}
}


14. topological sort
public static void DFS(int src, boolean[] discovered, Stack stack) {
	discovered[src] = true; 	// mark current node as discovered

	for (int dest : adjList.get(src)) {
		if (!discovered[dest]) {	// u is not discovered
			DFS(dest, discovered);
		}
	}
	stack.push(src);
}

// Recursive Java implementation of Depth first search
public static void main(String[] args) {
	List<Edge> edges = Arrays.asList(
			// Notice that node 0 is unconnected node
			new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
			new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
			new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
			new Edge(9, 10), new Edge(9, 11)
	);

	final int N = 13;
	Graph graph = new Graph(edges, N);
	boolean[] discovered = new boolean[N];
	Stack<Integer> stack  = new LinkedList<>();
	for (int i = 0; i < N; i++) {
		if (!discovered[i]) {
			DFS(graph, i, discovered);
		}
	}
}

flood fill
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }