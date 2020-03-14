// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

/*
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Tree{
	boolean isIdentical(Node root1, Node root2){
	    if(root1==null && root2==null)
            return true;
        if((root1==null && root2!=null) || (root1!=null && root2==null))
            return false;
            
        return (root1.data==root2.data) 
                && (isIdentical(root1.left, root2.left)) 
                && (isIdentical(root1.right, root2.right));
	}
}