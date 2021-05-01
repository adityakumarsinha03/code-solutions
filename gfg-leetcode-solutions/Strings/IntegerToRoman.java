// https://practice.geeksforgeeks.org/problems/convert-to-roman-no/1

import java.util.Scanner;
import java.util.*;

class IntegerToRoman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			GfG g = new GfG();
			System.out.println (g.convertToRoman(N));
			t--;
		}
	}
}

class GfG
{
    String convertToRoman(int n)
    {
        int num[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String rom[] = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        
        String ans = "";
        int index = 12;
        
        while(index >= 0){
            int quotient = n/num[index];
            int remaind = n%num[index];
            n = remaind;
            
            while(quotient-- > 0){
                ans += rom[index];
            }
            index--;
        }
        return ans;
    }
}