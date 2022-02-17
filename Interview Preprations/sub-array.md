** Prints all subarrays in arr[0..n-1] 
static void subArray( int n) { 
	for (int i=0; i <n; i++) { 	// Pick starting point
		for (int j=i; j<n; j++) { // Pick ending point 
			// Print subarray between current starting and ending points 
			for (int k=i; k<=j; k++) 
				System.out.print(arr[k]+" "); 
		} 
	} 
} 

** find sub array with given sum
-
static void sub_array_sum( int[] array, int n, int sum) { 
	for (int i=0; i <n; i++) { 	// Pick starting point
		int cur_sum = 0;
		for (int j=i; j<n; j++) { 
			cur_sum = cur_sum + array[j]
			if(cur_sum == sum){
				// print i to j
				// return;
			}
		} 
	} 
} 

==================================================================================================
** FindLargestSubarrayWithGivenSum
==================================================================================================
HD--
		int size = arr.length;
		int i = 0;
		int j = 0;
		int sum = 0;
		int max_subarray_length = 0;
		while(j < size) {
			sum += arr[j];
			
			if(sum < tgt_sum)
				j++;
			
			else if(sum == tgt_sum) {
				max_subarray_length = Math.max(max_subarray_length, j-i+1);
				j++;
			}
			
			
			else if(sum > tgt_sum) {
				while(sum > tgt_sum) {
					sum -= arr[i];
					i++;
					if(sum == tgt_sum) {
						max_subarray_length = Math.max(max_subarray_length, j-i+1);
						break;
					}	
				}
				j++;
			}
		}

- https://www.youtube.com/watch?v=HJDlxZNe1UI
public static void subArraySum(int[] arr, int sum) { 
	// cur_sum to keep track of cummulative sum till that point 
	int cur_sum = 0; 
	int start = 0; 
	int end = -1; 
	HashMap<Integer, Integer> hashMap = new HashMap<>(); 
	for (int i = 0; i < n; i++) { 
		cur_sum = cur_sum + arr[i]; 
		if (cur_sum == sum) { // it means the sub array is starting from index 0
			// start = 0;
			// end = i;
			break; 
		} 
		int y = cur_sum - sum; // case sum = y + cur_sum;
		if (hashMap.containsKey(y)) { 
			start = hashMap.get(y) + 1; 
			end = i;	
		} 
		// if value is not present then add to hashmap 
		hashMap.put(cur_sum, i); 
	} 
	// if end is -1 : means we have reached end without the sum 
	if (end == -1) System.out.println("No subarray with given sum exists"); 
	else System.out.println("Sum found between indexes " + start + " to " + end); 
} 


==================================================================================================
** return total subarray with given sum
==================================================================================================
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        int current_sum = 0;
        for(int i=0; i<nums.length; i++) {
            current_sum += nums[i];
            if(map.containsKey(current_sum - k))
                result += map.get(current_sum - k);

            int count = map.getOrDefault(current_sum, 0);
            map.put(current_sum, count+1);
        }
        return result; 
    }
}

==================================================================================================
** find maximum sum sub array of size K
==================================================================================================
private static void max(int[] arr, int k) {
		int size = arr.length;
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		
		if(size < k) {
			System.out.println("invalid input");
			return;
		}
		
		while(j < size) {
			sum += arr[j];
			
			if(j-i+1 < k) {
				j++;
			}
			
			else {
				max = Math.max(sum, max);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		System.out.println(max);
	}
	
==================================================================================================	
** first-negative-integer-every-window-size-k
==================================================================================================

private static void printNegativeNumbers(int[] arr, int k) {
		int size = arr.length;
		
		int i = 0;
		int j = 0;
		List<Integer> list = new LinkedList<>();
		
		if(size < k) {
			System.out.println("invalid input");
			return;
		}
		
		while(j < size) {

			if(arr[j] < 0)
				list.add(arr[j]);
			
			if(j-i+1 < k)
				j++;
			else {
				if(!list.isEmpty()) {
					System.out.print(list.get(0)+", " );
					if(list.get(0) == arr[i])
						list.remove(0);
				}else {
					System.out.print("0");
				}
				i++;
				j++;
			}
		}
	}


==================================================================================================
** find maximum sum sub array
==================================================================================================

- kadanes algorithm

class Solution {
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);	
        }
        return maxSoFar;
    }
}


==================================================================================================
** Length of the largest subarray with contiguous elements
 https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
==================================================================================================
O(N^2)
int findLength(int arr[], int n)
    {
        int max_len = 1;  // Initialize result
        for (int i = 0; i < n - 1; i++)
        {
            // Initialize min and max for all subarrays starting with i
            int mn = arr[i], mx = arr[i];
 
            // Consider all subarrays starting with i and ending with j
            for (int j = i + 1; j < n; j++)
            {
                // Update min and max in this subarray if needed
                mn = min(mn, arr[j]);
                mx = max(mx, arr[j]);
 
                // If current subarray has all contiguous elements
                if ((mx - mn) == j - i)
                    max_len = max(max_len, mx - mn + 1);
            }
        }
        return max_len;  // Return result
    }


==================================================================================================
** shortest subArray to be sorted
==================================================================================================
public static int[] subarraySort(int[] array) {
	int minOutOfOrder = Integer.MAX_VALUE;
	int maxOutOfOrder = Integer.MIN_VALUE;
	for (int i = 0; i < array.length; i++) {
		int num = array[i];
		if (isOutOfOrder(i, num, array)) {
		minOutOfOrder = Math.min(minOutOfOrder, num);
		maxOutOfOrder = Math.max(maxOutOfOrder, num);
		}
	}
	if (minOutOfOrder == Integer.MAX_VALUE) {
	    return new int[] {-1, -1};
	}
	int subarrayLeftIdx = 0;
	while (minOutOfOrder >= array[subarrayLeftIdx]) {
	    subarrayLeftIdx++;
	}
	int subarrayRightIdx = array.length - 1;
	while (maxOutOfOrder <= array[subarrayRightIdx]) {
	   subarrayRightIdx--;
	}
	return new int[] {subarrayLeftIdx, subarrayRightIdx};
}

public static boolean isOutOfOrder(int i, int num, int[] array) {
	if (i == 0) {
	    return num > array[i + 1];
	}
	if (i == array.length - 1) {
	    return num < array[i - 1];
	}
	return num > array[i + 1] || num < array[i - 1];
}




