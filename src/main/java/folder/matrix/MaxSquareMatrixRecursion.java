package folder.matrix;

public class MaxSquareMatrixRecursion {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1}
        };

        int res = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                int maxx = 0;
                maxx = Math.max(maxx, func(r, c, mat));
                if (maxx > res) {
                    res = maxx;
                }

            }
        }

        System.out.println(res * res);

    }

    private static int func(int r, int c, int[][] mat) {

        //base condition
        if (r >= mat.length || c >= mat[r].length || mat[r][c] == 0) {
            return 0;
        }

        int r1 = func(r + 1, c, mat);
        int c1 = func(r, c + 1, mat);
        int d1 = func(r + 1, c + 1, mat);

        return Math.min(r1, Math.min(c1, d1)) + 1;
    }
}
