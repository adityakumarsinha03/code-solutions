// https://practice.geeksforgeeks.org/problems/palindromic-patitioning/0

public class PalindromePartition {
    public static int isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return 0;
            i++;
            j--;
        }
        return 1;
    }

    public static int palindromePartition(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (isPalindrome(s, i, j) == 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int left, right, temp;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            // temp = 1 + palindromePartition(s, i, k, dp) + palindromePartition(s, k+1, j,
            // dp);

            if (dp[i][k] != -1)
                left = dp[i][k];
            else
                left = palindromePartition(s, i, k, dp);
            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else
                right = palindromePartition(s, k + 1, j, dp);

            temp = 1 + left + right;
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String str = br.readLine();
            int len = str.length();

            int[][] dp = new int[len + 1][len + 1];
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= len; j++) {
                    dp[i][j] = -1;
                }
            }
            System.out.println(palindromePartition(str, 0, len - 1, dp));
            t--;
        }
    }
}