** Minimum number of operations required to reach from 0 to N if only two opeartions 
From position X you can go to position X + 1 with a cost of P
Or, you can go to the position 2 * X with a cost of Q

static int minimumOperation(int N, int P, int Q)  { 
    int count = 0; 
    while (N > 0) { 
  
        if ((N & 1)>0) { // odd
            N--; 
        } else {   
            N /= 2; 
        } 
		count++;
    } 
  
    return count; 
} 

static int minCost(int N, int P, int Q) { 
    int cost = 0; 
  
    while (N > 0) { 
  
        if ((N & 1)>0) { if odd
            cost += P; 
            N--; 
        } 
        else { 
            int temp = N / 2; 
            if (temp * P > Q) 
                cost += Q; 
            else
                cost += P * temp; 
  
            N /= 2; 
        } 
    } 
    return cost; 
} 

Minimum cost path (Can also be solved with Dijkstra algorithm) 
class MinimumCostPath { 

    private static int minCost(int cost[][], int m, int n) { 
        int i, j; 
        int tc[][]=new int[m+1][n+1]; 
  
        tc[0][0] = cost[0][0]; 
  
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++) 
            tc[i][0] = tc[i-1][0] + cost[i][0]; 
  
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++) 
            tc[0][j] = tc[0][j-1] + cost[0][j]; 
  
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++) 
            for (j = 1; j <= n; j++) 
                tc[i][j] = min(tc[i-1][j-1],  
                               tc[i-1][j], 
                               tc[i][j-1]) + cost[i][j]; 
  
        return tc[m][n]; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
        int cost[][]= {{1, 2, 3}, 
                       {4, 8, 2}, 
                       {1, 5, 3}}; 
        System.out.println(minCost(cost,2,2)); 
    } 
} 

dungeon game
    public int calculateMinimumHP(int[][] dungeon) {
         int m = dungeon.length;
        int n = dungeon[0].length;
        
        
        int[][] dp = new int[m+1][n+1];
        for(int[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for(int i = m-1 ; i >= 0; i--){
            for(int j = n-1 ; j >= 0; j--){
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return dp[0][0];
    }
	
	
** Longest Common Subsequence
public static void main(String[] args) {
	String X = "ABCBDAB", Y = "BDCABA";
	int[][] T = new int[X.length() + 1][Y.length() + 1];
	Set<String> lcs = LCS(X, Y, T);
	System.out.print(lcs);
}

public static Set<String> LCS(String X, String Y, int[][] T){
	LCSLength(X, Y, T);
	List<String> lcs = LCS(X, Y, X.length(), Y.length(), T);
	return new HashSet<>(lcs);
}

public static int LCSLength(String X, String Y, int[][] T) {
	int max = 0;
	for (int i = 1; i <= X.length(); i++) {
		for (int j = 1; j <= Y.length(); j++) {
			if (X.charAt(i - 1) == Y.charAt(j - 1))
				T[i][j] = T[i - 1][j - 1] + 1;
			else
				T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
			
			if(T[i][j] > max)
				max = T[i][j];
		}
	}
	return max;
}

public static List<String> LCS(String X, String Y, int m, int n, int[][] T) {
	if (m == 0 || n == 0) {
		return Arrays.asList("");
	}

	if (X.charAt(m - 1) == Y.charAt(n - 1)) {
		List<String> lcs = LCS(X, Y, m - 1, n - 1, T);
		List<String> res = new ArrayList<>();
		for (String str : lcs) {
			res.add(str + X.charAt(m-1));
		}
		return res;
	}

	if (T[m - 1][n] > T[m][n - 1])
		return LCS(X, Y, m - 1, n, T);

	if (T[m][n - 1] > T[m - 1][n])
		return LCS(X, Y, m, n - 1, T);

	List<String> top = LCS(X, Y, m - 1, n, T);
	List<String> left = LCS(X, Y, m, n - 1, T);
	top.addAll(left);

	return top;
}

** Find Longest palindromic subsequence
solution- find longest common subsequence for given string and its reverse

** Fing Longest Repeating Subsequence
same logic can be use for longest repeating substring as well i!=j
solution- find longest common subsequence for given string with itself where i!=j

public static void LCSLength(String X, String Y, int m, int n, int[][] T) {
	// fill the lookup table in bottom-up manner
	int max = 0;
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (X.charAt(i - 1) == Y.charAt(j - 1) && i!=j) {
				T[i][j] = T[i - 1][j - 1] + 1;
			} else {
				T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
			}
			
			if(T([i][j] > max) 
				max = T[i][j];
		}
	}
	return max;
}

** shortest common supersequence
private static int[][] lookup;

public static void main(String[] args) {
	String X = "ABCBDAB", Y = "BDCABA";
	lookup = new int[X.length() + 1][Y.length() + 1];
	Set<String> scs = SCS(X, Y, lookup);
	System.out.println("All Shortest Common Supersequence of " + X + " and " + Y + " are:");
	// print all SCS present in the Set
	System.out.println(scs);
}

public static Set<String> SCS(String X, String Y, int[][] lookup) {
	int m = X.length(), n = Y.length();
	LCS(X, Y, m, n, lookup);
	List<String> list = SCS(X, Y, m, n, lookup);
	Set<String> scs = new HashSet<>(list);
	return scs;
}

public static void LCS(String X, String Y, int m, int n) {
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				lookup[i][j] = lookup[i - 1][j - 1] + 1;
			} else {
				lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
			}
		}
	}
}

