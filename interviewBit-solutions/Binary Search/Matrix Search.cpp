/*

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

*/

Solution:

int Solution::searchMatrix(vector<vector<int> > &a, int x){
    
    int m = a.size();
    int n = a[0].size();
    
    if(m == 0 || n == 0){
        return 0;
    }
    if(x == a[m-1][n-1] || x == a[0][0]){
        return 1;
    }
    if(x>a[m-1][n-1] || x<a[0][0]){
	    return 0;
	}
	int low = 0, high = m-1;
	int mid;
  
  //First find the suspected row
	int row, flag = 0;
	if(m>1){
	    if(x <= a[0][n-1]){
	        row = 0;
	    }
	    else{
        	while(low<=high){
        	    mid = (low+high)/2;
        	    if(a[mid][n-1]==x){
        	        flag = 1;
        	        row = mid;
        	        break;
        	    }
        	    else if(a[mid][n-1]>x){
        	        high = mid-1;
        	    }
        	    else{
        	        low = mid+1;
        	    }
        	}
        	if(x<a[mid][n-1] && mid-1>=0 && x>a[mid-1][n-1]){
        	    row = mid;
        	}
        	else if(x>a[mid][n-1] && mid+1<m && x<a[mid+1][n-1]){
        	    row = mid+1;
        	}
    	}
	}
	else{
	    row = 0;
	}
  
  // Now, after finding the suspected row, check if the desired element is present in that row 
	if(flag==1){
	    return 1;
	}
	else{
    	low = 0, high = n-1;
    	while(low<=high){
    	    mid = (low+high)/2;
    	    if(a[row][mid] == x){
    	        flag = 1;
    	        break;
    	    }
    	    else if(a[row][mid] > x){
    	        high = mid-1;
    	    }
    	    else{
    	        low = mid+1;
    	    }
    	}
    	if(flag == 1){
    	    return 1;
    	}
    	else if(flag == 0){
    	    return 0;
    	}
	}
}
