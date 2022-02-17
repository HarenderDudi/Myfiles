# Linked List
- does not waste memory space buttakes extra space for memory pointers 

class DoubleLinkedList<E> {
 
	private Node<E> head;
	
	private static Node<E> { // can not accessed non-static data member or methods
		E data;
		Node<E> prev; 
		Node<E> next;

		Node(E data){ this.data = data; }
	}
	
	public void add(E data){ }
	public void addFirst(E data) {}
	public void add(E data, int position) {}
	public int size();
	public print();
	public remove();
	public removeLast();
	public remove(int position);
}

parameter		linked list		array				dynamic array
indexing		O(n)			O(1)				O(1)
insertion/		O(1)			O(n), if not full	O(n)
deletion at 
beginning
insertion at	O(n)			O(1), if not full	O(1), if not full 
ending												O(n), if full
deletion at		O(n)			O(1)				O(1) 
ending
insertion in	O(n)			O(n)				O(n)
middle 
deletion in		O(n)			O(n)				O(n)
middle
wasted space	O(n)			0					O(n)
			(for pointers)
			
SingleLinkedList
- current.next == null to have last node reference

CircularLinkedList
- current.next == head

Programs: 
1.  Implement Linked List
2.  Implement Stack
3.  Delete Linked List
4.  Clone the Linked List
5.  Insert in sorted linked list
6.  Seacrh an Element (Recursive and Iterative)
7.  Count ocurrences of an element
8.  Find Length of Linked list (Recursive and Iterative)
9.  Find Middle
10. Detect loop
11. Detect loop size
12. Find kth element from end
13. Remove kth element from end
14. remove duplicates from sorted linked list
15. remove duplicates from unsorted linked list 
16. swap two nodes
17. pairwise swap
18. split aletrnale into two linked list
19. rearrage the the linked list with all even in the end in reverse   
20. print linked list in reverse order
21. reverse linked list
22. check if list is palindrome
23. merge two sorted linked list 
24.
25. sort list with 0's,1's,2'
26. check the length is eve or odd
27. merge sort
28. If we want to concatenate two linked lists, which of the following gives O(1) complexity? ----> Circular Linked List
29. If the head of a linked list is pointing to kth element, then how will you get the elements before kth element? ----> XOR Linked Lists
30. move last node to front
31. Reverse every group of k nodes

Solutions:
** Implement Linked List
class SingleLinkedList<E> {
 
	private Node<E> head;
	
	private static Node<E> { // can not accessed non-static data member or methods
		E data;
		Node<E> next;

		Node(E data){ this.data = data; }
	}
	
	public void addLast(E data){ }
	public void push(E data) {}
	public void add(E data, int position) {}
	public int size();
	public print();
	public pop();
	public removeFirst();
	public remove(int position);
}
Clone Linked List

** Implement Stack
void push(T data){
	if(head == null) {
		head = new Node<>(data);
		return; 
	} 
	Node<T> current = head;
	head = new Node<>(data);
	head.next=current;
}

Node<T> pop(){
	if(head==null) return head;
	Node<T> current = head;
	head = head.next;
	return current;
}

** Delete Linked List
head = null;

** Clone the linked list
Node<T> clone(){
	if(head == null) return null;
	
	Node<T> clonedHead = new Node<>(head.data);
	Node<T> current = head;
	Node<T> clonedCurrent = clonedHead;
	while(current.next != null){
		 clonedCurrent.next = Node<>(current.next.data);
		 clonedCurrent = clonedCurrent.next;
		 current = current.next;
	}
	
	return clonedHead;
}

** insert in sorted linked list
``` void insert(T data){
	if(head == null) {
		head = new Node<>(data);
		return; 
	}
	Node<T> tail = head;
	Node<T> current = head.next;
	while(current != null && current.data < data) {
		tail = current;
		current = current.next;
	}	

	tail.next = new Node<>(data);
	tail.next.next = current;
	
} ```

``` void insert(T data){
	if(head == null) {
		head = new Node<>(data);
		return; 
	}

	Node<T> current = head;
	while(current.next != null && current.next.data < data) {
		current = current.next;
	}	

	Node next = current.next;
	current.next = new Node<>(data);
	current.next.next = next;	
} ```

** search for an element

** count occurence of an element

** find length of the linked list

** find middle
Node<T> middle(){
	if(head == null) return head;
	Node<T> slow_ptr = head;
	Node<T> fast_ptr = head;
	while(fast_ptr != null && fast_ptr.next!=null) {
		fast_ptr = fast_ptr.next.next;
		slow_ptr = slow_ptr.next;
	}
	return slow_ptr;
}

