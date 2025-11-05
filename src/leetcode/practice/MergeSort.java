package leetcode.practice;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]) {
		int arr[] = new int[] { 100, 4, 6, 78 };
		mergeSort(arr);
		for(int obj : arr) {
			System.out.println(obj);
		}
	}

	public static void mergeSort(int arr[]) {
		if (arr.length < 2) {
			return;
		}
		int left[] = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int right[] = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

		mergeSort(left);
		mergeSort(right);
		mergeArray(arr, left, right);

	}

	private static void mergeArray(int[] arr, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int ptr = 0;
	    while (i < left.length || j < right.length) {
	    	if(j == right.length) {
	            while (i < left.length) {
	                arr[ptr++] = left[i++];
	            }
	            break;
	    	}
	    	else if(i == left.length) {
	    		 while (j < right.length) {
	    	            arr[ptr++] = right[j++];
	    	        }
	    		 break;
	    	}
            if (left[i] < right[j]) {
                arr[ptr++] = left[i++];
            } else {
                arr[ptr++] = right[j++];
            }
        }



       
	}
}
