// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

import java.util.*;
import java.lang.*;
import java.io.*;

class StringPermutation {
    public static String swapChars(String s, int left, int right) {

        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(left, s.charAt(right));
        sb.setCharAt(right, s.charAt(left));
        return sb.toString();
    }

    public static void perm(String s, int left, int right, ArrayList<String> arr) {
        if (left == right) {
            arr.add(s);
        } else {
            for (int i = left; i <= right; i++) {
                s = swapChars(s, left, i);
                perm(s, left + 1, right, arr);
                s = swapChars(s, left, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            ArrayList<String> arr = new ArrayList<String>();
            String s = br.readLine();
            perm(s, 0, s.length() - 1, arr);

            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            t--;
        }
    }
}