** detect loop 
 - Node isLoop(){
```	if(head == null) return head;
	Node<T> slow_ptr = head;
	Node<T> fast_ptr = head;
	while(slow_ptr != null && fast_ptr != null && fast_ptr.next!=null) {
		fast_ptr = fast_ptr.next.next;
		slow_ptr = slow_ptr.next;
		if(slow_ptr == fast_ptr) return true;
	}
	if(slow_ptr==null || fast_ptr==null)	return null;
	slow_ptr = head;
	while(slow_ptr!=fast_ptr){
		slow_ptr = slow_ptr.next;
		fast_ptr = fast_ptr.next;
	}
	return slow_ptr;
 } ```
- use hash

** loop size 
``` int loopSize(Node<T> fast_ptr, Node<T> slow_ptr){
	slow_ptr = slow_ptr.next;
	while(fast_ptr != slow_ptr){
		slow_ptr = slow_ptr.next;
		size++;
	}
	return size;
} ```

** find kth element from the end
```	Node<T> find(Node<T> node, int k){
		if(node == null) return null;
		Node<T> slow_ptr = head;
		Node<T> fast_ptr = head;
		int count = 0;
		while(fast_ptr!=null && count<k){
			fast_ptr = fast_ptr.next;
			count++;
		}
		
		while(fast_ptr != null){
			slow_ptr=slow_ptr.next;
			fast_ptr = fast_ptr.next;
		}
		return slow_ptr;
	}
```

** remove kth node from end
```	void remove(Node<T> node, int k){
		if(node == null) return null;
		Node<T> slow_ptr = head;
		Node<T> fast_ptr = head;
		int count = 0;
		while(count<k){ 						//0,1
			if(fast_ptr == null) return null;	
			fast_ptr = fast_ptr.next;			//2,3
			count++;							//2,3	
		} //2

		if(fast_ptr == null){
			head = head.next;
		}
		
		while(fast_ptr.next != null){ 			//4,null
			slow_ptr=slow_ptr.next;				//2,
			fast_ptr = fast_ptr.next; 			//4,
		}
		
		slow_ptr.next = slow_ptr.next.next;
	}
```

** remove duplicates from sorted linked list
``` void removeDuplicates(){
	if(head == null) return;
	Node<T> current = head;
	while(current.next!=null){
		if(current.data = current.next.data)	current.next = current.next.next // dont advance	
		else current = current.next;
	}
} ```

** remove duplicates from unsorted linked list
- sort the linked list
- hash

16. swap two nodes
- find and swap data
-
```	void swap(int x, int y){
		if(x==y) return;
		Node prevX=null, prevY=null;
		Node nodeX=null, nodeY=null;
		Node current = head;
		Node prev = null;
		while(curret!=null){
			if(current.data==x) prevX = prev; nodeX = current;
			else if(current.data == y) prevY = prev; nodeY = current;
			if(nodeX!=null &&nodeY!=null) break;
			prev = current;
			current= current.next;			
		}
		
		if(nodeX== null || nodeY == null) return;
		
		if(prevX==null)	head=nodeY;
		else prevX.next=nodeY;

		if(prevY==null)	head=nodeX;
		else prevY.next=nodeX;

		//swapping
		Node temp = NodeX.next;
		NodeX.next= NodeY.next;
		NodeY.next= temp;
	}
```

** pairwise swap (1-2-3-4-5) ----> (2-1-4-3-5)
```	void swap(Node node){
		Node current = node;
		while(node!=null && node.next!=null){
			int temp = node.data; 
            node.data = node.next.data; 
            node.next.data = temp; 
            
			current = current.next.next; 
		}
	}
```

** split alternate into two linked list
``` void split(Node node){
		if(node == null) return;
		Node a = node;
		Node b = node.next
		if(a == null || b == null) return;
		Node current = b.next;
		while(current != null && current.next!=null){
			a.next = current;
			b.next = current.next;
			current = current.next.next;
			a = a.next;
			b = b.next;
		}
		if(current != null) {
			a.next = current;
		}
	}
```

** rearrage the the linked list with all even in the end in reverse   
``` void split(Node node){
		if(node == null) return;
		Node a = node;
		Node b = node.next
		Node head_a = a;
		if(a == null || b == null) return;
		Node current = b.next;
		while(current != null && current.next!=null){
			a.next = current;
			a = a.next;
			
			Node temp = b;
			b = curret.next;
			b.next = temp; 	
			
			current = current.next.next;
		}
		if(current != null) {
			a.next = current;
			a = a.next;
		}
		
		a.next = b;
	}	
```

** print list in reverse
```	void print(Node node){
		if(node == null) return;
		print(node);
		System.out.println(node.data);
	}
```

** reverse linked list
```	Node reverse(Node head){
		if(head == null) return;
		Node current = head;
		Node prev = null;
		while(current!=null){
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
```

** palindrome
- use stack and then traverse again and compare
- reverse second half, compare and reconstruct
```	boolean isPalindrome() {
		if(head == null) return false;
		Node<T> slow_ptr = head;
		Node<T> fast_ptr = head;
		Node<T> prev_slow_ptr = null;
		while(fast_ptr!=null && fast_ptr.next != null && fast_ptr.next.next!=null) { 	
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
			prev_slow_ptr = slow_ptr;
		}
		
		Node midNode = null;
		if(fast_ptr==null){
			midNode = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		
		prev_slow_ptr.next = null; 	//terminate first list;
		Node headB = slow_ptr; 		// second list
		reverse(headB);
		compare(head,headB);
		reverse(headB);
		if(midNode == null){
			prev_slow_ptr.next = headB;
		} else {
			prev_slow_ptr.next = midNode;
			midNode.next = headB;
		}
	}
```

** sort list with 0's,1's,2' 
- Iterate through the linked list.
- Maintain 3 pointers named zero, one and two to point to current ending nodes of linked lists containing 0, 1, and 2 respectively. 
- For every traversed node, we attach it to the end of its corresponding list. Finally we link all three lists

**. check the length is even or odd
- calculate length
- use 2 pointer
``` while(current !=null && current.next!=null){
		current = current.next.next;
	}
	if(current == null) retrun "even";
	retrun "odd";
```

** merge two nodes
``` merge(Node headOne, Node headTwo){
		if(headOne == null) return headTwo;
		if(headTwo == null) return headOne;
		LinkedList current1 = headOne;
		LinkedList current2 = headTwo;
		LinkedList head = null;

		if(current1.value < current2.value){
			head = current1;
			current1 = current1.next;
		} else {
			head = current2;
			current2 = current2.next;
		}
		LinkedList current = head;
		while(current1!=null && current2!=null){
			if(current1.value < current2.value){
				current.next = current1;
				current1 = current1.next;
			} else {
				current.next = current2;
				current2 = current2.next;
			}
			current = current.next;
		}
		
		if(current1!=null) current.next = current1;
		if(current2!=null) current.next = current2;
		return head; 
	}
```

** move last element to front
``` void moveToFront() { 
	   if(head == null || head.next == null) return; 
        Node prev = null; 
        Node current = head;   
        while (current.next != null) { 
           prev = current; 
           current = current.next;  
        } 
        prev.next = null; 
		last.next = head; 
		head = last; 
    }  
```

** reverse group of k nodes
``` Node reverse(Node node, int k) { 
       Node current = node; 
       Node next = null; 
       Node prev = null; 
       int count = 0; 
       while (count < k && current != null)  //Reverse first k nodes
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
  
       if (next != null)  
          node.next = reverse(next, k); 
  
       // prev is now head of input list 
       return prev; 
    }  
```	


** intersection of Linked List 
- use hash
-
public static Node getIntersection(LinkedListIntersection list1, LinkedListIntersection list2) {	
	// Get length of list 1
	int length1 = 0;
	Node tmp1 = list1.getHead();
	while(tmp1.getNext() != null) {
		length1++;
		tmp1 = tmp1.getNext();		
	}
	
	// Get length of list 2
	int length2 = 0;
	Node tmp2 = list2.getHead();
	while(tmp2.getNext() != null) {
		length2++;
		tmp2 = tmp2.getNext();		
	}
	
	if(tmp1 != tmp2) {
		return null;
	}

	int diff = 0;
	if(length1 > length2) {
		tmp1 = list1.getHead();
		tmp2 = list2.getHead();
		diff = length1 - length2;
	} else {
		tmp1 = list2.getHead();
		tmp2 = list1.getHead();
		diff = length2 - length1;
	}
	while(diff > 0) {
		tmp1 = tmp1.getNext();
		diff--;
	}
	while(tmp1 != tmp2) {
		tmp1 = tmp1.getNext();
		tmp2 = tmp2.getNext();
	}
	return tmp1;
}

** delete the middle node
- find middle using two pointer
- then 
middle.data = middle.next.data
middle.next = midde.next.next

** rotate 10-20-30-40-50-60 k =3 ans 50-60-10-20-30-40
void rotate(int k)  { 
	if (k == 0) return; 
	Node current  = head; 
	int count = 0; 
	while (count < k && current !=  null) { 
		current = current.next; 
		count++; 
	} 

	if (current == null) 
		return; 

	// current points to kth node. Store it in a variable. 
	// kthNode points to node 40 in the above example 
	Node kthNode = current; 

	// current will point to last node after this loop 
	// current will point to node 60 in the above example 
	while (current.next != null) 
		current = current.next; 

	// Change next of last node to previous head 
	// Next of 60 is now changed to node 10 

	current.next = head; 

	// Change head to (k+1)th node 
	// head is now changed to node 50 
	head = kthNode.next; 

	// change next of kth node to null 
	kthNode.next = null;   
} 

** add linked list using stack
public ListNode addLists(ListNode node1, ListNode node2) {
	if (node1 == null) return node2;
	if (node2 == null) return node1;
	 
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	Stack<Integer> s3 = new Stack<Integer>();
	 
	ListNode temp = node1;
	while (temp != null) {
		s1.push(temp.value);
		temp = temp.next;
	}
	 
	temp = node2;
	while (temp != null) {
		s2.push(temp.value);
		temp = temp.next;
	}

	int sum = 0, carry = 0, value1, value2;
	while ((!s1.empty()) && (!s2.empty())) {
		value1 = s1.pop();
		value2 = s2.pop();
		sum   = (value1 + value2 + carry) % 10;
		carry = (value1 + value2 + carry) / 10;
		s3.push(sum);
	}
	 
	while (!s1.isEmpty()) {
		value1 = s1.pop(); 
		sum   = (value1 + carry) % 10;
		carry = (value1 + carry) / 10;
		s3.push(sum);
	}
	 
	while (!s2.isEmpty()) {
		value2 = s2.pop();
		sum   = (value2 + carry) % 10;
		carry = (value2 + carry) / 10;		 
		s3.push(sum);
	}
	 
	if (carry > 0) {
		s3.push(carry);
	}
	 
	return createLinkedList(s3);
}

** reoder linked list
Input:  1 -> 2 -> 3 -> 4
Output: 1 -> 4 -> 2 -> 3
Simple Solution: 
1) Initialize current node as head.
2) While next of current node is not null, do following
    a) Find the last node, remove it from the end and insert it as next
       of the current node.
    b) Move current to next to next of current
	
