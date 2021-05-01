// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0

import java.util.*;
import java.lang.*;
import java.io.*;

class LargestNumberFromArray {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            List<String> strsList = Arrays.asList(strs);
            Collections.sort(strsList, (a, b) -> {
                return (b + a).compareTo(a + b);
            });

            for (int i = 0; i < strsList.size(); i++) {
                System.out.print(strsList.get(i));
            }
            System.out.println();
            t--;
        }
    }
}