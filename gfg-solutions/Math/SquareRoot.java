import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}

class Solution
{
     long floorSqrt(long x)
	 {
	     long ans = 0;
	     while(ans*ans<x){
	         ans++;
	     }
	     if(ans*ans>x)
	        return ans-1;
	     else
	        return ans;
	 }
}
