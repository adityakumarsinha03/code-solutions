// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveAllAdjacentDuplicates {
    public static int checkDup(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i))
                return 1;
        }
        return 0;
    }

    public static String remDup(String s) {
        String ans = Character.toString(s.charAt(0));

        int flag = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toString(s.charAt(i)).equals(Character.toString(ans.charAt(ans.length() - 1)))) {
                flag = 1;
            } else {
                if (flag == 1) {
                    flag = 0;
                    ans = (ans == null || ans.length() == 0) ? null : (ans.substring(0, ans.length() - 1));
                }
                ans += Character.toString(s.charAt(i));
            }
        }
        if (flag == 1) {
            flag = 0;
            ans = (ans == null || ans.length() == 0) ? null : (ans.substring(0, ans.length() - 1));
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();

            String ans = s;
            while (checkDup(ans) > 0) {
                ans = remDup(ans);
            }
            System.out.println(ans);
            t--;
        }
    }
}