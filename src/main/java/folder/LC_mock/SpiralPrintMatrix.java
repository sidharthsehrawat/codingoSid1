package folder.LC_mock;

public class SpiralPrintMatrix {

    public static void main(String[] args) {
        generateMatrix(4);
    }

    private static int counter = 1;
    public static int[][] generateMatrix(int n) {
        int[][] dp = new int [n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;

        helper(left , right, top, bottom, dp);

        return dp;

    }

    public static void helper(int left, int right, int top, int bottom, int[][] dp){
        // base condition...

        if(left <=right || top <=bottom){

            for(int i =left ; i<=right; i++){
                dp[top][i] = counter;
                counter++;
            }

            for(int j = top+1; j<=bottom; j++){
                dp[j][right] = counter;
                counter++;
            }

            for(int k = right-1; k>=left; k--){
                dp[bottom][k] = counter;
                counter++;
            }

            for(int m = bottom-1; m>top; m--){
                dp[m][left] = counter;
                counter++;
            }


            helper(left+1, right-1, top+1 , bottom-1, dp);
        }
    }

}