Efficient Soution
1) Find the middle point using tortoise and hare method.
2) Split the linked list into two halves using found middle point in step 1.
3) Reverse the second half.
4) Do alternate merge of first and second halves. 
void rearrange(Node node) { 
	Node slow = node, fast = slow.next; 
	while (fast != null && fast.next != null) { 
		slow = slow.next; 
		fast = fast.next.next; 
	} 

	Node node1 = node; 
	Node node2 = slow.next; 
	slow.next = null; 

	node2 = reverselist(node2); 

	// 4) Merge alternate nodes 
	node = new Node(0); // Assign dummy Node 
	Node curr = node; 
	while (node1 != null || node2 != null) {  
		if (node1 != null) { 
			curr.next = node1; 
			curr = curr.next; 
			node1 = node1.next; 
		} 
		if (node2 != null) { 
			curr.next = node2; 
			curr = curr.next; 
			node2 = node2.next; 
		} 
	} 
	node = node.next; 
} 

** Phone Directory
public class PhoneDirectory {
    private HashSet<Integer> used;
    private Queue<Integer> available;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<Integer>();
        used = new HashSet<Integer>();
        for (int i = 0; i < maxNumbers; i ++) {
            available.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.isEmpty()) {
            return -1;
        }
        int next = available.poll();
        used.add(next);
        return next;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
           used.remove((Integer) number);
            available.add(number); 
        }
    }
}


