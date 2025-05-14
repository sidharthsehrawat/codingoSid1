package revision.trees;

public class BoundaryTraversal {
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
                 2        3
              4    5    6   7
                      8
       */
        // 1 2 4 5 6 7 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        // print left subtree including root
        // print right subtree using stack excluding
        boundaryTraversal(root);

    }

    private static void boundaryTraversal(TreeNode root) {
        if(root == null) return;
        printLeftSide(root);
        printLeaf(root.left);
        printLeaf(root.right);
        printRightSide(root.right);
    }

    private static void printLeaf(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null){
            System.out.print(" " + root.data);
        }
        printLeaf(root.left);
        printLeaf(root.right);
    }

    private static void printRightSide(TreeNode root){
        if(root == null) return;
        if(root.left!=null && root.right!=null){
            System.out.print(" " + root.data);
        }

        if(root.right!=null){
            printRightSide(root.right);
        }else {
            printRightSide(root.left);
        }
    }

    private static void printLeftSide(TreeNode root) {
        if(root == null) return;
        if(root.left != null && root.right != null){
            System.out.print(" " + root.data);
        }

        if(root.left!=null){
            printLeftSide(root.left);
        }else {
            printLeftSide(root.right);
        }
    }
}