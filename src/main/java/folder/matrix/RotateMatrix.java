package folder.matrix;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},   //  {7,4,1}
                {4,5,6},   //  {8,5,2}
                {7,8,9}    //  {9,6,3}
        };

     //   {1,2,3},   //  {1,4,7}
     //   {4,5,6},   //  {2,5,8}
     //   {7,8,9}    //  {3,6,9}

        for(int r = 0;r<matrix.length;r++){
            for(int c =r+1;c<matrix.length;c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        for(int r =0;r<matrix.length;r++){
            for(int c =0;c<matrix[r].length;c++){
                System.out.print(matrix[r][c]+ " ");
            }
            System.out.println();
        }
    }
}
