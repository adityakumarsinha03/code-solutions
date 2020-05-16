// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

class Solution {
    public int findJudge(int N, int[][] trust) {

        int in[] = new int[N];
        int out[] = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = 0;
            out[i] = 0;
        }

        int x, y;
        for (int i = 0; i < trust.length; i++) {
            x = trust[i][0];
            y = trust[i][1];

            in[y - 1]++;
            out[x - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (in[i] == N - 1 && out[i] == 0)
                return i + 1;
        }
        return -1;
    }
}