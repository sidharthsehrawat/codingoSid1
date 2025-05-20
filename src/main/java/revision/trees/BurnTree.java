package revision.trees;

import java.util.*;

public class BurnTree {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int node = 3;
        int res = burnTree(root,node);
        System.out.println("res " + res);
    }

    public static int burnTree(TreeNode root, int start) {

        TreeNode temp = findNode(root, start);
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        fillParent(root, parent);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        visited.add(temp);
        int min = -1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null && !visited.contains(poll.left)){
                    queue.add(poll.left);
                    visited.add(poll.left);
                }
                if(poll.right!=null && !visited.contains(poll.right)){
                    queue.add(poll.right);
                    visited.add(poll.right);
                }

                TreeNode parentNode = parent.get(poll);
                if(parentNode!=null && !visited.contains(parentNode)){
                    queue.add(parentNode);
                    visited.add(parentNode);
                }

            }
            min++;
        }
        return min;
    }

    public static void fillParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if(root == null){
            return;
        }
        if(root.left !=null){
            parent.put(root.left, root);
        }
        fillParent(root.left, parent);
        if(root.right !=null) {
            parent.put(root.right, root);
        }
        fillParent(root.right, parent);

    }

    public static TreeNode findNode(TreeNode root, int start) {
        if(root == null){
            return null;
        }

        if(root.data == start ){
            return  root;
        }
        TreeNode left  = findNode(root.left, start);
        if(left !=null) {
            return left;
        }

        TreeNode right = findNode(root.right, start);
        return right;
    }

}