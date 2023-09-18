package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
          List<String> list = getMazePaths(1,1,m,n);
          System.out.println(list);
         // int countMazePath = countMazePath(1,1,m,n);
        //  System.out.println(countMazePath);
        //int mazePathII = getMazePathsII(matrix);
        //System.out.println(mazePathII);

    }

    private static int getMazePathsII(int[][] matrix) {// 0 1 2
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int res = helper(dp, matrix, 0, 0, matrix.length - 1, matrix.length - 1);
        return res;
    }

    private static int helper(int[][] dp, int[][] matrix, int i, int j, int m, int n) {
        //boundary condition
        if (i > m || j > n) {
            return 0;
        }
        if (matrix[i][j] == 1) {
            return 0;
        }
        //base condition
        if (i == m && j == n) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];

        }
        if (dp[i][j] == -1) {
            int hor = helper(dp, matrix, i, j + 1, m, n);
            int ver = helper(dp, matrix, i + 1, j, m, n);
            dp[i][j] = hor + ver;
        }
        return dp[i][j];
    }

    static int count = 0;

    private static int countMazePath(int i, int j, int m, int n) {
        // boundary condition or constraints
        if (i > m || j > n) {
            return 0;
        }

        // base case
        if (i == m && j == n) {
            return 1;
        }
        int h = countMazePath(i, j + 1, m, n);
        int v = countMazePath(i + 1, j, m, n);

        return h + v;


    }

    private static List<String> getMazePaths(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return new ArrayList<>();
        }

        if (i == m && j == n) {
            List<String> stringList = new ArrayList<>();
            stringList.add("");
            return stringList;
        }

        List<String> hor = getMazePaths(i, j + 1, m, n);
        List<String> ver = getMazePaths(i + 1, j, m, n);

        List<String> mres = new ArrayList<>();

        for (String h : hor) {
            mres.add(h + "h");
        }

        for (String v : ver) {
            mres.add(v + "v");
        }

        return mres;
    }


}
