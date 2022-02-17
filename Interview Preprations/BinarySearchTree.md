## Binary Search Tree
• Since root data is always between left subtree data and right subtree data,
performing inorder traversal on binary search tree produces a sorted list.
• While solving problems on binary search trees, first we process left subtree, then
root data, and finally we process right subtree. This means, depending on the
problem, only the intermediate step (processing root data) changes and we do not
touch the first and third steps.
• If we are searching for an element and if the left subtree root data is less than the
element we want to search, then skip it. The same is the case with the right subtree..
Because of this, binary search trees take less time for searching an element than
regular binary trees. In other words, the binary search trees consider either left or
right subtrees for searching an element but not both.
• The basic operations that can be performed on binary search tree (BST) are insertion
of element, deletion of element, and searching for an element. While performing
these operations on BST the height of the tree gets changed each time. Hence there
exists variations in time complexities of best case, average case, and worst case.
• The basic operations on a binary search tree take time proportional to the height of
the tree. For a complete binary tree with node n, such operations runs in O(lgn)
worst-case time. If the tree is a linear chain of n nodes (skew-tree), however, the
same operations takes O(n) worst-case time.

			4
		2		6
	1	   3 5		7
## Programs
1.  search element (recursively &iteratively)
2.  print bst in sorted order (recursively & iteratively)
3.  print bst in descending order (recursively) 
4.  find smallest element in bst (recursively & ietratively)
5.  find largest element in bst (recursively & iteratively)
6*.  find kth smallest element in bst (recursively & ietratively)
7.  find kth largest element in bst (recursively)
8*.  insert element (recursively & iteratively) 
9.  find floor and ceil (recursively & iteratively)
10. check whether bst or not (recursively)
11. construct from sorted array (recursively)
12. construct from unsorted array (recursively)
13. construct from preorder (4,2,1,3,6,5,7)
14. construct from postorder (1,3,2,5,7,6,4)
15. delete element from bst 
16. find predecessor (recursively)
17. find successor (recursively)
18. find triplet with given sum
19. https://www.techiedelight.com/merge-two-bsts-into-doubly-linked-list-sorted-order/
20. https://www.techiedelight.com/construct-height-balanced-bst-from-unbalanced-bst/
21. convert bst to sorted doubly linked list

** search element recursively
-	public Node search(Node node, int target){
		if(node == null || node.data == target) return node;
		
		if(target < node.data)	
			return search(node.left, target);
		
		return search(node.right, target);
	}
Time Complexity: O(n), in worst case (when the given binary search tree is a skew tree).
Space Complexity: O(n), for recursive stack

** search element iteratively
public Node search(Node node, int target) {
	if(node == null) throw new RuntimeException("Not Found");

	if(node.data == target) return node;
	
	while(node != null){
		if(target == node.data) return node;
		if(target < node.data)	node = node.left;
		else node = node.right;
	}
	
	throw new RuntimeException("Not Found");
}
Time Complexity: O(n), in worst case (when the given binary search tree is a skew tree).

** print bst in sorted order
- inorder traversal

** print bst in descending order
- reverse in-order

** Find smallest
- 	Node smallest(Node node){
		if(node == null) return;
		while(node.left !=null)	node = node.left;
		return node;
	}

- 	Node smallest(Node node){
		if(node == null) return; // base case
		if(node.left == null) return node; // base case
		return smallest(node.left);
	}

** find largest
- same as above

** find kth smallest
- 	Node smallest(Node node, AtomicInteger i, int k){
		if(node == null) return node;
		Node smallest = smallest(node.left,i,k);
		if(smallest != null) return smallest;
		if(i.incrementAndGet() == k) return node;
		return(node.right, i, k);	
	}


** find kth largest
public static Node kthLargest(Node root, AtomicInteger i, int k)
{
	if (root == null) return node;
	// search in right subtree
	int right = kthLargest(root.right, i, k);

	// if k'th largest is found in right subtree, return it
	if (right != null) { 
		return right;
	}

	// if current element is k'th largest, return its value
	if (i.incrementAndGet() == k) {
		return root.data;
	}

	// else search in left subtree
	return kthLargest(root.left, i, k);
}