** merge k sorted lists to one sorted list
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Math.max(1,lists.length), 
                                                                (e1,e2) -> e1.val - e2.val);
        for (int i = 0; i < lists.length; i ++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode current = fakeHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }
            current.next = node;
            current = current.next;
        }
        return fakeHead.next;
    }
}

https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/1_leetcode_java_two_sum__medium.html

public class BlockingQueue {

  private List queue = new LinkedList();
  private int  limit = 10;

  public BlockingQueue(int limit){
    this.limit = limit;
  }


  public synchronized void enqueue(Object item)
  throws InterruptedException  {
    while(this.queue.size() == this.limit) {
      wait();
    }
    this.queue.add(item);
    if(this.queue.size() == 1) {
      notifyAll();
    }
  }


  public synchronized Object dequeue()
  throws InterruptedException{
    while(this.queue.size() == 0){
      wait();
    }
    if(this.queue.size() == this.limit){
      notifyAll();
    }

    return this.queue.remove(0);
  }
}

####################### Stack #########################
** Implementation of stack using array
class Stack { 
    private static final int MAX = 1000; 
    int top; 
    int a[] = new int[MAX]; // Maximum size of Stack 
  
    boolean isEmpty() {	return (top < 0); } 

    Stack() { top = -1; } 
  
