Programs
1. Implementation of stack using array
2. Implementation of stack using Linked List
3. check if expression is balanced or not
4. check duplicate parantehesis
5. postfix to infix || evaluate
6. prefix to infix  || evaluate
7. two stack using an array
8. min max stack 

Solutions


4. check duplicate parantehesis
static boolean findDuplicateparenthesis(String s) { 
	Stack<Character> Stack = new Stack<>(); 
	for (char ch : s.toCharArray()) { 
		if (ch != ')') Stack.push(ch); 
		else {
			if (stack.peek() == '(') return true; // reduntant bracket
			// pop till '(' is found for current ')'
			while (stack.peek() != '(') {
				stack.pop();
			}
			// pop '('
			stack.pop();
		}
	} 
	// No duplicates found  
	return false; 
} 