** insertion
public Node insert(Node node, int target){
	if(node == null) {
		node = new Node(target);
		return node;
	}
	
	if(node.data == target) return;
	
	if(target < node.data)	
		node.left = insert(node.left, target);
	else
		node.right = insert(node.right, target);
}
Time Complexity: O(n), in worst case (when the given binary search tree is a skew tree).
Space Complexity: O(n), for recursive stack

public Node insert(Node node, int target) {
	if(node == null) {
		node = new Node(target);
		return node;
	}
	Node parent;
	if(node.data == target) return;	
	while(node != null){
		parent = node;
		if(target == node.data) return;
		if(target < node.data)	node = node.left;
		else node = node.right;
	}
	
	if(target < parent.data)	parent.left = new Node(target);
	else parent.right = new Node(target);
}
Time Complexity: O(n), in worst case (when the given binary search tree is a skew tree).

** find floor and ceil for given keys
public static void findFloorCeil(Node node, Node floor, Node ceil, int key)
{
	while (node != null)
	{
		// if node with key's value is found, floor and ceil is equal to the current node
		if (node.data == key)
		{
			floor = node;
			ceil = node;
			break;
		}

		// if given key is less than the root node, visit left subtree
		else if (key < node.data)
		{
			// update ceil to current node before visiting left subtree
			ceil = node;
			node = node.left;
		}

		// if given key is more than the root node, visit right subtree
		else
		{
			// update floor to current node before visiting right subtree
			floor = node;
			node = node.right;
		}
	}
}

** check if balanced binary search tree
- 	public static boolean isBST(Node node, int minKey, int maxKey) {
		if (node == null) return true; // base case

		// if node's value fall outside valid range
		if (node.data < minKey || node.data > maxKey) return false;

		// recursively check left and right subtrees with updated range
		return isBST(node.left, minKey, node.data) &&
			isBST(node.right, node.data, maxKey);
	}

** construct balanced binary search tree from sorted array
-	public static Node convert(int[] keys, int low, int high) {
		if (low > high) return null; 		// base case

		// find middle element of current range
		int mid = low + (high - low) / 2;

		// construct a new node from mid element and assign it to root
		Node node = new Node(keys[mid]);

		// left subtree of root will be formed by keys less than mid element
		node.left = convert(keys, low, mid - 1);

		// right subtree of root will be formed by keys less than mid element
		node.right = convert(keys, mid + 1, high);

		return node;
	}
	
** construct balanced binary search tree from unsorted array
- sort the array and call above function

** construct from preorder
- 	public static Node constructBST(int[] preorder, int start, int end) {
		if (start > end) return null; 		// base case

		// Construct the root node of the sub-tree formed by keys of the
		// preorder sequence in range [start, end]
		Node node = new Node(preorder[start]);

		// search the index of first element in current range of preorder
		// sequence which is larger than the value of root node
		int i;
		for (i = start; i <= end; i++) {
			if (preorder[i] > node.key) {
				break;
			}
		}

		// recursively construct the left sub-tree
		node.left = constructBST(preorder, start + 1, i - 1);

		// recursively construct the right sub-tree
		node.right = constructBST(preorder, i, end);

		// return current node
		return node;
	}

** construct from post order

