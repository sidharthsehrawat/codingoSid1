package revision.trees;

import java.util.*;
import java.util.stream.Collectors;

public class PrintAllNodesAtDistanceOfK {
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
           9     0   8        
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        TreeNode node = root.left;
        int k = 2;
        printAllNodes(root, node, k); // 3 9 0 8
    }

    private static List<Integer> printAllNodes(TreeNode root, TreeNode node, int k) {
        if (root == null || node == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        fillParentMap(root, parent);
        int level = 0;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();

            if(level == k){
                return queue.stream().map(n -> n.data).collect(Collectors.toList());
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null && !visited.contains(poll.left)){
                   queue.add(poll.left);
                   visited.add(poll.left);
                }
                if(poll.right!=null && !visited.contains(poll.right)){
                    queue.add(poll.right);
                    visited.add(poll.right);
                }

                TreeNode treeNode = parent.get(poll);
                if(treeNode!=null && !visited.contains(treeNode)){
                    queue.add(treeNode);
                    visited.add(treeNode);
                }
            }
            level++;
        }
        return new ArrayList<>();
    }

    private static void fillParentMap(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
            fillParentMap(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            fillParentMap(root.right, parent);
        }
    }

}

