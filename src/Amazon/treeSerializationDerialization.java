package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
public class treeSerializationDerialization {

    // tree node class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // main class
    static class BinaryTree {
        TreeNode root;

        // Func1
        public static String serialize(TreeNode root)
        {
            if (root == null) {
                return null;
            }
            Stack<TreeNode> s = new Stack<>();
            s.push(root);

            List<String> l = new ArrayList<>();
            while (!s.isEmpty()) {
                TreeNode t = s.pop();
                if (t == null) {
                    l.add("#");
                }
                else {
                    l.add("" + t.val);
                    s.push(t.right);
                    s.push(t.left);
                }
            }
            return String.join(",", l);
        }

        static int t;

        // Func2
        public static TreeNode deserialize(String data)
        {
            if (data == null)
                return null;
            t = 0;
            String[] arr = data.split(",");
            return helper(arr);
        }

        public static TreeNode helper(String[] arr)
        {
            if (arr[t].equals("#"))
                return null;

            TreeNode root = new TreeNode(Integer.parseInt(arr[t]));
            t++;
            root.left = helper(arr);
            t++;
            root.right = helper(arr);
            return root;
        }

        static void inorder(TreeNode root)
        {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.val + " ");
                inorder(root.right);
            }
        }

        // driver code
        public static void main(String[] args)
        {
            BinaryTree tree = new BinaryTree();
            tree.root = new TreeNode(20);
            tree.root.left = new TreeNode(8);
            tree.root.right = new TreeNode(22);
            tree.root.left.left = new TreeNode(4);
            tree.root.left.right = new TreeNode(12);
            tree.root.left.right.left = new TreeNode(10);
            tree.root.left.right.right = new TreeNode(14);

            String serialized = serialize(tree.root);
            System.out.println("Serialized view of the tree:");
            System.out.println(serialized);
            System.out.println();

            TreeNode t = deserialize(serialized);

            System.out.println("Inorder Traversal of the tree constructed from serialized String:");
            inorder(t);
        }
    }
}
