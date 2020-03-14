/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

*/

Solution:

void countingsort(vector<int>&a, int nd){
    int n = a.size();
    vector<int>count1(10, 0);
    vector<int>c(n, 0);
    
    for(int i = 0; i<n; i++){
        count1[(a[i]/nd)%10]++;
    }
   
    for(int i = 1; i<10; i++){
        count1[i] = count1[i-1]+count1[i];
    }
    for(int i = n-1; i>=0; i--){
        c[count1[(a[i]/nd)%10]-1] = a[i];
        count1[(a[i]/nd)%10]--;
    }
  
    for(int i = 0; i<n; i++){
        a[i] = c[i];
    }
}

int maxgap(vector<int>&a){
    
    int n = a.size();
    int maxm = *max_element(a.begin(), a.end());
    // int minm = *min_element(a.begin(), a.end());
    for(int i = 1; maxm/i >0; i*=10){
        countingsort(a, i);
    }
   
    int ans = INT_MIN;
    for(int i = 0; i<n-1; i++){
        ans = max(ans, a[i+1]-a[i]);
    }
    return ans;
}

int Solution::maximumGap(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    if(A.size()<2)
        return 0;
    vector<int>b = A;
    return maxgap(b);
}
