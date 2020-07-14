// https://practice.geeksforgeeks.org/problems/form-a-palindrome/0

import java.util.*;
import java.lang.*;
import java.io.*;

class FormAPalindrome {
    public static int lcs(String a, String b) {
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();

            StringBuilder s1 = new StringBuilder(s);
            s1 = s1.reverse();
            System.out.println(s.length() - lcs(s, s1.toString()));
            t--;
        }
    }
}