    boolean push(int x) { 
        if (top >= (MAX - 1)) { 
            System.out.println("Stack Overflow"); 
            return false; 
        } else { 
            a[++top] = x; 
            System.out.println(x + " pushed into stack"); 
            return true; 
        } 
    } 
  
    int pop() { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } else { 
            int x = a[top--]; 
            return x; 
        } 
    } 
  
    int peek() { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } else { 
            int x = a[top]; 
            return x; 
        } 
    } 
} 

** two stack using an array
class TwoStacks 
{ 
    int size; 
    int top1, top2; 
    int arr[]; 
  
    TwoStacks(int n) { 
        arr = new int[n]; 
        size = n; 
        top1 = -1; 
        top2 = size; 
    } 
  
    void push1(int x) { 
        if (top1 < top2 - 1) { 
            top1++; 
            arr[top1] = x; 
        } else System.out.println("Stack Overflow"); 
    } 
  
    void push2(int x) { 
        if (top1 < top2 -1) { 
            top2--; 
            arr[top2] = x; 
        } else System.out.println("Stack Overflow"); 
    } 
  
    int pop1() { 
        if (top1 >= 0) { 
            int x = arr[top1]; 
            top1--; 
            return x; 
        } else return null; 
    } 
  
    int pop2() { 
        if(top2 < size) { 
            int x =arr[top2]; 
            top2++; 
            return x; 
        } else return null; 
    } 
}

** Implementation of Stack using Linked List
public class Stack<T> { 
  
    Node<T> root; 
  
    static class StackNode { 
        T data; 
        StackNode next; 
  
        StackNode(T data) { this.data = data; } 
    } 
  
    public boolean isEmpty() { 
        if (root == null) return true; 
        else return false; 
    } 
  
    public void push(T data) { 
        Stack<T> newNode = new Stack<>(data); 
		if (root == null) root = newNode;  
        else { 
            Stack<> temp = root; 
            root = newNode; 
            newNode.next = temp; 
        } 
    } 
  
    public T pop()     { 
        if (root == null) return null;
        else { 
            popped = root.data; 
            root = root.next; 
        } 
        return popped; 
    } 
  
    public T peek() 
    { 
        if (root == null) return null; 
        else { 
            return root.data; 
        } 
    } 
  
} 

** min max stack
instead of adding all the time check for leat element in mix max if they are same
import java.util.*;

class Program {
  static class MinMaxStack {
    List<Integer> stack = new ArrayList<>();
    List<Integer> min_stack = new ArrayList<>();
	List<Integer> max_stack = new ArrayList<>();

