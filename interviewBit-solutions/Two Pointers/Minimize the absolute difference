/*

Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

*/

Solution:

int Solution::solve(vector<int> &a, vector<int> &b, vector<int> &c) {
    int n1 = a.size();
    int n2 = b.size();
    int n3 = c.size();
    
    int res = INT_MAX;
    int temp;
    int j = 0, k = 0, l = 0;
    while(j<n1 && k<n2 && l<n3){
        temp = max(a[j], max(b[k], c[l]))- min(a[j], min(b[k], c[l]));
        
        if(temp<res){
            res = temp;
        }
            if(min(a[j], min(b[k], c[l])) == a[j]){
                j++;
            }
            else if(min(a[j], min(b[k], c[l])) == b[k]){
                k++;
            }
            else if(min(a[j], min(b[k], c[l])) == c[l]){
                l++;
            }
    }
    return res;
}
