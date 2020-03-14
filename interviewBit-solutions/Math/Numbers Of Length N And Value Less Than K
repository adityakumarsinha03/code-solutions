/*

Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  3 0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  4 0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9

*/

Solution:

vector <int> numToVec(int N) {   
    vector<int> digit;
    while(N != 0) {
        digit.push_back(N % 10);
        N = N / 10;
    }
    if(digit.size() == 0)
        digit.push_back(0);

    reverse(digit.begin(), digit.end());
    return digit; 
}

int Solution:: solve(vector<int> &A, int B, int C) {
    vector<int> digit;
    int  d, d2;
    // Convert number to digit array
    digit = numToVec(C);
    d = A.size();

    //Case 1
    if(B > digit.size()  || d == 0)
        return 0;

    // Case 2
    else if(B < digit.size()) {
        // contain 0
        if(A[0] == 0 && B != 1)
            return (d - 1) * pow(d, B - 1);
        else 
            return pow(d, B);
    }

    //Case 3
    else {
          int dp[B + 1], lower[11];
          for(int i = 0; i <= B; i++)
              dp[i] = 0;
          for(int i = 0; i <= 10; i++)
              lower[i] = 0;
          for(int i = 0; i < d; i++)
              lower[A[i] + 1] = 1;

          for(int i = 1; i <= 10; i++)
              lower[i] = lower[i-1] + lower[i]; 

          bool flag = true;
          dp[0] = 0;
          for(int i = 1; i <= B; i++) {
              d2 = lower[digit[i-1]];
              dp[i] = dp[i-1] * d;

              // For first index we can't use 0
             if(i == 1 &&  A[0] == 0 && B != 1)
                 d2 = d2 - 1;

             //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
             if(flag)
                 dp[i] += d2;
             //Is digit[i - 1] present in A ?
                flag = flag & (lower[digit[i-1] + 1] == lower[digit[i-1]] + 1);
        }
    return dp[B];                   
    } 
}


/*int Solution::solve(vector<int> &a, int b, int c) {
    
    long long n = a.size();
    long long ans = 0;
    if(b == 0 || n == 0){
        return 0;
    }
    long long p = c;
    vector<int>cdig;
    int g;
    while(p>0){
        g = p%10;
        cdig.push_back(g);
        p = p/10;
    }
    if(b>cdig.size() || b>d){
        return 0;
    }
    else if(cdig.size() > b){
        int zeron = 0;
        int k  = 0;
        if(b != 1){
            while(a[k] == 0){
                zeron++;
                k++;
            }
            ans = (n-zeron);
        }
        else{
            ans = n;
        }
        for(int i = 1; i<b; i++){
            ans = ans*n;
        }
        return ans;
    }
    else{
        int dp[b+1];
        dp[0] = 0;
        for(int i = 1; i<=b; i++){
            if(){ // less
                dp[i]+=(dp[i-1]*n);
            }
            else if(){ // equal
                int y = cdig[i];
                int county = 0;
                for(int k = 0; k<n; k++){
                    if(a[k]<y){
                        county++;
                    }
                }
                dp[i]+=county;
            }
        }
        return dp[b];
    }*/
    /*long long ans = 0;
    long long p = c;
    vector<int>cdig;
    int g;
    while(p>0){
        g = p%10;
        cdig.push_back(g);
        p = p/10;
    }
    if(cdig.size()<b){
        return 0;
    }
    else if(cdig.size() > b){
        int zeron = 0;
        int k  = 0;
        if(b != 1){
            while(a[k] == 0){
                zeron++;
                k++;
            }
            ans = (n-zeron);
        }
        else{
            ans = n;
        }
        for(int i = 1; i<b; i++){
            ans = ans*n;
        }
        return ans;
    }
    else if(cdig.size() == b){
        long long muln = 1;
        for(int i = 0; i<cdig.size()-1; i++){
            muln = muln*n;
        }
        //cout << "muln= " << muln << endl;
        long long count1;
        int countb = 0;
        if(b == 1){
            for(int i = 0; i<n; i++){
                if(a[i]<c){
                    ans++;
                }
            }
            return ans;
        }
        int m = cdig.size()-1;
        int flag = 0;
        while(m>=0 && countb < b){
            int q = cdig[m];
            if(m == cdig.size()-1){
                int j = 0;
                count1 = 0;
                while(a[j] <= q && j<n){
                    if(a[j]!=0 && a[j]!=q){
                        count1++;
                    }
                    if(a[j] == q){
                        flag = 1;
                    }
                    j++;
                }
                //cout << "count1*muln= " << count1*muln << endl;
                ans+=count1*muln;
                if(ans == 0 && flag == 0){
                    return 0;
                }
            }
            else{
                int flag2 = 0;
                for(int l = 0; l<n; l++){
                    if(a[l] == cdig[m+1]){
                        flag2 = 1;
                        break;
                    }
                }
                if(flag2 == 0){
                    return ans;
                }
                int j = 0;
                count1 = 0;
                while(a[j] < q && j<n){
                    count1++;
                    j++;
                }
                //cout << "count1*muln= " << count1*muln << endl;
                ans+=count1*muln;
            }
            muln = muln/n;
            //cout << "muln after= " << muln << endl;
            countb++;
            m--;
        }
        return ans;
    }*/
// }
