package folder.trees;

public class LeftViewBT {
 static  int max =0;
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(0);

        leftView(root, 1);
        max =0;
        System.out.println("======");
        rightView(root,1);
    }

    private static void rightView(TreeNode root, int curr) {
        if(root==null){
            return;
        }

        if(curr>max){
            System.out.println(root.data);
            max=curr;
        }

        rightView(root.right,curr+1);
        rightView(root.left,curr+1);

    }

    private static void leftView(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        if (curr > max) {
            System.out.println(root.data);
            max = curr;
        }
        leftView(root.left, curr + 1);
        leftView(root.right, curr + 1);
    }


}