** delete
-	public Node delete(Node root, int target) {
		if(root == null) throw new RuntimeException("Not Found");
		Node parent = null;
		Node current = root;
		while(current != null){
			if(target == current.data) break;
			parent = current;
			if(target < current.data)	current = current.left;
			else current = current.right;
		}
		
		if current == null throw new RuntimeException("Not Found");
		
		// Case 1: node to be deleted has no children i.e. it is a leaf node
		if (current.left == null && current.right == null)
		{
			// if node to be deleted is not a root node, then set its parent left/right child to null
			if (current != root) {
				if (parent.left == current) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			// if tree has only root node, delete it and set root to null
			else {
				root = null;
			}
		}

		// Case 2: node to be deleted has two children
		else if (current.left != null && current.right != null)
		{
			// find its in-order successor node
			Node successor  = minimum(current.right); ----> important

			// store successor value
			int val = successor.data;

			// recursively delete the successor. Note that the successor
			// will have at-most one child (right child)
			delete(root, successor.data); ----> important

			// Copy the value of successor to current node
			current.data = val;
		}	
		
		// Case 3: node to be deleted has only one child
		else
		{
			// find child node
			Node child = (current.left != null)? current.left: current.right;

			// if node to be deleted is not a root node, then set its parent
			// to its child
			if (current != root)
			{
				if (current == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			}
			// if node to be deleted is root node, then set the root to child
			else {
				root = child;
			}
		}
	}

	
** find predecessor
// Helper function to find maximum value node in given BST
public static Node findMaximum(Node root) {
	while (root.right != null) {
		root = root.right;
	}

	return root;
}

// Recursive function to find in-order predecessor for given key in a BST
public static Node findPredecessor(Node root, Node prec, int key)
{
	// base case
	if (root == null) {
		return prec;
	}

	// if node with key's value is found, the predecessor is maximum
	// value node in its left subtree (if any)
	else if (root.data == key) {
		if (root.left != null) {
			return findMaximum(root.left);
		}
		return prec;
	}

	// if given key is less than the root node, recur for left subtree
	else if (key < root.data) {
		return findPredecessor(root.left, prec, key);
	}

	// if given key is more than the root node, recur for right subtree
	else {
		// update predecessor to current node before recursing 
		// in right subtree
		prec = root;
		return findPredecessor(root.right, prec, key);
	}
}

** find successor

** find triplet with given sum
- find triple with sorted array 

19.

20.

** convert bst to linked list
Time Complexity O(n) and space Complexity O(h)
- reverse inorder traversal
public static Node convertBSTtoDLL(Node root, Node head) {
	if (root == null) { return head; }
	head = convertBSTtoDLL(root.right, head);
	// push current node at the front of the doubly linked list
	head = push(root, head);
	head = convertBSTtoDLL(root.left, head);

	return head;
}

public static Node push(Node root, Node head) {
	// insert the given node at the front of the DDL
	root.right = head;

	// update the left pointer of the existing head node of the DDL
	// to point to the BST node
	if (head != null) {
		head.left = root;
	}

	// update the head pointer of DDL
	head = root;
	return head;
}

** lowest common ancestor in BST
- recursive
Node lca(Node node, int n1, int n2)  
{ 
	if (node == null) 
		return null; 

	// If both n1 and n2 are smaller than root, then LCA lies in left 
	if (n1 < node.data && n2 < node.data) 
		return lca(node.left, n1, n2); 

	// If both n1 and n2 are greater than root, then LCA lies in right 
	if (n1 > node.data && n2 > node.data)  
		return lca(node.right, n1, n2); 

	return node; 
} 

- iteratively
static node lca(node root, int n1, int n2)  
{  
    while (root != null)  
    {  
        // If both n1 and n2 are smaller  
        // than root, then LCA lies in left  
        if (root.data > n1 &&  
            root.data > n2)  
        root = root.left;  
  
        // If both n1 and n2 are greater  
        // than root, then LCA lies in right  
        else if (root.data < n1 &&  
                 root.data < n2)  
        root = root.right;  
  
        else break;  ----> important
    }  
    return root;  
}

** find closest in binary search tree
private static int findClosestValue(TreeNode node, int target) {
    TreeNode currentNode = node;
    int closestValue = currentNode.val;
    double minDiff = Double.MAX_VALUE;

    while(currentNode != null) {
	
	  if(target == currentNode.value){
		return target;
	  }	
	  
      double currentDiff = Math.abs(target - currentNode.val);
      if(currentDiff < minDiff) {
        minDiff = currentDiff;
        closestValue = currentNode.val;
      }
      if(target < currentNode.val) {
        currentNode = currentNode.left;
      } else if (target > currentNode.val) {
        currentNode = currentNode.right;
      }
    }
    return closestValue;
  }
  
** BST Iterator
public class BSTIterator {
	Stack<TreeNode> stack;
 
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public int next() {
		TreeNode node = stack.pop();
		int result = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
}