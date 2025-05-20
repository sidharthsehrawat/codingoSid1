package revision.trees;

public class FormBTTreePreAndInorder {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] preOder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        int start = 0 ;
        int end = preOder.length;
        int index =0;
        createFun(preOder, inOrder, start, end , index);
    }

    private static TreeNode createFun(int[] preOder, int[] inOrder, int start, int end, int index) {
        if(start > end){
            return null;
        }
        int i =start;
        int rootValue = preOder[index] ;
        for(;i<=end;i++){
            if(inOrder[start] == rootValue){
                break;
            }
        }
        index++;
        TreeNode root = new TreeNode(rootValue);
        root.left=  createFun(preOder,inOrder,start,i-1 ,index);
        root.right=  createFun(preOder,inOrder,i+1,end ,index);
        return root;
    }

}
