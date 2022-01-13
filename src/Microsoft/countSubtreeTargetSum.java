package Microsoft;

// https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/
public class countSubtreeTargetSum {
    public static void main(String[] args) {
        int x = 7;

        Treenode node = new Treenode(5);
        node.left = new Treenode(-10);
        node.right = new Treenode(3);
        node.left.left = new Treenode(9);
        node.left.right = new Treenode(8);
        node.right.left = new Treenode(-4);
        node.right.right = new Treenode(7);

        System.out.println(countSubtreesWithSumX(node, x));
    }

    public static int countSubtreesWithSumX(Treenode root, int X) {
        count = 0;
        subTreeSum(root, X);
        return count;
    }

    static int count;
    private static int subTreeSum(Treenode root, int X) {
        if(root==null) {
            return 0;
        }
        int sum = root.val + subTreeSum(root.left, X) + subTreeSum(root.right, X);
        if(sum==X) {
            count++;
        }
        return sum;
    }
}

class Treenode {
    int val;
    Treenode left;
    Treenode right;


    Treenode() {
    }

    Treenode(int val) {
        this.val = val;
    }

    Treenode(int val, Treenode left, Treenode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
