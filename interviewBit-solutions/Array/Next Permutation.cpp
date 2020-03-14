/*

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

*/

Solution:

void Solution::nextPermutation(vector<int> &a){
    
    int n = a.size();
    int k;
    int flag = 0;
    for(int i = n-1; i>0; i--){
        if(a[i] > a[i-1]){
            k = i-1;
            flag = 1;
            break;
        }
    }
    if(flag == 0){
        sort(a.begin(), a.end());
        return;
    }
    int maxm = a[k+1];
    int ind = k+1;
    for(int i = k+2; i<n; i++){
        if(a[i] > a[k] && a[i]<maxm){
            maxm = a[i];
            ind = i;
        }
    }
    //cout << "k= " << k << endl;
    //cout << "ind= " << ind << endl;
    //cout << "maxm= " << maxm << endl;
    //cout << "a[k]= " << a[k] << endl;
    int temp = a[k];
    a[k] = maxm;
    a[ind] = temp;
    sort(a.begin()+k+1, a.end());
    return;
}
