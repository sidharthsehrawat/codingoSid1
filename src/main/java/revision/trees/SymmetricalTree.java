package revision.trees;

public class SymmetricalTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /*
                     1
                 2        2
              4    5    5   4

       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        symmetricalTree(root);
    }

    private static void symmetricalTree(TreeNode root) {
        boolean res = checkSymmetry(root.left, root.right);
        System.out.println("result " + res);
    }

    private static boolean checkSymmetry(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean left = checkSymmetry(root1.left, root2.right);
        boolean right = checkSymmetry(root1.right, root2.left);
        if (root1.data == root2.data && left && right) {
            return true;
        }
        return false;
    }

}
