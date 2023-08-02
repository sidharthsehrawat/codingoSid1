package folder.trees;

public class MaximumPathSumBT {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(-10);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(4);
        Value value = new Value();
        value.result = Integer.MIN_VALUE;
        int res = maximumPathSum(root, value.result);
        System.out.println(res);
    }

///               -1
///             1     2
///           4   5
///        8    4  -10


    static class Value {
        public int result;

    }

    private static int maximumPathSum(TreeNode root, int result) {

        if (root == null) {
            return 0;
        }
        int l = maximumPathSum(root.left, result);
        int r = maximumPathSum(root.right, result);
        int m1 = Math.max(Math.max(l, r) + root.data, root.data);
        int m21 = Math.max(m1, (l + r + root.data));
        result = Math.max(m21, result);
        return m1;
    }
}
