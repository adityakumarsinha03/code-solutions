/*

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 

*/

Solution:

vector<vector<int> > Solution::generateMatrix(int n) {
    
    int c[n][n];
    vector<vector<int> >b;
    b.resize(n);
    
    if(n == 1){
        b[0].push_back(1);
	    return b;
	}
	
	int h;
	if(n%2 == 0){
	    h = n/2;
	}
	else{
	   h = (n/2)+1;
	}
	int u = 1;
	for(int i = 0; i<h; i++){
    	    for(int j = i; j<n-i; j++){
    	        c[i][j] = u;
    	        u++;
    	    }
    	    for(int j = i+1; j<n-i; j++){
    	        c[j][n-i-1] = u;
    	        u++;
    	    }
    	    for(int j = n-i-2; j>=i; j--){
    	        c[n-i-1][j] = u;
    	        u++;
    	    }
    	    for(int j = n-i-2; j>=i+1; j--){
    	        c[j][i] = u;
    	        u++;
    	    }
	}
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
    	   b[i].push_back(c[i][j]);     
    	}
    }
    return b;
}
