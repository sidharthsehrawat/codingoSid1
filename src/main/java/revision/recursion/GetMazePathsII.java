package revision.recursion;

public class GetMazePathsII {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int ans = getMazePaths(matrix);
        System.out.println("maze paths : " + ans);
    }

    private static int getMazePaths(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                dp[row][col] = -1;
            }
        }
        int r = 0;
        int c = 0;
        return helper(r, c, matrix, dp);
    }

    private static int helper(int r, int c, int[][] matrix, int[][] dp) {
        if (r >=matrix.length || c >=matrix[0].length || matrix[r][c] == 1) {
            return 0;
        }
        if(r == matrix.length-1 && c == matrix[0].length-1){
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int h = helper(r + 1, c, matrix, dp);
        int v = helper(r, c + 1, matrix, dp);
        return dp[r][c] = h + v;
    }
}
