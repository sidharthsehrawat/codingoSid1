package folder.hard;

class LIPinMatrix {
    private static int ans = 0;

    public static void main(String[] args) {

        //  Below Test cases 6 :

        int[][] mat = {  // op = 5 [1,2,6,9,10]
                {9, 10, 8},
                {6, 7, 4},
                {2, 1, 1}
        };




       /* int[][] mat = { // op = 6 [1,2,6,7,8,9]
                {9, 8, 8},
                {6, 7, 4},
                {2, 1, 1}
        };*/

      /* int[][] mat = { // op = 5 [1,2,3,5,6]
                {5, 3, 8},
                {6, 2, 4},
                {2, 1, 1}
        };*/

        /*int[][] mat = { // op = 5 [-1,2,3,5,6]
                {5, 3, 8},
                {6, 2, 4},
                {2, -1, 1}
        };*/

       /* int[][] mat = { //op = 4 [3,5,6,8]
                {5, 3},
                {6, 8}
        };*/

         /*int[][] mat = { //op = 2 [3,5] or [4,8] etc ...
                {5, 3},
                {4, 8}
        };*/

      /*  int[][] mat = { //op = 2 [3,5] or [4,8] etc ...
                {-1, -1},
                {-1, -1}
        };*/

        //Empty Test cases handling..
        if (mat == null) {
            System.out.println("Enter correct matrix");
        } else if (mat.length == 0 || mat[0].length == 0) {
            System.out.println("Enter row and column properly..");
        }

        int[][] dp = new int[mat.length][mat[0].length];

        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int max = getMethod(mat, i, j, dp);
                count = Math.max(count, max);
            }
        }
        System.out.println(count);
    }

    public static int getMethod(int[][] mat, int r, int c, int[][] dp) {

        if (dp[r][c] > 0) {
            return dp[r][c];
        }

        int ans = 0;

        // base condition
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) {
            return 0;
        }

        if (r > 0 && mat[r - 1][c] > mat[r][c]) {
            int t = getMethod(mat, r - 1, c, dp);
            ans = Math.max(ans, t);
        }

        if (c > 0 && mat[r][c - 1] > mat[r][c]) {
            int l = getMethod(mat, r, c - 1, dp);
            ans = Math.max(ans, l);
        }

        if (r < mat.length - 1 && mat[r + 1][c] > mat[r][c]) {
            int b = getMethod(mat, r + 1, c, dp);
            ans = Math.max(ans, b);
        }

        if (c < mat[r].length - 1 && mat[r][c + 1] > mat[r][c]) {
            int ri = getMethod(mat, r, c + 1, dp);
            ans = Math.max(ans, ri);
        }

        dp[r][c] = ans + 1;
        return ans + 1;
    }

}
