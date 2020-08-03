// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0

public class EggDropping {
    public static int eggDropping(int e, int f, int[][] dp) {
        if (e == 1)
            return f;
        if (f == 0 || f == 1)
            return f;
        if (dp[e][f] != -1)
            return dp[e][f];

        int left, right, temp;
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            // temp = 1 + Math.max(eggDropping(e-1, k-1, dp), eggDropping(e, f-k, dp));

            if (dp[e - 1][k - 1] != -1) // egg breaks
                left = dp[e - 1][k - 1];
            else
                left = eggDropping(e - 1, k - 1, dp);

            if (dp[e][f - k] != -1) // egg doesn't break
                right = dp[e][f - k];
            else
                right = eggDropping(e, f - k, dp);

            temp = 1 + Math.max(left, right);
            ans = Math.min(ans, temp);
        }
        return dp[e][f] = ans;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int eggs = Integer.parseInt(strs[0]);
            int floors = Integer.parseInt(strs[1]);

            int[][] dp = new int[eggs + 1][floors + 1];
            for (int i = 0; i <= eggs; i++) {
                for (int j = 0; j <= floors; j++) {
                    dp[i][j] = -1;
                }
            }
            System.out.println(eggDropping(eggs, floors, dp));
            t--;
        }
    }
}