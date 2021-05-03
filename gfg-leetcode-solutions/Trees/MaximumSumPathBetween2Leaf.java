// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class Res{
    int value;
}
class Tree
{
    int maxPathSumUtil(Node root, Res res){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return root.data;
        
        int ls = maxPathSumUtil(root.left, res); // left-subtree
        int rs = maxPathSumUtil(root.right, res); // right-subtree
        
        if(root.left != null && root.right != null){
            // update the maximum sum
            res.value = Math.max(res.value, ls+rs+root.data);
            
            // return maximum sum for the root
            return Math.max(ls, rs) + root.data;
        } else if(root.left == null){ // if left is not present
            return rs + root.data; // return (rightSubtree + node)
        } else{
            return ls + root.data; // return (leftSubtree + node)
        }
    }
    int maxPathSum(Node root)
    {
        if(root == null)
            return 0;
          
        Res res = new Res();  
        res.value = Integer.MIN_VALUE;
        maxPathSumUtil(root, res);
        
        return res.value;
    } 
}