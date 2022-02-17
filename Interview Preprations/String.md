==================================================================================================
** alternating characters (minimum deletions required)
==================================================================================================
AAAA		3
BBBBB		4
ABABABAB	0	
BABABA		0
AAABBB		4

static int alternatingCharacters(String s) {
	if(s == null || s.isEmpty()) {
		return 0;
	}
	char[] array = s.toCharArray();
	char prev =  array[0];
	int result =0;
	for(int i=1;i<array.length; i++) {
		if(array[i] == prev)
			result++;
		prev = array[i];
	}
	return result;
}

==================================================================================================
** caesar cipher
==================================================================================================
static String caesarCipher(String s, int k) {
	char[] arr = s.toCharArray();
	for(int i=0; i< arr.length;i++) {
		if(!Character.isAlphabetic(arr[i]))
			continue;
		if(Character.isLowerCase(arr[i]))
			arr[i] = (char)(((arr[i] - 'a') + k)%26 + 'a');
		else 
			arr[i] = (char)(((arr[i] - 'A') + k)%26 + 'A');
	}      
	return new String(arr);
}

==================================================================================================
** Sort String of characters
==================================================================================================
soltion-1
char []arr = str.toCharArray(); 
Arrays.sort(arr); 
System.out.print(String.valueOf(arr)); 

solution-2
static void sortString(String str) { 
	int letters[] = new int[MAX_CHAR]; 
	for (char x : str.toCharArray()) { 
		// 'a'-'a' will be 0, 'b'-'a' will be 1, 
		// so for location of character in count 
		// array we will do str[i]-'a'. 
		letters[x - 'a']++; 
	} 

	// Traverse the hash array and print 
	// characters 
	for (int i = 0; i < MAX_CHAR; i++) { 
		for (int j = 0; j < letters[i]; j++) { 
			System.out.print((char) (i + 'a')); 
		} 
	} 
} 

==================================================================================================
**1[0]1 pattern count
==================================================================================================
int len = str.length();
		boolean oneSeen = false;
		int count = 0; // Initialize result
		for (int i = 0; i < len; i++) {
			char getChar = str.charAt(i);

			// Check if encountered '1' forms a valid pattern as specified
			if (getChar == '1' && oneSeen == true && str.charAt(i - 1) == '0') {
					count++;
			}

			// if 1 encountered for first time set oneSeen to 1
			if (getChar == '1' && oneSeen == false)
				oneSeen = true;

			// Check if there is any other character other than '0' or '1'. If so then set
			// oneSeen to 0 to search again for new pattern

//			if (getChar != '0' && str.charAt(i) != '1')
//				oneSeen = false;
			
			if(oneSeen && (getChar != '0' && getChar != '1')) {
				oneSeen = false;
			}
		}
		
		System.out.println(count);
	
	
==================================================================================================
** Reverse text without reversing the individual word
Input: s = “geeks quiz practice code” 
Output: s = “code practice quiz geeks”
==================================================================================================
public static void reverse(char[] chars, int begin, int end) {
	while (begin < end) {
		swap(chars, begin++, end--);
	}
}

public static void reverse(char[] chars) {
	int low = 0, high = 0;
	for (int i = 0; i < chars.length; i++) {
		// if space is found, we found a word
		if (chars[i] == ' ') {
			// reverse the found word
			reverse(chars, low, high);
			low = high = i + 1;
		} else {
			high = i;
		}
	}
	// reverse last word
	reverse(chars, low, high);
	// reverse the whole text
	reverse(chars, 0, chars.length - 1);
}

public static void main(String[] args) {
	String string = "preparation Interview Technical IT for material good provide We";

	// Since String is immutable in Java, convert it into a char array
	char[] chars = string.toCharArray();
	reverse(chars);

	System.out.println(chars);
} 

==================================================================================================
** palindrome index
==================================================================================================
static boolean isPalindrome(String str,  int low, int high) { 
	while (low < high)  { 
		if (str.charAt(low) != str.charAt(high)) 
			return false; 
		low++; 
		high--; 
	} 
	return true; 
} 

// This method returns -1 if it is not possible to make string a palindrome. it returns -2 if string is already  
// a palindrome. Otherwise it returns index of character whose removal can make the whole string palindrome. 

