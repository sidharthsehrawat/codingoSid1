 package revision.matrix;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14,15, 16}
        };
        spriralFun(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    private  static void spriralFun(int[][] matrix, int left, int right, int top, int bottom) {
        if (left <= right && top <= bottom) {

            for (int col = left; col <=right; col++) {
                System.out.print(" " + matrix[left][col]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                System.out.print(" " + matrix[row][right]);
            }

            for (int col = right-1; col >=left; col--) {
                System.out.print(" " + matrix[bottom][col]);
            }

            for (int row = bottom-1; row >= top+1; row--) {
                System.out.print(" " + matrix[row][left]);
            }
            spriralFun(matrix, left+1, right-1, top+1, bottom-1);
        }
    }
}