public static List<String> SCS(String X, String Y, int m, int n) {
	// if we have reached the end of first string, create a list
	// containing second substring and return
	if (m == 0) {
		return Arrays.asList(Y.substring(0, n));
	}

	// if we have reached the end of second string, create a list
	// containing first substring and return
	else if (n == 0) {
		return Arrays.asList(X.substring(0, m));
	}

	if (X.charAt(m - 1) == Y.charAt(n - 1)) {
		List<String> scs = SCS(X, Y, m - 1, n - 1);
		List<String> res = new ArrayList<>();
		for (String str : scs) {
			res.add(str + X.charAt(m-1));
		}
		return res;
	}

	if (lookup[m - 1][n] > lookup[m][n - 1]) {
		List<String> scs = SCS(X, Y, m - 1, n);
		List<String> res = new ArrayList<>();
		for (String str : scs) {
			res.add(str + X.charAt(m-1));
		}
		return res;
	}

	if (lookup[m][n - 1] > lookup[m - 1][n]) {
		List<String> scs = SCS(X, Y, m, n - 1);
		List<String> res = new ArrayList<>();
		for (String str : scs) {
			res.add(str + Y.charAt(n-1));
		}
		return res;
	}

	// if top cell value is same as left cell, then go in both
	// top and left directions

	// append current character of string X to all SCS of
	// substring X[0..m-2], Y[0..n-1]
	List<String> top = SCS(X, Y, m - 1, n);

	List<String> res = new ArrayList<>();
	for (String str : top) {
		res.add(str + X.charAt(m-1));
	}

	// append current character of string Y to all SCS of
	// substring X[0..m-1], Y[0..n-2]
	List<String> left = SCS(X, Y, m, n - 1);
	for (String str : left) {
		res.add(str + Y.charAt(n-1));
	}

	return res;
}

** Longest Common Substring s1 = "CLCL" s2="LCLC"
public static void main(String[] args) {
	String X = "ABAB";
	String Y = "BABA";

	int m = X.length(); 
	int n = Y.length();

	int match[][] = new int[m+1][n+1];
	 
	int max = Integer.MIN_VALUE; //Maximum length of the string
	ArrayList<String> result = null; //Result list
	 
	for(int i=1; i<=m; i++) {
		for(int j=1; j<=n; j++) {
			if(X.charAt(i-1) ==  Y.charAt(j-1)) {
				 
				match[i][j] = match[i-1][j-1] + 1;
				 
				if(match[i][j] > max) {
					max =  match[i][j];
					result = new ArrayList<String>();
					result.add(X.substring(i-max, i)); 
				} else if(match[i][j] == max){
					result.add(X.substring(i-max, i));
				}
			}

		}
	}
	
	result.forEach(System.out::println);
}	