static int possiblePalinByRemovingOneChar(String str) { 
	
	int low = 0, high = str.length() - 1; 

	
	while (low < high)  { 

		// If both characters are equal then  move both pointer towards end 
		if (str.charAt(low) == str.charAt(high))  { 
			low++; 
			high--; 
		}  else		
		{ 
			/* 
			* If removing str[low] makes the  whole string palindrome. We basically  
			* check if substring str[low+1..high] is palindrome or not. 
			*/
			
			if (isPalindrome(str, low + 1, high)) 
				return low; 

			/* 
			* If removing str[high] makes the whole string palindrome. We basically check if substring  
			* str[low+1..high] is palindrome or not. 
			*/
			if (isPalindrome(str, low, high - 1)) 
				return high; 
			return -1; 
		} 
	} 
	
	return -2; 
}


==================================================================================================
** ?? Longest Palindromic Substring O(n^2) time and O(1) space
==================================================================================================
// expand in both directions of low and high to find
// maximum length palindrome
public static String expand(String str, int low, int high) {
	int len = str.length();
	// expand in both directions
	while (low >= 0 && high < len &&
			(str.charAt(low) == str.charAt(high))) {
		low--;
		high++;
	}
	return str.substring(low + 1, high);
}

public static String LongestPalindromicSubString(String str, int len) {
	String max_str = "";
	int max_length = 0;
	for (int i = 0; i < len; i++) 	{
		// find a longest odd length palindrome with str[i] as mid point
		String curr_str = expand(str, i, i);
		int curr_length = curr_str.length();
		
		// update maximum length palindromic substring if odd length
		// palindrome has greater length
		if (curr_length > max_length) {
			max_length = curr_length;
			max_str = curr_str;
		}

		// find a longest even length palindrome with str[i] and
		// str[i+1] as mid points.
		// Note that an even length palindrome has two mid points
		curr_str = expand(str, i, i + 1);
		curr_length = curr_str.length();

		// update maximum length palindromic substring if even length
		// palindrome has greater length
		if (curr_length > max_length) {
			max_length = curr_length;
			max_str = curr_str;
		}
	}

	return max_str;
}


==================================================================================================
** ??check if string is rotated palindrome or not
==================================================================================================
- conacatenate the self and find longest palindromic substring of length n

==================================================================================================
** ??Check if characters of a given string can be rearranged to form a palindrome
==================================================================================================
We can do it in O(n) time using a list. Following are detailed steps.
1) Create a character list.
2) Traverse the given string.
3) For every character in the string, remove the character if the list already contains else add to the list.
3) If the string length is even the list is expected to be empty.
4) Or if the string length is odd the list size is expected to be 1
5) On the above two conditions (3) or (4) return true else return false.

==================================================================================================
** check if string can be derived from another string by circulaly rotating it
==================================================================================================
- concatenate x + x and check if new_x contains y space complecity O(n) 
- rotate (all combination) the string heck if two strings are equal
public static boolean check(String X, String Y) {
	int m;
	if ((m = X.length()) != Y.length()) {
		return false;
	}

	for (int i = 0; i < m; i++) {
		// left rotate String X by 1 unit
		X = X.substring(1) + X.charAt(0);
		// return true if X becomes equal to Y
		if (X.compareTo(Y) == 0) {
			return true;
		}
	}

	// return false if no rotation is matched
	return false;
}

==================================================================================================
** Check if a string can be obtained by rotating another string 2 places
==================================================================================================
static boolean isRotated(String str1, String str2) { 
	if (str1.length() != str2.length()) 
		return false; 
   
	String clock_rot = ""; 
	String anticlock_rot = ""; 
	int len = str2.length(); 
   
	// Initialize string as anti-clockwise rotation 
	anticlock_rot = anticlock_rot + str2.substring(len-2, len) + str2.substring(0, len-2) ; 
   
	// Initialize string as clock wise rotation 
	clock_rot = clock_rot + str2.substring(2) + str2.substring(0, 2) ; 
   
	// check if any of them is equal to string1 
	return (str1.equals(clock_rot) || str1.equals(anticlock_rot)); 
} 

==================================================================================================
** Check whether two strings are anagram of each other
==================================================================================================
- sort both and compareTo
- use freq map for 1 string and iterate over another char array and update the freq(decrement) 

** Anagram difference 
static int countManipulations(String s1, String s2)
{
	int count = 0;

	// store the count of character
	int char_count[] = new int[26];

	// iterate though the first String and update 
	// count
	for (int i = 0; i < s1.length(); i++) 
		char_count[s1.charAt(i) - 'a']++;        

	// iterate through the second string
	// update char_count.
	// if character is not found in char_count
	// then increase count
	for (int i = 0; i < s2.length(); i++) 
	{
		char_count[s2.charAt(i) - 'a']--;
	}
   
	for(int i = 0; i < 26; ++i)
	{
	  if(char_count[i] != 0)
	  {
		count+=abs(char_count[i]);
	  }
	}
	 
	return count;
}

