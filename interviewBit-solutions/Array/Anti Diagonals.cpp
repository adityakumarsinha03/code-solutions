/*

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]


*/

Solution:

vector<vector<int> > Solution::diagonal(vector<vector<int> > &a) {

    vector<vector<int> >b;
    
    int n = a.size();
    b.resize((2*n)-1);
    if(n == 1){
        b[0].push_back(a[0][0]);
        return b;
    }
    else if(n == 2){
        b[0].push_back(a[0][0]);
        b[1].push_back(a[0][1]);
        b[1].push_back(a[1][0]);
        b[2].push_back(a[1][1]);
        return b;
    }
    b[0].push_back(a[0][0]);
    for(int i = 1; i<=n-1; i++){
        for(int j = i; j>=0; j--){
            b[i].push_back(a[i-j][j]);
        }
    }
    for(int i = 0; i<n-2; i++){
        for(int j = n-2+1; j>=i+1; j--){
            b[n-2+2+i].push_back(a[n-2+2+i-j][j]);
        }
    }
    b[(2*n)-2].push_back(a[n-1][n-1]);
    return b;
}
