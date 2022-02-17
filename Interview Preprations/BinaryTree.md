## Tree

#Skew Tree
- each node has exactly one node
- left skew tree, right skew tree, skew tree

## Binary Tree

#Strict Binary Tree
- each node has exatly two children or no children

# Full Binary Tree
- each node has exactly two children and all leaf nodes are at same level
- number of nodes -----> 2^(h+1) – 1

# Complete Binary Tree
- all leaf nodes are at height h or h – 1 and also without any missing number in the sequence
- min number of nodes -----> 2^(h), and max number of nodes -----> 2^(h+1) – 1

class BinaryTree<T> {
	Node root;
	
	private static class Node<T> {
		Node left;
		Node right;
		T data;
		
		public Node(T data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	void preOrder(){ preOrder(root); }
	void preOrder(Node<T> node) {}
}

			1
	2				3
4		5		6		7

Programs
1*.  PreOrder Traversal (recursively and iteratively)
2*.  InOrder Traversal (recursively and iteratively)
3*.  PostOrder Traversal (recursively and iteratively)
4.  Level Order Traversal 
5.  Reverse Level Order Traversal
6.  Spiral Order Traversal
7.  Print Left view 
8.  Print Right View
9.  Print Top View
10. Print Bottom View
11. insert an element
12. delete tree 
13. find largest element (recursively and iteratively)
14. find smallest element (recursively and iteratively)
15. search an element (recursively and iteratively)
16. find deepest element
17. print leaf nodes
18*. print full nodes
19. calculate height (recursively and iteratively)
20. find minimum height (recursively and iteratively)
21. print root to leaf
22. print leaf to root
23. if two trees are identical
24. find diameter of binary tree
25. find max width
26. find level that has maximum sum
27. check if tree is complete
28. chek if two nodes are siblings
29. convert to mirror
30. check if mirror
31. find ancestors of a node
32. find lca of two nodes
33. find  distance between two node
34. construct from preorder and inorder 
35. construct from postorder and inorder 
36. vertical Order traversal
37. check if two nodes are cousins of each other

# Traversal
* trick to find the o/p -----> https://www.youtube.com/watch?v=WLvU5EQVZqY
** preorder
- 1-2-4-5-3-6-7
- go with flow ----> start printing ----> ignore visited
- recursive
void preOrder(Node<T> node) {
	if(node == null) return;
	System.out.println(node.data)
	preOrder(node.left);
	preOrder(node.right);
}
-iterative
void preOrder(Node<T> node){
	if(node == null) return;
	Stack<Node<T>> stack = new Stack<>();
	stack.push(node);
	while(!stack.isEmpty())
		Node current = stack.pop();
		System.out.print(current.data + " ")
		if(current.right != null)	stack.push(current.right) ----> important
		if(current.left != null)	stack.push(current.left)
	}
}

** inorder
- 4-2-5-1-6-3-7
- go with flow ----> is visited second time ----> print ----> ignore visited
void inOrderTraversal(Node<T> node){
	if(node == null) return;
	inOrderTraversal(node.left);
	System.out.println(node.data);
	inOrderTraversal(node.right);
}

void inOrderTraversal(Node<T> node){
	if(node == null) return;
	Stack<Node<T>> stack = new Stack<>();
	Node current = node;
	// if stack is ampty and current is also null then we are done 
	while(!stack.isEmpty() || current!=null) {
		/* Reach the left most Node of the current Node */
		while (current !=  null) { 
			s.push(current); 
			current = current.left; 
		} 
	
		current = stack.pop();
		System.out.print(node.data + " ");
		current=current.right;
	}
}	


** postorder 
- 4-5-2-6-7-3-1
- go with flow ----> is visited last time ----> print
void postOrderTraversal(Node<T> node){
	if(node == null) return;
	postOrderOrderTraversal(node.left);
	postOrderTraversal(node.right);
	System.out.println(node.data);
}
- iterative
void postOrder(Node<T> node){
	if(node == null) return;
	Stack<Node<T>> stack = new Stack<>();
	Stack<Node<T>> output = new Stack<>();
	stack.push(node);
	while(!stack.isEmpty()) {
		Node current = stack.pop();
		output.push(current);
		if(current.left != null)	stack.push(current.left) ----> important
		if(current.right != null)	stack.push(current.right)
	}
	while(!output.isEmpty())
		system.out.println(current.data + " ");
}

** level order traversal
void levelOrderTraversal(Node<T> node){
	if(node == null) return;
	Queue<Node<T>> queue = new LinkedList<>();
	queue.add(node);
	while(!queue.isEmpty()) {
		Node<T> current = queue.poll();
		system.out.println(current.data);
		
		if(current.left != null)
			queue.add(current.left);
			
		if(queue.right != null)
			queue.add(current.right);
	}
}
Time Complexity: O(n), Space Complexity O(n)

** reverse level order traversal
- void levelOrderTraversalInReverse(Node<T> node){
	if(node == null) return;
	Queue<Node<T>> queue = new LinkedList<>();
	Stack<Node<T>> stack = new Stack<>();
	queue.add(node);
	while(!queue.isEmpty()) {
		Node<T> current = queue.poll();
		stack.push(current);
		
		if(curret.left != null)
			queue.add(current.left);
			
		if(queue.right != null)
			queue.add(current.right);
	}
	while(!stack.isEmpty())
		System.out.println(stack.pop().data)
} 

** Bottom Up Level Order Traversal
use wrap list as list(insert at 0) or stack
```
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            while(size-- > 0) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}
```
** Populating Next Right Pointers in Each Node
```
   public Node connect(Node root) {
        if(root == null) return root; 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node current = queue.poll();
                if(size > 0)
                   current.next = queue.peek();
                
                if(current.left != null) 
                    queue.offer(current.left);
    
                if(current.right != null) 
                    queue.offer(current.right);
    
            }
        }
        return root;
    }
```

** print left view
- level order traversal 
  - print 1st node from every level 
  
** print right view
- level order traversal
  - print last node from every level 
  
** print top view
- level order traversal 
  - print 1st node at horizontal distance from root
  	public void topViewPrint(Node<T> node) {
		if(node == null) return;
		
		Queue<QueueObject<T>> queue = new LinkedList<>();
		queue.add(new QueueObject<>(node, 0));
		
		Map<Integer, Node<T>> map = new TreeMap<>();
		while (!queue.isEmpty()) {
			QueueObject<T> current = queue.poll();

			if(!map.containsKey(current.hd)) { ----> avoid this condition for bottom view
				map.put(current.hd, current.node);
			}
			if(current.node.left != null)
				queue.add(new QueueObject<>(current.node.left, current.hd-1));
			
			if(current.node.right != null)
				queue.add(new QueueObject<>(current.node.right, current.hd + 1));
		}
	}

** print bottom view
- level order traversal 
  - print last node at horizontal distance from root


** find bottom left tree value
class Solution {
     public int findBottomLeftValue(TreeNode root) {
		Helper helper = new Helper();
        findBottomLeftValue(root, 1, helper);
        return helper.value;
    }
    public void findBottomLeftValue(TreeNode root, int depth, Helper helper) {
		if(root == null) return;
			
        if (depth > helper.depth) {
            helper.value=root.val;
			helper.depth=depth;
        }
        findBottomLeftValue(root.left, depth+1, helper); ----> imp
        findBottomLeftValue(root.right, depth+1, helper);
    }
    
