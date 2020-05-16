// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

class Solution {
    public void floodFillUtil(int[][] image, int sr, int sc, int newColor, int m, int n, int stColor, int[][] finImage,
            int[][] vis) {

        if (sr < 0 || sc < 0 || sr >= m || sc >= n)
            return;
        if (vis[sr][sc] == 1 || image[sr][sc] != stColor)
            return;

        vis[sr][sc] = 1;
        finImage[sr][sc] = newColor;
        floodFillUtil(image, sr + 1, sc, newColor, m, n, stColor, finImage, vis);
        floodFillUtil(image, sr, sc + 1, newColor, m, n, stColor, finImage, vis);
        floodFillUtil(image, sr - 1, sc, newColor, m, n, stColor, finImage, vis);
        floodFillUtil(image, sr, sc - 1, newColor, m, n, stColor, finImage, vis);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        // System.out.println("m= " +m + " n= " +n);

        int stColor = image[sr][sc];
        int[][] finImage = image;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                vis[i][j] = -1;
        }

        floodFillUtil(image, sr, sc, newColor, m, n, stColor, finImage, vis);
        return finImage;
    }
}