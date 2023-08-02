package folder.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewUsingLevelOrder {

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
        leftView(root);
    }

    private static void leftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    System.out.println(node.data);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }

            // right view
            /*for (int i = n - 1; i >= 0; i--) {
                TreeNode node = queue.poll();

                if (i == n - 1) {
                    System.out.println(node.data);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

            }*/
        }
    }
}
