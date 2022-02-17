package test;

public class Main3 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		// {2,4,6,7,5,3,1}
		
		int j = -1;
		for(int i=0; i < arr.length; i++) {
			
			if(arr[i]%2 == 0) {
				// inc j and swap j and i
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		
		sortEven(arr,0,j);
//		sortOdd(arr,j+1, arr.length-1);
		
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
	}
	
	private static void sortEven(int[] arr, int start, int end) {
		int p = arr[end];
		int j = -1;

		if(start >= end) {
			return;
		}
		
		for(int i=start; i < end; i++) {
			if(arr[i] < p) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		j++;
		int temp = arr[j];
		arr[j] = arr[end];
		arr[end] = temp;
		
		sortEven(arr, start, j);
		sortEven(arr, j+1, end);
	}

}



































//
//int[] arr = new int[] {-8, 2, 3, -6, 10};
//int k = 2;
//
//int i = 0;
//int j = 0;
//
//List<Integer> lst = new ArrayList<>();
//
//while(j < arr.length) {
//	if(arr[j] < 0) {
//		lst.add(arr[j]);
//	}
//	
//	if(j-i+1 < k) {
//		j++;
//	}
//	
//	else {
//		if(!lst.isEmpty()) {
//			System.out.println(lst.get(0));
//			if(lst.get(0) == arr[i]) {
//				lst.remove(0);
//			}
//			
//		} else {
//			System.out.println(0);
//		}
//		
//		
//		i++;
//		j++;
//		
//		
//	}
//}

		
	





























//
//Employee table: id, name, salary, deptid
//
//department: deptid, deptname
//
//left join on deptid, groupby deptid, max
