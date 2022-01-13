package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/
public class connectSameLvlNodes {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);

        TreeNode ans = connect(node);
    }

    public static TreeNode connect(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode right = null;
            for(int i = q.size(); i > 0; i--) {

                TreeNode curr = q.poll();
                curr.next = right;
                right = curr;

                if(curr.right != null) {
                    q.offer(curr.right);
                    q.offer(curr.left);
                }
            }
        }

        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