** edit distance
	public static void main(String[] args) {
		String X = "kitten";
		String Y = "sitting";

		int m = X.length(); 
		int n = Y.length();

		int lookup[][] = new int[m+1][n+1];
		 
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0)
					lookup[i][j] = j;
				else if(j==0)
					lookup[i][j] = i;
				
				else if(X.charAt(i-1) ==  Y.charAt(j-1)) 
					lookup[i][j] = lookup[i-1][j-1];

				else {
					lookup[i][j] = Math.min(lookup[i][j-1] + 1, lookup[i-1][j] +1);
					lookup[i][j] = Math.min(lookup[i-1][j-1] + 1, lookup[i][j]);
				}
			}
		}
		
		System.out.println(lookup[m][n]);
	}

** maximum square sub matrix 
public int maximalSquare(char[][] A) {
	if(A.length == 0)
		return 0;
	int max =0;
	int[][] T = new int[A.length+1][A[0].length+1];
	for(int i=1; i<=A.length; i++){
		for(int j=1; j<=A[0].length; j++) {                
			if(A[i-1][j-1] == '1') { ----> imp
				T[i][j] = 1 + Math.min(T[i-1][j-1], Math.min(T[i-1][j], T[i][j-1]));
			}
			if(max < T[i][j])
				max = T[i][j];
		}
	}
	return max*max;
}

** count square sub matrices with all ones
public int maximalSquare(char[][] A) {
	if(A.length == 0)
		return 0;
	int result =0;
	int[][] T = new int[A.length+1][A[0].length+1];
	for(int i=1; i<=A.length; i++){
		for(int j=1; j<=A[0].length; j++) {                
			if(A[i-1][j-1] == '1') { ----> imp
				T[i][j] = 1 + Math.min(T[i-1][j-1], Math.min(T[i-1][j], T[i][j-1]));
			}
			result += T[i][j];
		}
	}
	return result;
}

** 01 knapsack profit
public static void main(String[] args) {
	int v[] = { 20, 5, 10, 40, 15, 25 };
	int w[] = { 1, 2, 3, 8, 7, 4 };
	// knapsack capacity
	int W = 10;
	int[][] lookup = new int[v.length+1][W+1];
	for(int i=1; i<=w.length; i++) {
		for(int j=1; j<=W; j++) {				
			if(j >= w[i-1])
			lookup[i][j] =
					Math.max(v[i-1] + lookup[i-1][j-w[i-1 ]], lookup[i-1][j]);
			else {
				lookup[i][j] = lookup[i-1][j];
			}
		}
	}
	
	System.out.println(lookup[v.length][W]);
}

** Minimum nuber of coins required coins = {1,5,6,9} sum =11
public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] numOfCoins = new int[n + 1];
    Arrays.fill(numOfCoins, Integer.MAX_VALUE);
    numOfCoins[0] = 0;
    int toCompare = 0;
    for (int denom : denoms) {
      for (int amount = 1; amount <=n; amount++) {
        if (denom <= amount) {
          if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
            toCompare = numOfCoins[amount - denom];
          } else {
            toCompare = numOfCoins[amount - denom] + 1;
          }
          numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
        }
      }
    }
    return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
  }

** count ways to get the denomination of coins
public static int numberOfWaysToMakeChange(int n, int[] denoms) {
	int[] ways = new int[n + 1];
	ways[0] = 1;
	for (int denom : denoms) {
	  for (int amount = 1; amount <=n; amount++) {
		if (denom <= amount) {
		  ways[amount] += ways[amount - denom];
		}
	  }
	}
	return ways[n];
}

** count ways to climb the n stairs with at most m steps  
public int climbStairs(int n, int m) {
        int[] steps = new int[m];
        for(int i=0;i<m; i++)
                steps[i] = i+1;
        int[] ways = new int[1+n];
        ways[0] = 1;
        
        for(int stair = 1; stair <= n;stair++) {
            for(int step: steps) {
                if(step <= stair) {
                    ways[stair] += ways[stair-step];
                }
            }
        }
        return ways[n];
}

** longest increasing subsequence
public int lengthOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];
        Arrays.fill(lengths, 1);
        int max = 1;
        for(int i=1; i<nums.length; i++) {
            int current = nums[i];
            for(int j=0; j<i; j++) {
                int prev = nums[j];
                if(prev < current) {
                    lengths[i] = Math.max(prev + 1, current);                    
                    max = Math.max(max, lengths[i]);
                }
            }
        }
        return max;
}

