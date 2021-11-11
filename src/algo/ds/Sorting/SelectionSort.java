package algo.ds.Sorting;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] result = sort(new int[]{5,3,7,1});
		for(int i : result)
		System.out.println(i);
	}

	private static int[] sort(int[] arr) {
		
		int min = 0;
		for(int i=0;i<arr.length-1; i++) {
			min = i;                         
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			
			swap(min, i, arr);
		}
		return arr;
	}

	private static void swap(int i, int j, int[]arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
