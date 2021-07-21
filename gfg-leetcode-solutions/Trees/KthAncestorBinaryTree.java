
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Solution
{
    public static Node kthAncestor(Node root, int target, int k)
    {
        if(root == null)
            return null;
            
        if(root.data == target || ancestorsUtil(root.left, target) != null || ancestorsUtil(root.right, target) != null){
            if(k>0)
				k--;
			else if(k == 0){
				System.out.println(root.data);
				return null;
			}
			return root;
        } else
            return null;
    }
}