    class Helper {
        public int value;
        public int depth;
    }
}
** Insert an element
- can be inserted anywhere as root also
- use level order traversal
- traverse till left or right null, when null insert and break

** Delete tree
- java: root= null
- use post traversal as before deleting parent chlidren should be deleted

** find largest
- Integer findmax(Node<Integer> node) {
	if(node == null) return Integer.MIN_VALUE;  ----> solution for max
	Integer maxValue = node.data;
	Integer leftMaxValue = findMax(node.left);
	Integer rightMaxValue = findMax(node.right);
	if(leftMaxValue > maxValue)
		maxValue = leftMaxValue;
	if(rightMaxValue > maxValue)
		maxValue = rightMaxValue;
	return maxValue;
}
- lever order traversal

** find smallest
- same as above

** search an element 
- Boolean search(Node<T> node, T target){
	if(node == null) return false;  
	if(node.data.equals(target))	return true;		
	return search(node.left, target) || search(node.right, target);
  } 
- Boolean search(Node<T> node, T target){
	if(node == null) return false;  
	Queue<Node<T>> queue = new LinkedList<>();
	queue.add(node);
	while(!queue.isEmpty())
		Node<T> current = queue.poll();
		if(current.data.equals(target)); 
			return true

		if(curret.left != null)
			queue.add(current.left);
			
		if(queue.right != null)
			queue.add(current.right);
	}
	return false;
  }  

