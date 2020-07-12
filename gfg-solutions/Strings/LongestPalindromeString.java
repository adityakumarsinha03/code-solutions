// https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalindromeString {
    public static boolean checkPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalin(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                maxLen = 2;
            }
        }
        for (int gap = 3; gap <= n; gap++) {
            for (int i = 0; i < n - gap + 1; i++) {
                int j = i + gap - 1;
                if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                    maxLen = Math.max(maxLen, gap);
                }
            }
        }

        for (int i = 0; i < n - maxLen + 1; i++) {
            String str = s.substring(i, i + maxLen);
            if (checkPalin(str) == true) {
                return str;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            System.out.println(longestPalin(s));
            t--;
        }
    }
}