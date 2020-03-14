/*

Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

*/

Solution:

vector<int> Solution::getRow(int n) {
     
     vector<int>a, b;
     if(n == 0){
         b.push_back(1);
         return b;
     }
     else if(n == 1){
         b.push_back(1);
         b.push_back(1);
         return b;
     }
     else{
         a.push_back(1);
         a.push_back(1);
         b.push_back(1);
         b.push_back(2);
         b.push_back(1);
         if(n == 2){
             return b;
         }
         else{
             for(int i = 3; i<=n; i++){
                 a.clear();
                 a = b;
                 b.clear();
                 b.push_back(1);
                 for(int j = 0; j<a.size()-1; j++){
                     b.push_back(a[j]+a[j+1]);
                 }
                 b.push_back(1);
             }
             return b;
         }
     }
     
     /*vector<int>a(n+1, 0);
     
     a[0] = 1;
     int p, q;
     for(int i = 1; i<n+1; i++){
         q = 1;
         for(int j = 1; j<i; j++){
             p = a[j];
             a[j] = a[j]+q;
             q = p;
         }
         a[i] = 1;
     }
     return a;*/
}