** Maximum  Sum Increasing SubSequence
public static int maxSumIS(int[] nums) {
	 
	int[] sum = nums.clone();
	int max = sum[0];
	for(int i=1; i<nums.length; i++) {
		int current = nums[i];
		for(int j=0; j<i; j++) {
			int prev = nums[j];
			if(prev < current) {
				sum[i] = Math.max(prev + current, current);                    
				max = Math.max(max, sum[i]);
			}
		}
	}
	return max;
}

** minimum number of jump to reach ends 
input: {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} output: 3 (1-> 3 -> 8 ->9)
public static int minNumberOfJumps(int[] array) {
	if (arr.length <= 1) 
		return 0; 

	// Return -1 if not possible to jump 
	if (arr[0] == 0) 
		return -1; 

	int[] jumps = new int[array.length];
	Arrays.fill(jumps, Integer.MAX_VALUE);
	jumps[0] = 0;
	for(int i=1; i< array.length; i++) {
		int current = array[i];
		for(int j = 0; j < i; j++) {
			int prev = array[j];
			if(prev >= i - j) {
				jumps[i] = Math.min(prev + 1, current);
			}
		}
	}
return jumps[jumps.length - 1];
}

** unbounded knapsack
public static void main(String[] args) {
	 int W = 100;
	 int v[] = {10, 30, 20};
	 int w[] = {5, 10, 15};
		
		// dp[i] is going to store maximum value
		// with knapsack capacity i.
		int lookup[] = new int[W + 1];
		 
		// Fill dp[] using above recursive formula
		for(int i = 1; i <= W; i++){
			for(int j = 1; j < w.length; j++){
				if(i>=w[j]){
					lookup[i] = Math.max(lookup[i], lookup[i - w[j]] + 
								v[j]);
				}
			}
		}
	
	System.out.println(lookup[W]);
}	

** cutting rod
 static int cutRod(int price[],int n) { 
	int lookup[] = new int[n+1]; 

	for (int i = 1; i<=n; i++) 
	{ 
		for (int j = 1; j < i; j++) 
			lookup[i] = Math.max(lookup[i],  
							   price[j] + lookup[i-j-1]); 
	} 

	return lookup[n]; 
} 
		
12. Max Subset Sum with no adjacent 
input : {5, 5, 10, 100, 10, 5} output: 110 {5,100,5}
static int maxSubsetSum(int[] arr) {
	if(arr.length == 0) return 0;
	if(arr.length == 1) return arr[0];

	int prev_prev = arr[0];

	int prev = Integer.max(arr[0], arr[1]);

	// start from index 2
	for (int i = 2; i < arr.length; i++)
	{
		// curr stores the maximum sum till index i
		int curr = Integer.max(arr[i], Integer.max(prev, prev_prev + arr[i]));
		prev_prev = prev;
		prev = curr;
	}

	// return maximum sum
	return prev;
}

longest increasing subsequence (print)
public static List<Integer> longestIncreasingSubsequence(int[] array) {
	int[] sequences = new int[array.length];
	Arrays.fill(sequences, Integer.MIN_VALUE);
	int[] lengths = new int[array.length];
	Arrays.fill(lengths, 1);
	int maxLengthIdx = 0;
	for (int i = 0; i < array.length; i++) {
		int currentNum = array[i];
		for (int j = 0; j < i; j++) {
			int otherNum = array[j];
			if (otherNum < currentNum && lengths[j] + 1 >= lengths[i]) {
				lengths[i] = lengths[j] + 1;
				sequences[i] = j;
			}
		}
		if (lengths[i] >= lengths[maxLengthIdx]) {
			maxLengthIdx = i;
		}
	}
	return buildSequence(array, sequences, maxLengthIdx);
}

public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
	List<Integer> sequence = new ArrayList<Integer>();
	while (currentIdx != Integer.MIN_VALUE) {
		sequence.add(0, array[currentIdx]);
		currentIdx = sequences[currentIdx];
	}
	return sequence;
}

