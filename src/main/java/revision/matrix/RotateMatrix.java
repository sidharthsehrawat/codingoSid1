package revision.matrix;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},        // 1 4 7     // 3 6 9
                      {4, 5, 6},         // 2 5 8     // 2 5 8
                      {7, 8, 9}          // 3 6 9     // 1 4 7
        };

        int[][] ans = rotateFun(mat);
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(" " + mat[row][col]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateFun(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = row; col < mat[0].length; col++) {
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(" " + mat[row][col]);
            }
            System.out.println();
        }

        for (int row = 0; row < mat[0].length; row++) {
            int last = mat[0].length-1;
            int mid = last/2;
            int start = 0;
            while (start<=mid){
                int temp = mat[row][start];
                mat[row][start] =  mat[row][last];
                mat[row][last] = temp;
                start++;
                last--;
            }
        }
        return mat;
    }
}
