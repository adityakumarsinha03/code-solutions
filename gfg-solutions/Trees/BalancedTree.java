// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
class Height{
    int height = 0;
}
class Tree{
    boolean isBalancedUtil(Node root, Height h){
        
        if(root==null){
            h.height = 0;
            return true;
        }
            
        Height lh = new Height();
        Height rh = new Height();
        
        boolean l = isBalancedUtil(root.left, lh);
        boolean r = isBalancedUtil(root.right, rh);
        
        h.height = Math.max(lh.height, rh.height)+1;
        if(Math.abs(lh.height-rh.height)>1)
            return false;
        else
            return (l&&r);
    }
    boolean isBalanced(Node root){
        if(root==null)
            return true;
        
        Height h = new Height();
        return isBalancedUtil(root, h);
    }
}