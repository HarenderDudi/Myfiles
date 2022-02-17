(Two Sum)Find the pair in array sums to given digit
Three number sum
array containing +ve and -ve in range from -MAX to +MAX
Relative Sorting
sort binary array
sort an array of 0's, 1's and 2's in linear time complexity
Binary Search
find minimum in sorted rotated array
find how many times array is rotated
square root of a number

HASHING
	not useful 
		sorted data or we want to store data in sorted manner
		find closest or floor/ceil of element
		
	useful	
		Dictionaries
		routers
		cache
		crypto

==================================================================================================
(Two Sum)Find the pair in array sums to given digit
input: [2,4,6,8,9,10] sum:15
output: (2,4)
==================================================================================================

- Time Complexity:- O(nlog(n)), Space Complexity : depends on sorting algo

public static int[] findPair(int[] A, int sum) {
	Arrays.sort(A);
	int low = 0, high = A.length - 1;
	while (low < high) {
		// sum found
		if (A[low] + A[high] == sum) return new int[] {A[low], A[high]}
		if (A[low] + A[high] < sum) low++;
		else high--;
	}
	null;x`
}


- Time Complexity:- O(n), Space Complexity : O(n)

public static int[] findPair(int[] A, int sum) {
	Map<Integer, Integer> map = new HashMap<>(); // use hashset if index is not required
	for (int i = 0; i < A.length; i++) {
		if (map.containsKey(sum - A[i])) return new int[]{i, map.get(sum - A[i])};
		map.put(A[i], i);
	}
	throw new RuntimeException("Not Found");
}

==================================================================================================
** Three number sum
input: { 4, 2, 3, 10, 6, 9, 1}
target sum = 16

Triplet are (4,  10, 2), ( 4,  9, 3), (6,  1, 9)

==================================================================================================
- Time Complexity:- O(n^2)
public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
	Arrays.sort(array);
	List<Integer[]> triplets = new ArrayList<>();
	for(int i=0; i<array.length-2; i++) {
		int left = i+1;
		int right = array.length-1;
		while(left<right) {
			if(array[left] + array[right] + array[i] == targetSum) {
				triplets.add(new Integer[]{array[i], array[left], array[right]});
				left++;
				right--;
			} else if(array[left] + array[right] + array[i] > targetSum){
				right--;
			} else {
				left++;
			}
		}
	}
	return triplets;
}


- use hash if not sort
- Time Complexity:- O(n^2)

	loop i = 0 to i <  size - 2
	create empty set
	loop from j = i+1 to  j < arr.length
	calculate diff of arr[i] + arr[j] and sum
	check if diff is present in set
	if present then sysout digits
	else add arr[j] in set

	
		for (int i = 0; i < arr_size - 2; i++) {
			
			// Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<Integer>();
			int curr_sum = sum - A[i];

			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(sum - A[i] - A[j])) {
					System.out.printf("Triplet is %d,  %d, %d", A[i], A[j], sum - A[i] - A[j]);
					//return true;
				}
				s.add(A[j]);
			}
		}
		

==================================================================================================
** four sum
==================================================================================================

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();	
        Arrays.sort(nums);     
		
        for (int i = 0; i <= nums.length - 4; i++) {
            if(i>0&&nums[i]==nums[i-1])  continue; // skipping duplicates
			
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue; // skipping duplicates

                int val = target - (nums[i] + nums[j]);
 
                int start = j + 1, end = nums.length - 1;
 
                while (start < end) {
                    if (nums[start] + nums[end] < val) 
                        start++;
                    else if (nums[start] + nums[end] > val)
                        end--;                    
                    else {
                        result.add(List.of(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end&&nums[start]==nums[start+1])start++; // skipping duplicates
                        while(start<end&&nums[end]==nums[end-1])end--; // skipping duplicates
                        start++;
                        end--;
                    }
                }
            }
        }
    
        return result;
    }



==================================================================================================
array containing +ve and -ve in range from -MAX to +MAX
find element in O(1)
==================================================================================================	
create a 2D matrix arr[MAX+1][2] // MAX+1 to include MAX also in array
traverse from i=0 to i < size
if arr[i] >= 0 insert 1 at that index in first row of matrix i.e arr[i][0] = 1
else take abs(arr[i]) and insert 1 at that index in 2nd row of matrixx i.e arr[i][1] = 1

while searching just look in hastable we created above
	
	
	
==================================================================================================
First non repeating element
	if element is not present in list add that element
	if present remove that element from list
	return list[0]
	
Find the missing number in integer array of 1 to 100
- expected sum(n*[n+1]/2)  - actual sum
- (xor of actuta) xor (xor of n number)

Find union and intersection of 2 array
- use hashing
- sort smaller array & then iterate over larger array, running binary search on smaller array

-HD: Union: create hashset and add number of both arr
	 intersect: create hashset and add numbers of A1 and iterate over A2 if number present in set sysout
==================================================================================================
Relative Sorting
Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
==================================================================================================
create a treeMap (nlogn)
create a result array
1)iterate over A1 and store count of every element in map
2)iterate over A2 and if present in map, put element in result array that many times and remove the element from hashmap 
3)Sort the rest of the numbers present in HashMap and put in the output array

Steps 1 and 2 on average take O(m+n)
third step takes O(p Log p)

public int[] relativeSortArray(int[] arr1, int[] arr2) {	
	Map<Integer, Integer> map = new TreeMap<>();
	for(int i=0; i<arr1.length; i++) {
		map.putIfAbsent(arr1[i],0);
		map.put(arr1[i], map.get(arr1[i])+1);
	}
	
	int[] result = new int[arr1.length];
	int index = 0;
	for(int i=0; i<arr2.length; i++) {
		if(map.containsKey(arr2[i])) {
			int count = map.get(arr2[i]);
			while(count-->0) {
				result[index++] = arr2[i];
			}
			map.remove(arr2[i]);
		}
	}
	
	for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
		int count = entry.getValue();
		for(int i=0; i<count; i++) {
			result[index++] = entry.getKey();        
		}

	}
	
	return result;
}

==================================================================================================
** sort binary array
==================================================================================================
- count 0's and fill n with zeros and rest with 1
- partitioning quick sort 
	create index = 0
	traverse through loop and check if current element is 0
	if 0 then swipe with index and increment index

==================================================================================================
** sort an array of 0's, 1's and 2's in linear time complexity
{ 2, 1, 0, 2, 1, 0, 1}
==================================================================================================
Solution1 - count 0,1,2 and create the array
Soultion2 -  same like sorting binary array, just one change, we are maintaining end index for '2'
	i = start = 0;
	end = size - 1;
	while(i <= end) {
			if(A[i] == 0) {
				swap(A, i , start);
				start ++;
			} else if(A[i] == 1) {
				i++;
			} else {
				swap(A, i , end);
				end--;	
			}
		}


==================================================================================================
** Binary Search
==================================================================================================
- Time Complexity:- O(logn), Space Complexity : O(1)

public int search(int[] nums, int target) {
	int start = 0;
	int end = nums.length-1;
	int mid;
	while(start <= end) {
		mid = start + (end - start)/2;
		if(target == nums[mid])
			return mid;
		else if(target < nums[mid])
			end = mid-1;
		else start = mid+1;
	}
	return -1;
}

==================================================================================================
** find minimum in sorted rotated array
** find how many times array is rotated
----> The minimum element is the only element whose previous is greater than it.
==================================================================================================

// O(log n) solution - Binary Search
public static int findPivotBinarySearch(int[] array) {

	if (array == null || array.length == 0) {
		return -1;
	}

	// Case when array is not rotated. Then first index is the pivot
	if (array.length == 1 || array[0] < array[array.length - 1]) {
		return 0;
	}

	int start = 0, end = array.length - 1;

	while (start <= end) {

		int mid = (start + end) / 2;
		// check if mid+1 is pivot
		if (mid < array.length-1 && array[mid] > array[mid+1]) {
			return (mid + 1);
		} else if (array[start] <= array[mid]) {
			// If array[start] <= array[mid],
			// it means from start to mid, all elements are in sorted order,
			// so pivot will be in second half
			start = mid + 1;
		} else {
			// else pivot lies in first half, so we find the pivot in first half
			end = mid - 1;
		}
	}

	return 0;
}


==================================================================================================
** square root of a number
 x  = 11
ans = 3
==================================================================================================

linear:   x^2 == N return x/mid
		  x^2 < N  ans = x
		  x^2 > N  return ans

use binary search as if x^2 < N then elements lower then x are not useful, search above x.	  
		  
public int mySqrt(int x) {     
	if (x == 0 || x == 1) 
		return x; 

	int start = 1, end = x, ans=0; 
	while (start <= end) { 
		int mid = (start + end) / 2; 
		
		if (mid <= x/mid) {            // mid * mid might cause overflow
			start = mid + 1; 
			ans = mid;                 // if mid^2 < x then it is possible answer 
		} else {
			end = mid-1;                 
		} 
	} 
	return ans; 
}

==================================================================================================
** is perfect square
==================================================================================================
public boolean isPerfectSquare(int num) {
 
	int start=1, end=num, result = 0;
	
	while(start<=end){
		double mid = start + (end-start)/2;
		if(mid == num/mid )
			return true;
		
		if(mid < num/mid)
			start = (int)mid+1;
		else 
			end = (int)mid-1;
	}
	
	return false;
}


==================================================================================================
** find peak element in an array

Input: array[]= {5, 10, 20, 15}
Output: 20

Input: array[] = {10, 20, 15, 2, 23, 90, 67}
Output: 20 or 90
==================================================================================================
1: Initialize start = 0, end = array.length - 1
2: Repeat following steps till peak element is found:
   (a) Find mid = (start+end)/2
   (b) If mid is peak element, return array[mid]
   (c) If array[mid-1] is greater than array[mid], find peak in left half of array  set end = mid - 1
   (d) Else find peak in right half of array  set start = mid + 1

Time Complexity: O(log n)
Space Complexity: O(1)


==================================================================================================
** single non duplicate element in sorted array
Input:  int arr[] = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
Output:  2
==================================================================================================
- sort if not sorted and linear traversal
- xor: xor and binary search works only if repeated element occurs once
- sort if not sorted and binary search

Below is an observation on the input array. 
All elements before the required have the first occurrence at even index (0, 2, ..) and the next occurrence at odd index (1, 3, …). And all elements after the required elements have the first occurrence at an odd index and the next occurrence at an even index. 

public int singleNonDuplicate(int[] nums) {
	int start = 0;
	int end = nums.length-1;
	
	while(start < end){
		int mid = start + (end-start)/2;
		if(mid%2==1) // moving to even index if mid is at odd index
			mid--;
		
		// move left if even and odd index element are not same
		// else move right
		
		if(nums[mid] != nums[mid+1])
			end=mid;
		
		else start = mid+2;
	}
	
	return nums[start];
}

==================================================================================================
** search in sorted rotated array
==================================================================================================
find mid and check if elements exists in sorted element range ( start < target < mid or mid < target < end)
if yes then move in the sorted side i.e if left is sorted and element exists in that subarray then end = mid -1 else start = mid + 1
else move in other side

public int search(int[] nums, int target) {
	int start = 0, end = nums.length-1;
	while(start <= end){
		int mid = start + (end-start)/2;
		if(target == nums[mid])
			return mid;
		if(nums[start] <= nums[mid]) { 						// left is sorted
			if(target < nums[mid] && target >= nums[start]) // move left if lies in sorted array
				end = mid-1;
			else
				start = mid+1;                
		} else { 											// right side is sorted
			if(target > nums[mid] && target <= nums[end])   // move right if lies in sorted array
				start = mid+1;
			else
				end = mid-1;
		}
	}
	return -1;
}

==================================================================================================
** ?? Number Complement
==================================================================================================
public int findComplement(int num) {
	int result = 0;
	int base=1;
	while(num>0){
		int rem = num%2==0?1:0;
		result = result + (rem*base);
		base = base*2;
		num=num/2;
	}
	return result;
}

==================================================================================================
** Find The Town Judge
If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.


int[][] arr = {{1,3},{2,3},{3,1}}; output: -1
int[][] arr = {{1,3},{2,3}}; 	   output: 3
int[][] arr = {{1,3}}; 			   output: -1
==================================================================================================
	private static int findJudge(int[][] arr, int N) {
		
		int[][] trust = new int[N+1][2]; //col1: trusts, col2: trustedBy

		for(int[] a : arr) {
			trust[a[0]][0] ++;
			trust[a[1]][1] ++;
		}
		
		for(int i = 1; i <= N; i++){
			if(trust[i][0] == 0 && trust[i][1] == N-1) {
				return i;
			}
		}
		
		return -1;
	}

==================================================================================================
** find maximum product of two intergers in an array
Input: arr[] = {-1, -3, -4, 2, 0, -5} 
Output: {-4,-5}

- find top 2 largest and top 2 smallest elements  
==================================================================================================
 for (int i = 0; i < size; i++)
        {
        	if(arr[i] > maxa) {
        		maxb = maxa;
        		maxa = arr[i];
        	} else if(arr[i] > maxb) {
        		maxb = arr[i];
        	}
        	
        	if(arr[i] < mina) {
        		minb = mina;
        		mina = arr[i];
        	} else if(arr[i] < minb) {
        		minb = arr[i];
        	}
        }

==================================================================================================
** find equilibrium index

Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes
input: {-7, 1, 5, 2, -4, 3, 0} 
output: 3 bcz A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Input: A[] = {1, 2, 3} 
Output: -1 
==================================================================================================

The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left sum which is initialized as zero. 
In the loop, we can get the right sum by subtracting the elements one by one

private static int getEquilibriumIndex(int[] arr) {
		int size = arr.length;
		int sum = 0;
		
		for(int i = 0 ; i < size ; i++)
			sum += arr[i];
		
		int leftSum = 0;
		for(int i = 0 ; i < size ; i++) {
			sum = sum - arr[i]; // now sum is right sum for index i
			
			if(sum == leftSum) {
				return i;
			}
			
			leftSum += arr[i];
		}
		
		return -1;
	}

==================================================================================================
** Product of an array except self
int[] arr = { 10, 3, 5, 2 };
output: 30 100 60 150 
- ideserve
==================================================================================================
public int[] productExceptSelf(int[] nums) {
		int[] t1 = new int[size];
		int[] t2 = new int[size];
 
		t1[0]=1;
		t2[size-1]=1;
 
		// scan from left to right
		for(int i=1; i<size; i++){
		    t1[i] = arr[i-1] * t1[i-1];
		}
		
		//scan from right to left
		for(int i=size-2; i>=0; i--){
		    t2[i] = t2[i+1] * arr[i+1];
		}
		
		//multiply
		for(int i=0; i<size; i++){
		    result[i] = t1[i] * t2[i];
		}
}

-
public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
 
    int left=1;
	// store the product upto i-1 index from the start of array
    for(int i=0; i<nums.length; i++){
        result[i]=left;
		left = left * nums[i];
    }
 
    int right=1;
    for(int i=nums.length-1; i>=0; i--){
        result[i]=right*results[i];
        right = right*nums[i];
    }
 
    return result;
}

- using division operator



==================================================================================================
** Minimum Rewards or Candies or Chocolates distribution
https://www.geeksforgeeks.org/chocolate-distribution-problem/

nput : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
Output: Minimum Difference is 2 

Explanation:
We have seven packets of chocolates and we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.
==================================================================================================

 O(n Log n) as we apply sorting before subarray search.
 
 An efficient solution is based on the observation that to minimize the difference, we must choose consecutive elements from a sorted packet. We first sort the array arr[0..n-1], then find the subarray of size m with the minimum difference between the last and first elements.
 
	Arrays.sort(arr);
      
        // Number of students cannot be more than number of packets
        if (n < m)
           return -1;
      
        // Largest number of chocolates
        int min_diff = Integer.MAX_VALUE;
      
        // Find the subarray of size m such that difference between last and first elements of subarray is minimum.
         
        for (int i = 0; i + m - 1 < n; i++)
        {
            int diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }

==================================================================================================
** find leaders
An element is leader if it is greater than all the elements to its right side. 
And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2},
leaders are 17, 5 and 2. 
==================================================================================================
Time Complexity: O(n)

Scan all the elements from right to left in an array and keep track of maximum till now. 
When maximum changes its value, print it.

void printLeaders(int arr[], int size) { 
	
	int max_from_right =  arr[size-1]; 
	/* Rightmost element is always leader */
	System.out.print(max_from_right + " "); 
   
	for (int i = size-2; i >= 0; i--) { 
		if (arr[i] > max_from_right) {            
			max_from_right = arr[i]; 
			System.out.print(max_from_right + " "); 
		} 
	}     
}	

==================================================================================================
** trapping water
https://www.geeksforgeeks.org/trapping-rain-water/

int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
output: 6
==================================================================================================
Method 3 (geeksforgeeks)
Time Complexity: O(n)

	static int findWater(int[]arr, int size) {
		int prev = arr[0];
		int prevIndex = 0;
		int water = 0;
		
		// To store the water until a larger wall is found, if there are no larger walls then delete temp value from water
		int temp = 0;
		
		for(int i = 1; i < size; i++) {
			// if current wall is greater than prev wall then make it prev and clear temp
			if(arr[i] >= prev) {
				prev = arr[i];
				prevIndex = i;
				temp = 0;
			} else {
				// if current wall is smaller then prev then add in water and temp
				water += prev - arr[i];
				temp += prev - arr[i];
			}
		}

		// if prevIndex is less then size of array then we didn't find the last wall greater or equal to prev wall then delete temp from water
		//
		// eg: for index 0 to 7 (element 3)
		//			water: 5
		//			temp: 5
		// for index 7 (element 3) to 11
		// 			water : 11 [5 + 1(3-2) + 2(3-1) + 1(3-2) + 2(3-1)]
		// 			temp : 6
		//
		// but we can store 1 water at index 9 (element 1)
		// remove temp from water 
		// iterate backward and store water
		
		if(prevIndex < size-1) {
			water -= temp;
			
			prev = arr[size - 1];
			for(int i = size-2; i >= prevIndex ; i--) {
				if(arr[i] > prev) {
					prev = arr[i];
				} else {
					water += prev - arr[i];
				}
			}
		}
		
		return water;
	}

static int findWater(int n) { 
	int left[] = new int[n]; 
	int right[] = new int[n]; 

	int water = 0; 

	left[0] = arr[0]; 
	for (int i = 1; i < n; i++) 
		left[i] = Math.max(left[i - 1], arr[i]); 

	right[n - 1] = arr[n - 1]; 
	for (int i = n - 2; i >= 0; i--) 
		right[i] = Math.max(right[i + 1], arr[i]); 

	for (int i = 0; i < n; i++) 
		water += Integer.max((min(left, right) - arr[i]),0);

	return water; 
} 


==================================================================================================
** ?? Two City Scheduling
==================================================================================================

public int twoCitySchedCost(int[][] costs) {
	
	// sorting by A-B (ASC)
	Arrays.sort(costs, (a,b) -> (a[0]-a[1]) - (b[0]-b[1])); //-170,-10,10,350
	int cost = 0;

	for(int i=0; i<costs.length/2; i++) {
		cost += costs[i][0]; 
	}
	
	for(int i=costs.length/2; i<costs.length; i++) {
		cost += costs[i][1]; 
	}
	
	return cost;
}

==================================================================================================
** Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in binary array
==================================================================================================
time Complexity: O(n)

- easy solution count number of 1 around every 0 and return index with max 1 around O(
- find the diff b/w current index of 0 and prev_prev_zero

static int maxOnesIndex(int arr[], int n) { 
	int max_count = 0;  // for maximum number of 1 around a zero 
	int max_index=0;  // for storing result 
	int prev_zero = -1;  // index of previous zero 
	int prev_prev_zero = -1; // index of previous to previous zero 

	// Traverse the input array 
	for (int curr=0; curr<n; ++curr) { 
		// If current element is 0, then calculate the difference 
		// between curr and prev_prev_zero 
		if (arr[curr] == 0) { 
			// Update result if count of 1s around prev_zero is more 
			if (curr - prev_prev_zero > max_count) { 
				max_count = curr - prev_prev_zero; 
				max_index = prev_zero; 
			} 

			// Update for next iteration 
			prev_prev_zero = prev_zero; 
			prev_zero = curr; 
		} 
	} 

	// Check for the last encountered zero 
	if (n - prev_prev_zero > max_count) 
		max_index = prev_zero; 

	return max_index; 
} 


==================================================================================================
** ?? minimum distance between two number
==================================================================================================
- find either of two number
- find the first other number and calculate the distance
{ 
    int minDist(int arr[], int n, int x, int y)  
    { 
          
    //previous index and min distance 
    int i=0,index=-1, min_dist=Integer.MAX_VALUE; 
      
    for(i=0 ; i<n ; i++){ 
        if(arr[i] ==x || arr[i] == y) { 
            //we will check if p is not equal to -1 and  
            //If the element at current index matches with 
            //the element at index p , If yes then update  
            //the minimum distance if needed  
            if(index != -1 && arr[i] != arr[index]) 
                min_dist = Math.min(min_dist,i-index); 
               
            //update the previous index  
            index=i; 
        } 
    } 
    //If distance is equal to int max  
    if(min_dist==Integer.MAX_VALUE) 
       return -1; 
    return min_dist; 
} 

==================================================================================================
** merge two sorted arrays
Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
==================================================================================================
Method 2 (O(n1 + n2) Time and O(n1 + n2) Extra Space) 
The idea is to use Merge function of Merge sort. 

Create an array arr3[] of size n1 + n2.
Simultaneously traverse arr1[] and arr2[]. 
Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
If there are remaining elements in arr1[] or arr2[], copy them also in arr3[].

OR

Method 3: Using Maps (O(nlog(n) + mlog(m)) Time and O(N) Extra Space) 

Insert elements of both arrays in a map as keys.
Print the keys of the map.

aayush <--
public static void merge(int[] X, int[] Y) {
	int m = X.length;
	int n = Y.length;

	// consider each element X[i] of array X and ignore the element
	// if it is already in correct order else swap it with next smaller
	// element which happens to be first element of Y
	for (int i = 0; i < m; i++) {
		// compare current element of X[] with first element of Y[]
		if (X[i] > Y[0]) {
			// swap (X[i], Y[0])
			int temp = X[i];
			X[i] = Y[0];
			Y[0] = temp;

			int first = Y[0];

			// move Y[0] to its correct position to maintain sorted
			// order of Y[]. Note: Y[1..n-1] is already sorted
			int k;
			for (k = 1; k < n && Y[k] < first; k++) {
				Y[k - 1] = Y[k];
			}

			Y[k - 1] = first;
		}
	}
}
-->


==================================================================================================
** minimum number of platforms
arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} 
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} 
Output: 3 
==================================================================================================
static int findPlatform(int arr[], int dep[], int n) { 
   Arrays.sort(arr); 
   Arrays.sort(dep); 
   
   // arr[] = {9:00, 9:40,  9:50,  11:00, 15:00, 18:00} 
   // dep[] = {9:10, 11:20, 11:30, 12:00, 19:00, 20:00}
   
   // plat_needed indicates number of platforms 
   // needed at a time 
   int plat_needed = 1, result = 1; 
   int i = 1, j = 0; ---->imp
   
   while (i < n && j < n) 
   { 
      // If next event in sorted order is arrival,  
      // increment count of platforms needed 
      if (arr[i] <= dep[j]) 
      { 
          plat_needed++; 
          i++; 
   
          // Update result if needed  
          if (plat_needed > result)  
              result = plat_needed; 
      } 
   
      // Else decrement count of platforms needed 
      else
      { 
          plat_needed--; 
          j++; 
      } 
   } 
   
   return result; 
} 

==================================================================================================
** hackerland radio transmitter // Number of transmitters required to install
==================================================================================================
		int[] arr = {7, 2, 4, 6, 5, 9, 12, 11, 16, 21};
		int range = 2;
		
		Arrays.sort(arr);
		// 2,4,5,6,7,9,11,12
		int size = arr.length;
		int installedTransmittors=0;
		int i = 0;
		
		while(i < size) {
			installedTransmittors++;
			int coveredHouses = arr[i] + (range);
			while(i < size && arr[i] <= coveredHouses) {
				i++;
			}
			
			coveredHouses = arr[--i] + range;
			System.out.println("install on house - " + arr[i]);
			while(i < size && arr[i] <= coveredHouses) {
				i++;
			}
		}

==================================================================================================
** (Ayush)rearrage the array in alternate low and high (wave sort)
==================================================================================================
public static void rearrangeArray(int[] A) {
	// start from second element and increment index
	// by 2 for each iteration of loop
	for (int i = 1; i < A.length; i += 2)
	{
		// If the prev element is greater than current element,
		// swap the elements
		if (A[i - 1] > A[i]) {
			swap(A, i - 1, i);
		}

		// if next element is greater than current element,
		// swap the elements
		if (i + 1 < A.length && A[i + 1] > A[i]) {
			swap(A, i + 1, i);
		}
	}
}

==================================================================================================
** (Ayush)smallest difference
==================================================================================================
static int findSmallestDifference(int A[], int B[], int m, int n) { 
	Arrays.sort(A); 
	Arrays.sort(B); 
	int a = 0, b = 0; 
	int result = Integer.MAX_VALUE; 
	while (a < m && b < n) { 
		if (Math.abs(A[a] - B[b]) < result) 
			result = Math.abs(A[a] - B[b]); 
  
		// Move Smaller Value 
		if (A[a] < B[b]) a++; 
		else b++; 
	} 
	return result;  
} 

==================================================================================================
** (Ayush)find minimum difference pair
==================================================================================================
static int minimumAbsoluteDifference(int[] arr) {
	Arrays.sort(arr); 
	int diff = Integer.MAX_VALUE; 
	for (int i=0; i<arr.length-1; i++) 
		if (arr[i+1] - arr[i] < diff) 
			diff = arr[i+1] - arr[i]; 
	return diff;
}

==================================================================================================
** move all instances of an element to the end of an array
==================================================================================================
public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
	int start = 0;
	int end = array.size()-1;
	while(start < end){
		while(start < end && array.get(end) == toMove) end --;
		if(array.get(start) == toMove){
			int temp = array.get(start);
			array.set(start, array.get(end));
			array.set(end,temp);
		}
		start++;
	}
	return array;
}

==================================================================================================
** reverse in group of k
==================================================================================================
static void reverse(int arr[], int n, int k) { 
	for (int i = 0; i < n; i += k) { 
		int left = i; 
		// to handle case when k is not multiple of n 
		int right = Math.min(i + k - 1, n - 1); 
		int temp; 
  
		while (left < right) { 
			temp=arr[left]; 
			arr[left]=arr[right]; 
			arr[right]=temp; 
			left++; 
			right--; 
		} 
	} 
}

==================================================================================================
** buy and sell stock - 1 transaction
==================================================================================================
O(N)
public static int maxProfit(int[] prices){
	int profit = 0;
	int mimimumPrice = price[0];
	for(int i=1; i< prices.length; i++) {
		profit = Math.max(profit, prices[i]-minimumPrice);
		minimumPrice = Math.min(minimumPrice, prices[i]);
	}
	return profit;
}

==================================================================================================
** buy and sell stock - multiple transaction
==================================================================================================
O(N)
public static int maxProfit(int[] prices){
	int totalProfit = 0;

	for(int i=1; i< prices.length; i++) {
		int currentProfit = prices[i]-price[i-1]);
		if(currentProfit > 0)
			totalProfit += currentProfit;
	}
	return totalProfit;
}

void stockBuySell(int price[], int n) { 
	if (n == 1) 
		return; 

	int count = 0; 
	ArrayList<Interval> sol = new ArrayList<Interval>(); 
	int i = 0; 
	while (i < n - 1) { 
		// Find Local Minima. Note that the limit is (n-2) as we are 
		// comparing present element to the next element. 
		while ((i < n - 1) && (price[i + 1] <= price[i])) 
			i++; 

		// If we reached the end, break as no further solution possible 
		if (i == n - 1) 
			break; 

		Interval e = new Interval(); 
		e.buy = i++; 
		// Store the index of minima 

		// Find Local Maxima.  Note that the limit is (n-1) as we are 
		// comparing to previous element 
		while ((i < n) && (price[i] >= price[i - 1])) 
			i++; 

		// Store the index of maxima 
		e.sell = i - 1; 
		sol.add(e); 

		// Increment number of buy/sell 
		count++; 
	} 

	// print solution 
	if (count == 0) 
		System.out.println("There is no day when buying the stock "
						   + "will make profit"); 
	else
		for (int j = 0; j < count; j++) 
			System.out.println("Buy on day: " + sol.get(j).buy 
							   + "        "
							   + "Sell on day : " + sol.get(j).sell); 

	return; 
} 


** Left rotate
static int[] rotLeft(int[] a, int d) {
	int[] arr = new int[d];
	for(int i=0; i<d;i++) arr[i] = a[i];
	for(int i=d; i<a.length;i++) a[i-d] = a[i];
	for(int i=(a.length-d),int j=0; i<a.length; i++, j++) a[i] = arr[j];
	return a;
}

** isMonotonic
public static boolean isMonotonic(int[] array) {
	boolean isDecreasing = true;
	boolean isIncreasing = true;
	for (int i=1; i<array.length; i++) {
		if(array[i] < array[i-1]) {
			isIncreasing = false;
		}
		if(array[i] > array[i-1]) {
			isDecreasing = false;
		}
		if(!isIncreasing && !isDecreasing){
			return false;
		}
	}
	return true;
}

** Find Majority Element
- use HashMap
- use sorting
- use Boyer-Moore Vote Algorithm
public static Integer getMajorityElement(int[] array) {	
	if (array == null || array.length == 0) return null;
         
	Integer candidate = null;
	int count = 0;
	for (int i = 0; i < array.length; i++) {
		if (count == 0) {
			candidate = array[i];
				count = 1;
				continue;
		} else {
			if (candidate == array[i]) {
				count++;
			} else {
				count--;
			}
		}
	}
	
	if (count == 0) {
		return null;
	}
	
	         
	count = 0;
	for (int i = 0; i < array.length; i++) {
		if (candidate == array[i]) {
			count++;
		}
	}
	return (count > array.length / 2) ? candidate : null;
}

** New Year Chaos
static void minimumBribes(int[] q) {
	int swap_count = 0;
	for(int i = q.length-1; i>=0; i--) {
		if(q[i] == i+1)
			continue;
		
		if(((i-1) >= 0) && (q[i-1] == i+1)) { // bribed next person
			swap_count++;
			swap(q, i, i-1);
			continue;
		} 

		if(((i-2) >= 0) && (q[i-2] == i+1)) { //bribed next and next to next person
			swap_count += 2;
			swap(q, i-2, i-1);
			swap(q, i-1, i);
			continue;
		} 

		System.out.println("Too chaotic");
		return;
	}

	System.out.println(swap_count);
}

** Maximum Hour Glass Sum
static int hourglassSum(int[][] arr) {
	int row = arr.length;
	int col = arr[0].length;

	if(row < 3 || col < 3 )
		return -1;
	
	int max_sum = Integer.MIN_VALUE;
	for(int i=0; i<(row-2); i++){
		for(int j=0; j< (col-2); j++){
				int sum = (arr[i][j] + arr[i][j + 1] +  arr[i][j + 2]) + 
									(arr[i + 1][j + 1]) +  
						  (arr[i + 2][j] + arr[i + 2][j + 1] +  arr[i + 2][j + 2]); 

			max_sum = Math.max(max_sum, sum); 
		}
	}
	return max_sum;
}

==================================================================================================
** Spiral Traverse
==================================================================================================
static void spiralPrintMethod1(int rH, int cH, int a[][])
    {
        int i, rL = 0, cL = 0;
 
        /*  rL - starting row index
        rH - ending row index
        cL - starting column index
        cH - ending column index
        i - iterator
        */
 
        while (rL < rH && cL < cH) {
            // Print the first row from the remaining rows
            for (i = cL; i < cH; ++i) {
                System.out.print(a[rL][i] + " ");
            }
            rL++;
 
            // Print the last column from the remaining
            // columns
            for (i = rL; i < rH; ++i) {
                System.out.print(a[i][cH - 1] + " ");
            }
            cH--;
 
            // Print the last row from the remaining rows */
            if (rL < rH) {
                for (i = cH - 1; i >= cL; --i) {
                    System.out.print(a[rH - 1][i] + " ");
                }
                rH--;
            }
 
            // Print the first column from the remaining
            // columns */
            if (cL < cH) {
                for (i = rH - 1; i >= rL; --i) {
                    System.out.print(a[i][cL] + " ");
                }
                cL++;
            }
        }
    }

** rotate matrix clockwise
// transpose matrix
int[][] transpose = new int[column][row];
for(int i = 0; i < row; i++) {
	for (int j = 0; j < column; j++) {
		transpose[j][i] = matrix[i][j];
	}
}
// swap columns
for(int i = 0; i < row; i++) {
	for (int j = 0; j < col / 2; j++) {
		int temp = mat[i][j];
		mat[i][j] = mat[i][col - j - 1];
		mat[i][col - j - 1] = temp;
	}
}

** rotate matrix anti-clockwise
// swap rows
for (int i = 0; i < row/2; i++) {
	for (int j = 0; j < col; j++) {
		// swap mat[i][j] with mat[row-i-1][j]
		int temp = mat[i][j];
		mat[i][j] = mat[row-i-1][j];
		mat[row-i-1][j] = temp;
	}
}
   

** print matrix in diagonal order
private static void printMatrixDiagonally(int[][] matrix) {
	for (int i = 0 ; i < matrix.length ; i++) { // rowwise
		int row = i;
		int col = 0;

		while (row >= 0 && col < matrix[0].length) {
			System.out.print(matrix[row][col] + " ");
			col++;
			row--;
		}
		System.out.println();
	}

	for (int i = 1 ; i < matrix[0].length ; i++) { // columnwise
		int row = matrix.length-1;
		int col = i;

		while (row >= 0 && col < matrix[0].length) {
			System.out.print(matrix[row][col] + " ");
			col++;
			row--;
		}
		System.out.println();
	}
}

** Arrange given numbers to form the biggest number
sort the array using string comparison

** inversion of array
- naive solution:
count all the number < a[i] Time Complexity O(n^2)

// Merge sort function 
private static int mergeSortAndCount(int[] arr, int l, int r)  { 
	int count = 0; 

	if (l < r) { 
		int m = l + (r - l) / 2; 

		// Total inversion count = left subarray count 
		// + right subarray count + merge count 

		// Left subarray count 
		count += mergeSortAndCount(arr, l, m); 

		// Right subarray count 
		count += mergeSortAndCount(arr, m + 1, r); 

		// Merge count 
		count += mergeAndCount(arr, l, m, r); 
	} 

	return count; 
} 

private static int mergeAndCount(int[] arr, int l, int m, int r) { 
	// Left subarray 
	int[] left = Arrays.copyOfRange(arr, l, m + 1); 

	// Right subarray 
	int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

	int i = 0, j = 0, k = l, swaps = 0; 

	while (i < left.length && j < right.length) { 
		if (left[i] <= right[j]) 
			arr[k++] = left[i++]; 
		else { 
			arr[k++] = right[j++]; 
			swaps += (m + 1) - (l + i);  // all elements to the right of a[i] including a[i]
		} 
	} 

	// Fill from the rest of the left subarray 
	while (i < left.length) 
		arr[k++] = left[i++]; 

	// Fill from the rest of the right subarray 
	while (j < right.length) 
		arr[k++] = right[j++]; 

	return swaps; 
} 

// Driver code 
public static void main(String[] args) { 
	int[] arr = { 1, 20, 6, 4, 5 }; 
	System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
} 



** merge overlapping intervals
public static void mergeIntervals(Interval arr[])  {  
	// Test if the given set has at least one interval  
	if (arr.length <= 0)  
		return;  

	// Create an empty stack of intervals  
	Stack<Interval> stack=new Stack<>(); 

	// sort the intervals in increasing order of start time  
	Arrays.sort(arr,new Comparator<Interval>(){ 
		public int compare(Interval i1,Interval i2) 
		{ 
			return i1.start-i2.start; 
		} 
	}); 

	// push the first interval to stack  
	stack.push(arr[0]);  

	// Start from the next interval and merge if necessary  
	for (int i = 1 ; i < arr.length; i++)  
	{  
		// get interval from stack top  
		Interval top = stack.peek();  

		// if current interval is not overlapping with stack top,  
		// push it to the stack  
		if (top.end < arr[i].start)  
			stack.push(arr[i]);  

		// Otherwise update the ending time of top if ending of current  
		// interval is more  
		else if (top.end < arr[i].end)  
		{  
			top.end = arr[i].end;  
			stack.pop();  
			stack.push(top);  
		}  
	}  

	// Print contents of stack  
	System.out.print("The Merged Intervals are: "); 
	while (!stack.isEmpty())  
	{  
		Interval t = stack.pop();  
		System.out.print("["+t.start+","+t.end+"] "); 
	}  
}

 check if number is lucky number or not
static int counter = 2;
boolean isLucky(number) {
	if(number < counter) return true;
	// canceled out
	if(number%counter==0) return false;
	int remaining_numbers_count =number - number/counter;
	counter++;
	return isLucky(number)
}

** Check if a number can be expressed as x raised to power y
  a = x^y
If we take log on both sides, we get:
     log a = log (x^y)
     log a = y log x
     y = log a / log x
	 
	
	
 static boolean isPower(int n) 
    { 
        for (int x = 2; x <= Math.sqrt(n); x++) { 
            int y = 2; 
  
            double p = Math.pow(x, y); 
  
            while (p <= n && p > 0) { 
                if (p == n) 
                    return true; 
                y++; 
                p = Math.pow(x, y); 
            } 
        } 
        return false; 
    }
	
public static boolean check(int a) {
	if (a == 1)
		return true;
	for (int i = 2; i <= Math.sqrt(a); i++) {
		double value = Math.log(a) / Math.log(i);
		if ((value - (int) value) < 0.000000001) {
			return true;
		}
	}
	return false;
}

HD REF
49. https://www.ideserve.co.in/learn/find-common-elements-in-n-sorted-arrays