** find deepest node
- level order traversal

** count leaf nodes
- if (node == null) return 0; 
  if (node.left == null && node.right == null) return 1; 
  else return getLeafCount(node.left) + getLeafCount(node.right); 
- level order traversal
  - if both left and right are null then count++;

** count full nodes
- if (node == null) return 0; 
  if (node.left != null && node.right != null) 
	return 1 + getFullCount(node.left) + getFullCount(node.right); 
  else return getFullCount(node.left) + getFullCount(node.right); 

- level order traversal
  - if both left and right are null then count++; 

** calcuate size
- 1 + sizeOfLeft + sizeOfRight
- level order traversal

** find height or depth
- 1 + heightOfLeft > heightOfRight ? heightOfLeft: heightOfRight;
  termination by 0 || -1
-  level order
int height(Node<T> node) {
		if (root == null) return 0;

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(node);

		int height = 0;
		while (!queue.isEmpty())
		{
			// calculate number of nodes in current level
			int size = queue.size();

			// process each node of current level and enqueue their
			// non-empty left and right child to queue
			while (size-- > 0) {
				Node<T> current = queue.poll();

				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}

			height++;
		}
		return height;
	}  

** min height
- int height(Node<T> node) {
		if (root == null) return 0;

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(node);

		int height = 0;
		while (!queue.isEmpty())
		{
			// calculate number of nodes in current level
			int size = queue.size();

			// process each node of current level and enqueue their
			// non-empty left and right child to queue
			height++;
			while (size-- > 0) {
				Node<T> current = queue.poll();
				
				if(current.left == null && current.right == null)
					return height;
					
				if (current.left != null) {
					queue.add(current.left);
				}

				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return height;
	}  

- recursively
minHeight(Node node) {
	if(node == null) return 0
	
	if(node.left == null && node.right == null) return 1 // leaf
	
	int left_depth = node.left != null? minHeight(node.left): Integer.MAX_VALUE;
	int right_depth = node.right != null? minHeight(node.right): Integer.MAX_VALUE;
	
	return 1 + Math.min(left_depth, right_depth);

}

**  print root to leaf
- same as below

** print leaf to root path
-	void leafToRootPath(Node<T> node, Deque<Node<T>> path) {
		if(node == null) return;
		path.add(node);

		if(node.left==null && node.right==null) {
			Iterator<Node<T>> iterator = 
				path.descendingIterator(); ----> use regular for loop for root-leaf path
			while (iterator.hasNext()) {
				System.out.print(iterator.next().data);
				
				if(iterator.hasNext()) System.out.print("->");	
			}
			System.out.println();
		}
		leafToRootPath(node.left, path);
		leafToRootPath(node.right, path);

		path.removeLast();		
	}
 
** if two trees are identical
- isIdentical(Node<T> node1, Node<T> node2){
	if(node1==null && node2== null) return true;
	if(node1==null || node2== null) return false;
	if(node1.value != node.value) return false;
	return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right)
} 

** check if mirror
public void isMirror(Node<T> node1, Node<T> node2) {
	if(node1 == null && node2 == null) return true;
	if(node1 == null || node2 == null) return false;
	if(node1.data != node2.data) return false;
	return isMirror(node1.left, node2.right) && isMirror(node1.right,node2.left);
}

** convert to mirror
public void mirror(Node<T> node) {
	if(node == null) return;
	mirror(node.left);
	mirror(node.right);
	
	Node temp = node.left;
	node.left = node.right;
	node.right= temp;
}

** find diameter of binary tree
- int diameter(Node node, AtomicInteger diameter){
	if(root == null) return 0;
	int leftHeight = diameter(node.left, diameter);
	int rightHeight = diameter(node.left, diameter);
	int diameterOfNode = 1 + left_height + right_height	;
	diameter.set(Math.max(diameter.get(), diamterOfNode));
	return Math.max(leftHeight, rightHeight) + 1; // return height of node
  }
  
** Max_Path_Sum
public int maxPathSum(TreeNode root) {
	AtomicInteger sum = new AtomicInteger(Integer.MIN_VALUE); ----> imp
	sum(root, sum);
	return sum.get();
}

public int sum(TreeNode root, AtomicInteger sum){
	if(root == null)
		return 0;
	int left_sum = Math.max(sum(root.left, sum),0);    ----> importatnt
	int right_sum = Math.max(sum(root.right, sum),0);
	int current_sum = root.val + left_sum + right_sum;
	sum.set(Math.max(sum.get(), current_sum));
	
	return Math.max(left_sum, right_sum) + root.val;
}
  
  
** find max width(width- number of nodes at each level) 
- use level order traversal

** find level that has maximum sum
- use level order traversal

**  delete node in binary tree
- replace the last node with deepest node
  - use level order traversal
  - find key and deepest node
  - replace key node value with deepest node value and deepest node == null
  
** check if tree is complete
- public boolean checkIfComplete(Node<T> node){
	if(node == null) return true;
	Boolean nonFullNodeSeen = false;
	Queue<Node<T>> queue = new LinkedList<>();
	queue.add(node);
	
	while(!queue.isEmpty()) {
		Node<T> current = queue.poll();
		// if we have encountered a non-full node before and current node
		// is not a leaf, tree cannot be complete tree
		if (nonFullNodeSeen && (current.left != null || current.right != null)) {
			return false;
		}

		// if left child is empty & right child exists, tree cannot be complete
		if (current.left == null && current.right != null) {
			return false;
		}

		// if left child exists, enqueue it
		if (current.left != null) {
			queue.add(current.left);
		}
		// if current node is a non-full node, set flag to true
		else {
			nonFullNodeSeen = true;
		}

		// if right child exists, enqueue it
		if (current.right != null) {
			queue.add(current.right);
		}
		// if current node is a non-full node, set flag to true
		else {
			nonFullNodeSeen = true;
		}
	}
  } 
  
** check if two nodes are siblings
boolean areSiblings(Node<T> node,Node<T> node1,Node<T> node2) {
	if (root == null) return 0;

	Queue<QueueObject<T>> queue = new LinkedList<>();
	queue.add(new QueueObject<>(node, null));

	while (!queue.isEmpty())
	{
		Node<T> parA,parB;
		int size = queue.size();
		while (size-- > 0) {
			QueueObject<Node<T>,Node<T>> current = queue.poll();

			if(current.data == node1.data)
				parA = current.parent;
			
			if(current.data == node2.data)	
				parB = current.parent;
					
			if(parA!= null && parB!= null)
				break;

			if (current.left != null) {
				queue.add(current.left, current);
			}

			if (current.right != null) {
				queue.add(current.right, current);
			}
		}
		if(parA != null && parB != null) 
			return parA != parB; 
  
		if ((parA!=null && parB==null) || (parB!=null && parA==null)) 
			return false; 
	}
	return false;
}  


** find ancestors of a node
- use root to leaf node strategy

** find lca of two nodes
- Find path from root to n1 and store it in a vector or array.
  Find path from root to n2 and store it in another vector or array.
  Traverse both paths till the values in arrays are same. Return the common	

- 
Node lca(Node node, int n1, int n2) {
	if (node == null)
		return null;

	if (node.data == n1 || node.data == n2)
		return node;

	Node left_lca = lca(node.left, n1, n2);
	Node right_lca = lca(node.right, n1, n2);

	if (left_lca!=null && right_lca!=null)
		return node;

	return (left_lca != null) ? left_lca : right_lca;
}
	
static node lca(Node node, int n1, int n2, Boolean isNode1Found, Boolean isNode2Found){
	if(node ==null) return null;
	
	Node temp = null;
	if(node.data == n1)	{
		temp = node;
		isNode1Found.set(true);
	} 

	if(node.data == n2)	{
		temp = node;
		isNode2Found.set(true);
	} 
	
	Node left_lca = lca(node.left, n1, n2);
	Node right_lca = lca(node.right, n1, n2);
	
	if(temp != null) return temp;
	
	if(left_lca!=null && right_lca!=null) return node;
	
	return left_lca != null ? left_lca: right_lca;
}

main() {
	Node lca = lca(root, 6, 7);
	if(isNode1Found.get() && isNode2Found.get()){
		// print lca;
	} else {
	  // print null;
	}
}

** find  distance between two node
-  find lca and do the logic

** construct from preorder and inorder 
----> 1,2,4,5,3,6,7 (perorder)
----> 4,2,5,1,6,3,7 (inorder)
- public Node construct(T[] inOrder, T[] postOrder){
	Map<T, Integer> map = IntStream.range(0,inOrder.size())
   								   .boxed()
								   .collect(toMap(inOrder::get, i->i));
	construct(0, inOrder.size()-1, map, preOrder, new AtomicInteger(0));							   
  }
 
  public Node<T> construct(Integer start, Integer end, Map<T,Integer> map,
							T[] preOrder, AtomicInteger pIndex) {
	if(start > end)
		return null;
	
	Node<T> current = new Node(preOrder[pIndex.getAndIncrement()]);
	Integer iIndex = map.get(T);
	
	node.left = construct(start, iIndex-1, map, preOrder, pIndex);
	node.right = construct(iIndex+1, end, map, preOrder, pIndex);
	
	return node;
  }
  
** construct from postorder and inorder 
public TreeNode buildTree(int[] inorder, int[] postorder) {
		 Map<Integer, Integer> map = IntStream.range(0,inorder.length)
								   .boxed()
								   .collect(Collectors.toMap(i->inorder[i], i->i));
		return construct(0, postorder.length-1, postorder, map, new AtomicInteger(postorder.length-1));   
}

public TreeNode  construct(int start, int end, int[] postorder, Map<Integer, Integer> inorder, AtomicInteger pIndex)     {
	if(start > end)
		return null;
	
	TreeNode node = new TreeNode(postorder[pIndex.getAndDecrement()]);
	int index = inorder.get(node.val);

	node.right = construct(index+1, end, postorder, inorder, pIndex);
	node.left = construct(start, index-1, postorder, inorder, pIndex);

	
	return node;
}	

** Path Sum III (leetcode)

class O(n2)Soultion {
		int total = 0;
	    public int pathSum(TreeNode root, int sum) {
			if(root == null) return 0;
			findPathSum(root, sum, 0);
			pathSum(root.left, sum);
			pathSum(root.right, sum);
		}
		
		void findPathSum(TreeNode root, int sum, int currentSum) {
			if(root == null) return;
			currentSum += root.val;
			if(sum == currentSum) total++;
			findPathSum(root.left, sum, currentSum);
			findPathSum(root.right, sum, currentSum);
		}
}

class Solution {
    int total = 0;
   public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        findPathSum(root, 0, sum, hm);  
        return total; 
   }
    private void findPathSum(TreeNode curr, int currentSum, int target, HashMap<Integer, Integer> hm) {
        if (curr == null)
            return;
        
        currentSum += curr.val;
        if(hm.containsKey(currentSum-target))
          total += hm.get(currentSum-target);
        hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);
         findPathSum(curr.left, currentSum, target, hm);
         findPathSum(curr.right, currentSum, target, hm);
        hm.put(currentSum, hm.get(currentSum) - 1);
        return;
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap(); // ----> cumulative sum vs freq
        hashMap.put(0,1);
        return helper(root, 0, sum, hashMap);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> hashMap) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = hashMap.getOrDefault(currSum - target, 0);
        hashMap.put(currSum, hashMap.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, hashMap) + helper(root.right, currSum, target, hashMap);
        hashMap.put(currSum, hashMap.get(currSum) - 1);
        return res;
    }
}