** check if two strings are k-anagrams or not (above logic can also be used)
Solution-1
1. Stores occurrence of all characters of both strings in separate count arrays.
2. Count number of different characters in both strings (in this if a strings has 4 a and second has 3 ‘a’ then it will be also count.
3. If count of different characters is less than or equal to k, then return true else false.
static boolean arekAnagrams(String str1, String str2, int k)
{
	// If both strings are not of equal
	// length then return false
	int n = str1.length();
	if (str2.length() != n)
		return false;

	int[] count1 = new int[MAX_CHAR];
	int[] count2 = new int[MAX_CHAR];
	int count = 0;
	
	// Store the occurrence of all characters
	// in a hash_array
	for (int i = 0; i < n; i++)
		count1[str1.charAt(i) - 'a']++;
	for (int i = 0; i < n; i++)
		count2[str2.charAt(i) - 'a']++;

	// Count number of characters that are
	// different in both strings
	for (int i = 0; i < MAX_CHAR; i++)
		if (count1[i] > count2[i]) ----> important
			count = count + Math.abs(count1[i] - 
									  count2[i]);

	// Return true if count is less than or
	// equal to k
	return (count <= k);
}

** beautiful binary string
static int beautifulBinaryString(String b) {
	char[] arr = b.toCharArray();
	int count = 0;
	int i=0;
	while(i < b.length()-2 ) {
		if(arr[i] == '0' && arr[i+1] == '1' && arr[i+2] == '0') {
			count++;
			i = i+3;                
		} else {
			i++;
		}
			
	}
	return count;

}

** remove duplicates from string
String duplicates(char[] array){
	int index = -1;
	Set<Character> characters = new HashSet<>();
	for(int i=0;i<array.length;i++){
		if(!characters.contains(array[i])){
			array[++index] = array[i];
		}
	}
	return String.valueOf(array);
}

** remove all adjacent duplicates
public static String removeAdjDup(String str) {
	// As String is Immutable in Java, convert it to character array
	char[] chars = str.toCharArray();

	// stores previous valid character
	char prev = chars[0];

	// k maintains the index of last filled location in the result
	int k = 0;

	// start from second character
	int i = 1;

	// do till end of the String is reached
	while (i < chars.length) {
		// if the current character is not same as the previous character
		if (prev != chars[i]) {
			chars[++k] = chars[i++];	// update result
			prev = chars[k];			// update prev
		} else {
			// remove adjacent duplicates
			while (i < chars.length && prev == chars[i]) {
				i++;
			}
			prev = chars[--k];		// update prev
		}
	}

	// delete str[k+1, n) as result lies in str[0..k]
	return new String(chars).substring(0, k + 1);
}

** longest substring with non repeating characters
public static String longestSubstr(String str) {
	Set<Character> window = new HashSet<>();

	// stores longest substring boundaries
	int begin = 0, end = 0;
	// [low..high] maintain sliding window boundaries
	for (int low = 0, high = 0; high < str.length(); high++)
		// if current character is present in current window
		if (window.contains(str.charAt(high))) {
			// remove characters from the left of the window till
			// we encounter current character
			while (str.charAt(low) != str.charAt(high)) {
				window.remove(str.charAt(low));
				low++;
			}

			low++;		// remove current character
		}
		else
		{
			// if current character is not present in the current
			// window, include it
			window.add(str.charAt(high)) = true;

			// update maximum window size if necessary
			if (end - begin < high - low)
			{
				begin = low;
				end = high;
			};
		}
	}

	// return longest substring found at str[begin..end]
	return str.substring(begin, end + 1);
}

** shifting letters
* Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
``` public String shiftingLetters(String S, int[] shifts) {
	char[] arr = S.toCharArray();
	int shift = 0;
	for (int i = arr.length - 1; i >= 0; i--) {
		shift = (shift + shifts[i]) % 26;
		arr[i] = (char)((arr[i] - 'a' + shift) % 26 + 'a');
	}
	return new String(arr);
} ```

** common prefix
public String longestCommonPrefix(String[] a) 
{ 
	int size = a.length; 

	/* if size is 0, return empty string */
	if (size == 0) 
		return ""; 

	if (size == 1) 
		return a[0]; 

	/* sort the array of strings */
	Arrays.sort(a); 

	/* find the minimum length from first and last string */
	int end = Math.min(a[0].length(), a[size-1].length()); 

	/* find the common prefix between the first and 
	   last string */
	int i = 0; 
	while (i < end && a[0].charAt(i) == a[size-1].charAt(i) ) 
		i++; 

	String pre = a[0].substring(0, i); 
	return pre; 
} 

