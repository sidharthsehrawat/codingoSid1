package folder.trees;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class IsSumTreeBalance {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        int res = isSumTree(root, 0, 0);
    }
private  static int max = 0;
    private static TreeNode node  = null;
    private static int isSumTree(TreeNode root, int lSum, int rSum) {
        if (root == null) {
            return 0;
        }
        isSumTree(root.left, lSum, rSum);
        lSum = lSum + root.data;
        isSumTree(root.left, lSum, rSum);
        rSum = rSum + root.data;

        if(lSum == rSum){
           if(lSum > max){
               max = lSum;
               node = root;
           }
        }

        return lSum+ rSum + root.data;

    }
}
