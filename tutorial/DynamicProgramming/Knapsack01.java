import java.util.*;
import java.lang.*;
import java.io.*;

class Knapsack01 {
	public static int knapsack(int[] price, int[] weight, int w, int n, int[][] dp) {
		if (n == 0 || w == 0)
			return 0;
		if (dp[n][w] != -1)
			return dp[n][w];
		if (weight[n - 1] > w)
			return dp[n][w] = knapsack(price, weight, w, n - 1, dp);
		else {
			return dp[n][w] = Math.max(price[n - 1] + knapsack(price, weight, w - weight[n - 1], n - 1, dp),
					knapsack(price, weight, w, n - 1, dp));
		}
	}

	public static void main(String[] args) throws IOException {

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {

			int n = Integer.parseInt(br.readLine());
			int w = Integer.parseInt(br.readLine());

			int price[] = new int[n];
			String line = br.readLine();
			String[] strs = line.trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				price[i] = Integer.parseInt(strs[i]);
			}
			int weight[] = new int[n];
			line = br.readLine();
			strs = line.trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(strs[i]);
			}

			int[][] dp = new int[n + 1][w + 1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= w; j++) {
					dp[i][j] = -1;
				}
			}
			System.out.println(knapsack(price, weight, w, n, dp));
			t--;
		}

	}
}