## Breadth-First-Search

** connected nodes
public static void main(String args[]) { 
		List<int[]> edges  = Arrays.asList(
				new int[]{6,11}, new int[]{9,5}, new int[]{11,9},
				new int[]{15,9}, new int[]{13,15}, new int[]{12,14},
				new int[]{15,16}, new int[]{1,16} );
		int n = 16;
		
		Map<Integer, List<Integer>> adjListArray = new HashMap<>();
		
		for(int[] edge: edges) {
			adjListArray.putIfAbsent(edge[0], new ArrayList<Integer>());
			adjListArray.putIfAbsent(edge[1], new ArrayList<Integer>());
			adjListArray.get(edge[0]).add(edge[1]);
			adjListArray.get(edge[1]).add(edge[0]);
		}
		
		boolean[] visited = new boolean[n+1];
		for (int v = 1; v <= n; ++v) {
			if (!visited[v]) {
				System.out.println(bfs(adjListArray, visited, v));
			}
		}
		
	}

private static int bfs(Map<Integer, List<Integer>> adjListArray, boolean[] visited, int v) {
	Queue<Integer> queue = new LinkedList<>();

	int result = 0;
	queue.add(v);
	visited[v] = true;
	while(!queue.isEmpty()) {
		int src = queue.poll();
		result++;
		List<Integer> list = adjListArray.getOrDefault(src, new ArrayList<>());
		for(Integer dest: list) {
			if(!visited[dest]) {
				queue.add(dest);
				visited[dest] = true;
			}
		}
	}
	return result;
}


