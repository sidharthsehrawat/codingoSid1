package revision.trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
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
           8         8        8
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        int node = 8;
        List<Integer> list = new ArrayList<>();
        nodePath(root,node, list);
    }
    private static void nodePath(TreeNode root, int node, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.data == node){
            System.out.println("path " + list);
            list.remove(list.size()-1);
            return;
        }
        nodePath(root.left, node, list);
        nodePath(root.right,node,list);
        list.remove(list.size()-1);
    }
}

