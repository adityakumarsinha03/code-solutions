// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;
            currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

class Res{
    int value;
}

class Solution 
{
    //Function to return the diameter of a Binary Tree.
    int height(Node root, Res res){
        if(root == null)
            return 0;
        
        int lh = height(root.left, res);
        int rh = height(root.right, res);
        
        // diameter = 1 + leftHeight + rightHeight
        res.value = Math.max(res.value, 1+lh+rh);
        
        return 1 + Math.max(lh, rh);
    }
    int diameter(Node root) {
        if(root == null)
            return 0;
        
        Res res = new Res();
        res.value = Integer.MIN_VALUE;
        height(root, res);
        return res.value;
    }
}
