// https://practice.geeksforgeeks.org/problems/special-keyboard/0

import java.util.*;
import java.lang.*;
import java.io.*;

class SpecialKeyboard {
    public static int specialKeyBoard(int n) {
        if (n <= 6)
            return n;
        return Math.max(4 * specialKeyBoard(n - 5), 3 * specialKeyBoard(n - 4));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            if (n > 75)
                System.out.println("-1");
            else
                System.out.println(specialKeyBoard(n));
            t--;
        }
    }
}