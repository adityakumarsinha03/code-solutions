/*

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

*/

Solution:

int Solution::maxPoints(vector<int> &x, vector<int> &y){
    int n = x.size();
    if(n<2){
        return n;
    }
    map<pair<int, int>, int>m;
    int maxpoint = 0;
    int currmax, verti, overlap;
    for(int i = 0; i<n; i++){
        currmax = 0, verti = 0, overlap = 0;
        for(int j = i+1; j<n; j++){
            if(x[i] == x[j] && y[i]==y[j]){
                overlap++;
            }
            else if(x[i] == x[j]){
                verti++;
            }
            else{
                int xdiff = (x[j]-x[i]);
                int ydiff = (y[j]-y[i]);
                // find the gcd
                int gcd = __gcd(xdiff, ydiff);
                xdiff = xdiff/gcd;
                ydiff = ydiff/gcd;
                
                pair<int, int>p;
                p = make_pair(xdiff, ydiff);
                m[p]++;
                currmax = max(currmax, m[p]);
            }
            currmax = max(currmax, verti);
        }
        maxpoint = max(maxpoint, currmax+overlap+1);
        m.clear();
    }
    return maxpoint;
}

/*

// The code below is not able to handle vertical slope lines
#include <bits/stdc++.h>
using namespace std;

int lines(int x[], int y[], int n){    
    map<pair<int, int>, int>m;
    for(int i = 0; i<n; i++){
        int a, r, s, b, c;
        if(x[i]==0 && y[i] !=0){
            x0++;
            b = 0;
            c = 1; 
        }
        else if(x[i]!=0 && y[i] ==0){
            y0++;
            c = 0;
            b = 1; 
        }
        else if(x[i]==0 && y[i]==0){
            flag = 1;
        }
        else if(x[i] != 0 && y[i] != 0){
            a = abs(x[i]);
            r = abs(x[i]);
            s = abs(y[i]);
            b = r, c = s;
            while(a>1){
                if(r%a == 0){
                    if(s%a == 0){
                        b = r/a;
                        c = s/a;
                        break;
                    }
                }
                a--;
            }
            if((x[i]<0 && y[i]<0) || (x[i]>0 && y[i]>0)){
                b = b;
                c = c;
            }
            else{
                b = (-1)*b;
            }
        }
        if(x[i] != 0 || y[i] != 0){
            pair<int, int>p;
            p = make_pair(b, c);
            cout << p.first << " " << p.second << endl;
            if(m.find(p) == m.end()){
                m[p] = 1;
            }
            else{
                m[p]++;
            }
        }
    }
    int ans = -1;
    for(map<pair<int, int>, int>:: iterator it = m.begin(); it!=m.end(); ++it){
        if(it->second > ans){
            ans = it->second;
        }
        cout << it->first.first << " " << it->first.second << endl;
        if(flag == 1 && ((it->first.first+it->first.second == 0)||(it->first.first==it->first.second))){
            ans++;    
        }
    }
    if(ans == 1){
        ans++;
    }
    return ans;
}

int main(){
    int n = 3;
    int x[] = {1, 1, 1};
    int y[] = {0, 4, -1};
    //int t = 18;
    //vector<int>ans;
    int ans = lines(x, y, n);
    cout << ans << endl;
    return 0;
}

*/