** convert string to integer
public static int atoi(String str) { 
	  
	if(str.length() == 0) 		return -1; 

	int sign = 1; // Initialize sign as positive 
	int res = 0; // Initialize result 
	int i = 0; // Initialize index of first digit 
	  
	// If number is negative, then update sign 
	if(str.charAt(i)=='-') { 
		sign = -1; 
		i++; // Also update index of first digit 
	} 
	  
	// Iterate through all digits of input 
	// string and update result 
	for(; i < str.length(); i++) 
	{ 
		if(Character.isDigit(str.charAt(i)) == false) 
		{ 
			return -1; 
		} 
		res = res * 10 + Character.getNumericValue(str.charAt(i)); 
	} 
	  
	return sign * res; 
	  
}

** integer to roman
public String intToRoman(int num) {
	int arabics = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] romans = new String[]{"M", "CM" "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV","I"};
	StringBuilder sb =new StringBuilder();
	for(i=0;i<arabics.length;i++){
		while(number-arabics[i]>0){
			sb.append(romans[i]);
			number = number-arabics[i];
		}
	}
	return sb.toString();
}

** roman to integer
public int romanToInt(String s) {
	if (s == null || s.length() == 0) {
		return 0;
	}
	
	Map<Character, Integer> romanValues = new HashMap<>();
	romanValues.put('I', 1);
	romanValues.put('V', 5);
	romanValues.put('X', 10);
	romanValues.put('L', 50);
	romanValues.put('C', 100);
	romanValues.put('D', 500);
	romanValues.put('M', 1000);
	
	int length = s.length();
	int result = romanValues.get(s.charAt(length - 1));
	
	for (int i = length - 2; i >= 0; i--) {
		if (romanValues.get(s.charAt(i)) >= romanValues.get(s.charAt(i + 1))) {
			result += romanValues.get(s.charAt(i));
		} else {
			result -= romanValues.get(s.charAt(i));    
		}            
	}
	
	return result;
}

** All Permuation of String
public static void main(String[] args) { 
	String str = "ABC"; 
	int n = str.length(); 
	permute(str.toCharArray(), 0, n-1); 
} 

private static void permute(char[] str, int start, int end, List<char[]> resultsList) { 
	if (start == end) {
		resultsList.add(str);
		return;
	}

	for (int i = start; i <= end i++) { 							
		swap(str,start,i);  // fixing the character					
		permute(str,start+1,end,resultsList); //permute			
		swap(str,start,i);  // backtracking 						
	} 

} 

private static void swap(char[] ch, int i, int j)	{
	char temp = ch[i];
	ch[i] = ch[j];
	ch[j] = temp;
}

** Largest even integer number
class GFG {
 
    static int MAX = 10;
 
    // Function to return the maximum
    // even number that can be formed
    // with any number of digit swaps
    static String getMaxEven(char[] str, int len)
    {
 
        // To store the frequencies of
        // all the digits
        int[] freq = new int[MAX];
 
        // To store the minimum even digit
        // and the minimum overall digit
        int i, minEvenDigit = MAX, minDigit = MAX;
        for (i = 0; i < len; i++) {
            int digit = str[i] - '0';
            freq[digit]++;
 
            // If digit is even then update
            // the minimum even digit
            if (digit % 2 == 0)
                minEvenDigit
                    = Math.min(digit, minEvenDigit);
 
            // Update the overall minimum digit
            minDigit = Math.min(digit, minDigit);
        }
 
        // If there is no even digit then
        // it is not possible to generate
        // an even number with swaps
        if (minEvenDigit == MAX)
            return "-1";
 
        // Decrease the frequency of the
        // digits that need to be swapped
        freq[minEvenDigit]--;
        freq[minDigit]--;
 
        i = 0;
 
        // Take every digit starting from the maximum
        // in order to maximize the number
        for (int j = MAX - 1; j >= 0; j--) {
 
            // Take current digit number of times
            // it appeared in the original number
            for (int k = 0; k < freq[j]; k++)
                str[i++] = (char)(j + '0');
 
            // If current digit equals to the
            // minimum even digit then one instance of it
            // needs to be swapped with the minimum overall
            // digit i.e. append the minimum digit here
            if (j == minEvenDigit)
                str[i++] = (char)(minDigit + '0');
        }
 
        // Append once instance of the minimum
        // even digit in the end to make the number even
        str[i - 1] = (char)(minEvenDigit + '0');
 
        return String.valueOf(str);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        char[] str = "1023422".toCharArray();
        int len = str.length;
 
        // Function call
        System.out.println(getMaxEven(str, len));
    }
}