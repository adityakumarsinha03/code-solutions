// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1

/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Tree
{
    int height(Node node){
        if(node == null)
            return 0;
        
        else{
            int lh = height(node.left);
            int rh = height(node.right);
            
            return Math.max(lh, rh)+1;
        }
    }   
}