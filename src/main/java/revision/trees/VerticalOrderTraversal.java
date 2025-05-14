package revision.trees;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Pair {
        int hd;
        TreeNode node;
        public Pair(int hd , TreeNode node){
            this.hd = hd;
            this.node = node;
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
       verticalOrderTraversal(root);

    }


    private static void verticalOrderTraversal(TreeNode root) {
        if(root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0,root));
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!map.containsKey(pair.hd)){
                List<Integer> list = new ArrayList<>();
                list.add(pair.node.data);
                map.put(pair.hd, list);
            }else {
                List<Integer> list = map.get(pair.hd);
                list.add(pair.node.data);
                map.put(pair.hd , list);
            }
            if(pair.node.left!=null){
                queue.add(new Pair(pair.hd -1 , pair.node.left));
            }
            if(pair.node.right!=null){
                queue.add(new Pair(pair.hd+1, pair.node.right));
            }
        }

        List<List<Integer>> list = map.values().stream().map(inner->inner.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()))
                .collect(Collectors.toList());


        System.out.println("ans = " + list);
    }

}