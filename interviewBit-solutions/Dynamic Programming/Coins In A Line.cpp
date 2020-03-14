/*

There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line 
until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6

*/

Solution:

int Solution::maxcoin(vector<int> &a){
    
    int n = a.size();
    vector<vector<pair<int, int> > >t(n, vector<pair<int, int> >(n));
	for(int i = 0; i<n; i++){
	    t[i][i].first = a[i];
	    t[i][i].second = 0;
	}
	for(int j = 1; j<n; j++){
	    int k = j;
	    for(int i = 0; i<n-j && k<n; i++){
	        if(a[i]+t[i+1][k].second > a[k]+t[i][k-1].second){
	            t[i][k].first = a[i]+t[i+1][k].second; // if left side is picked
	            t[i][k].second = t[i+1][k].first; 
	        }
	        else{
	            t[i][k].first = a[k]+t[i][k-1].second; // if right side is picked
	            t[i][k].second = t[i][k-1].first;
	        }
	        k++;
	    }
	}
    return t[0][n-1].first;
}
