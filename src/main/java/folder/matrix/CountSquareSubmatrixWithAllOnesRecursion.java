package folder.matrix;

public class CountSquareSubmatrixWithAllOnesRecursion {
    public static void main(String[] args) {
        /*int[][] mat = {
                {0,1,1},  // 5 = 1*1
                {0,1,1},  // 2 = 1*2
                {0,0,1}   // 2 = 2*1
        }; */               // 1 = 2*2
        // 1 = 3*1  = (11) ans

        int[][] mat = {
                {0, 0, 1},  // 5 = 1*1
                {0, 1, 1},  // 2 = 1*2
                {0, 1, 0}   // 2 = 2*1
        };

        int[][] dp = {
                {0, 0, 1},  // 5 = 1*1
                {0, 1, 3},  // 2 = 1*2
                {0, 2, 0}   // 2 = 2*1
        };
        int ans = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                if (mat[r][c] == 1) {
                    ans += funcM(r, c, mat);
                }
            }
        }
        System.out.println(ans);
    }

    private static int funcM(int r, int c, int[][] mat) {
        if (r >= mat.length || c >= mat[r].length || mat[r][c] == 0) {
            return 0;
        }


        int r1 = funcM(r + 1, c, mat);
        int c1 = funcM(r, c + 1, mat);
        int d1 = funcM(r + 1, c + 1, mat);

        return Math.min(r1, Math.min(c1, d1)) + 1;
    }
}
