package revision.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MaxWidth {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        /*
                     1
                 2       3
              4    5       7
                           
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        maxWidth(root);
    }

    private static void maxWidth(TreeNode root) {
        if (root == null) return;
        int max = 1;
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addFirst(new Pair(root, 0));

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                Pair pair = deque.pollFirst();
                size--;
                if (pair != null && pair.node.left != null) {
                    deque.offer(new Pair(pair.node.left, 2 * pair.index + 1));
                }
                if (pair != null && pair.node.right != null) {
                    deque.offer(new Pair(pair.node.right, 2 * pair.index + 2));
                }
            }
            if (!deque.isEmpty()) {
                int index1 = deque.peekFirst().index;
                int index2 = deque.peekLast().index;
                max = Math.max(max, index2 - index1 + 1);
            }
        }

        System.out.println("max width is " + max);
    }
}

