package revision.trees;

public class ChildrenSumProperty {
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
                     10
                 4        6
              4        2    3

       */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        boolean res = childerSum(root);
        System.out.println("result " + res);
    }

    private static boolean childerSum(TreeNode root) {
        return checkChilder(root) == root.data;
    }

    private static int checkChilder(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.data;
        }

        int left = checkChilder(root.left);
        int right = checkChilder(root.right);

        if (left == -1 || right == -1) return -1;

        return root.data == left + right ? root.data : -1;
    }
}