static int dfs(int v, boolean[] visited, List<List<Integer>> adjListArray)
{
	visited[v] = true;
	int result = 1;
	for (int x : adjListArray.get(v)) {
		if (!visited[x])
			result += dfs(x, visited, adjListArray);
	}
	return result;
}

** set matrix zero
   public void setZeroes(int[][] matrix) {
    int m=matrix.length;
    int n=matrix[0].length;
    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                row.add(i);
                col.add(j);
            }
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(row.contains(i)||col.contains(j)){
                matrix[i][j]=0;
            }
        }
    }
}

** https://leetcode.com/problems/employee-importance/
[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
```
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }
}
```

** Number Of Islands
```
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if (r < 0 || r >= m || c < 0 || c >=n || visited[r][c] || grid[r][c] == '0') 
                    continue;
                
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
    }
}```

** Perimeter of Island
class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1)
                    return bfs(i,j,grid, visited);
            }
        }
        
        return -1;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int bfs(int i, int j, int[][] grid, boolean[][] visited) {
        
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] src  = queue.poll();
            int x = src[0];
            int y = src[1];
            result += 4;
            if(x>0 && grid[x-1][y] == 1) //up
                result--;
            
            if(x<grid.length-1 && grid[x+1][y] == 1) //down
                result--;
            
            if(y>0 && grid[x][y-1] == 1) //left
                result--;
            
            if(y<grid[0].length-1 && grid[x][y+1] == 1) //right
                result--;
            
            for(int[] dir: dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX<0 || newX>grid.length-1 
                   || newY<0 || newY>grid[0].length-1 
                   || grid[newX][newY] == 0 
                   || visited[newX][newY] == true)
                    continue;
                
                visited[newX][newY] = true;
                queue.offer(new int[] {newX, newY});
            }
        }
        return result;
    }
}

