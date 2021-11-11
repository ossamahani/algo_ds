package algo.ds.Array;

public class GettingDifferentNumber {

	 static int getDifferentNumber(int[] arr) {
	    // [0,5,4,1,3,6,2]
	    int temp = 0;
	    for(int i = 0; i < arr.length; i++){
	        temp = arr[i];   
	        if(temp < arr.length && temp != arr[temp]){
	         swap(temp, arr[temp], arr);
	      }
	    }
      
	    for(int i = 0; i < arr.length; i++) {
	       if(arr[i] != i) {
	            return i;
	        }
	    }
	    return arr.length;
	}
	
	 static void swap(int a, int b, int[]arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(getDifferentNumber(new int[]{1,0,3,4,5}));
	}
}
