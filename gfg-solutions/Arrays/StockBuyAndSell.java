// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

import java.util.*;
import java.lang.*;
import java.io.*;

class PairInd {
    int x;
    int y;

    PairInd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class StockBuyAndSell {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            int a[] = new int[n];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }

            List<PairInd> v = new ArrayList<>();
            int p = 0, q = 1;
            int flag;
            while (p < n && q < n) {
                flag = 0;
                q = p + 1;
                while (q - 1 >= 0 && q < n && a[p] < a[q] && a[q] > a[q - 1]) {
                    flag = 1;
                    q++;
                }
                if (flag == 1) {
                    v.add(new PairInd(p, q - 1));
                    p = q - 1;
                }
                p++;
            }
            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    System.out.print("(" + v.get(i).x + " " + v.get(i).y + ") ");
                }
                System.out.println();
            } else {
                System.out.println("No Profit");
            }
            t--;
        }
    }
}