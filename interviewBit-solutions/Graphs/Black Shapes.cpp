/*

Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

*/

Solution:

void dfsUtil(vector<string>&a, int i, int j){
    
    if(i<0 || i>=a.size() || j<0 || j>=a[i].size()){
        return;
    }
    if(a[i][j] == 'O'){
        return;
    }
    a[i][j] = 'O';
    dfsUtil(a, i+1, j);
    dfsUtil(a, i, j+1);
    dfsUtil(a, i-1, j);
    dfsUtil(a, i, j-1);
}

int Solution::black(vector<string> &a){
    
    int count = 0;
    for(int i = 0; i<a.size(); i++){
        for(int j = 0; j<a[i].size(); j++){
            if(a[i][j] == 'X'){
                dfsUtil(a, i, j);
                count++;
            }
        }
    }
    return count;
}
