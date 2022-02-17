1.implement queue 
class Queue
{
	private static Node rear = null, front = null;

	// Utility function to remove front element from the queue
	public static int dequeue() 	// delete at the beginning
	{
		if (front == null) {
			System.out.print("\nQueue Underflow");
			System.exit(1);
		}

		Node temp = front;
		System.out.printf("Removing %d\n", temp.data);

		// advance front to the next node
		front = front.next;

		// if list becomes empty
		if (front == null) {
			rear = null;
		}

		// deallocate the memory of removed node and
		// optionally return the removed item
		int item = temp.data;
		return item;
	}

	// Utility function to add an item in the queue
	public static void enqueue(int item) 	// insertion at the end
	{
		// Allocate the new node in the heap
		Node node = new Node(item);
		System.out.printf("Inserting %d\n", item);

		// special case: queue was empty
		if (front == null) {
			// initialize both front and rear
			front = node;
			rear = node;
		} else {
			// update rear
			rear.next = node;
			rear = node;
		}
	}

	// Utility function to return top element in a queue
	public static int peek() {
		// check for empty queue
		if (front != null) {
			return front.data;
		} else {
			System.exit(1);
		}

		return -1;
	}

	// Utility function to check if the queue is empty or not
	public static boolean isEmpty() {
		return rear == null && front == null;
	}
}

2. implement using stack
static class Queue  
{  
    static Stack<Integer> s1 = new Stack<Integer>();  
    static Stack<Integer> s2 = new Stack<Integer>();  
  
    static void enQueue(int x)  
    {  
        // Move all elements from s1 to s2  
        while (!s1.isEmpty()) 
        {  
            s2.push(s1.pop());  
            //s1.pop();  
        }  
  
        // Push item into s1  
        s1.push(x);  
  
        // Push everything back to s1  
        while (!s2.isEmpty())  
        {  
            s1.push(s2.pop());  
            //s2.pop();  
        }  
    }  
  
    // Dequeue an item from the queue  
    static int deQueue()  
    {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);  
        }  
  
        // Return top of s1  
        int x = s1.peek();  
        s1.pop();  
        return x;  
    }  
};  