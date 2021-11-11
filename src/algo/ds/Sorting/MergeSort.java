package algo.ds.Sorting;

public class MergeSort {

    public static void main(String[] args) {
        int input[] = new int[]{19, 6, 14, -1, 20, 17, 800, 299};
        mergeSort(input, 0, input.length-1);
        for(int i : input) {
            System.out.println(i);
        }
    }


    public static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[]arr, int start, int mid, int end) {
        int temp[] = new int[end - start +1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
       } 
      while(i <= mid) {
        temp[k++] = arr[i++];
      }
      while(j <= end){
        temp[k++] = arr[j++];
      }

      for(i = start; i<=end; i++) {
          arr[i] = temp[i-start];
      }
    }
    
}
