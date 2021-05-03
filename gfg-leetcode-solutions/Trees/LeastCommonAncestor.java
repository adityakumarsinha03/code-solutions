// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1

class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
	    if(root == null)
	        return root;
	     
		// if root is greater than both n1 and n2, LCA will be on left
	    if(root.data>n1 && root.data>n2)
			return LCA(root.left, n1, n2);
	     
		// if root is less than both n1 and n2, LCA will be on right
	    if(root.data<n1 && root.data<n2)
			return LCA(root.right, n1, n2);
	       
	    return root;
    }
}