package leetcode.binarysearch;

public class MatrixSearch {

	public static void main(String[] args) {
		int[][] matrix = {{
			1,3,5,7
		},{
			10,11,16,20
			},{
				23,30,34,60
				}};
		searchMatrix(matrix,3);

	}
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        int left = 0;
	        int right = matrix.length;
	        int l_idx = 0;
	        if(matrix[0][0]>target)
	            return false;
	            
	        while(left<right){
	            int mid = (left + right)/2;
	            if(matrix[mid][0]==target)
	                return true;
	          if(mid+1>=matrix.length)
	                {
	                    l_idx = matrix.length - 1;
	                    break;
	                }  
	            if(matrix[mid+1][0]==target)
	                return true;
	            if(matrix[mid][0]<target && target<matrix[mid+1][0])
	                {
	                    l_idx = mid;
	                    break;
	                }
	            if(target<matrix[mid][0])
	                right = mid-1;
	            else
	                left = mid;
	        }
	        
	        left = 0;
	        right = matrix[l_idx].length;
	        while(left<right){
	            int mid = (left+right)/2;
	            if(matrix[l_idx][mid]==target)
	            return true;
	            if(target<matrix[l_idx][mid])
	                right = mid;
	            else
	                left = mid+1;
	        }
	        return false;
	    }
	}

