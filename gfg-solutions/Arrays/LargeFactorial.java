import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(str[i]);
            }

            Solution ob = new Solution();
            
            long res[] = ob.factorial(a,n);
            
            for (int i=0; i<n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public long[] factorial(long a[], int n) {
        long b = (1000*1000*1000)+7;
        
        long[] fact = new long[100001];
        fact[0] = 1;
        for(int i = 1; i<=100000; i++){
            
            long temp = ((fact[i-1]%b)*(i%b))%b;
            // java.math.BigInteger t1 = java.math.BigInteger.valueOf(fact[i-1]);
            // java.math.BigInteger t2 = java.math.BigInteger.valueOf(i);
            // java.math.BigInteger t3 = (t1.multiply(t2)).mod(java.math.BigInteger.valueOf(b));
            
            // long temp = t3.longValue();
            fact[i] = temp;
        }
        
        long[] ans = new long[n];
        for(int i = 0; i<n; i++){
            int x = (int)a[i];
            // System.out.println(x + " " + fact[x]);
            ans[i] = fact[x];
        }
            
        return ans;
    }
}