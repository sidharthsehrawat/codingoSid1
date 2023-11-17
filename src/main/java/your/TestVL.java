package your;

import java.util.ArrayList;
import java.util.List;

public class TestVL {
    public static void main(String[] args) {
        int[][] mat = {
                {0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, -2}};
        // output =  15
        List<List<Integer>> list = maxSumSubmatrix(mat);
        System.out.println(list);
    }

    private static List<List<Integer>> maxSumSubmatrix(int[][] mat) {
        int maxtop = 0;
        int maxBottom = 0;
        int maxleft = 0;
        int maxright = 0;
        int L;
        int R;
        int maxSum = Integer.MIN_VALUE;
        int currSum;

        for (int c = 0; c < mat[0].length; c++) {
            L = c;
            int[] arr = new int[mat.length];
            for (int c1 = c; c1 < mat[0].length; c1++) {
                R = c1;
                for (int r = 0; r < mat.length; r++) {
                    arr[r] = arr[r] + mat[r][c1];
                }
                int[] res = kadaneAlgo(arr);
                currSum = res[0];
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxtop = res[1];
                    maxBottom = res[2];
                    maxleft = L;
                    maxright = R;
                }
            }
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for (int mrow = maxtop; mrow <=maxBottom; mrow++) {
            List<Integer> list = new ArrayList<>();
            for (int mcol = maxleft; mcol <=maxright; mcol++) {
                list.add(mat[mrow][mcol]);
            }
            finalList.add(list);
        }
        System.out.println("MaxSum :" + maxSum);
        return finalList;
    }

    private static int[] kadaneAlgo(int[] arr) {
        int[] res = new int[3];
        int maxSum = Integer.MIN_VALUE;
        int currSum1 = 0;
        int top = 0;
        int bottom = 0;
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum1 = currSum1 + arr[i];
            if (currSum1 > maxSum) {
                bottom = i;
                top = x;
                maxSum = currSum1;
            }
            if (currSum1 < 0) {
                currSum1 = 0;
                x = i+1;
            }
        }
        res[0] = maxSum;
        res[1] = top;
        res[2] = bottom;
        return res;
    }
}
