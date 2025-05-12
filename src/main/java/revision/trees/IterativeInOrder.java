package revision.trees;

import java.util.Stack;

public class IterativeInOrder {

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
       */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        iterate(root); // 4 2 5 1 6 3 7
    }

    private static void iterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        TreeNode temp = root ;
        while (!stack.isEmpty() || temp !=null) {
            if (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
            else {
                    temp = stack.pop();
                    System.out.print(" " + temp.data);
                    temp = temp.right;
            }
        }
    }
}
