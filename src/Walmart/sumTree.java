package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/
public class sumTree {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-2);
        node.right = new Node(6);
        node.left.left = new Node(8);
        node.left.right = new Node(-4);
        node.right.left = new Node(7);
        node.right.right = new Node(5);

        toSumTree(node);
    }

    private static void toSumTree(Node root) {
        if(root == null) return;

        treeSum(root);
    }

    public static int treeSum(Node root){
        if(root == null){
            return 0;
        }

        int prevHead = root.data;
        root.data = treeSum(root.left) + treeSum(root.right);

        return root.data + prevHead;
    }

    private static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data=d;
            left=null;
            right=null;
        }
    }
}
