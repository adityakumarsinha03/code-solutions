// https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            RomanToNumber rn = new RomanToNumber();
            System.out.println(rn.romanToDecimal(roman));
        }
    }
}

class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int getVal(char c){
        if(c == 'I')    return 1;
        if(c == 'V')    return 5;
        if(c == 'X')    return 10;
        if(c == 'L')    return 50;
        if(c == 'C')    return 100;
        if(c == 'D')    return 500;
        if(c == 'M')    return 1000;
        return 0;
    }
    public int romanToDecimal(String str) {
        int ans = 0;
        for(int i = 0; i<str.length(); i++){
            int s1 = getVal(str.charAt(i));
            if(i+1<str.length()){
                int s2 = getVal(str.charAt(i+1));
                if(s1<s2){
                    ans += (s2-s1);
                    i++;
                } else
                    ans += s1;
            } else{
                ans += s1;
            }
        }
        return ans;
    }
}