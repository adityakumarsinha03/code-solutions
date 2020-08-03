public class BooleanParenthesization {
    public static int modInt = 1003;

    public static int booleanParenthesizationOptimized(String str, int i, int j, int isTrue, int[][][] dp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1 && str.charAt(i) == 'T')
                return 1;
            else if (isTrue == 1 && str.charAt(i) == 'F')
                return 0;
            if (isTrue == 0 && str.charAt(i) == 'F')
                return 1;
            else if (isTrue == 0 && str.charAt(i) == 'T')
                return 0;
        }
        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        int lTrue = 1, lFalse = 1, rTrue = 1, rFalse = 1;
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            // int lTrue = booleanParenthesizationOptimized(str, i, k-1, true, dp);
            if (dp[i][k - 1][1] != -1)
                lTrue = dp[i][k - 1][1];
            else
                lTrue = booleanParenthesizationOptimized(str, i, k - 1, 1, dp);

            // int lFalse = booleanParenthesizationOptimized(str, i, k-1, false, dp);
            if (dp[i][k - 1][0] != -1)
                lFalse = dp[i][k - 1][0];
            else
                lFalse = booleanParenthesizationOptimized(str, i, k - 1, 0, dp);

            // int rTrue = booleanParenthesizationOptimized(str, k+1, j, true, dp);
            if (dp[k + 1][j][1] != -1)
                rTrue = dp[k + 1][j][1];
            else
                rTrue = booleanParenthesizationOptimized(str, k + 1, j, 1, dp);

            // int rFalse = booleanParenthesizationOptimized(str, k+1, j, false, dp);
            if (dp[k + 1][j][0] != -1)
                rFalse = dp[k + 1][j][0];
            else
                rFalse = booleanParenthesizationOptimized(str, k + 1, j, 0, dp);

            if (str.charAt(k) == '&') {
                if (isTrue == 1)
                    ans = (ans + (lTrue * rTrue)) % modInt;
                else
                    ans = (ans + (lTrue * rFalse) + (lFalse * rTrue) + (lFalse * rFalse)) % modInt;
            } else if (str.charAt(k) == '|') {
                if (isTrue == 1)
                    ans = (ans + (lTrue * rTrue) + (lTrue * rFalse) + (lFalse * rTrue)) % modInt;
                else
                    ans = (ans + (lFalse * rFalse)) % modInt;
            } else if (str.charAt(k) == '^') {
                if (isTrue == 1)
                    ans = (ans + (lTrue * rFalse) + (lFalse * rTrue)) % modInt;
                else
                    ans = (ans + (lTrue * rTrue) + (lFalse * rFalse)) % modInt;
            }
        }
        return dp[i][j][isTrue] = ans;
    }

    public static int booleanParenthesization(String str, int i, int j, boolean isTrue, Map<String, Integer> mp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == true && str.charAt(i) == 'T')
                return 1;
            else if (isTrue == true && str.charAt(i) == 'F')
                return 0;
            public class BooleanParenthesization {

            }
            if (isTrue == false && str.charAt(i) == 'F')
                return 1;
            else if (isTrue == false && str.charAt(i) == 'T')
                return 0;
        }
        StringBuilder strBldr = new StringBuilder();
        strBldr.append(i).append("_").append(j).append("_").append(isTrue);
        if (mp.containsKey(strBldr.toString()) == true) {
            return mp.get(strBldr.toString());
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lTrue = booleanParenthesization(str, i, k - 1, true, mp);
            int lFalse = booleanParenthesization(str, i, k - 1, false, mp);
            int rTrue = booleanParenthesization(str, k + 1, j, true, mp);
            int rFalse = booleanParenthesization(str, k + 1, j, false, mp);

            if (str.charAt(k) == '&') {
                if (isTrue == true)
                    ans = (ans + (lTrue * rTrue)) % modInt;
                else
                    ans = (ans + (lTrue * rFalse) + (lFalse * rTrue) + (lFalse * rFalse)) % modInt;
            } else if (str.charAt(k) == '|') {
                if (isTrue == true)
                    ans = (ans + (lTrue * rTrue) + (lTrue * rFalse) + (lFalse * rTrue)) % modInt;
                else
                    ans = (ans + (lFalse * rFalse)) % modInt;
            } else if (str.charAt(k) == '^') {
                if (isTrue == true)
                    ans = (ans + (lTrue * rFalse) + (lFalse * rTrue)) % modInt;
                else
                    ans = (ans + (lTrue * rTrue) + (lFalse * rFalse)) % modInt;
            }
        }
        mp.put(strBldr.toString(), new Integer(ans));
        return ans;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int len = str.length();

            boolean isTrue = true;
            Map<String, Integer> mp = new HashMap<>();
            System.out.println(booleanParenthesization(str, 0, len - 1, isTrue, mp));

            int isTrueInt = 1;
            int[][][] dp = new int[len + 1][len + 1][2];
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= len; j++) {
                    for (int k = 0; k < 2; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }
            System.out.println(booleanParenthesizationOptimized(str, 0, len - 1, isTrueInt, dp));
            t--;
        }
    }
}