** max area of Islands
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    result = Math.max(result, bfs(grid, queue, visited) + 1); ----> Important
                }
            }
        }
        
        return result;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if (r < 0 || r >= m || c < 0 || c >=n || visited[r][c] || grid[r][c] == 0) 
                    continue;
                
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
                result++;
            }
        }
        return result;
    }
}

** shortest path
** https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
```
public int shortestPathBinaryMatrix(int[][] matrix) {  
	int row = matrix.length;
	int col = matrix[0].length;
	Queue<int[]> queue = new LinkedList<>();
	boolean[][] visited = new boolean[row][col];
	
	if(matrix[0][0]==1 || matrix[row-1][col-1]==1) {
		return -1;
	}
	queue.add(new int []{0, 0});
	visited[0][0] = true;
	int [][] directions = new int [][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
	int move = 0;
	while (!queue.isEmpty()) {
		int size = queue.size();
		move++;
		while(size-->0) {
		int [] current = queue.poll();
		int x = current[0];
		int y = current[1];

		if(x==row-1 && y == col-1)
			return move;
		
		for (int [] dir : directions) {
				int newX = dir[0] + x;
				int newY = dir[1] + y;
			 if(newX>=0 && newX<row && newY>=0 && newY<col && !visited[newX][newY] && matrix[newX][newY]==0) {
					queue.add(new int[]{newX,newY});
					visited[newX][newY]=true;
				}
			}
		}
	}
	return -1;
}```

