/*

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

*/

Solution:

vector<int> Solution::maxset(vector<int> &a) {
    
    int n = a.size();
    vector<int>b, c;
    int sb, eb, sc, ec;
    long long sumc = 0, sumb = 0;
    for(int i = 0; i<n; ){
        sumc = 0;
        sc = i;
        c.erase(c.begin(), c.end());
        while(a[i] >= 0 && i<n){
            c.push_back(a[i]);
            sumc+=a[i];
            i++;
        }
        if(sumc > sumb){
            b.erase(b.begin(), b.end());
            b = c;
            sb = sc;
            sumb = sumc;
            c.erase(c.begin(), c.end());
        }
        else if(sumc == sumb){
            if(b.size()<c.size()){
                b.erase(b.begin(), b.end());
                b = c;
                sb = sc;
                c.erase(c.begin(), c.end());
            }
            else if(b.size() == c.size()){
                if(sb > sc){
                    b.erase(b.begin(), b.end());
                    b = c;
                    c.erase(c.begin(), c.end());
                }
            }
        }
        i++;
    }
    return b;
}
