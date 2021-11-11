package algo.ds.Array;

import java.util.HashSet;
import java.util.Set;

public class MissingElementSortedArray {

	public static void main(String[] args) {
		//int result = missingElement(new int[] { 4, 7, 9, 10 }, 6);  // 13
		//int result = missingElement(new int[] {1,2,4 }, 3);   // 6
		int result = missingElementBinarySearch(new int[] { 4,7,9,10}, 3);  // 13
		System.out.println(result);
	}

	private static int missingElement(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i : arr) {
			set.add(i);
		}
		
		int count = 0;
		for(int i = arr[0]; i<=arr[arr.length-1]; i++) {
			if(!set.contains(i)) {
				count++;
			}
			if(count == k) {
				return i;
			}
		}
		return arr[arr.length-1] + (k-count);
	}

	private static int missingElementBinarySearch(int[] arr, int k) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi-1) {
			int mid = (lo + hi) / 2;
			int missing = arr[mid] - arr[lo] - (mid - lo);
			if (missing >= k) {
				hi = mid;
			} else {
				lo = mid;
				k = k - missing;
			}
		}
		return arr[lo] + k;
	}

}