** rotting oranges
```
public int orangesRotting(int[][] grid) {
	Queue<int[]> queue = new LinkedList();
	int freshCount = 0;
	for (int i = 0; i < grid.length; i++){
		for (int j = 0; j < grid[0].length; j++){
			if (grid[i][j] == 2)
				queue.add(new int[]{i, j});
			if (grid[i][j] == 1)
				freshCount ++;
		}
	}
	int time = 0;
	int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	while(!queue.isEmpty() && freshCount > 0){
		time ++;
		int size = queue.size();
		while(size-- > 0){
			int [] xy = queue.poll();
			for(int [] d : directions){
				int x = xy[0] + d[0];
				int y = xy[1] + d[1];
				if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
					continue;
				queue.add(new int []{x, y});
				grid[x][y] = 2;
				freshCount --;
			} 
		}
	}
	return freshCount == 0 ? time : -1;
	
}
```	
** 0-1 matrix
class Solution {
     public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new int []{i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE; // to mark it as not visited
            }
        }
        int [][] directions = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 
				|| newX >= row || newY >= col 
				|| matrix[newX][newY] < matrix[x][y]) ----> imp
                    continue;
                queue.add(new int [] {newX, newY});
                matrix[newX][newY] = matrix[x][y] + 1;
            }
        }
        return matrix;
    }
}

** cheapest flight with at most k stops
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
	for (int[] f : flights) {
		if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
		prices.get(f[0]).put(f[1], f[2]);
	}
	Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
	pq.add(new int[] {0, src, k + 1}); ----> imp
	while (!pq.isEmpty()) {
		int[] top = pq.remove();
		int price = top[0];
		int city = top[1];
		int stops = top[2];
		if (city == dst) return price;
		if (stops > 0) {
			Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
			for (int a : adj.keySet()) {
				pq.add(new int[] {price + adj.get(a), a, stops - 1});
			}
		}
	}
	return -1;
}

** letter combination of phone
String[] table
            = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" }; //OR
String[] table
            = { "",   "",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };				
static List<String> combination(int[] number, int n)
{
	// To store the generated letter combinations
	ArrayList<String> list = new ArrayList<>();

	Queue<String> q = new LinkedList<>();
	q.add("");

	while (!q.isEmpty()) {
		String s = q.remove();

		// If complete word is generated
		// push it in the list
		if (s.length() == n)
			list.add(s);
		else {
			String val = table[number[s.length()]];
			for (int i = 0; i < val.length(); i++) 
			{
				q.add(s + val.charAt(i));
			}
		}
	}
	return list;
}