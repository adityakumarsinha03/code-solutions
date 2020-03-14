/*

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

Solution:

vector<vector<int> > Solution::generate(int n) {
    
    vector<vector<int> >b;
    b.resize(n);
    if(n == 0){
        return b;
    }
    else if(n == 1){
        b[0].push_back(1);
        return b;
    }
    if(n == 2){
        b[0].push_back(1);
        b[1].push_back(1);
        b[1].push_back(1);
        return b;
    }
    b[0].push_back(1);
    b[1].push_back(1);
    b[1].push_back(1);
    for(int i = 2; i<n; i++){
        b[i].push_back(1);
        for(int j = 0; j<i-1; j++){
            b[i].push_back(b[i-1][j]+b[i-1][j+1]);
        }    
        b[i].push_back(1);
    }
    return b;
}