Maximum  Sum Increasing SubSequence
public static List<Integer> longestIncreasingSubsequence(int[] array) {
	int[] sequences = new int[array.length];
	Arrays.fill(sequences, Integer.MIN_VALUE);
	int[] sums = array.clone();
	int maxLengthIdx = 0;
	for (int i = 0; i < array.length; i++) {
		int currentNum = array[i];
		for (int j = 0; j < i; j++) {
			int otherNum = array[j];
			if (otherNum < currentNum && sums[j] + currentNum >= sums[i]) {
				sums[i] = sums[j] + currentNum;
				sequences[i] = j;
			}
		}
		if (sums[i] >= sums[maxLengthIdx]) {
			maxLengthIdx = i;
		}
	}
	System.out.println(maxLengthIdx);
	System.out.println(Arrays.toString(sequences)); 
	System.out.println(sums[maxLengthIdx]);
	return buildSequence(array, sequences, maxLengthIdx);
}

public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
	List<Integer> sequence = new ArrayList<Integer>();
	while (currentIdx != Integer.MIN_VALUE) {
		sequence.add(0, array[currentIdx]);
		currentIdx = sequences[currentIdx];
	}
	return sequence;
}

15. Box Statcking
public static List<Box> maxHeight(List<Box> boxes) {
	List<Box> rotations = createAllRotations(boxes);
	rotations.sort((box1, box2) -> box2.length * box2.width - box1.length * box1.width); // descending
//		boxes.stream().forEach(box-> System.out.println(box.height + ","+ box.length+ ","+ box.width));
	int[] heights = new int[rotations.size()];
	for (int i = 0; i < rotations.size(); i++) {
		heights[i] = rotations.get(i).height;
	}
	int[] sequences = new int[rotations.size()];
	for (int i = 0; i < rotations.size(); i++) {
		sequences[i] = Integer.MIN_VALUE;
	}
	int maxHeightIdx = 0;
	for (int i = 1; i < rotations.size(); i++) {
		Box currentBox = rotations.get(i);
		for (int j = 0; j < i; j++) {
			Box otherBox = rotations.get(j);
			if (areValidDimensions(otherBox, currentBox)) {
				if (heights[i] <= currentBox.height + heights[j]) {
					heights[i] = currentBox.height + heights[j];
					sequences[i] = j;
				}
			}
		}
		if (heights[i] >= heights[maxHeightIdx]) {
			maxHeightIdx = i;
		}
	}
	System.out.println(Arrays.toString(heights));
	return buildSequence(rotations, sequences, maxHeightIdx);
}

public static List<Box> buildSequence(List<Box> array, int[] sequences, int currentIdx) {
	List<Box> sequence = new ArrayList<>();
	while (currentIdx != Integer.MIN_VALUE) {
		sequence.add(0, array.get(currentIdx));
		currentIdx = sequences[currentIdx];
	}
	return sequence;
}

private static List<Box> createAllRotations(List<Box> boxes) {
	List<Box> rotations = new ArrayList<>();

	// do for each box
	for (Box box : boxes) {
		// push the original box: {L x W x H}
//			rotations.add(new Box(Math.max(box.length, box.width), Math.min(box.length, box.width), box.height));
		rotations.add(box);

		// push the first rotation: {max(L, H) x Math.min(L, H) x W}
		rotations.add(new Box(Math.max(box.length, box.height), Math.min(box.length, box.height), box.width));

		// push the second rotation: {max(W, H) x Math.min(W, H) x L}
		rotations.add(new Box(Math.max(box.width, box.height), Math.min(box.width, box.height), box.length));
	}

	return rotations;
}

public static boolean areValidDimensions(Box o, Box c) {
	return o.width > c.width && o.length > c.length;
}

static class Box {
	int width;
	int length;
	int height;

	public Box(int length, int width, int height) {
		super();
		this.width = width;
		this.length = length;
		this.height = height;
	}

}

public static void main(String[] args) {
	// input boxes
	List<Box> boxes = Arrays.asList(new Box(4, 2, 5), new Box(3, 1, 6), new Box(3, 2, 1), new Box(6, 3, 8));

	System.out.println("The maximum height is ");

	maxHeight(boxes).stream().forEach(box -> System.out.println(box.height + "," + box.length + "," + box.width));
}

16. cutting rod 
static int cutRod(int price[],int n) { 
	int val[] = new int[n+1]; 
	val[0] = 0; 

	for (int i = 1; i<=n; i++) 
	{ 
		int max_val = Integer.MIN_VALUE; 
		for (int j = 0; j < i; j++) 
			max_val = Math.max(max_val,  
							   price[j] + val[n-j-1]); 
		val[i] = max_val; 
	} 

	return val[n]; 
} 