    // O(1) time | O(1) space
    public int peek() {
		return stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
		min_stack.remove(min_stack.size() - 1);
		max_stack.remove(max_stack.size() - 1);
		return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public void push(int number) {
		if(!stack.isEmpty()){
			min_stack.add(Math.min(min_stack.get(min_stack.size() -1), number));
		    max_stack.add(Math.max(max_stack.get(max_stack.size() -1), number));			
		} else {
			min_stack.add(number);				
			max_stack.add(number);				
		}
	    stack.add(number);
    }

    // O(1) time | O(1) space
    public int getMin() {
      return min_stack.get(min_stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int getMax() {
      return max_stack.get(max_stack.size() -1);
    }
  }
}


** check if expression is balanced or not
public static boolean isBalanced(String exp) {
	Stack<Character> stack = new Stack();
	for (int i = 0; i < exp.length(); i++) 	{
		if (exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[' ) {
			stack.push(exp.charAt(i));
		}

		if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']')
		{
			if (stack.empty()) return false; 
			Character top = stack.pop();
			if ((top == '(' && exp.charAt(i) != ')') ||
				(top == '{' && exp.charAt(i) != '}') ||
				(top == '[' && exp.charAt(i) != ']')) {
				return false;
			}
		}
	}
	return stack.empty();
}

** postfix to infix ----> abc++ ----> (a + (b + c))

void convert(String exp){
	Stack<Character> Stack = new Stack<>(); 
	for (char ch : s.toCharArray()) { 
		if(isOperator(ch)){
			x = stack.pop();
			y = stack.pop();
			stack.push("("x + ch + y")");
		} else stack.push(ch);
	}
	return stack.pop(); // stack contains single element
}

** prefix to infix ---->  *+AB-CD ----> ((A+B)*(C-D))
void convert(String exp){
	Stack<Character> Stack = new Stack<>(); 
	for (int i = length-1; i >= 0; i++) 	{
		ch = exp.charAt(i);
		if(isOperator(ch)){
			x = stack.pop();
			y = stack.pop();
			stack.push(x + "ch" + y);
		} else stack.push(ch);
	}
	return stack.pop(); // stack contains single element
}



or
public class Stack<T> { 
  
    Node<T> root; 
  
    static class StackNode { 
        T data; 
		T min;
		T max;
        StackNode next; 
  
        StackNode(T data) { this.data = data; } 
    } 
}

** next greater element 
public static void printNextGreaterElement(int[] input) {
	Stack<Integer> stack = new Stack<Integer>();
	int inputSize = input.length;
	stack.push(input[0]);
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 1; i < inputSize; i++) {
		while (!stack.isEmpty() && input[i] > stack.peek()) {   ----> use greater than for next smaller
			map.put(stack.pop(), input[i]);
//			System.out.println("Next greater element for " + stack.pop() + "\t = " + input[i]);
		}
		stack.push(input[i]);
	}
	while (!stack.isEmpty()) {
		map.put(stack.pop(), -1);
//		int top = (int) stack.pop();
//		System.out.println("Next greater element for " + top + "\t = " + null);
	}
	
	for (i=0; i< input.length; i++){
		  System.out.println(arr[i] + " ---> " + map.get(input[i])); 
	}
}

** if duplicate exist in above problem use Map<Integer, Queue>

** stock span problem
static void calculateSpan(int price[], int n, int span[]) { 
	Stack<Integer> st = new Stack<>(); 
	st.push(0); 

	// Span value of first element is always 1 
	span[0] = 1; 

	// Calculate span values for rest of the elements 
	for (int i = 1; i < n; i++) { 
		while (!st.empty() && price[i] >=price[st.peek()] )  
			st.pop(); 

		span[i] = (st.empty()) ? (i + 1) : (i - st.peek()); 
		st.push(i); ----> putting the index
	} 
} 

** maximum rectangular area in a histogram
class Solution {
    public int largestRectangleArea(int[] heights) {        
        int n = heights.length;
        if(n == 0) {
            return 0;
        }
        int max = 0;
        int[] left = new int[n]; // how many on left are greater than current
        int[] right = new int[n]; // how many on right are greater than current
        
        left[0] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++) {

            while(!stack.isEmpty() && heights[i] <=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = i;
            }else {
                left[i] = i - stack.peek() - 1;
            }
            stack.push(i); 
            
        }
        
        right[n-1] = 0;
        stack.clear();
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = n - 1 - i;
            }else {
                right[i] = stack.peek() - i - 1;
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++) {
            int area = (left[i] + right[i] + 1) * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }
}

** remove k digits so that the new number is the smallest possible
public String removeKdigits(String num, int k) {
	
	if(k==num.length())        
		return "0";
	
	Stack<Character> stack = new Stack<>();
	for(int i=0; i<num.length(); i++) {
		while(k>0 &&!stack.isEmpty() && num.charAt(i) < stack.peek()) {
			stack.pop();
			k--;
		}
		
		stack.push(num.charAt(i));
	}
	
	// corner case like "1234"
	while(k>0){
		stack.pop();
		k--;            
	}
	
	//construct the number from the stack
	StringBuilder sb = new StringBuilder();
	while(!stack.isEmpty())
		sb.append(stack.pop());
	sb.reverse();
	
	//"1000200"
	// 000200
	while(sb.length()>1 && sb.charAt(0)=='0')
		sb.deleteCharAt(0);
	return sb.toString();
}
