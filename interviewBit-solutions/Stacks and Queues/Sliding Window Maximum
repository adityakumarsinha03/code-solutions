/*

A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the 
array to the very right. You can only see the w numbers in the window. Each time the sliding window moves 
rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 

*/

Solution:

vector<int> Solution::slidingMaximum(const vector<int> &a, int k){
    
    int n = a.size();
    vector<int>ans;
    
    if(k>=n){
        int y = *max_element(a.begin(), a.end());
        ans.push_back(y);
        return ans;
    }
    deque<int>q;

    for(int i = 0; i<k; i++){
        while(!q.empty() && a[q.back()]<=a[i]){
            q.pop_back();
        }
        q.push_back(i);
    }
    ans.push_back(a[q.front()]);
    
    for(int i = k; i<n; i++){
        while(!q.empty() && q.front() <= i-k){
            q.pop_front();
        }
        while(!q.empty() && a[q.back()]<=a[i]){
            q.pop_back();
        }
        q.push_back(i);
        ans.push_back(a[q.front()]);
    }
    return ans;
}
