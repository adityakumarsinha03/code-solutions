// https://practice.geeksforgeeks.org/problems/symmetric-tree/1

/*
class of the node of the tree is as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class GfG{
    public static boolean isSymmetricUtil(Node root1, Node root2){
        if(root1==null && root2==null)
            return true;
        if((root1==null && root2!=null) || (root1!=null && root2==null))
            return false;
            
        return (root1.data==root2.data) 
                && (isSymmetricUtil(root1.left, root2.right)) 
                && (isSymmetricUtil(root1.right, root2.left));
    }
    public static boolean isSymmetric(Node root){
        if(root==null)
            return true;
            
        return isSymmetricUtil(root.left, root.right);
    }
}