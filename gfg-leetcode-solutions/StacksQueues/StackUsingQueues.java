// https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1

import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

class GfG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t>0)
		{
			StackQueue g = new StackQueue();
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryTyoe = sc.nextInt();
				if(QueryTyoe == 1)
				{
					int a = sc.nextInt();
					g.Push(a);
				}else
				if(QueryTyoe == 2)
				System.out.print(g.Pop()+" ");
			q--;
				
			}
			System.out.println();
		t--;
		}
	}
}

class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        s1.push(x);
    }
	
    void transfer(Stack<Integer> s1, Stack<Integer> s2){
        while(!s1.isEmpty()){
            int top = s1.peek();
            s1.pop();
            s2.push(top);
        }
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        int top = -1;
        if(!s1.isEmpty()){
            transfer(s1, s2);
            top = s2.peek();
            s2.pop();
            transfer(s2, s1);
        }
        return top;
    }
}
