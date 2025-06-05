package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsMinDistanceWithNumbersRecursion {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int m = mat.length;
        int n = mat[0].length;

        //    List<String> list = printNumPath(1, 1, mat, m, n);
        //    System.out.println(list);

        int[][] mat1 = {
                {3, 4, 2, 4},
                {4, 1, 3, 1},
                {2, 3, 9, 2},
                {1, 2, 4, 0}  // ans  14
        };

        int list1 = printNumPathWithDP(mat1);
        System.out.println(list1);
    }

    private static int printNumPathWithDP(int[][] mat) {
        for (int i = 1; i < mat.length; i++) {
            mat[0][i] = mat[0][i - 1] + mat[0][i];
            mat[i][0] = mat[i - 1][0] + mat[i][0];
        }
         int min =0;
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                min = Math.min(mat[i-1][j], mat[i][j-1]);
                mat[i][j] = mat[i][j] + min;
            }
        }

            return mat[mat.length-1][mat[0].length-1];
    }

    private static List<String> printNumPath(int r, int c, int[][] mat, int m, int n) {

        if (r > m || c > n) {
            return new ArrayList<>();
        }
        if (r == m && c == n) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> hl = printNumPath(r,c + 1, mat, m, n);
        List<String> vl = printNumPath(r + 1, c, mat, m, n);


        List<String> finallist = new ArrayList<>();

        for (String s : vl) {
            finallist.add("" + s + mat[r - 1][c - 1]);
        }

        for (String s1 : hl) {
            finallist.add("" + s1 + mat[r - 1][c - 1]);
        }

        return finallist;
    }
}
